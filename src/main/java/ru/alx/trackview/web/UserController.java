package ru.alx.trackview.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.alx.trackview.dao.UserDAO;
import ru.alx.trackview.model.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/getallusers")
    public @ResponseBody List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @GetMapping("/getuser/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") String id) {
        int targetId = 0;

        if (id == null) {
            logger.warn("error when try find user with empty (null) id");
            return null;
        }

        try {
            targetId = Integer.valueOf(id);
        } catch (Exception e) {
            logger.warn("error when try find user with id = " + id);
            return null;
        }

        if (targetId == 0) {
            logger.warn("error when try find user with id = 0");
            return null;
        }

        return userDAO.findById(targetId);
    }

    @PostMapping("/adduser")
    public @ResponseBody User addUserById(@RequestBody User user) {
        user.setRole("user");
//        logger.warn(user.toString());
        userDAO.create(user);
        return user;
    }

}
