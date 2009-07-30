package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GisFeatureType other = (GisFeatureType) obj;
        if ((this.featureClass == null) ? (other.featureClass != null) : !this.featureClass.equals(other.featureClass)) {
            return false;
        }
        if ((this.featureCode == null) ? (other.featureCode != null) : !this.featureCode.equals(other.featureCode)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.featureClass != null ? this.featureClass.hashCode() : 0);
        hash = 37 * hash + (this.featureCode != null ? this.featureCode.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("featureClass", this.featureClass).append("featureCode", this.featureCode).toString();
    }
}
