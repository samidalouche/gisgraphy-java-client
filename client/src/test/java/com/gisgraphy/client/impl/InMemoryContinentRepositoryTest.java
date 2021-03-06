package com.gisgraphy.client.impl;

import static com.gisgraphy.client.continent.ContinentObjectMother.europe;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.gisgraphy.client.continent.ContinentRepository;
import com.gisgraphy.client.impl.InMemoryContinentRepository;
import com.google.common.collect.Iterables;

public class InMemoryContinentRepositoryTest {

    private ContinentRepository continentRepository;
    
    @Before
    public void setUp() {
	this.continentRepository = new InMemoryContinentRepository();
    }
    
    @Test
    public void findAllShouldReturnAllContinents() {
	assertEquals(7, Iterables.size(this.continentRepository.findAll()));
    }
    
    @Test
    public void findAllShouldReturnEuropeAmongOthers() {
	assertTrue(Iterables.contains(this.continentRepository.findAll(), europe()));
    }
    
    @Test
    public void findByCodeShouldFindEurope() {
	assertEquals(europe(), this.continentRepository.findByCode("EU"));
    }
    
}
