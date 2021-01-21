package com.test;

import com.dbcontrollers.UserController;
import com.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.ArrayList;

class UserControllerTest extends UserController {

    User user = new User("admin", "admin@admin.com", "superSecret");
    ArrayList<User> list = new ArrayList<>();

    @Test
    void testCreate() throws SQLException, ClassNotFoundException {
        //create
        Assertions.assertEquals(1, create(user));

    }

    @Test
    void testFetch() throws SQLException, ClassNotFoundException {
        User copy = fetch("admin@admin.com");
        Assertions.assertEquals("admin@admin.com", copy.getEmail());
    }

    @Test
    void testFetchAll() throws SQLException, ClassNotFoundException {
        list = fetchAll();
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void testUpdate() throws SQLException, ClassNotFoundException {
        user.setPassword("password");
        Assertions.assertEquals(1, update(user));
    }

    @Test
    void testDelete() throws SQLException, ClassNotFoundException {
        Assertions.assertEquals(1, delete("admin@admin.com"));
    }
}