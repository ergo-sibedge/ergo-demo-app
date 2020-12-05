package com.sibedge.ergo.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * A convenient set of service constants.
 */
public class Constants {

    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    /**
     * Describes supported audit event types.
     */
    @Getter
    @RequiredArgsConstructor
    public enum EventKey {
        FILTER_PERSON_LIST("PDA001", "Person data access through the filter");

        private final String key;
        private final String description;
    }
}
