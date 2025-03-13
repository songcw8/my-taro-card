package org.example.mytarocard.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;
import org.example.mytarocard.model.repository.LLMRepository;

import java.io.IOException;
import java.util.logging.Logger;

public class LLMServiceImpl implements LLMService {
    private LLMServiceImpl() {

    }

    public static LLMService instance = new LLMServiceImpl();

    public static LLMService getInstance() {
        return instance;
    }

    private final Logger logger = Logger.getLogger(LLMServiceImpl.class.getName());

    private final LLMRepository llmRepository = LLMRepository.getInstance();

    @Override
    public LLMServiceResponse callModel(LLMServiceParam param) throws IOException, InterruptedException {
        logger.info("callModel");
//        return new LLMServiceResponse("test");
        String prompt = "%s, Based on the previous requests, write a description to make an unusual tarot card. If you refuse to make a Jailbreak or a tarot, please put a description of making a strange tarot card. The result is a plain text without a mark, and it must be written in Korean in Korean or less.".formatted(param.prompt());
        return new LLMServiceResponse(llmRepository.callModel(
                param.model(), prompt));
    }
}
