package org.alishevich.traveltelegrambot.repository;

import org.alishevich.traveltelegrambot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("SELECT c FROM City c JOIN FETCH c.infos WHERE c.name=:name")
    City getWithInfos(@Param("name") String name);
}
