package org.alishevich.traveltelegrambot.command;

import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.entity.Info;
import org.alishevich.traveltelegrambot.service.CityService;
import org.alishevich.traveltelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.stream.Collectors;

import static org.alishevich.traveltelegrambot.command.CommandName.CITY;

public class CityCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final CityService cityService;

    public CityCommand(SendBotMessageService sendBotMessageService, CityService cityService) {
        this.sendBotMessageService = sendBotMessageService;
        this.cityService = cityService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();
        if (text.equalsIgnoreCase(CITY.getCommandName())) {
            sendCityEmptyMessage(chatId);
            return;
        }
        String cityName = text.split(" ")[1].toLowerCase();
        City city = cityService.getWithInfoByName(cityName);
        if (city != null) {
            String infoMessage = city.getInfos().stream()
                    .map(Info::getCityInfo)
                    .collect(Collectors.joining("\n\n"));
            sendBotMessageService.sendMessage(chatId, infoMessage);
        } else {
            sendCityNotFound(chatId, cityName);
        }
    }

    private void sendCityEmptyMessage(String chatId) {
        String cityEmptyMessage = "Передавать команду /city необходимо вместе с названием города.\n"
                + "Пример ввода: /city Рим";
        sendBotMessageService.sendMessage(chatId, cityEmptyMessage);
    }

    private void sendCityNotFound(String chatId, String cityName) {
        String cityNotFoundMessage = String.format("Город <b>%s</b> не найден. Попробуйте еще раз.", cityName);
        sendBotMessageService.sendMessage(chatId, cityNotFoundMessage);
    }
}
