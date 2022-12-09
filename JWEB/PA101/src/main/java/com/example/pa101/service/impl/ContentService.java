package com.example.pa101.service.impl;

import com.example.pa101.model.Content;
import com.example.pa101.repository.IContentRepository;
import com.example.pa101.repository.impl.ContentRepository;
import com.example.pa101.service.IContentService;

import java.util.List;

public class ContentService implements IContentService {

    IContentRepository iContentRepository = new ContentRepository();

    @Override
    public List<Content> getAllContent() {
        return iContentRepository.getAllContent();
    }

    @Override
    public void createContent(Content content) {
        iContentRepository.addContext(content);
    }

    @Override
    public Content searchByTitle(String title) {
        return iContentRepository.getByTitle(title);
    }
}
