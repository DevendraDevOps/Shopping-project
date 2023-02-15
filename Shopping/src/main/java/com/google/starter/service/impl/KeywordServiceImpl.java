package com.google.starter.service.impl;

import com.google.starter.entity.Keyword;
import com.google.starter.repository.KeywordRepository;
import com.google.starter.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    KeywordRepository keywordRepository;

    @Override
    public Keyword addKeyWord(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    @Override
    public List<Keyword> getALlMatchingKeywords(String keyWord) {
        List<Keyword> keywordList =
                keywordRepository.findAll();
        return keywordList.stream().filter(x->x.getKey().contains(keyWord) ||
                x.getDescription().contains(keyWord)).collect(Collectors.toList());

    }
}
