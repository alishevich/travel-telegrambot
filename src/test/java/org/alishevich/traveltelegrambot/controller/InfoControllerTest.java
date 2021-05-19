package org.alishevich.traveltelegrambot.controller;

import org.alishevich.traveltelegrambot.entity.Info;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class InfoControllerTest extends AbstractControllerTest{

    private static final String URL = InfoController.URL.replace("{cityId}", String.valueOf(ID)) + "/";

    @Test
    void createWithLocation() throws Exception {
        Info newInfo = new Info(null, "newInfo");

        perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newInfo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.cityInfo").value("newInfo"));
    }
}