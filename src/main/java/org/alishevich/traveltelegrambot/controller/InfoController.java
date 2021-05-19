package org.alishevich.traveltelegrambot.controller;

import lombok.extern.slf4j.Slf4j;
import org.alishevich.traveltelegrambot.entity.Info;
import org.alishevich.traveltelegrambot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.Map;

import static org.alishevich.traveltelegrambot.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(InfoController.URL)
@Slf4j
public class InfoController {
    static final String URL = CityController.URL + "/{cityId}/infos";

    private final InfoService service;

    @Autowired
    public InfoController(InfoService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Info> createWithLocation(@Valid @RequestBody Info info, @PathVariable int cityId) {
        checkNew(info);
        log.info("create {} for city {}", info, cityId);
        Info created = service.create(info, cityId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(cityId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
