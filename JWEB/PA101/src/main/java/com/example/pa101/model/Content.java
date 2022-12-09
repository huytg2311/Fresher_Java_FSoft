package com.example.pa101.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Content {
    private int id;
    private String title;
    private String brief;
    private String content;
    private Timestamp create_date;
    private LocalDateTime update_time;
    private String sort;
    private int authorId;

    public Content() {
    }

    public Content(int id, String title, String brief, Timestamp create_date) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.create_date = create_date;
    }

    public Content( String title, String brief, String content, Timestamp create_date) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.create_date = create_date;
    }

    public Content(int id, String title, String brief, String content, Timestamp create_date, LocalDateTime update_time, String sort, int authorId) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.create_date = create_date;
        this.update_time = update_time;
        this.sort = sort;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
