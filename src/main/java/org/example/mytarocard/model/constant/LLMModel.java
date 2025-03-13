package org.example.mytarocard.model.constant;

public enum LLMModel {
    GEMINI_2_0_FLASH("gemini-2.0-flash", LLMPlatform.GENIMI),;
    public final String modelName;
    public final LLMPlatform platform;

    LLMModel(String modelName, LLMPlatform platform) {
        this.modelName = modelName;
        this.platform = platform;
    }
}
