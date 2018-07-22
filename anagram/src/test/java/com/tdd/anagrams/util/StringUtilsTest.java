package com.tdd.anagrams.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void testStringUtilsToSort(){
        Assertions.assertEquals("abc",StringUtils.sort("bac"));
    }
}
