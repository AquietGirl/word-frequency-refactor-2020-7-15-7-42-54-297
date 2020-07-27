import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputWords) {

        return Arrays.stream(inputWords.split("\\s+"))
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(Collectors.joining("\n"));

    }
}
