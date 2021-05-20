package org.alishevich.traveltelegrambot.controller;

import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.entity.Info;
import org.alishevich.traveltelegrambot.exception.NotFoundException;
import org.alishevich.traveltelegrambot.repository.CityRepository;
import org.alishevich.traveltelegrambot.service.CityService;
import org.alishevich.traveltelegrambot.service.InfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class CityControllerTest  extends AbstractControllerTest{

    @Autowired
    private CityService service;

    @Autowired
    private CityRepository repository;

    @Autowired
    private InfoService infoService;

    private static final String URL = CityController.URL + '/';
    private static final int NOT_FOUND = 20;

    @Test
    void get() throws Exception {
        City newCity = createNewCity();
        City created = repository.save(newCity);

        perform(MockMvcRequestBuilders.get(URL + created.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(newCity)));
    }

    @Test
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + NOT_FOUND))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void getWithInfos() throws Exception {
        int id = createCityWithInfo().getId();

        perform(MockMvcRequestBuilders.get(URL + id + "/with-infos"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(service.get(id))));
    }

    @Test
    void createWithLocation() throws Exception {
        City newCity = createNewCity();

        perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newCity)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value(newCity.getName()));
    }

    @Test
    void update() throws Exception {
        int id = saveCity().getId();

        perform(MockMvcRequestBuilders.put(URL + id)
                .content(objectMapper.writeValueAsString(new City(null,"city2")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        Assertions.assertEquals(service.get(id).getName(), "city2");
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL + ID))
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL + NOT_FOUND))
                .andExpect(status().isUnprocessableEntity());
    }

    private static City createNewCity() {
        return new City(null, "city1");
    }

    private City saveCity() {
        return repository.save(createNewCity());
    }

    private City createCityWithInfo() {
         City city = saveCity();
         Info info = infoService.create(new Info(null, "info1"), city.getId());
         city.setInfos(List.of(info));
         return city;
    }
}

