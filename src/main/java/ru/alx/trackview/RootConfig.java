package ru.alx.trackview;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "ru.alx.trackview.dao",
        "ru.alx.trackview.service"
})
public class RootConfig {
}
