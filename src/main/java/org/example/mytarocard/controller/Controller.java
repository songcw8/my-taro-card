package org.example.mytarocard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class Controller extends HttpServlet {
    //logger를 구현할 필요는 없음
    protected final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected void view(HttpServletRequest req, HttpServletResponse resp, String name) throws ServletException, IOException {
        String prefix = "/WEB-INF/views/";
        String suffix = "jsp";
        req.getRequestDispatcher("%s%s.%s".formatted(prefix, name, suffix)).forward(req, resp);
    }
}
