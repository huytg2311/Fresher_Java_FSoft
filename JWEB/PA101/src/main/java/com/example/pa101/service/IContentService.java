package com.example.pa101.service;

import com.example.pa101.model.Content;

import java.util.List;

public interface IContentService {
    List<Content> getAllContent();
    void createContent(Content content);
    Content searchByTitle(String title);
}
