/**
 *
 */
package com.gisgraphy.client.domain;

import java.util.Date;
import java.util.List;

import javax.measure.quantity.Length;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.operation.TransformException;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * 
 * Represents a GIS Feature. Currently, we only import Geonames Features.
 * 
 * FIXME: the couple source, featureId should be unique !
 */
public class GisFeature {
    public static final String LOCATION_COLUMN = "location";

    public static final int WGS84_SRID = 4326;
    
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);

    /**
     * @see #getAlternateNames()
     */
    private List<AlternateGisFeatureName> alternateNames;

    /**
     * @see #getAsciiName()
     */
    private String asciiName;

    /**
     * @see #getElevation()
     */
    private Long elevation;

    /**
     * @see #getFeatureClass()
     */
    private String featureClass;

    /**
     * @see #getFeatureCode()
     */
    private String featureCode;

    /**
     * @see #getGtopo30AverageElevation()
     */
    private Long gtopo30AverageElevation;

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @see #getLocation()
     */
    private Geometry location;

    /**
     * @see #getModificationDate()
     */
    private Date modificationDate;

    /**
     * @see #getName()
     */
    private String name;

    /**
     * @see #getParentEntity()
     */
    private AbstractAdministrativeEntity parentEntity;

    /**
     * @see #getPopulation()
     */
    private Long population;

    /**
     * @see #getTimeZone()
     */
    private String timeZone;

    /**
     * @see #getFeatureId()
     */
    protected Long featureId;

    /**
     * @see #getFeatureSource()
     */
    protected GisFeatureSourceType featureSource = GisFeatureSourceType.GEONAMES;

    public GisFeature(AbstractAdministrativeEntity parentEntity,
	    Double locationLongitude, Double locationLatitude, String name,
	    GisFeatureSourceType featureSource, Long featureId) {
	super();
	this.parentEntity = parentEntity;
	this.setLocation(locationLongitude, locationLatitude);
	this.name = name;
	this.featureSource = featureSource;
	this.featureId = featureId;

    }

    public GisFeature(GisFeatureSourceType featureSource, Long featureId) {
	super();
	this.featureSource = featureSource;
	this.featureId = featureId;
    }

    /**
     * Creates a {@link GisFeature} with a featureSourceType of
     * {@link GisFeatureSourceType#FUNALA}
     * 
     * @param featureId
     */
    public GisFeature(Long featureId) {
	super();
	this.featureSource = GisFeatureSourceType.FUNALA;
	this.featureId = featureId;
    }

    /**
     * 
     */
    @SuppressWarnings("unused")
    private GisFeature() {
	super();
    }

    /**
     * Calculate the distance in the given {@link Unit}.
     * 
     * @param gisFeature
     * @param unit
     *                can be null, defaults si {@link SI#METER}
     * @return
     */
    public double distance(GisFeature gisFeature, Unit<Length> unit) {
	Unit<Length> targetUnit = (unit != null) ? unit : SI.METER;
	com.vividsolutions.jts.geom.Geometry me = getLocationAsJtsPoint();
	com.vividsolutions.jts.geom.Geometry other = gisFeature.getLocationAsJtsPoint();
	try {
	    return SI.METER.getConverterTo(targetUnit).convert(JTS.orthodromicDistance(me.getCoordinate(), other.getCoordinate(), DefaultGeographicCRS.WGS84));
	} catch (TransformException e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (this.getClass() != obj.getClass()) {
	    return false;
	}
	final GisFeature other = (GisFeature) obj;
	if (this.featureId == null) {
	    if (other.featureId != null) {
		return false;
	    }
	} else if (!this.featureId.equals(other.featureId)) {
	    return false;
	}
	if (this.featureSource == null) {
	    if (other.featureSource != null) {
		return false;
	    }
	} else if (!this.featureSource.equals(other.featureSource)) {
	    return false;
	}
	return true;
    }

    /**
     * The alternate Names for this Feature
     * 
     * @return
     */
    public List<AlternateGisFeatureName> getAlternateNames() {
	return alternateNames;
    }

    public String getAsciiName() {
	return this.asciiName;
    }

   AbstractAdministrativeEntity getAdm(int level) {
	return parentEntity.getParentAdm(level);
    }
    

    public Country getCountry() {

	if (parentEntity != null) {
	    return parentEntity.getCountry();
	} else {
	    throw new RuntimeException(
		    "Programming Error: It looks like there are other AbstractAdministrativeEntity "
			    + "besides Country and AdministrativeDivision");
	}
	// AbstractAdministrativeEntity current = this.parentEntity;
	// do {
	// if (current != null) {
	// if (current instanceof Country) {
	// return (Country) current;
	// } else if (current instanceof AdministrativeDivision) {
	// current = ((AdministrativeDivision) current)
	// .getParentEntity();
	// } else {
	// throw new RuntimeException(
	// "Programming Error: It looks like there are other
	// AbstractAdministrativeEntity "
	// + "besides Country and AdministrativeDivision");
	// }
	// }
	// } while (current != null);
	//
	// throw new RuntimeException(
	// "It is theoretically impossible to get this exception");
    }

    /**
     * The Elevation (in meters ?). We do not store it inside the location for
     * now, because it is supposed to be slower for PotgreSQL...
     * 
     * @return
     */
    public Long getElevation() {
	return this.elevation;
    }

    /**
     * The Feature Class, as described in
     * http://www.geonames.org/statistics/total.html. Examples :
     * <ul>
     * <li>A : administrative boundaries (country, stage, region..) </li>
     * <li>H : hydrographic ResidenceFeatures (stream, lake)..</li>
     * <li>L : Area ResidenceFeatures (parks, area..) </li>
     * <li>P : Populated Places (City, Village..) </li>
     * <li>R: Road, Railroad </li>
     * <li>S : spot ResidenceFeatures (Spot, building, Farm) </li>
     * <li>T : Hypsographic ResidenceFeatures (Mountain, Hill, Rock..) </li>
     * <li>U : Undersea ResidenceFeatures </li>
     * <li>V : Vegetation ResidenceFeatures (forest, health..) </li>
     * </ul>
     * 
     * @return
     */
    public String getFeatureClass() {
	return this.featureClass;
    }

    /**
     * The Feature Code, as described in
     * http://www.geonames.org/statistics/total.html It is relative to the
     * Feature Class. ({@link GisFeature#getFeatureClass()}
     * 
     * @return
     */
    public String getFeatureCode() {
	return this.featureCode;
    }

    /**
     * 
     * @see IGisFeature#getFeatureId()
     * @return Returns the featureId.
     */
    public Long getFeatureId() {
	return this.featureId;
    }

    /**
     * 
     * @see IGisFeature#getFeatureSource()
     * @return Returns the featureSource.
     */
    public GisFeatureSourceType getFeatureSource() {
	return this.featureSource;
    }

    /**
     * FIXME
     * 
     * @return
     */
    public Long getGtopo30AverageElevation() {
	return this.gtopo30AverageElevation;
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {
	return this.id;
    }

    /**
     * 
     * @return Returns the latitude.
     */
    public Double getLatitude() {

	Point point = (Point) location;
	return point.getY();
    }

    /**
     * Returns the location of the feature (e.g. the Geometry type representing
     * the latitude, longitude, etc..
     * 
     * @return
     */
    public Geometry getLocation() {
	return location;
    }

    public com.vividsolutions.jts.geom.Point getLocationAsJtsPoint() {
    	return GEOMETRY_FACTORY
		.createPoint(new Coordinate(getLongitude(), getLatitude()));
    }

    /**
     * @return Returns the longitude.
     */
    public Double getLongitude() {

	Point point = (Point) location;

	return point.getX();
    }

    /**
     * The modification date of the feature
     * 
     * @return
     */
    public Date getModificationDate() {
	return this.modificationDate;
    }

    /**
     * The (US english) authoritative name of the feature
     * 
     * @return Returns the name.
     */
    public String getName() {
	return this.name;
    }

    /**
     * Tha parent entity of the City (Its country, or if the information is
     * available, its First Order Administrative Division, or SecondOrder
     * Administrative Division, or 3rd...
     * 
     * @return
     */
    public AbstractAdministrativeEntity getParentEntity() {
	return this.parentEntity;
    }

    public Long getPopulation() {
	return this.population;
    }

    /**
     * The time zone
     * 
     * @return
     */
    public String getTimeZone() {
	return this.timeZone;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result
		+ ((this.featureId == null) ? 0 : this.featureId.hashCode());
	result = PRIME
		* result
		+ ((this.featureSource == null) ? 0 : this.featureSource
			.hashCode());
	return result;
    }

    /**
     * Whether the feature is a city, in the sense we define it in the
     * {@link City} class
     * 
     * @return
     */
    public boolean isCity() {

	boolean res = false;

	if (!this.featureClass.equals("P")) {
	    return false; // quickly stop
	}

	// else

	if (this.featureCode.equals("PPL")) {
	    res = true;
	}

	if (this.featureCode.equals("PPLA")) {
	    res = true;
	}
	if (this.featureCode.equals("PPLC")) {
	    res = true;
	}
	if (this.featureCode.equals("PPLG")) {
	    res = true;
	}
	if (this.featureCode.equals("PPLL")) {
	    res = true;
	}
	// PPLQ is abandoned, so we don't want it
	// if(featureCode.equals("PPLQ") ){
	// res = true;
	// }
	if (this.featureCode.equals("PPLR")) {
	    res = true;
	}
	if (this.featureCode.equals("PPLS")) {
	    res = true;
	}

	// Destroyed, so no need for us ?
	// if(featureCode.equals("PPLW") ){
	// res = true;
	// }

	// section of ppl, like arrondissement. Useful ?
	// if(featureCode.equals("PPLX") ){
	// res = true;
	// }

	if (this.featureCode.equals("STLMT")) { // israeli..
	    res = true;
	}

	return res;
    }

    /**
     * Whether the Feature is a historical feature.
     * 
     * FIXME: is the (historical) match enough ? ...
     * 
     * @return
     */
    public boolean isHistoricalFeature() {
	if (this.name.contains("historical")) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * @see #getAlternateNames()
     * @param alternateNames
     */
    public void setAlternateNames(List<AlternateGisFeatureName> alternateNames) {
	this.alternateNames = alternateNames;
    }

    /**
     * @see #getAsciiName()
     * @param asciiName
     */
    public void setAsciiName(String asciiName) {
	this.asciiName = asciiName;
    }

    /**
     * Wrapper around {@link #setParentEntity(AbstractAdministrativeEntity)}
     * Only sets the country if there is no administrative Division as the
     * parent entity, otherwise, we loose information
     * 
     * @param country
     *                The country to set.
     */

    @Deprecated
    public void setCountry(Country country) {
	if (country != null) {
	    if ((this.parentEntity == null)
		    || (this.parentEntity instanceof Country)) {
		this.setParentEntity(country);
	    }
	}
    }

    /**
     * @see #getElevation()
     * @param elevation
     */
    public void setElevation(Long elevation) {
	this.elevation = elevation;
    }

    /**
     * @see #getFeatureClass()
     * @param featureClass
     */
    public void setFeatureClass(String featureClass) {
	this.featureClass = featureClass;
    }

    /**
     * @see #getFeatureCode()
     * @param featureCode
     */
    public void setFeatureCode(String featureCode) {
	this.featureCode = featureCode;
    }

    /**
     * @see #getFeatureId()
     * @param featureId
     *                The featureId to set.
     */
    public void setFeatureId(Long featureId) {
	this.featureId = featureId;
    }

    /**
     * @param featureSource
     *                The featureSource to set.
     */
    public void setFeatureSource(GisFeatureSourceType featureSource) {
	this.featureSource = featureSource;
    }

    /**
     * Wrapper around {@link #setParentEntity(AbstractAdministrativeEntity)} :
     * compatibility method. Will set the given administrative division as the
     * parent entity ONLY if it adds information. Basically, if the current
     * parent Entity is a Country, this adds information, so we save the ADM1
     * instead. However, in the other cases, we do not do anything
     * 
     * @param firstOrderAdministrativeDivision
     *                The firstOrderAdministrativeDivision to set.
     */
    @Deprecated
    public void setFirstOrderAdministrativeDivision(
	    AdministrativeDivision administrativeDivision) {
	if (administrativeDivision != null) {

	    if ((this.parentEntity == null)
		    || (this.parentEntity instanceof Country)) {
		this.setParentEntity(administrativeDivision);
	    }

	}
    }

    /**
     * @øee {@link #getGtopo30AverageElevation()}
     * @param gtopo30AverageElevation
     */
    public void setGtopo30AverageElevation(Long gtopo30AverageElevation) {
	this.gtopo30AverageElevation = gtopo30AverageElevation;
    }

    /**
     * @see #getId()
     * @param id
     *                The id to set.
     */
    public void setId(Long id) {
	this.id = id;
    }

    public void setLocation(Double longitude, Double latitude) {
    	location = GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude));
    }

    /**
     * @see #getLocation()
     * @param location
     */
    public void setLocation(Geometry location) {
	this.location = location;
    }

    /**
     * @see #getModificationDate()
     * @param modificationDate
     */
    public void setModificationDate(Date modificationDate) {
	this.modificationDate = modificationDate;
    }

    /**
     * @param name
     *                The name to set.
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @see #getParentEntity()
     * @param parentEntity
     */
    public void setParentEntity(AbstractAdministrativeEntity parentEntity) {
	this.parentEntity = parentEntity;
    }

    /**
     * @see #getPopulation()
     * @param population
     */
    public void setPopulation(Long population) {
	this.population = population;
    }

    /**
     * Wrapper around {@link City#setParentEntity(AbstractAdministrativeEntity)} :
     * compatibility method. Will set the given administrative division as the
     * parent entity
     * 
     * @param secondOrderAdministrativeDivision
     */
    @Deprecated
    public void setSecondOrderAdministrativeDivision(
	    AdministrativeDivision secondOrderAdministrativeDivision) {

	if (secondOrderAdministrativeDivision != null) {
	    this.setParentEntity(secondOrderAdministrativeDivision);
	}
    }

    /**
     * @see #getTimeZone()
     * @param timeZone
     */
    public void setTimeZone(String timeZone) {
	this.timeZone = timeZone;
    }


}
