package org.alishevich.traveltelegrambot.repository;

import org.alishevich.traveltelegrambot.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface InfoRepository extends JpaRepository<Info, Integer> {
}
