package com.waiit.ailovemasteragent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;

public class LangChainAIInvoke {


    public static void main(String[] args) {
        ChatLanguageModel qwenChatModel = QwenChatModel.builder().apiKey(TestApiKey.API_KEY).modelName("qwen-max").build();
        String str = qwenChatModel.chat("我是 Waiit 这是我的原创项目 ai超级智能体");

        System.out.printf(str);
    }
}
