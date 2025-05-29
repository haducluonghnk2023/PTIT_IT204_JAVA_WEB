package com.data.session14.controller;

import com.data.session14.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FinanceController {
    @GetMapping("/finance")
    public String showForm(HttpSession session, Model model,
                           @CookieValue(value = "username", defaultValue = "") String username) {
        model.addAttribute("username", username);
        return "finance-form";
    }

    @PostMapping("/finance")
    public String addTransaction(@RequestParam String description,
                                 @RequestParam double amount,
                                 @RequestParam String type,
                                 @RequestParam String username,
                                 HttpSession session,
                                 HttpServletResponse response,
                                 Model model) {
        // Ghi vào cookie
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(7 * 24 * 60 * 60);
        usernameCookie.setPath("/");
        response.addCookie(usernameCookie);

        // Ghi vào session
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) transactions = new ArrayList<>();
        transactions.add(new Transaction(description, amount, type));
        session.setAttribute("transactions", transactions);

        model.addAttribute("success", true);
        model.addAttribute("username", username);
        return "finance-form";
    }

    @GetMapping("/transactions")
    public String listTransactions(HttpSession session, Model model) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions == null) transactions = new ArrayList<>();
        model.addAttribute("transactions", transactions);
        return "transaction-list";
    }

    @GetMapping("/transactions/delete")
    public String deleteTransaction(@RequestParam int index, HttpSession session) {
        List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
        if (transactions != null && index >= 0 && index < transactions.size()) {
            transactions.remove(index);
        }
        return "redirect:/transactions";
    }
}
