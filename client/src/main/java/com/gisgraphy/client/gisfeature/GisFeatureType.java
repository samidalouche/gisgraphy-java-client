package com.gisgraphy.client.gisfeature;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author christophe
 */
public final class GisFeatureType {
    public static class GisFeatureTypeBuilder {
	private String geonamesFeatureClass;

	public GisFeatureTypeBuilder(String featureClass) {
	    super();
	    this.geonamesFeatureClass = featureClass;
	}
	
	public GisFeatureType geonamesFeatureCode(String code) {
	    return new GisFeatureType(this.geonamesFeatureClass, code);
	}
 	
    }
    private String geonamesFeatureClass;
    private String geonamesFeatureCode;

    public static GisFeatureTypeBuilder geonamesFeatureClass(String featureClass) {
	return new GisFeatureTypeBuilder(featureClass);
    }
    
    private GisFeatureType(String geonamesFeatureClass, String geonamesFeatureCode) {
        Validate.notEmpty(geonamesFeatureClass);
        Validate.notEmpty(geonamesFeatureCode);
        this.geonamesFeatureClass = geonamesFeatureClass;
        this.geonamesFeatureCode = geonamesFeatureCode;
    }

    public String getGeonamesFeatureClass() {
        return geonamesFeatureClass;
    }

    public String getGeonamesFeatureCode() {
        return geonamesFeatureCode;
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
        if ((this.geonamesFeatureClass == null) ? (other.geonamesFeatureClass != null) : !this.geonamesFeatureClass.equals(other.geonamesFeatureClass)) {
            return false;
        }
        if ((this.geonamesFeatureCode == null) ? (other.geonamesFeatureCode != null) : !this.geonamesFeatureCode.equals(other.geonamesFeatureCode)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.geonamesFeatureClass != null ? this.geonamesFeatureClass.hashCode() : 0);
        hash = 37 * hash + (this.geonamesFeatureCode != null ? this.geonamesFeatureCode.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("geonamesFeatureClass", this.geonamesFeatureClass).append("geonamesFeatureCode", this.geonamesFeatureCode).toString();
    }
}
