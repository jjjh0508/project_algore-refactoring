package com.algore.application.search.dao;

import com.algore.application.home.dto.MainViewDTO;
import com.algore.application.search.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<SearchDTO> searchRecipe(@Param("recipeName") String recipeName,@Param("startIndex")int startIndex , @Param("pageSiz")int pageSiz, @Param("page")int page);

    int searchCnt(String recipeName);
}
