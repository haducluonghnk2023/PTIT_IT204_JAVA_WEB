package com.data.session05.controller;

import com.data.session05.model.Post;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlogController", value = "/blog")
public class BlogController extends HttpServlet {
    private static ArrayList<Post> posts = new ArrayList<>();

    @Override
    public void init() {
        posts.add(new Post(1, "Bài viết đầu tiên", "Nội dung bài viết đầu tiên", "Admin", "2025-05-11"));
        posts.add(new Post(2, "Chào mừng đến với blog", "Đây là bài viết thứ hai", "User1", "2025-05-10"));
        posts.add(new Post(3, "Java Servlet đơn giản", "Cùng học Java Servlet nhé!", "Student", "2025-05-09"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Post post = findPostById(id);
            if (post != null) {
                request.setAttribute("post", post);
                request.getRequestDispatcher("/views/postDetail.jsp").forward(request, response);
                return;
            }
        }

        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/views/postList.jsp").forward(request, response);
    }

    private Post findPostById(int id) {
        for (Post post : posts) {
            if (post.getId() == id) return post;
        }
        return null;
    }
}