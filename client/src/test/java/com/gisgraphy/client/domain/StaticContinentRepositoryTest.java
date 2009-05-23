package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.gisgraphy.client.impl.StaticContinentRepository;
import com.google.common.collect.Iterables;

public class StaticContinentRepositoryTest {

    private ContinentRepository continentRepository;
    
    @Before
    public void setUp() {
	this.continentRepository = new StaticContinentRepository();
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
