package com.gisgraphy.client.administrativedivision;

public interface GeographicCountryInformation {
    /**
     * @return null or zero if information not available
     */
    Long getPopulation();
    /**
     * @return null or zero if information not available
     */
    Double getArea();
}