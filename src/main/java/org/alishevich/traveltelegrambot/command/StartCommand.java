package org.alishevich.traveltelegrambot.command;

import org.alishevich.traveltelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE ="Добро пожаловать в TravelBot!\uD83C\uDF0D\n\n"
            + "Я рассказываю, что можно увидеть в городах путешественнику.\n\n"
            + "Для получения информации передайте команду /city вместе с названием города.\n"
            + "Например: /city Рим";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
