package org.alishevich.traveltelegrambot.controller;

import lombok.extern.slf4j.Slf4j;
import org.alishevich.traveltelegrambot.entity.City;
import org.alishevich.traveltelegrambot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.alishevich.traveltelegrambot.util.ValidationUtil.assureIdConsistent;
import static org.alishevich.traveltelegrambot.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(CityController.URL)
@Slf4j
public class CityController {
    static final String URL = "/api/cities";

    private final CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public City get(@PathVariable int id) {
        log.info("get city {} ", id);
        return service.get(id);
    }

    @GetMapping
    public List<City> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    @GetMapping("/{id}/with-infos")
    public City getWithInfos(@PathVariable int id) {
        log.info("getWithInfos {}", id);
        return service.getWithInfos(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> createWithLocation(@Valid @RequestBody City city) {
        checkNew(city);
        log.info("create {}", city);
        City created = service.create(city);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody City city, @PathVariable int id) {
        assureIdConsistent(city, id);
        log.info("update {} ", city);
        service.update(city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {} ", id);
        service.delete(id);
    }
}
