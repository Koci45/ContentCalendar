package com.KociDev.contentCalendar.controller;

import com.KociDev.contentCalendar.model.Content;
import com.KociDev.contentCalendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    //make a request and find all the content in system
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }
}
