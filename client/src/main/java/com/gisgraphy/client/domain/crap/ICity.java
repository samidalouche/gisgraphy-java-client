package com.gisgraphy.client.domain.crap;

import java.util.List;

public interface ICity {

    List<String> getAlternateNamesAsStrings();

    Long getFeatureId();

    String getFullyQualifiedName();

    Double getLatitude();

    Double getLongitude();
    
    String getShortQualifiedName();

}