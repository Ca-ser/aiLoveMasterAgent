package com.waiit.ailovemasteragent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONArray;


/**
 * 使用 HTTP 的方式调用 阿里云百炼大模型*/
public class httpAiInvoke {



    public static void main(String[] args) {
        // 设置API密钥
        String apiKey = TestApiKey.API_KEY;

        // 构建请求URL
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 构建请求体JSON
        JSONObject requestBody = new JSONObject();

        // 设置模型
        requestBody.put("model", "qwen-plus");

        // 构建消息列表
        JSONObject input = new JSONObject();
        JSONArray messages = new JSONArray();

        // 添加system消息
        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a helpful assistant.");
        messages.add(systemMessage);

        // 添加user消息
        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", "你是谁？");
        messages.add(userMessage);

        // 设置input字段
        input.put("messages", messages);
        requestBody.put("input", input);

        // 设置参数
        JSONObject parameters = new JSONObject();
        parameters.put("result_format", "message");
        requestBody.put("parameters", parameters);

        // 发送HTTP请求
        HttpResponse response = HttpRequest .post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();

        // 处理响应
        if (response.isOk()) {
            System.out.println("请求成功");
            System.out.println(response.body());
        } else {
            System.out.println("请求失败，状态码：" + response.getStatus());
            System.out.println(response.body());
        }
    }
}