import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputWords) {

        String[] words = inputWords.split("\\s+");

        Map<String, Integer> wordCount = getWordCount(words);

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }

        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        return formatResult(list);

    }

    private String formatResult(List<Input> wordsList){
        return wordsList.stream().map(word -> word.getValue() + " " + word.getWordCount()).collect(Collectors.joining("\n"));
    }

    private Map<String, Integer> getWordCount(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            if (wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word)+1);
            }else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }
}
