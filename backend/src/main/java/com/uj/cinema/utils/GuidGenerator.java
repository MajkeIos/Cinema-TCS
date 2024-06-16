package com.uj.cinema.utils;

import java.security.SecureRandom;
import java.util.function.Predicate;

public class GuidGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Integer MIN_LENGTH = 11;
    private static final Integer MAX_LENGTH = 15;
    private static final String SEPARATOR = "_";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateGuid(final String guidPrefix, final Predicate<String> existsInDb) {
        String guid;
        do {
            final int suffixLength = RANDOM.nextInt((MAX_LENGTH - MIN_LENGTH) + 1) + MIN_LENGTH;
            final StringBuilder sb = new StringBuilder(guidPrefix.length() + SEPARATOR.length() + suffixLength);
            sb.append(guidPrefix).append(SEPARATOR);
            for (int i = 0; i < suffixLength; i++) {
                final int index = RANDOM.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            guid = sb.toString();
        } while (existsInDb.test(guid));

        return guid;
    }
}
