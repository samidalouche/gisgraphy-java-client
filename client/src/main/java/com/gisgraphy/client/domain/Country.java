package com.gisgraphy.client.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.util.Currency;


/**
 * A Country as defined by ISO 3166. 
 * 
 * A country always has an ISO 3166 alpha2, alpha3 and numeric code, but may, or may not have 
 * other names (FIPS, ..). The list of countries has been imported from Geonames Country List.
 * 
 * @see <a
 *      href="http://www.iso.org/iso/en/prods-services/popstds/countrynamecodes.html">Country Name Codes</a>
 * 
 */
public class Country implements Serializable, AdministrativeEntity {
    private static final long serialVersionUID = 1L;

    private Double area;
    private Continent continent;
    private String currencyCode;
    private String equivalentFipsCode;
    private String fipsCode;
    private CountryCode iso3166Id;
    private String name;
    private List<Country> neighbourCountries = new ArrayList<Country>();
    private String phonePrefix;
    private Long population;
    private String postalCodeMask;
    private String postalCodeRegex;
    private List<Language> spokenLanguages = new ArrayList<Language>();
    private String topLevelDomain;

    public Country() {
	super();

    }

    public Country(Continent continent, String name, String iso3166Alpha2Code,
	    String iso3166Alpha3Code, Long iso3166NumericCode) {
	super();
	this.continent = continent;
	this.name = name;
	//this.iso3166Alpha2Code = iso3166Alpha2Code;
	//this.iso3166Alpha3Code = iso3166Alpha3Code;
	//this.iso3166NumericCode = iso3166NumericCode;
    }

    public Country(Continent continent, String name, String iso3166Alpha2Code,
	    String iso3166Alpha3Code, Long iso3166NumericCode, String fipsCode) {
	this(continent, name, iso3166Alpha2Code, iso3166Alpha3Code,
		iso3166NumericCode);
	//this.setFipsCode(fipsCode);

    }

    /**
     * Add a neighbour country
     * 
     * @param c
     */
    public void addNeighbourCountry(Country c) {
	neighbourCountries.add(c);
    }

    /**
     * Adds a language to the country.
     * 
     * @param lang
     */
    public void addSpokenLanguage(Language lang) {
	this.spokenLanguages.add(lang);
    }

    /**
     * 2 Countries are equal if they have the same ISO Alpha3 Code
     */
    /*@Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	final Country other = (Country) obj;
	if (iso3166Alpha3Code == null) {
	    if (other.iso3166Alpha3Code != null)
		return false;
	} else if (!iso3166Alpha3Code.equals(other.iso3166Alpha3Code))
	    return false;
	return true;
    }*/

    public int getAdminitrativeDivisionLevel() {
	return 0;
    }

    /**
     * Country area in Square Km
     * 
     * @return
     */
    public Double getArea() {
	return this.area;
    }

    /**
     * The continent of the Country (i.e. Europe, for France)
     * 
     * @return
     */
    public Continent getContinent() {
	return this.continent;
    }

    /**
     * ISO 4217 Currency.
     * 
     * FIXME: some currencies are NOT recognized by
     * {@link Currency#getInstance(java.util.Locale)}. What should we do ???
     * 
     * @see Currency
     * @return
     */
    public Currency getCurrency() {
	Currency c = null;
	if (this.currencyCode != null) {
	    c = Currency.getInstance(this.currencyCode);
	}
	return c;
    }

    /**
     * ISO 4217 Currency Code when possible. However, for some countries, there
     * is no official ISO 4217 code, like Guernsey (GGP), and the information
     * can be null sometimes when we're not sure of the currency (United States
     * Minor Outlying Islands). This field is not unique, because some countries
     * have the same currency. (Euro for instance..)
     * 
     * @see <a
     *      href="http://www.iso.org/iso/en/prods-services/popstds/currencycodeslist.html">
     *      ISO 4217 Currency names </a>
     * @see <a href="http://en.wikipedia.org/wiki/Guernsey_pound">Guernsey Pound</a>
     * @see <a
     *      href="http://en.wikipedia.org/wiki/United_States_Minor_Outlying_Islands">
     *      United States Minor Outlying Islands</a>
     * 
     * @return
     */
    public String getCurrencyCode() {
	return this.currencyCode;
    }


    /**
     * The equivalent fips Code. This is the same as the FIPS code, except that
     * sometimes, there is no FIPS code for some entity (Aaland Islands), even
     * if it is the same country than another one (finland). So in that case,
     * aaland island equivalent fips code will be set to FI
     * 
     * @return
     */
    public String getEquivalentFipsCode() {
	return equivalentFipsCode;
    }

    /**
     * THe FIPS 10.4 country code
     * 
     * This field can be null in some circonstances (when there is an ISO Code
     * and no FIPS code, for instance).
     * 
     * @see <a href="http://en.wikipedia.org/wiki/List_of_FIPS_country_codes">
     *      List Of FIPS Country Codes </a>
     * @return Returns the fipsCode.
     */
    public String getFipsCode() {
	return this.fipsCode;
    }


    /**
     * The (US english) feature name
     * 
     * @return Returns the name.
     */
    public String getName() {
	return this.name;
    }

    /**
     * Neighbour Countries
     * 
     * @return
     */
    public List<Country> getNeighbourCountries() {
	return neighbourCountries;
    }

    /**
     * The Phone Prefix (+33..)
     * 
     * @return
     */
    public String getPhonePrefix() {
	return phonePrefix;
    }

    /**
     * The population, in FIXME
     * 
     * @return
     */
    public Long getPopulation() {
	return this.population;
    }

    /**
     * The Postal Code Mask (99999)
     * 
     * @return
     */
    public String getPostalCodeMask() {
	return postalCodeMask;
    }

    public String getPostalCodeRegex() {
        return postalCodeRegex;
    }

    /**
     * All language codes spoken in this Country.
     * 
     * @see Language
     * @return
     */
    public List<Language> getSpokenLanguages() {
	return this.spokenLanguages;
    }

    /**
     * Top Level Domain (.fr, ...)
     * 
     * @return
     */
    public String getTopLevelDomain() {
	return topLevelDomain;
    }

    /**
     * Return a hash based on the ISO Alpha 3 Code
     */
   /* @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME
		* result
		+ ((iso3166Alpha3Code == null) ? 0 : iso3166Alpha3Code
			.hashCode());
	return result;
    }*/


    public AdministrativeEntity getParentAdminitrativeEntity() {
	return null;
    }

}
