package org.alishevich.traveltelegrambot.repository;

import org.alishevich.traveltelegrambot.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Integer> {

}
