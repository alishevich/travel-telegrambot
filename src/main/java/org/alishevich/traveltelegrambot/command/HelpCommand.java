package org.alishevich.traveltelegrambot.command;

import org.alishevich.traveltelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.alishevich.traveltelegrambot.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды</b>\n\n"
                    + "%s - начать работу со мной\n"
                    + "%s - получить помощь в работе со мной\n"
                    + "%s название города - получить информацию о городе\n",
            START.getCommandName(), HELP.getCommandName(), CITY.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
