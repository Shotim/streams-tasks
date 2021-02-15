package com.leverx.streamstasks.mapper;

import com.leverx.streamstasks.model.Task;
import com.leverx.streamstasks.model.TaskDto;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Tsimafei Shostka
 */
@NoArgsConstructor(access = PRIVATE)
public final class TaskMapper {

    public static TaskDto toDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .type(task.getType())
                .createdOn(task.getCreatedOn())
                .tags(task.getTags())
                .build();
    }
}
