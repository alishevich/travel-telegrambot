package org.alishevich.traveltelegrambot.service;

import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.alishevich.traveltelegrambot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City getWithInfoByName(String name) {
        return repository.getWithInfos(name);
    }

    @Override
    public City get(int id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public City getWithInfos(int id) {
        return repository.getWithInfos(id);
    }

    @Transactional
    @Override
    public City create(City city) {
        Assert.notNull(city, "city must not be null");
        if (!city.isNew() && get(city.getId()) == null) {
            return null;
        }
        Optional.ofNullable(city.getInfos()).ifPresent(
                (infos -> infos.forEach(info -> info.setCity(city))));
        city.setName(city.getName().toLowerCase());
        return repository.save(city);
    }

    @Override
    public void update(City city) {
        Assert.notNull(city, "city must not be null");
        checkNotFoundWithId(repository.save(city), city.getId());
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }
}
