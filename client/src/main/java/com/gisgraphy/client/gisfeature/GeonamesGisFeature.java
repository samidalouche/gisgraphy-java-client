package com.gisgraphy.client.gisfeature;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.util.Assert;

import com.gisgraphy.client.commons.DistanceCalculator;
import com.gisgraphy.client.commons.NamePart;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class GeonamesGisFeature implements GisFeature, DistanceCalculator<GisFeature>{

    public static class GisFeatureBuilder {

        private GeonamesGisFeature gisFeature;

        public GisFeatureBuilder() {
            gisFeature = new GeonamesGisFeature();
        }

        public GeonamesGisFeature build() {
            if (gisFeature.lastModificationDate == null) {
                gisFeature.lastModificationDate = new DateTime();
            }
            check();
            return returnAndNullify();
        }

        private void check() {
            Assert.notNull(gisFeature.gisFeatureId);
            Assert.notNull(gisFeature.geography);
            Assert.notNull(gisFeature.names);
            Assert.notNull(gisFeature.type);
        }

        public GisFeatureBuilder geography(GisFeatureGeography geography) {
            gisFeature.geography = geography;
            return this;
        }

        public GisFeatureBuilder geonamesId(Long featureId) {
            gisFeature.gisFeatureId = new GisFeatureId(featureId);
            return this;
        }

        public GisFeatureBuilder lastModificationDate(DateTime lastModificationDate) {
            gisFeature.lastModificationDate = lastModificationDate;
            return this;
        }

        public GisFeatureBuilder names(GisFeatureNames featureNames) {
            gisFeature.names = featureNames;
            return this;
        }

        public GisFeatureBuilder parentAdministrativeEntity(AdministrativeEntity parentEntity) {
            gisFeature.parentAdministrativeEntity = parentEntity;
            return this;
        }

	private GeonamesGisFeature returnAndNullify() {
	    GeonamesGisFeature toReturn = gisFeature;
            this.gisFeature = null;
	    return toReturn;
	}

        public GisFeatureBuilder type(GisFeatureType featureType) {
            gisFeature.type = featureType;
            return this;
        }
    }
    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    
    
    public static GisFeatureBuilder gisFeature() {
        return new GisFeatureBuilder();
    }
    private GisFeatureGeography geography;
    private GisFeatureId gisFeatureId;
    private DateTime lastModificationDate;
    private GisFeatureNames names;

    private AdministrativeEntity parentAdministrativeEntity;

    private GisFeatureType type;

    private GeonamesGisFeature() {
    }

    public double distance(GisFeature o, Unit<Length> unit) {
	return this.geography.distance(((GeonamesGisFeature)o).geography, unit);
    }


    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(gisFeatureId)
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
        GeonamesGisFeature other = (GeonamesGisFeature) obj;
        
        return new EqualsBuilder()
		.append(gisFeatureId, other.gisFeatureId)
		.isEquals();
    }

    public GisFeatureGeography getGeography() {
        return geography;
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
        return gisFeatureId.getGeonamesId();
    }

    public GeonamesGisFeature getGisFeature() {
	return this;
    }

    // GisFeatureAware //
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return names.getAlternateNames();
    }

    public String getGisFeatureAsciiName() {
	return names.getAsciiName();
    }

    public String getGisFeatureDefaultName() {
	return names.getName();
    }

    public Long getElevation() {
	return geography.getElevation();
    }

    
    public Long getGtopo30AverageElevation() {
	return geography.getGtopo30AverageElevation();
    }

    public double getLatitude() {
	return geography.getLatitude();
    }

    public Point getLocation() {
	return geography.getLocation();
    }

    public double getLongitude() {
	return geography.getLongitude();
    }

    public Long getPopulation() {
	return geography.getPopulation();
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	return names.getPreferredName(language);
    }
    
    public String getGisFeatureShortName(Iso639Language language) {
	return names.getShortName(language);
    }

    public DateTimeZone getTimeZone() {
	return geography.getTimeZone();
    }

    public DateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public String getName() {
	return names.getName();
    }
    public GisFeatureNames getNames() {
        return names;
    }

    public GisFeatureType getGisFeatureType() {
	return type;
    }


    /**
     * 
     * @return possibly null result for features located in international waters
     */
    public AdministrativeEntity getParentAdministrativeEntity() {
        return parentAdministrativeEntity;
    }

    public GisFeatureType getType() {
        return type;
    }

    
    // //
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("featureId", this.gisFeatureId).append("featureName", this.names).append("featureType", this.type).append("featureGeograhy", this.geography).append("lastModificationDate", this.lastModificationDate).append("parentEntity", this.parentAdministrativeEntity).toString();
    }

    public ImmutableList<NamePart> getFullyQualifiedNameParts() {
	return ImmutableList.copyOf(
		Iterables.concat(
			getParentAdministrativeEntity() != null ? getParentAdministrativeEntity().getFullyQualifiedNameParts() : emptyStringList(), 
			ImmutableList.of(new NamePart(getName(), getFriendlyCode()))));
    }

    private ImmutableList<NamePart> emptyStringList() {
	return ImmutableList.of();
    }

    public String getFriendlyCode() {
	return null;
    }

    public GisFeatureId getGisFeatureId() {
        return gisFeatureId;
    }
   
}
