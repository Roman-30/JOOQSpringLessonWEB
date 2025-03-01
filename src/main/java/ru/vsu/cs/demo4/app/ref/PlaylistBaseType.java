package ru.vsu.cs.demo4.app.ref;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaylistBaseType {
    FAVORITE("Моё любимое треки", "Мое любимое"),
    HISTORY("Недавно прослушанные треки", "История");

    private final String description;
    private final String name;
}
