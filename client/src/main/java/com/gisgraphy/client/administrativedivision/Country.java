package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.gisgraphy.client.commons.NamePart;
import com.gisgraphy.client.continent.Continent;
import com.gisgraphy.client.gisfeature.AdministrativeEntity;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureProvider;
import com.gisgraphy.client.gisfeature.GisFeatureType;
import com.gisgraphy.client.gisfeature.InMemoryGeonamesGisFeatureProvider;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.ibm.icu.util.Currency;
import com.vividsolutions.jts.geom.Point;

/**
 * A Country as defined by ISO 3166. 
 * 
 * A country always has an ISO 3166 alpha2, alpha3 and numeric code, but may, or may not have 
 * other names (FIPS, ..). The list of countries has been imported from Geonames Country List.
 * 
 * Pay attention, as some countries do not have any currency !!! (ex: antarctica)
 * @see <a
 *      href="http://www.iso.org/iso/en/prods-services/popstds/countrynamecodes.html">Country Name Codes</a>
 * 
 */
public final class Country implements AdministrativeEntity,GisFeature,CurrencyProvider, AdministrativeCountryInformation, GeographicCountryInformation {
    public static class CountryBuilder {
	private Continent continent;
	private GisFeatureProvider gisFeatureProvider;
	private IsoCountryCode isoCountryCode;
	private String name;
	
	public CountryBuilder(String name) {
	    this.name = name;
	}
	
	public Country andGisFeature(GeonamesGisFeature gisFeature) {
	    this.gisFeatureProvider = new InMemoryGeonamesGisFeatureProvider(gisFeature);
	    return buildCountry();
	}
	
	public Country andGisFeatureProvider(GisFeatureProvider gisFeatureProvider) {
	    this.gisFeatureProvider = gisFeatureProvider;
	    return buildCountry();
	}

	private Country buildCountry() {
	    return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeatureProvider);
	}
	
	public CountryBuilder withContinent(Continent continent) {
	    this.continent = continent;
	    return this;
	}
	
