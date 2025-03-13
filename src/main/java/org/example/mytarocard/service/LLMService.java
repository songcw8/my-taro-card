package org.example.mytarocard.service;

import org.example.mytarocard.model.dto.LLMServiceParam;
import org.example.mytarocard.model.dto.LLMServiceResponse;

public interface LLMService {

    LLMServiceResponse callModel(LLMServiceParam param);
}
