package ru.yandex.practicum.catsgram.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(of = "id")
public class Post {

    private Long id;
    private long authorId; // автор
    private String description; // дата создания
    private Instant postDate; // описание

}