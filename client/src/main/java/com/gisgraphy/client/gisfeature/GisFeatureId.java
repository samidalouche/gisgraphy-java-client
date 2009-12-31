package com.gisgraphy.client.gisfeature;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class GisFeatureId {
    private Long geonamesId;

    public GisFeatureId(Long geonamesId) {
	super();
	Validate.notNull(geonamesId);
	this.geonamesId = geonamesId;
    }
    
    @Override
    public String toString() {
	return String.valueOf(geonamesId);
    }
    
    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(geonamesId)
		.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GisFeatureId other = (GisFeatureId) obj;
        
        return new EqualsBuilder()
		.append(geonamesId, other.getGeonamesId())
		.isEquals();
    }

    public Long getGeonamesId() {
        return geonamesId;
    }

}
