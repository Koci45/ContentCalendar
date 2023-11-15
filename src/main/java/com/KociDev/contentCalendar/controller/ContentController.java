package com.KociDev.contentCalendar.controller;

import com.KociDev.contentCalendar.model.Content;
import com.KociDev.contentCalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @PostMapping("")
    public void create(@RequestBody Content content){
        repository.save(content);
    }
}
