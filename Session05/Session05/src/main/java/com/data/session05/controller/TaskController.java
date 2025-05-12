package com.data.session05.controller;

import com.data.session05.model.Task;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TaskController", value = "/tasks")
public class TaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                request.getRequestDispatcher("/views/addTask.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Task task = findTaskById(id);
                if (task != null) {
                    request.setAttribute("task", task);
                    request.getRequestDispatcher("/views/editTask.jsp").forward(request, response);
                }
                break;
            default:
                request.setAttribute("tasks", tasks);
                request.getRequestDispatcher("/views/listTasks.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                String description = request.getParameter("description");
                String dueDate = request.getParameter("dueDate");
                Task newTask = new Task(taskIdCounter++, description, dueDate, false);
                tasks.add(newTask);
                response.sendRedirect("/Session05/tasks");
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Task taskToUpdate = findTaskById(id);
                if (taskToUpdate != null) {
                    taskToUpdate.setDescription(request.getParameter("description"));
                    taskToUpdate.setDueDate(request.getParameter("dueDate"));
                    taskToUpdate.setCompleted(request.getParameter("completed") != null);
                }
                response.sendRedirect("/Session05/tasks");
                break;
            case "delete":
                int taskId = Integer.parseInt(request.getParameter("id"));
                Task taskToDelete = findTaskById(taskId);
                if (taskToDelete != null) {
                    tasks.remove(taskToDelete);
                }
                response.sendRedirect("/Session05/tasks");
                break;
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}