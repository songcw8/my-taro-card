package org.example.mytarocard.model.repository;


import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;

import java.util.logging.Logger;

public class LLMRepository {
    private LLMRepository() {}
    private final static LLMRepository instance = new LLMRepository();
    public static LLMRepository getInstance() {
        return instance;
    }

    private final Logger logger = Logger.getLogger(LLMRepository.class.getName());

    //나중에 수정이 필요하면 오버로딩 여러개의 파람.
    public String callModel(String model, String token, String platform, String prompt) {
        return "";
    }
}
