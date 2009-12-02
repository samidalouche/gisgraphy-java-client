package com.gisgraphy.client.impl;

import static com.gisgraphy.client.continent.Continent.continent;

import com.gisgraphy.client.continent.Continent;
import com.gisgraphy.client.continent.ContinentRepository;
import com.google.common.collect.ImmutableMap;

public class InMemoryContinentRepository implements ContinentRepository {

    private static final ImmutableMap<String, Continent> CONTINENTS = 
	new ImmutableMap.Builder<String,Continent>()
	.put("AF", continent("AF").withName("Africa"))
	.put("AS", continent("AS").withName("Asia"))
	.put("EU", continent("EU").withName("Europe"))
	.put("NA", continent("NA").withName("North America"))
	.put("OC", continent("OC").withName("Oceania"))
	.put("SA", continent("SA").withName("South America"))
	.put("AN", continent("AN").withName("Antarctica"))
	.build();
    
    public Iterable<Continent> findAll() {
	return CONTINENTS.values();
    }

    public Continent findByCode(String code) {
	return CONTINENTS.get(code);
    }

}
