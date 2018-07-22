package com.tdd.anagrams;

import com.tdd.anagrams.util.StringUtils;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.*;
import static java.util.stream.Collectors.toList;

public class AnagramFinder {

    public List<String> find(String inputStr, final List<String> inputDictionary) {
        final String input = ofNullable(inputStr).map(StringUtils::sort).orElse("");
        List<String> dictionary = ofNullable(inputDictionary).orElse(emptyList());
        return dictionary.stream()
                .peek(System.out::println)
                .filter(x -> StringUtils.sort(x).equals(input))
                .collect(toList());
    }
}