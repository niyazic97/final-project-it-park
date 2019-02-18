package ru.itpark.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.dto.FilmsDto;
import ru.itpark.dto.UsersDto;
import ru.itpark.entity.FilmsEntity;
import ru.itpark.entity.SubscriptionEntity;
import ru.itpark.entity.UsersEntity;
import ru.itpark.repository.FilmsRepository;
import ru.itpark.repository.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository repository;
    private final FilmsService filmsService;
    private final UsersService usersService;

    public SubscriptionService(SubscriptionRepository repository, FilmsService filmsService, UsersService usersService) {
        this.repository = repository;
        this.filmsService = filmsService;
        this.usersService = usersService;
    }


    public List<SubscriptionEntity> getSubscriptionByUserId(Integer userId) {
        return repository.findAllByUsersEntity(usersService.getById(userId));
    }

    public void save(Integer userId, Integer filmId) {

        List<SubscriptionEntity> subscriptionEntities = repository.findAllByUsersEntityAndFilmsEntity(usersService.getById(userId), filmsService.getById(filmId));

        if (subscriptionEntities.isEmpty()) {
            SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
            subscriptionEntity.setUsersEntity(usersService.getById(userId));
            subscriptionEntity.setFilmsEntity(filmsService.getById(filmId));
            repository.save(subscriptionEntity);
        }

    }

    @Transactional
    public void removeByUserIdAndFilmId(Integer userId, Integer filmId) {
        UsersEntity usersEntity = usersService.getById(userId);
        FilmsEntity filmsEntity = filmsService.getById(filmId);
        repository.removeByFilmsEntityAndUsersEntity(filmsEntity, usersEntity);
    }
}
