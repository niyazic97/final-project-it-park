package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "subscriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private FilmsEntity filmsEntity;
}
