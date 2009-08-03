package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.gisfeature.AdministrativeEntity;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureAware;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableSet;

public final class City implements Comparable<City>, GisFeatureAware{
    private GisFeature gisFeature;

    public int compareTo(City o) {
	if (o == null) {
	    return 1;
	} else {
	    return this.getName().compareTo(o.getName());
	}
    }

    public String getName() {
	return getGisFeatureDefaultName();
    }
    
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((gisFeature == null) ? 0 : gisFeature.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	City other = (City) obj;
	if (gisFeature == null) {
	    if (other.gisFeature != null)
		return false;
	} else if (!gisFeature.equals(other.gisFeature))
	    return false;
	return true;
    }
    
    //// GisFeatureAware implementation ////
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return gisFeature.getGisFeatureAlternateNames();
    }

    public GisFeature getGisFeature() {
        return gisFeature;
    }
    public Long getGeonamesId() {
	return gisFeature.getGeonamesId();
    }
    
    public String getGisFeatureDefaultName() {
	return gisFeature.getGisFeatureDefaultName();
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	return gisFeature.getGisFeaturePreferredName(language);
    }

    public String getGisFeatureShortName(Iso639Language language) {
	return gisFeature.getGisFeatureShortName(language);
    }

    public AdministrativeEntity getParentAdministrativeEntity() {
	return gisFeature.getParentAdministrativeEntity();
    }
    
    //// ////

}
