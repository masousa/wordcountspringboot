package br.com.letscode.samplecode.service;


import br.com.letscode.samplecode.payloads.WordCountResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SampleCodeServiceTest {

    @InjectMocks
    private WordCountService wordCountService;
    @Test
    public void should_generate_wordResponseWith4Words(){
        String phrase ="Should exists only words";
        WordCountResponse response = wordCountService.execute(phrase);
        Assertions.assertTrue(response.getWords().equals(4));
    }

    @Test
    public void should_generate_wordResponseWith21Letters(){
        String phrase ="Should exists only words";
        WordCountResponse response = wordCountService.execute(phrase);
        Assertions.assertTrue(response.getLetters().equals(21));
    }

    @Test
    public void should_generate_wordResponseWith21and2Number(){
        String phrase ="1Should exists only 0 words";
        WordCountResponse response = wordCountService.execute(phrase);
        Assertions.assertTrue(response.getLetters().equals(21));
        Assertions.assertEquals(response.getNumbers(),2);
    }
    @Test
    public void should_generate_wordResponseWith2OccurrencesOfS(){
        String phrase ="Should exists only words";
        WordCountResponse response = wordCountService.execute(phrase);
        Assertions.assertTrue(response.getLetters().equals(21));
        Assertions.assertEquals(response.getOccurrences()
                .stream().filter(occurrence
                        -> occurrence.getCharacter()
                        .equals("S")).findFirst()
                .get().getNumberOfTimes(),4);
    }
}
