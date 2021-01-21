package com.test;

import com.dbcontrollers.DemandController;
import com.models.Demand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DemandControllerTest extends DemandController {
    Demand demand = new Demand(1, "a", "a", "a", "a", "F", "1990-12-12", "a", "2020-10-10", "2020-10-20", "a", "email@email.com", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", false);
    ArrayList<Demand> list = new ArrayList<>();

    @Test
    void create() throws SQLException, ClassNotFoundException {
        Assertions.assertEquals(1, create(demand));
    }

    @Test
    void fetch() throws SQLException, ClassNotFoundException {
        Demand copy = fetch(2);
        Assertions.assertEquals(2, copy.getId());
    }


    @Test
    void testFetchAll() throws SQLException, ClassNotFoundException {
        ArrayList<Demand> list = fetchAll();
        Assertions.assertEquals(1, list.size());
    }


    @Test
    void testUpdate() throws SQLException, ClassNotFoundException {
        Demand copy2 = fetch(3);
        copy2.setFirstName("c");
        Assertions.assertEquals(1, update(copy2));
    }

    @Test
    void delete() throws SQLException, ClassNotFoundException {
        Assertions.assertEquals(1, delete(2));
    }
}