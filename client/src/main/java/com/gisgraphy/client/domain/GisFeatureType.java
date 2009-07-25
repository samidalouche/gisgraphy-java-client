package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;

/**
 *
 * @author christophe
 */
public class GisFeatureType {

    private String featureClass;
    private String featureCode;

    public GisFeatureType(String featureClass, String featureCode) {
        Validate.notEmpty(featureClass);
        Validate.notEmpty(featureCode);
        this.featureClass = featureClass;
        this.featureCode = featureCode;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public String getFeatureCode() {
        return featureCode;
    }
}
