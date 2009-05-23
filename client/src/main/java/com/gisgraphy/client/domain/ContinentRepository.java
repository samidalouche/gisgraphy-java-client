package com.gisgraphy.client.domain;

public interface ContinentRepository {
    Iterable<Continent> findAll();
    Continent findByCode(String code);
}
