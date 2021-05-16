package org.alishevich.traveltelegrambot.service;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
