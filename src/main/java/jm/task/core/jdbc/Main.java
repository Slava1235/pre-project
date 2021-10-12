package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Leonid", "Salikov", (byte) 18));
        userList.add(new User("Slava", "Pipkin", (byte) 20));
        userList.add(new User("Dima", "Petrov", (byte) 50));
        userList.add(new User("Sergey", "Pumin", (byte) 72));

        userService.createUsersTable();
        for (User user : userList) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем " + user.getName() + " добавлен в базу данных");
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
