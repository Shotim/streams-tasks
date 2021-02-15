package com.leverx.streamstasks.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Tsimafei Shostka
 */
@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    void findFirstFiveForReadingTasksTitlesSortedByCreatedOnField() {
        System.out.println(taskService.findFirstFiveForReadingTasksTitlesSortedByCreatedOnField());
    }

    @Test
    void mapToDto() {
        System.out.println(taskService.mapToDto());
    }
}