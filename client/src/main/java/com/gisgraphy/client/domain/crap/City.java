package com.gisgraphy.client.domain.crap;

import java.util.List;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A city. Does not contain the information about the city, but is linked to a
 * GisFeature that contains all the imported information.
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 */

public class City implements ICity, Comparable<City> {

    /**
     * @see #getAssociatedGisFeature()
     */
    private OldGisFeature associatedGisFeature;

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * Needed by CGLib
     */
    public City() {
	super();
    }

    public City(OldGisFeature associatedGisFeature) {
	super();
	this.associatedGisFeature = associatedGisFeature;
    }

    public int compareTo(City o) {
	if (o == null) {
	    return 1;
	} else {
	    return this.getCityName().compareTo(o.getCityName());
	}
    }

    /**
     * 
     * @see OldGisFeature#distance(OldGisFeature, Unit)
     * @param city
     * @param unit
     * @return
     */
    public double distance(City city, Unit<Length> unit) {
	return associatedGisFeature.distance(city.getAssociatedGisFeature(),unit);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	final City other = (City) obj;
	if (associatedGisFeature == null) {
	    if (other.associatedGisFeature != null)
		return false;
	} else if (!associatedGisFeature.equals(other.associatedGisFeature))
	    return false;
	return true;
    }

    /**
     * @see OldGisFeature#getAlternateNames()
     * @return
     */
    public List<AlternateGisFeatureName> getAlternateNames() {
	return associatedGisFeature.getAlternateNames();
    }

    public List<String> getAlternateNamesAsStrings() {
	return Lists.newArrayList(Iterables.transform(getAlternateNames(), new Function<AlternateGisFeatureName, String>(){
	    public String apply(AlternateGisFeatureName arg0) {
		return arg0.getAlternateName();
	    }
	}));
    }

    /**
     * The Associated GIS Feature that this city is linked to. Basically, we
     * have chosen not to import all the informations directly inside the City
     * object, but link to the correct GisFeature, so that we can import and
     * deal with all GIS Features the same way.
     * 
     * @return
     */
    public OldGisFeature getAssociatedGisFeature() {
	return this.associatedGisFeature;
    }

    
    public String getCityName() {
	return this.associatedGisFeature.getName();
    }

    
    public OldCountry getCountry() {
	return associatedGisFeature.getCountry();
    }

    /**
     * 
     * @see IGisFeature#getFeatureId()
     * @return Returns the featureId.
     */
    
    public Long getFeatureId() {
	return associatedGisFeature.getFeatureId();
    }

    /**
     * 
     * @see IGisFeature#getFeatureSource()
     * @return Returns the featureSource.
     */
    
    public GisFeatureSourceType getFeatureSource() {
	return associatedGisFeature.getFeatureSource();
    }

    /**
     * Get a name of the form : (all ADMs are printed) Paris, Département de
     * Ville-De-Paris, Ile-De-France, France
     * 
     * @return
     */
    
    public String getFullyQualifiedName() {

	StringBuilder completeCityName = new StringBuilder();
	completeCityName.append(this.getCityName());
	AbstractAdministrativeEntity adm = this.getParentEntity();
	
	do {
	    completeCityName.append(", ");
	    completeCityName.append(adm.getDisplayableName());
	    adm = adm.getParentEntity();
	} while (adm != null);

	return completeCityName.toString();
    }

    public Long getId() {
	return this.id;
    }

    /**
     * @see OldGisFeature#getLatitude()
     * @return
     */
    
    public Double getLatitude() {
	return this.associatedGisFeature.getLatitude();
    }

    /**
     * @see OldGisFeature#getLongitude()
     * @return
     */
    
    public Double getLongitude() {
	return this.associatedGisFeature.getLongitude();
    }

    /**
     * Tha parent entity of the City (Its country, or if the information is
     * available, its First Order Administrative Division, or SecondOrder
     * Administrative Division, or 3rd...
     * 
     * @return
     */
    
    public AbstractAdministrativeEntity getParentEntity() {
	return this.associatedGisFeature.getParentEntity();
    }

    /**
     * Get a name of the form : (only ADM1 is printed) Paris, Ile-De-France,
     * France
     * 
     * @return
     */
    
    public String getShortQualifiedName() {

	StringBuilder shortCityName = new StringBuilder();
	shortCityName.append(this.getCityName());
	AbstractAdministrativeEntity adm = this.getParentEntity();

	do {
	    if (adm.getAdminitrativeDivisionLevel() <= 1) { // only show adm1
		// and country
		shortCityName.append(", ");
		shortCityName.append(adm.getDisplayableName());
	    }
	    adm = adm.getParentEntity();
	} while (adm != null);

	return shortCityName.toString();
    }

    
    public String getTimeZone() {
	return this.associatedGisFeature.getTimeZone();
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME
		* result
		+ ((associatedGisFeature == null) ? 0 : associatedGisFeature
			.hashCode());
	return result;
    }

    /**
     * @see #getAssociatedGisFeature()
     * @param associatedGisFeature
     */
    public void setAssociatedGisFeature(OldGisFeature associatedGisFeature) {
	this.associatedGisFeature = associatedGisFeature;
    }

    @Override
    public String toString() {
	return getFullyQualifiedName();
    }

    /**
     * @see #getId()
     * 
     * @param id
     */
    @SuppressWarnings("unused")
    private void setId(Long id) {
	this.id = id;
    }
    
    
    public String getVeryShortQualifiedName() {
	return String.format("%s, %s", getCityName(), getCountry().getName());
    }
    
    
    public String getShortUsStyleName() {
	AbstractAdministrativeEntity adm1 = getAdm(1);
	if (adm1 == null) return null;
	return String.format("%s, %s", getCityName(), adm1.getDisplayableCode());
    }
    
    
    public String getLongUsStyleName() {
	AbstractAdministrativeEntity adm1 = getAdm(1);
	if (adm1 == null) return null;
	return String.format("%s, %s", getCityName(), adm1.getDisplayableName());
    }

     public AbstractAdministrativeEntity getAdm(int level) {
	return this.associatedGisFeature.getAdm(level);
    }
    
}
