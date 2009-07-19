package com.gisgraphy.client.domain;

import java.util.Date;
import java.util.List;

import com.gisgraphy.client.domain.crap.AbstractAdministrativeEntity;
import com.gisgraphy.client.domain.crap.AlternateGisFeatureName;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class GisFeature {
    public static final int WGS84_SRID = 4326;
    public static final PrecisionModel PRECISION_MODEL = new PrecisionModel(PrecisionModel.FLOATING);
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(PRECISION_MODEL, WGS84_SRID);
    
    private Long featureId;
    
    private String name;
    private String asciiName;
    private List<AlternateGisFeatureName> alternateNames;

    private String featureClass;
    private String featureCode;

    private Geometry location;
    private Long elevation;
    private Long gtopo30AverageElevation;
    
    private Date lastModificationDate;
    
    private AbstractAdministrativeEntity parentEntity;
    private Long population;
    private String timeZone;
    
    
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
    
    
    
    
}
