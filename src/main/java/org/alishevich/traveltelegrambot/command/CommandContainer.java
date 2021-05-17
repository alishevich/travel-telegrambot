package org.alishevich.traveltelegrambot.command;

import com.google.common.collect.ImmutableMap;
import org.alishevich.traveltelegrambot.service.CityService;
import org.alishevich.traveltelegrambot.service.SendBotMessageService;

import static org.alishevich.traveltelegrambot.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, CityService cityService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(CITY.getCommandName(), new CityCommand(sendBotMessageService, cityService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
