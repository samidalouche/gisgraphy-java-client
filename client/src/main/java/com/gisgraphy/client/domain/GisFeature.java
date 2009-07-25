package com.gisgraphy.client.domain;

import com.gisgraphy.client.domain.crap.AbstractAdministrativeEntity;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.springframework.util.Assert;

public final class GisFeature {

    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    private Long featureId;
    private AbstractAdministrativeEntity parentEntity;
    private GisFeatureName featureName;
    private GisFeatureType featureType;
    private GisFeatureGeography featureGeography;
    private DateTime lastModificationDate;

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

        public GisFeatureBuilder featureType(GisFeatureType featureType) {
            gisFeature.featureType = featureType;
            return this;
        }

        public GisFeatureBuilder featureGeography(GisFeatureGeography geography) {
            gisFeature.featureGeography = geography;
            return this;
        }

        public GisFeatureBuilder lastModificationDate(DateTime lastModificationDate) {
            gisFeature.lastModificationDate = lastModificationDate;
            return this;
        }

        public GisFeature build() {
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

    public GisFeatureName getFeatureName() {
        return featureName;
    }

    public DateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public AbstractAdministrativeEntity getParentEntity() {
        return parentEntity;
    }

    public GisFeatureGeography getFeatureGeography() {
        return featureGeography;
    }

    public GisFeatureType getFeatureType() {
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
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("featureId", this.featureId).append("featureName", this.featureName).append("featureType", this.featureType).append("featureGeograhy", this.featureGeography).append("lastModificationDate", this.lastModificationDate).append("parentEntity", this.parentEntity).toString();
    }
}
