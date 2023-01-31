package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Afanasyi", "Stupin", (byte) 20);
        System.out.println("User с именем – Sergey добавлен в базу данных");
        userService.saveUser("Vitaliy", "Sidorov", (byte) 26);
        System.out.println("User с именем – Vitaliy добавлен в базу данных");
        userService.saveUser("Andrey", "Sidorov", (byte) 28);
        System.out.println("User с именем – Andrey добавлен в базу данных");
        userService.saveUser("Sasha", "Tereshenko", (byte) 24);
        System.out.println("User с именем – Sasha добавлен в базу данных");
        userService.removeUserById(2);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
