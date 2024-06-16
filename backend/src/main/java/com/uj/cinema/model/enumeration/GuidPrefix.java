package com.uj.cinema.model.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public enum GuidPrefix {

    MOVIE("MV"),
    THEATER("THR"),
    SCREEN("SC"),
    SCREENING("SCG"),
    SCREENING_RESERVATION("SCGRES"),
    RESERVATION("RES"),
    USER("UR"),
    UNKNOWN("");

    private final String name;

    private static final Map<String, GuidPrefix> GUID_PREFIX_INDEX = Arrays
            .stream(GuidPrefix.values())
            .collect(Collectors.toMap(GuidPrefix::getName, Function.identity()));

    GuidPrefix(final String name) {
        this.name = name;
    }

    public static GuidPrefix fromName(final String guidPrefixName) {
        return GUID_PREFIX_INDEX.getOrDefault(guidPrefixName, UNKNOWN);
    }
}
