package com.leverx.streamstasks.service;

import com.leverx.streamstasks.mapper.TaskMapper;
import com.leverx.streamstasks.model.Task;
import com.leverx.streamstasks.model.TaskDto;
import com.leverx.streamstasks.model.TaskGroupingDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.leverx.streamstasks.model.TaskType.CODING;
import static com.leverx.streamstasks.model.TaskType.READING;
import static com.leverx.streamstasks.model.TaskType.WRITING;
import static java.time.Month.JULY;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author Tsimafei Shostka
 */
@Service
public class TaskService {

    public static final int MAX_SIZE = 5;
    public static final String DELIMITER = ", ";

    private List<Task> generateTasks() {
        Task task1 = new Task(1L,
                "Read Version Control with Git book",
                READING,
                LocalDate.of(2015, JULY, 1))
                .addTag("git")
                .addTag("reading")
                .addTag("books");

        Task task2 = new Task(2L,
                "Read Java 8 Lambdas book",
                READING,
                LocalDate.of(2015, JULY, 2))
                .addTag("java8")
                .addTag("reading")
                .addTag("books");

        Task task3 = new Task(3L,
                "Write a mobile application to store my tasks",
                CODING,
                LocalDate.of(2015, JULY, 3))
                .addTag("coding")
                .addTag("mobile");

        Task task4 = new Task(4L,
                "Write a blog on Java 8 Streams",
                WRITING,
                LocalDate.of(2015, JULY, 4))
                .addTag("blogging")
                .addTag("writing")
                .addTag("streams");

        Task task5 = new Task(5L,
                "Read Domain Driven Design book",
                READING,
                LocalDate.of(2015, JULY, 5))
                .addTag("ddd")
                .addTag("books")
                .addTag("reading");

        return List.of(task1, task2, task3, task4, task5);
    }

    public String findFirstFiveForReadingTasksTitlesSortedByCreatedOnField() {
        return generateTasks().stream()
                .filter(task -> READING.equals(task.getType()))
                .sorted(comparing(Task::getCreatedOn))
                .limit(MAX_SIZE)
                .map(Task::getTitle)
                .collect(joining(DELIMITER));
    }

    public List<TaskDto> mapToDto() {
        return generateTasks().stream()
                .map(TaskMapper::toDto)
                .collect(toList());
    }

    public Collection<List<Task>> groupByParams(){
        return generateTasks().stream().collect(groupingBy(TaskGroupingDto::of)).values();
    }
}
