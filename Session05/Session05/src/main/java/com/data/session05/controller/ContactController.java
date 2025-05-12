package com.data.session05.controller;

import com.data.session05.model.Contact;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ContactController", value = "/contacts")
public class ContactController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("views/addContact.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Contact contact = findContactById(id);
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("views/editContact.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("contacts", contacts);
                request.getRequestDispatcher("views/listContacts.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createContact(request);
                break;
            case "update":
                updateContact(request);
                break;
            case "delete":
                deleteContact(request);
                break;
        }

        response.sendRedirect("contacts");
    }

    private void createContact(HttpServletRequest request) {
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        contacts.add(new Contact(idCounter++, fn, ln, email, phone));
    }

    private void updateContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact c = findContactById(id);
        if (c != null) {
            c.setFirstName(request.getParameter("firstName"));
            c.setLastName(request.getParameter("lastName"));
            c.setEmail(request.getParameter("email"));
            c.setPhone(request.getParameter("phone"));
        }
    }

    private void deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact c = findContactById(id);
        if (c != null) {
            contacts.remove(c);
        }
    }

    private Contact findContactById(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}