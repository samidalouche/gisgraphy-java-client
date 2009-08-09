package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.administrativedivision.Country;

/**
 * FIXME: cyclic dependency between gisfeature and 
 * administrativedivision package
 * (Country vs GisFeature).
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 *
 */
public interface AdministrativeEntity {
    /**
     * ADM0 (Country), ADM1 (First Level ADM), ADM2, ...)
     * @return
     */
    int getAdminitrativeDivisionLevel();
    
    /**
     * Return the parent Administrative Entity 
     * @return never null
     */
    AdministrativeEntity getParentAdministrativeEntity();
    
    /**
     * Return the administrative entity that is positioned at the given level 
     * (0 will be the country, 1 will be ADM1, etc..)
     * @param level
     * @return never null
     */
    AdministrativeEntity getAdministrativeEntity(int level);
    
    /**
     * Return the country for this administrative division
     * @return
     */
    Country getCountry();
}
