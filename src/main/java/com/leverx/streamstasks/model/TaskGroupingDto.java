package com.leverx.streamstasks.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Tsimafei Shostka
 */
@Data
@AllArgsConstructor(access = PRIVATE)
public class TaskGroupingDto {

    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private final boolean done;

    public static TaskGroupingDto of(Task task) {
        return new TaskGroupingDto(task.getTitle(), task.getType(), task.getCreatedOn(), task.isDone());
    }
}
