package com.algore.application.search.service;

import com.algore.application.search.dto.SearchDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchServiceTest {

    @Autowired
    private SearchService searchService;


    @DisplayName("레시피 검색시 존재하지 않는 검색어 입력하면 Empty인지 테스트")
    @ParameterizedTest
    @CsvSource({"김치","호박고구마"})
    void searchRecipe(String name) {
        List<SearchDTO> searchDTOS = searchService.searchRecipe(name,0,5,1);
        boolean result = searchDTOS.isEmpty();
        Assertions.assertTrue(result);

    }
}