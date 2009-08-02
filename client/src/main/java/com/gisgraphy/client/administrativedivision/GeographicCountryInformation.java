package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public final class GeographicCountryInformation {
    private Long population;
    private Double area;
    
    private GeographicCountryInformation(Long population, Double area) {
	super();
	this.population = population;
	this.area = area;
    }
    
    public static GeographicCountryInformation geographicCountryInformation() {
	return new GeographicCountryInformation(null, null);
    }
    
    public GeographicCountryInformation withPopulation(Long population) {
	return new GeographicCountryInformation(population, this.area);
    }
    
    public GeographicCountryInformation withArea(Double area) {
	return new GeographicCountryInformation(this.population, area);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((area == null) ? 0 : area.hashCode());
	result = prime * result
		+ ((population == null) ? 0 : population.hashCode());
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
	GeographicCountryInformation other = (GeographicCountryInformation) obj;
	if (area == null) {
	    if (other.area != null)
		return false;
	} else if (!area.equals(other.area))
	    return false;
	if (population == null) {
	    if (other.population != null)
		return false;
	} else if (!population.equals(other.population))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
