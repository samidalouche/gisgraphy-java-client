package com.gisgraphy.client.domain;

import java.util.Date;

import com.gisgraphy.client.domain.crap.AbstractAdministrativeEntity;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.Assert;

public final class GisFeature {
    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    
    private Long featureId;
    private AbstractAdministrativeEntity parentEntity;
    
    private GisFeatureName featureName;
    
    private String featureClass;
    private String featureCode;

    private Geometry location;
    private Long elevation;
    private Long gtopo30AverageElevation;
    private Long population;
    private String timeZone;
    
    private Date lastModificationDate;

    private GisFeature() {
    }


    private static class GisFeatureBuilder {
        private GisFeature gisFeature;

        public GisFeatureBuilder() {
            gisFeature = new GisFeature();
        }

        public GisFeatureBuilder featureId(Long featureId) {
            gisFeature.featureId = featureId;
            return this;
        }

        public GisFeatureBuilder parentEntity(AbstractAdministrativeEntity parentEntity) {
            gisFeature.parentEntity = parentEntity;
            return this;
        }

        public GisFeatureBuilder featureName(GisFeatureName featureName) {
            gisFeature.featureName = featureName;
            return this;
        }

        public GisFeatureBuilder featureClass(String featureClass) {
            gisFeature.featureClass = featureClass;
            return this;
        }

        public GisFeatureBuilder featureCode(String featureCode) {
            gisFeature.featureCode = featureCode;
            return this;
        }

        public GisFeatureBuilder location(Geometry location) {
            gisFeature.location = location;
            return this;
        }

        public GisFeatureBuilder elevation(Long elevation) {
            gisFeature.elevation = elevation;
            return this;
        }

        public GisFeatureBuilder gtopo30AverageElevation(Long gtopo30AverageElevation) {
            gisFeature.gtopo30AverageElevation = gtopo30AverageElevation;
            return this;
        }

        public GisFeatureBuilder population(Long population) {
            gisFeature.population = population;
            return this;
        }

        public GisFeatureBuilder timeZone(String timeZone) {
            gisFeature.timeZone = timeZone;
            return this;
        }

        public GisFeatureBuilder lastModificationDate(Date lastModificationDate) {
            gisFeature.lastModificationDate = lastModificationDate;
            return this;
        }

        public GisFeature build() {
            check();
            return gisFeature;
        }

        private void check() {
            Assert.notNull(gisFeature.featureId);
            Assert.notNull(gisFeature.location);
        }
     }

    public static GisFeatureBuilder gisFeature() {
        return new GisFeatureBuilder();
    }

    public Long getElevation() {
        return elevation;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public GisFeatureName getFeatureName() {
        return featureName;
    }

    public Long getGtopo30AverageElevation() {
        return gtopo30AverageElevation;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public Geometry getLocation() {
        return location;
    }

    public AbstractAdministrativeEntity getParentEntity() {
        return parentEntity;
    }

    public Long getPopulation() {
        return population;
    }

    public String getTimeZone() {
        return timeZone;
    }
    
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((featureId == null) ? 0 : featureId.hashCode());
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
	GisFeature other = (GisFeature) obj;
	if (featureId == null) {
	    if (other.featureId != null)
		return false;
	} else if (!featureId.equals(other.featureId))
	    return false;
	return true;
    }
    
    
    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("featureId", this.featureId)
                .append("featureName", this.featureName)
                .append("featureClass", this.featureClass)
                .append("featureCode", this.featureCode)
                .append("location", this.location)
                .append("elevation", this.elevation)
                .append("gtopo30AverageElevation", this.gtopo30AverageElevation)
		.append("lastModificationDate", this.lastModificationDate)
                .append("parentEntity", this.parentEntity)
                .append("population", this.population)
                .append("timeZone", this.timeZone)
		.toString();
    }
    
}
