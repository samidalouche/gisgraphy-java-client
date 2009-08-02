package com.gisgraphy.client.gisfeature;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.springframework.util.Assert;

import com.gisgraphy.client.language.IsoLanguage;
import com.google.common.collect.ImmutableSet;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class GisFeature implements GisFeatureAware{

    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    private Long featureId;
    private AdministrativeEntity parentAdministrativeEntity;
    private GisFeatureName featureName;
    private GisFeatureType featureType;
    private GisFeatureGeography featureGeography;
    private DateTime lastModificationDate;

    private GisFeature() {
    }

    public static class GisFeatureBuilder {

        private GisFeature gisFeature;

        public GisFeatureBuilder() {
            gisFeature = new GisFeature();
        }

        public GisFeatureBuilder featureId(Long featureId) {
            gisFeature.featureId = featureId;
            return this;
        }

        public GisFeatureBuilder parentEntity(AdministrativeEntity parentEntity) {
            gisFeature.parentAdministrativeEntity = parentEntity;
            return this;
        }

        public GisFeatureBuilder name(GisFeatureName featureName) {
            gisFeature.featureName = featureName;
            return this;
        }

        public GisFeatureBuilder type(GisFeatureType featureType) {
            gisFeature.featureType = featureType;
            return this;
        }

        public GisFeatureBuilder geography(GisFeatureGeography geography) {
            gisFeature.featureGeography = geography;
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
            return gisFeature;
        }

        private void check() {
            Assert.notNull(gisFeature.featureId);
            Assert.notNull(gisFeature.featureGeography);
            Assert.notNull(gisFeature.featureName);
            Assert.notNull(gisFeature.featureType);
        }
    }

    public static GisFeatureBuilder gisFeature() {
        return new GisFeatureBuilder();
    }

    public String getFeatureClass() {
        return featureType.getFeatureClass();
    }

    public String getFeatureCode() {
        return featureType.getFeatureCode();
    }

    public Long getFeatureId() {
        return featureId;
    }

    public GisFeatureName getName() {
        return featureName;
    }

    public DateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public AdministrativeEntity getParentAdministrativeEntity() {
        return parentAdministrativeEntity;
    }

    public GisFeatureGeography getGeography() {
        return featureGeography;
    }

    public GisFeatureType getType() {
        return featureType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((featureId == null) ? 0 : featureId.hashCode());
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
        if (featureId == null) {
            if (other.featureId != null) {
                return false;
            }
        } else if (!featureId.equals(other.featureId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("featureId", this.featureId).append("featureName", this.featureName).append("featureType", this.featureType).append("featureGeograhy", this.featureGeography).append("lastModificationDate", this.lastModificationDate).append("parentEntity", this.parentAdministrativeEntity).toString();
    }

    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return featureName.getAlternateNames();
    }

    public String getGisFeatureAsciiName() {
	return featureName.getAsciiName();
    }

    public String getGisFeatureOriginalName() {
	return featureName.getName();
    }

    public String getGisFeaturePreferredName(IsoLanguage language) {
	return featureName.getPreferredName(language);
    }

    public String getGisFeatureShortName(IsoLanguage language) {
	return featureName.getShortName(language);
    }
}
