package com.gisgraphy.client.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.util.Currency;


/**
 * A Country (as defined by ISO 3166). A country always has an ISO 3166 alpha2,
 * alpha3 and numeric code, but may, or may not have other names (FIPS, ..). The
 * list of countries has been imported from Geonames Country List.
 * 
 * There is no feature Source since all Countries come from Geonames Country
 * List.
 * 
 * Codes are written uppercase !!!
 * 
 * @see <a
 *      href="http://www.iso.org/iso/en/prods-services/popstds/countrynamecodes.html">Country
 *      Name Codes</a>
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * 
 */
public class Country extends AbstractAdministrativeEntity implements
	Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @see #getArea()
     */
    private Double area;

    /**
     * @see #getBoundingBoxEast()
     */
    private Double boundingBoxEast;

    /**
     * @see #getBoundingBoxNorth()
     */
    private Double boundingBoxNorth;

    /**
     * @see #getBoundingBoxSouth()
     */
    private Double boundingBoxSouth;

    /**
     * @see #getBoundingBoxWest()
     */
    private Double boundingBoxWest;

    /**
     * @see #getContinent()
     */
    private Continent continent;

    /**
     * @see #getCurrencyCode()
     * @see #getCurrency()
     */
    private String currencyCode;

    /**
     * @see #getEquivalentFipsCode()
     */
    private String equivalentFipsCode;

    /**
     * @see #getFipsCode()
     */
    private String fipsCode;

    /**
     * @see #getIso3166Alpha2Code()
     */
    private String iso3166Alpha2Code;

    /**
     * @see #getIso3166Alpha3Code()
     */
    private String iso3166Alpha3Code;

    /**
     * @see #getIso3166NumericCode()
     */
    private Long iso3166NumericCode;

    /**
     * @see #getName()
     */
    private String name;

    /**
     * @see #getNeighbourCountries()
     */
    private List<Country> neighbourCountries = new ArrayList<Country>();

    /**
     * @see #getPhonePrefix()
     */
    private String phonePrefix;

    /**
     * @see #getPopulation()
     */
    private Long population;

    /**
     * @see #getPostalCodeMask()
     */
    private String postalCodeMask;

    /**
     * @see #getPostalCodeRegex()
     */
    private String postalCodeRegex;
    
    /**
     * @see #getLanguageCodes()
     */
    private List<Language> spokenLanguages = new ArrayList<Language>();

    /**
     * @see #getTopLevelDomain()
     */
    private String topLevelDomain;

    /**
     * 
     */
    public Country() {
	super();

    }

    public Country(Continent continent, String name, String iso3166Alpha2Code,
	    String iso3166Alpha3Code, Long iso3166NumericCode) {
	super();
	this.continent = continent;
	this.name = name;
	this.iso3166Alpha2Code = iso3166Alpha2Code;
	this.iso3166Alpha3Code = iso3166Alpha3Code;
	this.iso3166NumericCode = iso3166NumericCode;
    }

    public Country(Continent continent, String name, String iso3166Alpha2Code,
	    String iso3166Alpha3Code, Long iso3166NumericCode, String fipsCode) {
	this(continent, name, iso3166Alpha2Code, iso3166Alpha3Code,
		iso3166NumericCode);
	this.setFipsCode(fipsCode);

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
    @Override
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
    }

    @Override
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

    public Double getBoundingBoxEast() {
	return this.boundingBoxEast;
    }

    public Double getBoundingBoxNorth() {
	return this.boundingBoxNorth;
    }

    public Double getBoundingBoxSouth() {
	return this.boundingBoxSouth;
    }

    public Double getBoundingBoxWest() {
	return this.boundingBoxWest;
    }

    /**
     * Returns the string that is considered to be the name of the index
     * (Compass Index) of any City belonging to this Country. This is used by
     * {@link CitySubIndexHash} to redirect the index creator to the right
     * index, and by
     * {@link CityDaoImpl#searchByApproximateName(String, Country)} to restrict
     * the search to a single sub index (and thus, to improve performance).
     * 
     * Pay attention to the fact that a change in this method will most likely
     * require a complete re-build of Compass Indexes.
     * 
     * @return
     */
    public String getCityIndexName() {
	return this.getIso3166Alpha3Code() + "-city";
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

    @Override
    public String getDisplayableCode() {
	return iso3166Alpha2Code;
    }

    @Override
    public String getDisplayableName() {
	return getName();
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
     * The ISO 3166 alpha-2 letter code
     * 
     * @see <a href="http://en.wikipedia.org/wiki/ISO_3166"> ISO 3166 </a>
     * 
     * @return Returns the iso3166Alpha2Code.
     */
    public String getIso3166Alpha2Code() {
	return this.iso3166Alpha2Code;
    }

    /**
     * The ISO 3166 alpha-3 letter code
     * 
     * @see <a href="http://en.wikipedia.org/wiki/ISO_3166"> ISO 3166 </a>
     */
    public String getIso3166Alpha3Code() {
	return this.iso3166Alpha3Code;
    }

    /**
     * The ISO 3166 Numeric Code
     */
    public Long getIso3166NumericCode() {
	return this.iso3166NumericCode;
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
    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME
		* result
		+ ((iso3166Alpha3Code == null) ? 0 : iso3166Alpha3Code
			.hashCode());
	return result;
    }

    /**
     * @see #getArea()
     * @param area
     */
    public void setArea(Double area) {
	this.area = area;
    }

    /**
     * @see #getBoundingBoxEast()
     * @param boundingBoxEast
     */
    public void setBoundingBoxEast(Double boundingBoxEast) {
	this.boundingBoxEast = boundingBoxEast;
    }

    /**
     * @see #getBoundingBoxNorth()
     * @param boundingBoxNorth
     */
    public void setBoundingBoxNorth(Double boundingBoxNorth) {
	this.boundingBoxNorth = boundingBoxNorth;
    }

    /**
     * @see #getBoundingBoxSouth()
     * @param boundingBoxSouth
     */
    public void setBoundingBoxSouth(Double boundingBoxSouth) {
	this.boundingBoxSouth = boundingBoxSouth;
    }

    /**
     * @see #getBoundingBoxWest()
     * @return
     */
    public void setBoundingBoxWest(Double boundingBoxWest) {
	this.boundingBoxWest = boundingBoxWest;
    }

    /**
     * @see #getContinent()
     * @param continent
     */
    public void setContinent(Continent continent) {
	this.continent = continent;
    }

    /**
     * @see #getCurrency()
     * @param currency
     */
    public void setCurrency(Currency currency) {
	this.setCurrencyCode(currency.getCurrencyCode());
    }

    /**
     * @see #getEquivalentFipsCode()
     * @param equivalentFipsCode
     */
    public void setEquivalentFipsCode(String equivalentFipsCode) {
	this.equivalentFipsCode = equivalentFipsCode;
    }

    /**
     * @see #getFipsCode()
     * @param fipsCode
     *                The fipsCode to set.
     */
    public void setFipsCode(String fipsCode) {
	this.fipsCode = fipsCode;
    }

    /**
     * @see #getIso3166Alpha2Code()
     * @param iso3166Alpha2Code
     *                The iso3166Alpha2Code to set.
     */
    public void setIso3166Alpha2Code(String isoCode) {
	this.iso3166Alpha2Code = isoCode;
    }

    /**
     * @see #getIso3166Alpha3Code()
     * @param iso3166Alpha3Code
     */
    public void setIso3166Alpha3Code(String iso3166Alpha3Code) {
	this.iso3166Alpha3Code = iso3166Alpha3Code;
    }

    /**
     * @see #getIso3166NumericCode()
     * @param iso3166NumericCode
     */
    public void setIso3166NumericCode(Long iso3166NumericCode) {
	this.iso3166NumericCode = iso3166NumericCode;
    }

    /**
     * @param name
     *                public abstract java.util.Set keySet();
     * 
     * The name to set.
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @see #getNeighbourCountries()
     * @param neighbourCountries
     */
    public void setNeighbourCountries(List<Country> neighbourCountries) {
	this.neighbourCountries = neighbourCountries;
    }

    /**
     * @see #getPhonePrefix()
     * @param phonePrefix
     */
    public void setPhonePrefix(String phonePrefix) {
	this.phonePrefix = phonePrefix;
    }

    /**
     * @see #getPopulation()
     * @param population
     */
    public void setPopulation(Long population) {
	this.population = population;
    }

    /**
     * @see #getPostalCodeMask()
     * @param postalCodeMask
     */
    public void setPostalCodeMask(String postalCodeMask) {
	this.postalCodeMask = postalCodeMask;
    }

    public void setPostalCodeRegex(String postalCodeRegex) {
        this.postalCodeRegex = postalCodeRegex;
    }

    /**
     * @see #getSpokenLanguages()
     * @param languages
     */
    public void setSpokenLanguages(List<Language> languages) {
	this.spokenLanguages = languages;
    }

    /**
     * @see #getTopLevelDomain()
     * @param tld
     */
    public void setTopLevelDomain(String tld) {
	this.topLevelDomain = tld;
    }


    /**
     * Use this when {@link #setCurrency(Currency)} does not recognize a
     * particular language. Make sure the code is correct !!
     * 
     * @see #getCurrencyCode()
     * @param currencyCode
     */
    private void setCurrencyCode(String currencyCode) {
	this.currencyCode = currencyCode;
    }

    @Override
    public AbstractAdministrativeEntity getParentAdm(int level) {
	if(level == 0) {
	    return this;
	} else {
	    return null;    
	}
	
    }

}
