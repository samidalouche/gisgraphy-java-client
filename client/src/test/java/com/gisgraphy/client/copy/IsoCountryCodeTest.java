package com.gisgraphy.client.copy;

import static com.gisgraphy.client.administrativedivision.IsoCountryCode.alpha2Code;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother;

public class  IsoCountryCodeTest {
    
    @Test
    public void shouldCreateFranceCountryCode() {
	assertEquals("IsoCountryCode[alpha2=FR,alpha3=FRA,numeric=250]", IsoCountryCodeObjectMother.franceCountryCode().toString());
    }
    
    @Test
    public void lowercaseCountryCodesShouldBeUppercased() {
	assertEquals("IsoCountryCode[alpha2=FR,alpha3=FRA,numeric=250]", alpha2Code("fr").alpha3Code("fra").andNumericCode(250).toString());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowEmptyAlpha2Code() {
	alpha2Code("").alpha3Code("FRA").andNumericCode(250);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowNullAlpha2Code() {
	alpha2Code(null).alpha3Code("FRA").andNumericCode(250);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowNullAlpha3Code() {
	alpha2Code("FR").alpha3Code(null).andNumericCode(250);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowEmptyAlpha3Code() {
	alpha2Code("FR").alpha3Code("").andNumericCode(250);
    }
    
    @Test
    public void countryCodesWithSameAlpha2Alpha3AndNumericShouldBeEqual() {
	assertEquals(alpha2Code("FR").alpha3Code("FRA").andNumericCode(250), 
		     alpha2Code("FR").alpha3Code("FRA").andNumericCode(250));
    }
    
    @Test
    public void countryCodesWithSameAlpha2Alpha3AndNumericShouldHaveSameHashCode() {
	assertTrue(alpha2Code("FR").alpha3Code("FRA").andNumericCode(250).hashCode() ==  
		     alpha2Code("FR").alpha3Code("FRA").andNumericCode(250).hashCode());
    }
    
    @Test
    public void countryCodesShouldNotBeEqualWhenAlpha2Differs() {
	assertFalse(alpha2Code("F1").alpha3Code("FRA").andNumericCode(250).equals( 
		     alpha2Code("F2").alpha3Code("FRA").andNumericCode(250)));
    }
    
    @Test
    public void countryCodesShouldNotHaveSameHashCodeWhenAlpha2Differs() {
	assertFalse(alpha2Code("F1").alpha3Code("FRA").andNumericCode(250).hashCode() == 
		     alpha2Code("F2").alpha3Code("FRA").andNumericCode(250).hashCode());
    }
    
    @Test
    public void countryCodesShouldNotBeEqualWhenAlpha3Differs() {
	assertFalse(alpha2Code("FR").alpha3Code("FR1").andNumericCode(250).equals( 
		     alpha2Code("FR").alpha3Code("FR2").andNumericCode(250)));
    }
    
    @Test
    public void countryCodesShouldNotHaveSameHashCodeWhenAlpha3Differs() {
	assertFalse(alpha2Code("FR").alpha3Code("FR1").andNumericCode(250).hashCode() == 
		     alpha2Code("FR").alpha3Code("FR2").andNumericCode(250).hashCode());
    }
    
    @Test
    public void countryCodesShouldNotBeEqualWhenNumericCodeDiffers() {
	assertFalse(alpha2Code("FR").alpha3Code("FRA").andNumericCode(250).equals( 
		     alpha2Code("FR").alpha3Code("FRA").andNumericCode(251)));
    }
    
    @Test
    public void countryCodesShouldNotHaveSameHashCodeWhenNumericCodeDiffers() {
	assertFalse(alpha2Code("FR").alpha3Code("FRA").andNumericCode(250).hashCode() == 
		     alpha2Code("FR").alpha3Code("FRA").andNumericCode(251).hashCode());
    }
}
