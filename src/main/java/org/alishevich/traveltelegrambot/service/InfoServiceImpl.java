package org.alishevich.traveltelegrambot.service;

import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.entity.Info;
import org.alishevich.traveltelegrambot.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.alishevich.traveltelegrambot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class InfoServiceImpl implements InfoService{

    private final InfoRepository repository;
    private final CityService cityService;

    @Autowired
    public InfoServiceImpl(InfoRepository repository, CityService cityService) {
        this.repository = repository;
        this.cityService = cityService;
    }

    @Transactional
    @Override
    public Info create(Info info, int cityId) {
        Assert.notNull(info, "info must not be null");
        City city = checkNotFoundWithId(cityService.get(cityId), cityId);
        info.setCity(city);
        return repository.save(info);
    }
}
