package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    List<UsersEntity>findByLogin(String login);
    Optional<UsersEntity>findByName(String name);
    void removeById(Integer id);
    Optional<UsersEntity> getById(Integer id);


}
