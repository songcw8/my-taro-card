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
        String model = param.model();
        String platform = param.platform();
        String token = dotenv.get("%S_KEY".formatted(platform));
        String prompt = "%s".formatted(param.prompt());
        return new LLMServiceResponse(llmRepository.callModel(
                model, token, platform, prompt));
    }
}
