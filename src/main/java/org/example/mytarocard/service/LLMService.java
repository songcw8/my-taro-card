package org.example.mytarocard.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;

public interface LLMService {

    LLMServiceResponse callModel(LLMServiceParam param);

    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
}
