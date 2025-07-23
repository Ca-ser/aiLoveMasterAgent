package com.waiit.ailovemasteragent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 使用Spring AI Alibaba 的方式引入 阿里云百炼大模型
 */

@Component
public class SpringAiInvoke implements CommandLineRunner {


    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，我是waiit, 请问你可以为我做什么")).getResult().getOutput();
        System.out.println(output.getText());
    }
}

