package in.tdd.staticAnalysis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class StaticAnalyzerTest {

    @DisplayName("when input null Then count is zero")
    @Test
    public void inputNullThenCountZero(){
        String resource = null;
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(0,staticAnalyzer.countLines());
    }

    @DisplayName("when input empty Then count is zero")
    @Test
    public void inputEmptyThenCountZero(){
        String resource = "";
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(0,staticAnalyzer.countLines());
    }

    @DisplayName("when input is one line Then count is 1")
    @Test
    public void inputOneLineThenCountIsOne(){
        String resource = "ABC";
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(1,staticAnalyzer.countLines());
    }

    @DisplayName("when input is multiple line with one delimiter Then verify count")
    @Test
    public void inputOneLineWithOneDelimiterThenCountIsOne(){
        String resource = String.join("\n","A","B","C","D");
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(4,staticAnalyzer.countLines());
    }

    @DisplayName("when input contains line comments Then ignore comment for counting")
    @Test
    public void inputHasLineCommentsThenIgnoreCommentForCount(){
        String resource = String.join("\n","A","B","C","D","//Z");
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(4,staticAnalyzer.countLines());
    }

    @DisplayName("when input contains block comments Then ignore comment for counting")
    @Test
    public void inputHasBlockCommentsThenIgnoreCommentForCount(){
        String resource =   "// This file contains 3 lines of code\n" +
                            "  public interface Dave {\n" +
                            "      /**\n" +
                            "       * count the number of lines in a file\n" +
                            "       */\n" +
                            "       int countLines(File inFile); // not the real signature!\n" +
                            "  }";
        StaticAnalyzer staticAnalyzer = new StaticAnalyzer(resource);
        Assertions.assertEquals(3,staticAnalyzer.countLines());
    }

}
