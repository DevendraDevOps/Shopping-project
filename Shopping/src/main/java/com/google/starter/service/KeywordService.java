package com.google.starter.service;

import com.google.starter.entity.Keyword;

import java.util.List;

public interface KeywordService {

    Keyword addKeyWord(Keyword keyword);

    List<Keyword> getALlMatchingKeywords(String keyWord);
}
