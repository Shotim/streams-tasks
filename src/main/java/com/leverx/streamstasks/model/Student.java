package com.leverx.streamstasks.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tsimafei Shostka
 */
@Data
@RequiredArgsConstructor
public class Student {

    private final Map<String, Integer> rating = new HashMap<>();
    private final String name;

    public Student rate(String subject, Integer rate) {
        rating.put(subject, rate);
        return this;
    }

    public boolean hasSubject(@NonNull String subject) {
        return rating.containsKey(subject);
    }
}
