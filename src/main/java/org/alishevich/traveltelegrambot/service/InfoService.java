package org.alishevich.traveltelegrambot.service;

import org.alishevich.traveltelegrambot.entity.Info;

public interface InfoService {

    Info create(Info info, int cityId);
}
