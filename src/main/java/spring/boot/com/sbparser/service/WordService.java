package spring.boot.com.sbparser.service;

import java.util.List;

public interface WordService {
    // void saveAll(List<Word> words);

    List<String> findMostUsed(int quantity);
}
