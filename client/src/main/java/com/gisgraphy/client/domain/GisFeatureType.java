package com.gisgraphy.client.domain;

import org.springframework.util.Assert;

/**
 *
 * @author christophe
 */
public class GisFeatureType {

    private String featureClass;
    private String featureCode;

    public GisFeatureType(String featureClass, String featureCode) {
        Assert.hasText(featureClass);
        Assert.hasText(featureCode);
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
