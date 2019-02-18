package ru.itpark.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.entity.FilmsEntity;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository extends JpaRepository<FilmsEntity, Integer> {
    List<FilmsEntity> findAll();

    Optional<FilmsEntity> getById(Integer id);

    List<FilmsEntity> findByName(String name);
    @Transactional
    void removeById(Integer id);

    List<FilmsEntity> findByPremiereInGoodQuality(Integer id);//пока хз как лучше,поэтому оставил

    List<FilmsEntity> findByRfPremierAndWorldPremierAndPremiereInGoodQuality(Integer rfPremier, Integer worldPremier, Integer premiereInGoodQuality);

    List<FilmsEntity> findByRfPremier(Integer id);//пока хз как лучше,поэтому оставил

    List<FilmsEntity> findByWorldPremier(Integer id);//пока хз как лучше,поэтому оставил

    List<FilmsEntity> findByGenre(String genre);


}
