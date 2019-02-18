package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.dto.UsersDto;
import ru.itpark.entity.UsersEntity;
import ru.itpark.exception.UsersNotFoundException;
import ru.itpark.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<UsersEntity> getAll() {
        return repository.findAll();
    }

    public Optional<UsersEntity> getByName(String name) {
        return repository.findByName(name);
    }

    public UsersEntity getById(Integer id) {
        return repository.getById(id).orElseThrow(UsersNotFoundException::new);
    }

    public void updateUsers(UsersDto usersDto,Integer id){
        UsersEntity usersEntity = getById(id);
        usersEntity.setName(usersDto.getName());
        usersEntity.setSurName(usersDto.getSurName());
        usersEntity.setEmail(usersDto.getEmail());
        usersEntity.setYearOfBirth(usersDto.getYearOfBirth());
        repository.save(usersEntity);

    }
}