	public CountryBuilder withIsoCountryCode(IsoCountryCode isoCountryCode) {
	    this.isoCountryCode = isoCountryCode;
	    return this;
	}
    }
    
    
    public static CountryBuilder countryName(String name)  {
	return new CountryBuilder(name);
    }
    private AdministrativeCountryInformation administrativeCountryInformation = GeonamesAdministrativeCountryInformation.administrativeCountryInformation();
    private Continent continent;
    private Currency currency;
    
    private FipsCountryCode fipsCountryCode;
    private GeographicCountryInformation geographicCountryInformation = GeonamesGeographicCountryInformation.geographicCountryInformation();
    private GisFeatureProvider gisFeatureProvider;
    private IsoCountryCode isoCountryCode;
    
    private String name;
    
    private Country(IsoCountryCode isoCountryCode, String name, Continent continent, GisFeatureProvider gisFeatureProvider) {
	super();
	
	Validate.notNull(isoCountryCode);
	Validate.notEmpty(name);
	Validate.notNull(continent);
	Validate.notNull(gisFeatureProvider.getGisFeatureId());
	
	this.isoCountryCode = isoCountryCode;
	this.name = name;
	this.gisFeatureProvider = gisFeatureProvider;
	this.continent = continent;
    }
    
    private Country(IsoCountryCode isoCountryCode, String name, Continent continent, GisFeatureProvider gisFeatureProvider, Currency currency, FipsCountryCode fipsCountryCode, AdministrativeCountryInformation administrativeCountryInformation, GeographicCountryInformation geographicCountryInformation) {
	this(isoCountryCode, name, continent, gisFeatureProvider);
	this.currency = currency;
	this.fipsCountryCode = fipsCountryCode;
	this.administrativeCountryInformation = administrativeCountryInformation;
	this.geographicCountryInformation = geographicCountryInformation;
    }
    
    public AdministrativeCountryInformation getAdministrativeCountryInformation() {
        return administrativeCountryInformation;
    }
    
    public Continent getContinent() {
        return continent;
    }
    
    public Currency getCurrency() {
        return currency;
    }
    
    public FipsCountryCode getFipsCountryCode() {
        return fipsCountryCode;
    }

    public GeographicCountryInformation getGeographicCountryInformation() {
        return geographicCountryInformation;
    }

    public GisFeature getGisFeature() {
        return gisFeature();
    }

    public IsoCountryCode getIsoCountryCode() {
        return isoCountryCode;
    }

    public String getName() {
        return name;
    }

    public Country withIsoCountryCode(IsoCountryCode isoCountryCode) {
	return new Country(isoCountryCode, this.name, this.continent, this.gisFeatureProvider, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withName(String name) {
	return new Country(this.isoCountryCode, name, this.continent, this.gisFeatureProvider, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withContinent(Continent continent) {
	return new Country(this.isoCountryCode, this.name, continent, this.gisFeatureProvider, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withGisFeature(GisFeatureProvider gisFeatureProvider) {
	return new Country(this.isoCountryCode, this.name, this.continent, gisFeatureProvider, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }
    
    public Country withAdministrativeCountryInformation(AdministrativeCountryInformation administrativeCountryInformation) {
	Validate.notNull(administrativeCountryInformation);
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeatureProvider, this.currency, this.fipsCountryCode, administrativeCountryInformation, this.geographicCountryInformation);
    }

    public Country withCurrency(Currency currency) {
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeatureProvider, currency, this.fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }

    public Country withFipsCountryCode(FipsCountryCode fipsCountryCode) {
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeatureProvider, this.currency, fipsCountryCode, this.administrativeCountryInformation, this.geographicCountryInformation);
    }

    public Country withGeographicCountryInformation(GeographicCountryInformation geographicCountryInformation) {
	Validate.notNull(geographicCountryInformation);
	return new Country(this.isoCountryCode, this.name, this.continent, this.gisFeatureProvider, this.currency, this.fipsCountryCode, this.administrativeCountryInformation, geographicCountryInformation);
    }

    public int getAdminitrativeDivisionLevel() {
	return 0;
    }

    public AdministrativeEntity getParentAdministrativeEntity() {
	return null;
    }
    
    
    private AdministrativeEntityHierarchy administrativeEntityLevelProvider() {
	return new AdministrativeEntityHierarchy(new AdministrativeEntityHierarchy.AdministrativeEntityProvider() {
	    
	    public AdministrativeEntity getParentAdministrativeEntity() {
		return Country.this.getParentAdministrativeEntity();
	    }
	    
	    public AdministrativeEntity getCurrentAdministrativeEntity() {
		return Country.this;
	    }
	});
    }
    
    public AdministrativeEntity getAdministrativeEntity(int level) {
	return administrativeEntityLevelProvider().getAdministrativeEntity(level);
    }

    public Long getGeonamesId() {
	return gisFeature().getGeonamesId();
    }
    
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return gisFeature().getGisFeatureAlternateNames();
    }

    public String getGisFeatureDefaultName() {
	return gisFeature().getGisFeatureDefaultName();
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	return gisFeature().getGisFeaturePreferredName(language);
    }

    public String getGisFeatureShortName(Iso639Language language) {
	return gisFeature().getGisFeatureShortName(language);
    }

    public Long getElevation() {
	return gisFeature().getElevation();
    }

    public GisFeatureType getGisFeatureType() {
	return gisFeature().getGisFeatureType();
    }

    public Long getGtopo30AverageElevation() {
	return gisFeature().getGtopo30AverageElevation();
    }

    public DateTime getLastModificationDate() {
	return gisFeature().getLastModificationDate();
    }

    public double getLatitude() {
	return gisFeature().getLatitude();
    }

    public Point getLocation() {
	return gisFeature().getLocation();
    }

    public double getLongitude() {
	return gisFeature().getLongitude();
    }

    public Long getPopulation() {
	//return gisFeature.getPopulation();
	// use geographicCountryInformation that should be more up to date..
	return geographicCountryInformation.getPopulation();
    }

    public DateTimeZone getTimeZone() {
	return gisFeature().getTimeZone();
    }
    
    
    public Country getCountry() {
	return this;
    }

    @Override
    public int hashCode() {
	return gisFeatureProvider.gisFeatureHashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Country other = (Country) obj;
	
	return gisFeatureProvider.gisFeatureEquals(other.gisFeatureProvider);
    }

    public String getPhonePrefix() {
	return administrativeCountryInformation.getPhonePrefix();
    }

    public String getPostalCodeMask() {
	return administrativeCountryInformation.getPostalCodeMask();
    }

    public String getPostalCodeRegex() {
	return administrativeCountryInformation.getPostalCodeRegex();
    }

    public ImmutableList<Iso639Language> getSpokenLanguages() {
	return administrativeCountryInformation.getSpokenLanguages();
    }

    public String getTopLevelDomain() {
	return administrativeCountryInformation.getTopLevelDomain();
    }

    public Double getArea() {
	return geographicCountryInformation.getArea();
    }

    public ImmutableList<NamePart> getFullyQualifiedNameParts() {
	return ImmutableList.of(new NamePart(getName(), getFriendlyCode()));
    }

    public String getFriendlyCode() {
	return isoCountryCode.getIso3166Alpha2Code();
    }

    private GisFeature gisFeature() {
	return this.gisFeatureProvider.getGisFeature();
    }
}
