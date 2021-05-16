package org.alishevich.traveltelegrambot.command;

public enum CommandName {

    START("/start"),
    HELP("/help"),
    CITY("/city"),
    NO("nocommand");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
