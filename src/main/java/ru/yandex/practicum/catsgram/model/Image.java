package ru.yandex.practicum.catsgram.model;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Image {
    Long id;
    long postId;
    String originalFileName;
    String filePath;

}
