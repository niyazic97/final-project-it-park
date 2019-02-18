package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.entity.FilmsEntity;
import ru.itpark.entity.SubscriptionEntity;
import ru.itpark.entity.UsersEntity;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity,Integer> {
    public List<SubscriptionEntity>findAllByUsersEntity(UsersEntity usersEntity);
    @Transactional
    public  void removeByFilmsEntityAndUsersEntity(FilmsEntity filmsEntity, UsersEntity usersEntity);
    public List<SubscriptionEntity>findAllByUsersEntityAndFilmsEntity(UsersEntity usersEntity,FilmsEntity filmsEntity);
}


