package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivision.administrativeDivision;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.arrondissementDeRambouilletAdm3;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.yvelinesAdm2;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.france;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.arrondissementDeRambouilletAdm3GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
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
		.andGisFeature(rambouilletAdm4GisFeature());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithEmptyName() {
	administrativeDivision("")
		.withCode("78517")
		.andGisFeature(rambouilletAdm4GisFeature());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullCode() {
	administrativeDivision("Rambouillet")
		.withCode(null)
		.andGisFeature(rambouilletAdm4GisFeature());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithEmptyCode() {
	administrativeDivision("Rambouillet")
		.withCode("")
		.andGisFeature(rambouilletAdm4GisFeature());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAdministrativeDivisionWithNullGisFeature() {
	administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(null);
    }
   
    
    @Test
    public void administrativeDivisionsWithSameGisFeatureShouldBeEqual() {
	AdministrativeDivision rambouillet1 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(rambouilletAdm4GisFeature());
	
	AdministrativeDivision rambouillet2 = administrativeDivision("Rambouillet2")
		.withCode("78517-2")
		.andGisFeature(rambouilletAdm4GisFeature());
	
	assertEquals(rambouillet1, rambouillet2);
	assertEquals(rambouillet1.hashCode(), rambouillet2.hashCode());
    }
    
    @Test
    public void administrativeDivisionsWithDifferentGisFeatureShouldNotBeEqual() {
	AdministrativeDivision rambouillet1 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(rambouilletAdm4GisFeature());
	
	AdministrativeDivision rambouillet2 = administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(arrondissementDeRambouilletAdm3GisFeature());
	
	assertFalse(rambouillet1.equals(rambouillet2));
	assertTrue(rambouillet1.hashCode() != rambouillet2.hashCode());
    }
    
    @Test public void administrativeDivisionLevelShouldBe1ForAdm1() {
	Assert.assertEquals(1,AdministrativeDivisionObjectMother.ileDeFranceAdm1().getAdminitrativeDivisionLevel());
    }
    
    @Test public void administrativeDivisionLevelShouldBe2ForAdm2() {
	Assert.assertEquals(2,AdministrativeDivisionObjectMother.yvelinesAdm2().getAdminitrativeDivisionLevel());
    }
    
    @Test public void administrativeDivisionLevelShouldBe3ForAdm3() {
	Assert.assertEquals(3,arrondissementDeRambouilletAdm3().getAdminitrativeDivisionLevel());
    }
    
    @Test public void administrativeDivisionLevelShouldBe4ForAdm4() {
	Assert.assertEquals(4,AdministrativeDivisionObjectMother.rambouilletAdm4().getAdminitrativeDivisionLevel());
    }
    
    @Test public void getAdministrativeEntityShouldReturnItselfWhenRequestedLevelIsCurrentLevel() {
	Assert.assertEquals(arrondissementDeRambouilletAdm3(), arrondissementDeRambouilletAdm3().getAdministrativeEntity(3));
    }
    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldThrowExceptionWhenRequestedLevelIsHigherThanCurrentLevel() {
	arrondissementDeRambouilletAdm3().getAdministrativeEntity(4);
    }
    
    @Test public void getAdministrativeEntityShouldWorkRecursivelyWhenRequestedLevelIsLowerThancurrentLevel() {
	Assert.assertEquals(yvelinesAdm2(), arrondissementDeRambouilletAdm3().getAdministrativeEntity(2));
    }
    
    @Test public void shouldReturnFullyQualifiedName() {
	Assert.assertEquals("[NamePart[name=France,friendlyCode=FR], NamePart[name=Région Île-de-France,friendlyCode=A8], NamePart[name=Département des Yvelines,friendlyCode=78], NamePart[name=Arrondissement de Rambouillet,friendlyCode=782], NamePart[name=Rambouillet,friendlyCode=78517]]",AdministrativeDivisionObjectMother.rambouilletAdm4().getFullyQualifiedNameParts().toString());
    }
    
}
