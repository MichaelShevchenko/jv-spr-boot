package spring.boot.com.sbparser.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.com.sbparser.service.WordService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private static final String DEFAULT_NUMBER_OF_WORDS = "1000";
    private final WordService wordService;

    @Autowired
    public ReviewController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/most-used-words")
    List<String> getMostUsedWords(
            @RequestParam(defaultValue = DEFAULT_NUMBER_OF_WORDS) int wordsQuantity) {
        return wordService.findMostUsed(wordsQuantity);
    }
}
