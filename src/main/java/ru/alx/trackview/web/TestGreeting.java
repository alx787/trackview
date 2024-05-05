package ru.alx.trackview.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class TestGreeting {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String content;
}
