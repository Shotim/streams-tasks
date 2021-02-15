package com.leverx.streamstasks.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tsimafei Shostka
 */
@Data
@RequiredArgsConstructor
public class Task {

    private final long id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private final Set<String> tags = new HashSet<>();
    private boolean done;
    private LocalDate dueTo;

    public Task addTag(String tag) {
        tags.add(tag);
        return this;
    }
}
