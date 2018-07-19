package com.narvar.urlshortner.commons;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class RandomString {

    private static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String lowerCase = upperCase.toLowerCase();

    private static String numbers = "0123456789";

    private static String alphanum = upperCase + lowerCase + numbers;

    private final Random random = new SecureRandom();

    private final char[] symbols = alphanum.toCharArray();

    public String nextString(int length) {
        char[] buf = new char[length];
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
}
