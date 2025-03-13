package org.example.mytarocard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;
import org.example.mytarocard.service.LLMService;
import org.example.mytarocard.service.LLMServiceImpl;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/")
public class TaroFormController extends Controller {
    private LLMService llmService;

    @Override
    public void init() throws ServletException {
        log("TaroFormController init...");
        llmService = LLMServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("TaroFormController doGet");
        req.setAttribute("pageTitle", "타로 좋아! 정말 좋아!");
        req.setAttribute("ogTitle", "어렸을 때부터 타로를 좋아한 사람이 있었다?");
        req.setAttribute("ogDescription", "타로타로 타로 밀크티!!!");
        req.setAttribute("ogImageUrl", "%s/assets/%s".formatted(req.getContextPath(), "taro.jpeg"));
        req.setAttribute("ogPageUrl", req.getContextPath());
        view(req, resp, "form");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //무언가 처리할 예정!
        log("TaroFormController doPost");
        LLMServiceParam param = new LLMServiceParam();
        LLMServiceResponse response = llmService.callModel(param);
        log(response.data());

        String uuid = UUID.randomUUID().toString();
        resp.sendRedirect(req.getContextPath() + "/result/%s".formatted(uuid));
    }
}
