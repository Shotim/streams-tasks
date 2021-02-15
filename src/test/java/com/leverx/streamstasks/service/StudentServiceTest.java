package com.leverx.streamstasks.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Tsimafei Shostka
 */
@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void calculateSubjectRatingAverage1() {
        System.out.println(studentService.calculateSubjectRatingAverage1());
    }

    @Test
    void calculateSubjectRatingAverage2() {
        System.out.println(studentService.calculateSubjectRatingAverage2());
    }

    @Test
    void getRatingOfSubjectsForStudents() {
        System.out.println(studentService.getRatingOfSubjectsForStudents());
    }
}