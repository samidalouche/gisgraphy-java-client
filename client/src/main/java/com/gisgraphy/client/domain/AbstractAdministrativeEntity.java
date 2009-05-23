package com.gisgraphy.client.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * An abstract Administrative Entity. This by itself doesn't mean anything, but
 * is used to abstract out the notion of {@link Country} and
 * {@link AdministrativeDivision}. It is mainly used in
 * {@link AdministrativeDivision} to refer to the parent entity, which can
 * either be a {@link Country} (in the case of a First Order
 * AdministrativeDivision - e.g. a State -) or another
 * {@link AdministrativeDivision} in the case of a nested
 * {@link AdministrativeDivision} (e.g. a County, or Département, ..).
 * </p>
 * <p>
 * Remark: in the case of a true OO design (OO Database), we should use an
 * interface instead... This class uses the Interface-simulation pattern (See
 * Wiki) to simulate this..
 * </p>
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * 
 */
public abstract class AbstractAdministrativeEntity {

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @see #getAssociatedGisFeature()
     */
    protected GisFeature associatedGisFeature;

    /**
     * @see #getNestedAdministrativeEntities()
     */
    protected List<AbstractAdministrativeEntity> nestedAdministrativeEntities = new ArrayList<AbstractAdministrativeEntity>();

    /**
     * @see #getParentEntity()
     */
    protected AbstractAdministrativeEntity parentEntity;

    /**
     * Return the level of an administrative division : i.e. 0 for a country, 1,
     * 2, ++ for other ADMs
     * 
     * @return
     */
    public abstract int getAdminitrativeDivisionLevel();

    /**
     * 
     * @return
     */
    public List<AlternateGisFeatureName> getAlternateNames() {
	if (associatedGisFeature == null) {
	    return new ArrayList<AlternateGisFeatureName>();
	} else {
	    return associatedGisFeature.getAlternateNames();
	}
    }

    /**
     * Warning : is null in most cases of ADM1s
     * 
     * @return
     */
    public GisFeature getAssociatedGisFeature() {
	return associatedGisFeature;
    }

    /**
     * Get the country associated to this {@link AbstractAdministrativeEntity}.
     * This is either the current instance, or a parent instance.
     * 
     * @return
     */
  /* public Country getCountry() {
	if (this instanceof Country) {
	 //   return (Country) this;
	} else {
	    if (parentEntity != null) {
		return parentEntity.getCountry();
	    } else {
		throw new RuntimeException(
			"It is theoretically impossible to reach that point");
	    }
	}
    }*/

    public abstract String getDisplayableCode();

    public abstract String getDisplayableName();

    public Long getId() {
	return this.id;
    }
    
    public abstract AbstractAdministrativeEntity getParentAdm(int level);

    /**
     * <p>
     * Administrative Divisions. - US : States - Canada : Provinces - France :
     * Régions - ...
     * </p>
     * 
     * <p>
     * 
     * @see {@link AbstractAdministrativeEntity#getParentEntity()} for more
     *      information of why this method deals with
     *      {@link AbstractAdministrativeEntity} instead of
     *      {@link AdministrativeDivision}, even though all returned instances
     *      are necessarily of the {@link AdministrativeDivision} type.
     * 
     * </p>
     * @return Returns the nestedAdministrativeEntities.
     */
    public List<AbstractAdministrativeEntity> getNestedAdministrativeEntities() {
	return this.nestedAdministrativeEntities;
    }

    /**
     * <p>
     * the {@link Country} that this division divises, or the parent
     * {@link AdministrativeDivision}. See {@link AbstractAdministrativeEntity}
     * for more information.
     * </p>
     * <p>
     * Is always null for a Country. Is it however necessary to keep this
     * property here, because of
     * {@link Country#getNestedAdministrativeEntities()}. In fact, if this
     * method returned {@link AdministrativeDivision} directly, there would be a
     * FK from {@link AdministrativeDivision#getParentEntity()} to
     * {@link Country #getId()}, which is not what we want.
     * </p>
     * 
     * @return Returns the {@link AbstractAdministrativeEntity}.
     */
    public AbstractAdministrativeEntity getParentEntity() {
	return this.parentEntity;
    }

    /**
     * @see #getAssociatedGisFeature()
     * @param associatedGisFeature
     */
    public void setAssociatedGisFeature(GisFeature associatedGisFeature) {
	this.associatedGisFeature = associatedGisFeature;
    }

    /**
     * @see #getId()
     * @param id
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @param nestedAdministrativeEntities
     *                The nestedAdministrativeEntities to set.
     */
    public void setNestedAdministrativeEntities(
	    List<AbstractAdministrativeEntity> administrativeDivisions) {
	this.nestedAdministrativeEntities = administrativeDivisions;
    }

    /**
     * @param entity
     */
    public void setParentEntity(AbstractAdministrativeEntity entity) {
	this.parentEntity = entity;
    }

}
