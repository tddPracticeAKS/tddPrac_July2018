package in.tdd.staticAnalysis;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StaticAnalyzer {

    private final String resource;

    public StaticAnalyzer(String resource) {
        this.resource = Optional.ofNullable(resource).orElse("");
    }

    public long countLines() {
        return Stream.of(resource.split("\n")).map(String::trim)
                .filter(e -> !e.isEmpty())
                .filter(e-> ! e.matches("^[// , /\\*\\* , \\*/ , \\*]"))
                .count();
    }
}
