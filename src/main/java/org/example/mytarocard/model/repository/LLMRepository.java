package org.example.mytarocard.model.repository;


import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class LLMRepository {
    private LLMRepository() {}
    private final static LLMRepository instance = new LLMRepository();
    public static LLMRepository getInstance() {
        return instance;
    }

    private final Logger logger = Logger.getLogger(LLMRepository.class.getName());
    private final HttpClient client = HttpClient.newHttpClient();

    //나중에 수정이 필요하면 오버로딩 여러개의 파람.
    public String callModel(String model, String token, String platform, String prompt) throws IOException, InterruptedException {
        String url = "";
        switch (platform) {
            case "TOGETHER" -> url = "together";
            case "GROQ" -> url = "groq";
            case "GEMINI" -> url = "gemini";
            default -> throw new RuntimeException("Unknown platform: " + platform);
        }
        String[] headers = {};
        String body = "";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .headers(headers)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return "";
    }
}
