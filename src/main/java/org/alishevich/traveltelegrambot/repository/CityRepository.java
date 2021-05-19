package org.alishevich.traveltelegrambot.repository;

import org.alishevich.traveltelegrambot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("SELECT c FROM City c JOIN FETCH c.infos WHERE c.name=:name")
    City getWithInfos(@Param("name") String name);

    @Query("SELECT c FROM City c JOIN FETCH c.infos WHERE c.id=:id")
    City getWithInfos(@Param("id") int id);

    @Modifying
    @Query("DELETE FROM City c WHERE c.id=:id")
    int delete(@Param("id") int id);
}
