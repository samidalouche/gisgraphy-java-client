package com.gisgraphy.client.continent;

public interface ContinentRepository {
    Iterable<Continent> findAll();
    Continent findByCode(String code);
}
