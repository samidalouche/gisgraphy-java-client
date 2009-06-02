package com.gisgraphy.client.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FipsCountryCodeTest {
    
    @Test public void shouldCreateFipsCountryCode() {
	FipsCountryCode fipsCountryCode = FipsCountryCodeObjectMother.franceFipsCountryCode();
	assertEquals("FR", fipsCountryCode.getFipsCode());
	assertNull(fipsCountryCode.getEquivalentFipsCode());
    }
    
    @Test public void shouldCreateEquivalentFipsCountryCode() {
	FipsCountryCode fipsCountryCode = FipsCountryCode.equivalentFipsCountryCode("FI");
	assertNull(fipsCountryCode.getFipsCode());
	assertEquals("FI", fipsCountryCode.getEquivalentFipsCode());
    }
    
    @Test public void fipsCodesWithSameFipsCodeShouldBeEqual() {
	FipsCountryCode fipsCountryCode1 = FipsCountryCode.fipsCountryCode("FR");
	FipsCountryCode fipsCountryCode2 = FipsCountryCode.fipsCountryCode("FR");
	assertEquals(fipsCountryCode1, fipsCountryCode2);
	assertEquals(fipsCountryCode1.hashCode(), fipsCountryCode2.hashCode());
    }
    
    @Test public void fipsCodesWithSameEquivalentFipsCodeShouldBeEqual() {
	FipsCountryCode equivalentFipsCountryCode1 = FipsCountryCode.equivalentFipsCountryCode("FI");
	FipsCountryCode equivalentFipsCountryCode2 = FipsCountryCode.equivalentFipsCountryCode("FI");
	assertEquals(equivalentFipsCountryCode1, equivalentFipsCountryCode2);
	assertEquals(equivalentFipsCountryCode1.hashCode(), equivalentFipsCountryCode2.hashCode());
    }
}
