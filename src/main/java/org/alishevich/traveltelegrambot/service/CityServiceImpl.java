package org.alishevich.traveltelegrambot.service;

import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<City> getWithInfoByName(String name) {
        return repository.getWithInfos(name);
    }
}
