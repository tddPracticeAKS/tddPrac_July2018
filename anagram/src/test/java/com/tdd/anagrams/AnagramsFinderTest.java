package com.tdd.anagrams;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class AnagramsFinderTest {


    @DisplayName("Input is null and dictionary is null then return empty list")
    @Test
    public void testIsAnagramsWhenInputIsNull(){
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(emptyList(), anagramFinder.find(null, null));
    }

    @DisplayName("Input is null and dictionary is empty then return empty list")
    @Test
    public void testIsAnagramsWhenInputIsNullAndDictionaryIsEmpty(){
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(emptyList(), anagramFinder.find(null, Collections.EMPTY_LIST));
    }

    @DisplayName("Input is null and dictionary is not empty then return empty list")
    @Test
    public void testIsAnagramsWhenInputIsNullAndDictionaryIsNotEmpty(){
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(emptyList(), anagramFinder.find(null, asList("abc")));
    }

    @DisplayName("Input is present in dictionary then return the input")
    @Test
    public void testIsAnagramsWhenInputIsNotNullAndDictionaryIsNotEmpty(){
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(asList("abc"), anagramFinder.find("abc", asList("abc")));
    }

    @DisplayName("Input is present and Dictionay contains anagrams of the input" +
            "input = abc and dictionary = {bac")
    @Test
    public void testIsAnagramsWhenInputIsNotNullAndDictionaryhasAnagram() {
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(asList("bac"), anagramFinder.find("abc", asList("bac")));
    }

    @Test
    public void testIsAnagramsWhenInputIsNotNullAndDictionaryhasMultipleAnagram() {
        AnagramFinder anagramFinder = new AnagramFinder();
        assertEquals(asList("abd","adb"), anagramFinder.find("bad", asList("bac","abd","adb","cat")));
    }
}