import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputWords) {

        String[] words = inputWords.split("\\s+");

        List<Input> wordFrequencylist = getWordFrequency(words);

        return formatResult(wordFrequencylist);

    }

    private List<Input> getWordFrequency(String[] words) {
        Map<String, Integer> wordCount = getWordCount(words);

        return wordCount
                .entrySet()
                .stream()
                .map(word -> new Input(word.getKey(), word.getValue()))
                .sorted((word1, word2) -> word2.getWordCount()- word1.getWordCount())
                .collect(Collectors.toList());
    }

    private String formatResult(List<Input> wordsList) {
        return wordsList.stream().map(word -> word.getValue() + " " + word.getWordCount()).collect(Collectors.joining("\n"));
    }

    private Map<String, Integer> getWordCount(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }
}
