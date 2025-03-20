package ru.yandex.practicum.catsgram.model;


import lombok.*;

import java.time.Instant;

@Data
@EqualsAndHashCode(of = "email")
@AllArgsConstructor
public class User {
    Long id;
    String username;
    String email;
    String password;
    Instant registrationDate;
}
