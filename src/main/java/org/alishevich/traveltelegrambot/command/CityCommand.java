package org.alishevich.traveltelegrambot.command;

import org.alishevich.traveltelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CityCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public CityCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        //todo send message
    }
}
