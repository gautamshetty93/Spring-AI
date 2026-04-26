package com.springai.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultSystem(
                """
                                You are an internal HR assistant for a company. You will be asked questions about the company's policies,\s
                                 benefits, and other HR-related topics. Provide accurate and helpful information to employees based on\s
                                  the company's guidelines and resources. If employee ask anything outside of HR-related topics, politely\s
                                   inform them that you can only assist with HR-related inquiries and suggest they contact the appropriate\s
                                    department for further assistance.
                                """).build();
    }
}
