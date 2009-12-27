package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public final class GeonamesGeographicCountryInformation implements GeographicCountryInformation {
    private Long population;
    private Double area;
    
    private GeonamesGeographicCountryInformation(Long population, Double area) {
	super();
	this.population = population;
	this.area = area;
    }
    
    public static GeonamesGeographicCountryInformation geographicCountryInformation() {
	return new GeonamesGeographicCountryInformation(null, null);
    }
    
    public GeonamesGeographicCountryInformation withPopulation(Long population) {
	return new GeonamesGeographicCountryInformation(population, this.area);
    }
    
    public GeographicCountryInformation withArea(Double area) {
	return new GeonamesGeographicCountryInformation(this.population, area);
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(area)
		.append(population)
		.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	GeonamesGeographicCountryInformation other = (GeonamesGeographicCountryInformation) obj;
	return new EqualsBuilder()
		.append(area, other.getArea())
		.append(population, other.getPopulation())
		.isEquals();
    }
    
    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.GeographicCountryInformation#getPopulation()
     */
    public Long getPopulation() {
        return population;
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.GeographicCountryInformation#getArea()
     */
    public Double getArea() {
        return area;
    }
}
