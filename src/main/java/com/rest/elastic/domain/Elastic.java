package com.rest.elastic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Objects;

@Document(indexName = "elastic", type = "elastictype")
public class Elastic {

    @Id
    private Long id;

    private String name;
    private String search;
    private String autosearch;

    public Elastic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getAutosearch() {
        return autosearch;
    }

    public void setAutosearch(String autosearch) {
        this.autosearch = autosearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elastic)) return false;
        Elastic elastic = (Elastic) o;
        return Objects.equals(getId(), elastic.getId()) &&
                Objects.equals(getName(), elastic.getName()) &&
                Objects.equals(getSearch(), elastic.getSearch()) &&
                Objects.equals(getAutosearch(), elastic.getAutosearch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSearch(), getAutosearch());
    }
}
