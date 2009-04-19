package com.gisgraphy.client.domain;

import java.util.List;

public interface ICity {

    List<String> getAlternateNamesAsStrings();

    Long getFeatureId();

    String getFullyQualifiedName();

    Double getLatitude();

    Double getLongitude();
    
    String getShortQualifiedName();

}