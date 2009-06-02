package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.Continent.continent;
import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class ContinentTest {

    @Test
    public void shouldCreateEuropeContinent() {
	Continent europe = ContinentObjectMother.europe();
	assertEquals("Continent[code=EU,name=Europe]", europe.toString());
	assertEquals("EU", europe.getCode());
	assertEquals("EU", europe.getGeonamesCode());
	assertEquals("Europe", europe.getName());
	assertEquals("Europe", europe.getGeonamesName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptNullCode() {
	continent(null).withName("Europe");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptEmptyCode() {
	continent("").withName("Europe");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptNullName() {
	continent("EU").withName(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAcceptEmptyName() {
	continent("EU").withName("");
    }
    
    @Test
    public void continentsWithSameCodeShouldBeEqual() {
	assertTrue(europe().withName("europe1").equals(europe().withName("europe2")));
    }
    
    @Test
    public void continentsWithSameCodeShouldHaveSameHashCode() {
	assertEquals(europe().withName("europe1").hashCode(), europe().withName("europe2").hashCode());
    }
    
    @Test
    public void continentsWithDifferentCodeShouldNotBeEqual() {
	Assert.assertFalse(europe().withCode("EU1").equals(europe().withCode("EU2")));
    }
    
    @Test
    public void continentsWithDifferentCodeShouldNotHaveSameHashCode() {
	Assert.assertFalse(europe().withCode("EU1").hashCode() == europe().withCode("EU2").hashCode());
    }

}
