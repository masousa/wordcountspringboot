package br.com.letscode.samplecode.service;

import br.com.letscode.samplecode.payloads.Occurrence;
import br.com.letscode.samplecode.payloads.WordCountResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

@Service
public class WordCountService {
    private final static Pattern LETTERS_PATTERN = Pattern.compile("[a-zA-Z]");
    private final static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    public WordCountResponse execute(String phrase) {
        WordCountResponse response = new WordCountResponse();
        StringTokenizer token = new StringTokenizer(phrase, " ");
        response.setWords(token.countTokens());
        String phraseWithNoSpaces = phrase.replaceAll(" ","").trim();

        Long letters = LETTERS_PATTERN.matcher(phraseWithNoSpaces).results().count();
        response.setLetters(letters.intValue());
        final Long count = NUMBER_PATTERN.matcher(phraseWithNoSpaces).results().count();
        response.setNumbers(count.intValue());
        Map<String, Integer> occurrencesMap = new HashMap<>();
        for (char character : phraseWithNoSpaces.toCharArray()) {
            String sCharacter = String.valueOf(character).toUpperCase();
            Integer numberOfTimes = 0;
            if(occurrencesMap.containsKey(sCharacter)){
                numberOfTimes = occurrencesMap.get(sCharacter);
            }
            numberOfTimes++;
            occurrencesMap.put(sCharacter,numberOfTimes);
        }
        List<Occurrence> occurrenceList = new ArrayList<>();
        for (String key : occurrencesMap.keySet()) {
            Occurrence occurrence = new Occurrence();
            occurrence.setCharacter(key);
            occurrence.setNumberOfTimes(occurrencesMap.get(key));
            occurrenceList.add(occurrence);
        }
        response.setOccurrences(occurrenceList);
        return response;
    }
}
