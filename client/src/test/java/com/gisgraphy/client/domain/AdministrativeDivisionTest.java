package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AdministrativeDivision.administrativeDivision;
import static com.gisgraphy.client.domain.AdministrativeDivisionObjectMother.arrondissementDeRambouilletAdm3;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.arrondissementDeRambouilletAdm3GisFeature;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class AdministrativeDivisionTest {

    @Test
    public void shouldCreateAdministrativeDivision() {
	AdministrativeDivision rambouilletAdm4 = AdministrativeDivisionObjectMother.rambouilletAdm4();
	assertEquals("78517", rambouilletAdm4.getCode());
	assertEquals("Rambouillet", rambouilletAdm4.getName());
	assertEquals(rambouilletAdm4GisFeature(), rambouilletAdm4.getGisFeature());
	assertEquals(arrondissementDeRambouilletAdm3(), rambouilletAdm4.getParentEntity());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullName() {
	administrativeDivision(null)
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithEmptyName() {
	administrativeDivision("")
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullCode() {
	administrativeDivision("Rambouillet")
		.withCode(null)
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithEmptyCode() {
	administrativeDivision("Rambouillet")
		.withCode("")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullGisFeature() {
	administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(null)
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullParentEntity() {
	administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(null);
    }
    
    @Test
    public void administrativeDivisionsWithSameGisFeatureShouldBeEqual() {
	AdministrativeDivision rambouillet1 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
	
	AdministrativeDivision rambouillet2 = administrativeDivision("Rambouillet2")
		.withCode("78517-2")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(AdministrativeDivisionObjectMother.yvelinesAdm2());
	
	assertEquals(rambouillet1, rambouillet2);
	assertEquals(rambouillet1.hashCode(), rambouillet2.hashCode());
    }
    
    @Test
    public void administrativeDivisionsWithDifferentGisFeatureShouldNotBeEqual() {
	AdministrativeDivision rambouillet1 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
	
	AdministrativeDivision rambouillet2 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(arrondissementDeRambouilletAdm3GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
	
	assertFalse(rambouillet1.equals(rambouillet2));
	assertTrue(rambouillet1.hashCode() != rambouillet2.hashCode());
    }
    
}
