package com.example.pa101.repository;

import com.example.pa101.model.Content;

import java.util.List;

public interface IContentRepository {

    List<Content> getAllContent();

    void addContext(Content content);

    Content getByTitle(String title);
}
