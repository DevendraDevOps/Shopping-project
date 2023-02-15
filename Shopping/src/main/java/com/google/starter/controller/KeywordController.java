package com.google.starter.controller;

import com.google.starter.entity.Keyword;
import com.google.starter.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @PostMapping("/keyword")
    public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword){
        return new ResponseEntity<>(keywordService.addKeyWord(keyword)
        , HttpStatus.CREATED);
    }

    @GetMapping("/keyword")
    public ResponseEntity<List<Keyword>> findKeywords(@RequestParam("q")
                                                      String q){
        return new ResponseEntity<>(keywordService.getALlMatchingKeywords(q),
                HttpStatus.OK)
                ;
    }
}
