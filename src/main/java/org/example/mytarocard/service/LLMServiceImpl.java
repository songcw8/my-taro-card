package org.example.mytarocard.service;

import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;

import java.util.logging.Logger;

public class LLMServiceImpl implements LLMService {
    private LLMServiceImpl() {

    }

    public static LLMService instance = new LLMServiceImpl();

    public static LLMService getInstance() {
        return instance;
    }

    private final Logger logger = Logger.getLogger(LLMServiceImpl.class.getName());

    @Override
    public LLMServiceResponse callModel(LLMServiceParam param) {
        logger.info("callModel");
        return new LLMServiceResponse("test");
    }
}
