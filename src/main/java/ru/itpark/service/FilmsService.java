package ru.itpark.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.dto.FilmsDto;
import ru.itpark.entity.FilmsEntity;
import ru.itpark.entity.SubscriptionEntity;
import ru.itpark.exception.FilmsNotFoundException;
import ru.itpark.repository.FilmsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmsService {
    private final FilmsRepository repository;

    public FilmsService(FilmsRepository repository) {
        this.repository = repository;
    }

    public List<FilmsEntity> getAll() {
        return repository.findAll();
    }

    public FilmsEntity getById(Integer id) {
        return repository.getById(id).orElseThrow(FilmsNotFoundException::new);

    }

    public List<FilmsEntity> getBySubscriptions(List<SubscriptionEntity> subscriptionEntities){
        List<FilmsEntity>filmsEntities = new ArrayList<FilmsEntity>();
        for (int i=0;i<subscriptionEntities.size();i++){
            FilmsEntity filmsEntity = subscriptionEntities.get(i).getFilmsEntity();
            filmsEntities.add(filmsEntity);
        }
        return filmsEntities;
    }

    public List<FilmsEntity> getByGenre(String name) {
        return repository.findByGenre(name);
    }

    public List<FilmsEntity> getByName(String name) {
        return repository.findByName(name);
    }


    public void saveFilms(FilmsDto filmsDto) {
        FilmsEntity filmsEntity = new FilmsEntity();
        filmsEntity.setName(filmsDto.getName());
        filmsEntity.setGenre(filmsDto.getGenre());
        filmsEntity.setPlot(filmsDto.getPlot());
        filmsEntity.setRfPremier(filmsDto.getRfPremier());
        filmsEntity.setWorldPremier(filmsDto.getWorldPremier());
        filmsEntity.setPremiereInGoodQuality(filmsDto.getPremierInGoodQuality());
        filmsEntity.setWorldPremier(filmsDto.getWorldPremier());
        filmsEntity.setYoutubeId(filmsDto.getYoutubeId());
        repository.save(filmsEntity);

    }

    public void updateFilms(FilmsDto filmsDto, Integer id) {

        FilmsEntity filmsEntity = getById(id);
        filmsEntity.setName(filmsDto.getName());
        filmsEntity.setGenre(filmsDto.getGenre());
        filmsEntity.setPlot(filmsDto.getPlot());
        filmsEntity.setPremiereInGoodQuality(filmsDto.getPremierInGoodQuality());
        filmsEntity.setRfPremier(filmsDto.getRfPremier());
        filmsEntity.setWorldPremier(filmsDto.getWorldPremier());
        filmsEntity.setYoutubeId(filmsDto.getYoutubeId());
        repository.save(filmsEntity);
    }
    @Transactional
    public void deleteFilms(int id) {
    repository.removeById(id);
    }
}






