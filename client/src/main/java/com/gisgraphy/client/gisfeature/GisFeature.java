package com.gisgraphy.client.gisfeature;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.springframework.util.Assert;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableSet;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class GisFeature implements GisFeatureAware, DistanceAware<GisFeature>{

    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    private Long geonamesId;
    private GisFeatureName name;
    private GisFeatureType type;
    private AdministrativeEntity parentAdministrativeEntity;
    private GisFeatureGeography geography;
    private DateTime lastModificationDate;

    private GisFeature() {
    }

    public static class GisFeatureBuilder {

        private GisFeature gisFeature;

        public GisFeatureBuilder() {
            gisFeature = new GisFeature();
        }

        public GisFeatureBuilder geonamesId(Long featureId) {
            gisFeature.geonamesId = featureId;
            return this;
        }

        public GisFeatureBuilder parentAdministrativeEntity(AdministrativeEntity parentEntity) {
            gisFeature.parentAdministrativeEntity = parentEntity;
            return this;
        }

        public GisFeatureBuilder name(GisFeatureName featureName) {
            gisFeature.name = featureName;
            return this;
        }

        public GisFeatureBuilder type(GisFeatureType featureType) {
            gisFeature.type = featureType;
            return this;
        }

        public GisFeatureBuilder geography(GisFeatureGeography geography) {
            gisFeature.geography = geography;
            return this;
        }

        public GisFeatureBuilder lastModificationDate(DateTime lastModificationDate) {
            gisFeature.lastModificationDate = lastModificationDate;
            return this;
        }

        public GisFeature build() {
            if (gisFeature.lastModificationDate == null) {
                gisFeature.lastModificationDate = new DateTime();
            }
            check();
            return returnAndNullify();
        }

	private GisFeature returnAndNullify() {
	    GisFeature toReturn = gisFeature;
            this.gisFeature = null;
	    return toReturn;
	}

        private void check() {
            Assert.notNull(gisFeature.geonamesId);
            Assert.notNull(gisFeature.geography);
            Assert.notNull(gisFeature.name);
            Assert.notNull(gisFeature.type);
        }
    }

    public static GisFeatureBuilder gisFeature() {
        return new GisFeatureBuilder();
    }

    public String getGeonamesFeatureClass() {
        return type.getGeonamesFeatureClass();
    }

    public String getGeonamesFeatureCode() {
        return type.getGeonamesFeatureCode();
    }

    /**
     * the public, stable, Geoname feature ID
     * @return
     */
    public Long getGeonamesId() {
        return geonamesId;
    }

    public GisFeatureName getName() {
        return name;
    }

    public DateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public AdministrativeEntity getParentAdministrativeEntity() {
        return parentAdministrativeEntity;
    }

    public GisFeatureGeography getGeography() {
        return geography;
    }

    public GisFeatureType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geonamesId == null) ? 0 : geonamesId.hashCode());
        return result;
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
        GisFeature other = (GisFeature) obj;
        if (geonamesId == null) {
            if (other.geonamesId != null) {
                return false;
            }
        } else if (!geonamesId.equals(other.geonamesId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("featureId", this.geonamesId).append("featureName", this.name).append("featureType", this.type).append("featureGeograhy", this.geography).append("lastModificationDate", this.lastModificationDate).append("parentEntity", this.parentAdministrativeEntity).toString();
    }

    
    // GisFeatureAware //
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return name.getAlternateNames();
    }

    public String getGisFeatureAsciiName() {
	return name.getAsciiName();
    }

    public String getGisFeatureDefaultName() {
	return name.getName();
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	return name.getPreferredName(language);
    }

    public String getGisFeatureShortName(Iso639Language language) {
	return name.getShortName(language);
    }

    public GisFeature getGisFeature() {
	return this;
    }
    // //
    
    public double distance(GisFeature o, Unit<Length> unit) {
	return this.geography.distance(o.geography, unit);
    }
}
