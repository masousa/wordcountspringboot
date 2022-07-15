package br.com.letscode.samplecode.payloads;

import lombok.Data;

import java.util.List;

@Data
public class WordCountResponse {
    private Integer words;
    private Integer letters;
    private Integer numbers;
    private List<Occurrence> occurrences;
}
