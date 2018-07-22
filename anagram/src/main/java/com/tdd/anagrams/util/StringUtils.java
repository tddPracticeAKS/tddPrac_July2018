package com.tdd.anagrams.util;

import java.util.Arrays;
import java.util.function.Function;

public class StringUtils {
    public static String sort(String inputStr){
        char[] a = inputStr.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
