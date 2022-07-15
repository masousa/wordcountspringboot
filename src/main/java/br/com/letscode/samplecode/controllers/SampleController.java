package br.com.letscode.samplecode.controllers;

import br.com.letscode.samplecode.payloads.HelloResponse;
import br.com.letscode.samplecode.payloads.WordCountResponse;
import br.com.letscode.samplecode.service.WordCountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final WordCountService wordCountService;
    @GetMapping(path = "/hello", produces = "application/json")
    @ApiResponse(description = "Say Hello")
    public HelloResponse getHelloResponse(){
        return HelloResponse.builder().text("Hello").build();
    }

    @GetMapping(path = "/count/{phrase}", produces = "application/json")
    @ApiResponse(description = "Contador de palavras")
    public WordCountResponse getCountWord(@PathVariable(name = "phrase") String phrase){
        return wordCountService.execute(phrase);
    }
}
