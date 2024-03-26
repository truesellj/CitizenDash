package org.justintruesell.citizendash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.justintruesell.citizendash.models.Todo;
import org.justintruesell.citizendash.repositories.TodoRepository;
import org.justintruesell.citizendash.services.TodoService;
import org.justintruesell.citizendash.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CitizenDashApplicationTests {

    @Autowired
    TodoServiceImpl todoService;

    @Autowired
    TodoRepository todoRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindByOwner(){
        Assertions.assertNotNull(todoService.loadByOwner("jtruesell@gmail.com"));
    }

    @Test
    void largestBiggerThanSmallest(){
        Assertions.assertNotEquals(todoRepo.findLargestID(),todoRepo.findSmallestID());
    }

    @Test
    void titleOfAnItem(){
        Assertions.assertEquals(todoRepo.findTitleByListItem("Bologna"), "Shopping");
    }
    @Test
    void negativeIndex(){
        Assertions.assertFalse(todoRepo.findSmallestID() < 0);
    }

}
