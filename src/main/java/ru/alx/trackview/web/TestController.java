package ru.alx.trackview.web;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/hello")
    public @ResponseBody TestGreeting testAnswer() {

        logger.warn("hello world log warn");
        logger.info("hello world log info");
        logger.debug("hello world log debug");

        return new TestGreeting(123, "hello world");
    }
}
