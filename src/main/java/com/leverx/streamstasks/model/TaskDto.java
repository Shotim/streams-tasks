package com.leverx.streamstasks.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Tsimafei Shostka
 */
@Data
@Builder
@RequiredArgsConstructor
public class TaskDto {
    private final long id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private final Set<String> tags;
}
