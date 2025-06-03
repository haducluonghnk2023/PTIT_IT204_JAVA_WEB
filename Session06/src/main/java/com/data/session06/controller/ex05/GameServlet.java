package com.data.session06.controller.ex05;

import java.io.*;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
    private static final String[] choices = {"Búa", "Kéo", "Lá"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String playerChoice = request.getParameter("playerChoice");
        String computerChoice = choices[new Random().nextInt(3)];
        String result = determineWinner(playerChoice, computerChoice);

        request.setAttribute("playerChoice", playerChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/ex05/game.jsp");
        dispatcher.forward(request, response);
    }

    private String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Hòa!";
        }
        if ((player.equals("Búa") && computer.equals("Kéo")) ||
                (player.equals("Kéo") && computer.equals("Lá")) ||
                (player.equals("Lá") && computer.equals("Búa"))) {
            return "Bạn thắng!";
        } else {
            return "Bạn thua!";
        }
    }
}