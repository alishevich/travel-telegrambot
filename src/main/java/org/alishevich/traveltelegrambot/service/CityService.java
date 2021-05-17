package org.alishevich.traveltelegrambot.service;

import org.alishevich.traveltelegrambot.entity.City;

import java.util.List;

public interface CityService {
    City getWithInfoByName(String name);

    City get(int id);

    List<City> getAll();

    City create(City city);

    void update(City city);

    void delete(int id);
}
