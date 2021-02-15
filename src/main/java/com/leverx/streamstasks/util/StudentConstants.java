package com.leverx.streamstasks.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Tsimafei Shostka
 */
@NoArgsConstructor(access = PRIVATE)
public final class StudentConstants {

    @NoArgsConstructor(access = PRIVATE)
    public static final class Names {
        public static final String DAVE = "Dave";
        public static final String STEVE = "Steve";
        public static final String MIKE = "Mike";
    }

    @RequiredArgsConstructor
    public enum Subjects {
        MATH("Math"),
        PE("PE"),
        CHEMISTRY("Chemistry");

        @Getter
        private final String value;
    }
}
