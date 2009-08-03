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
     * @return
     */
    AdministrativeEntity getParentAdministrativeEntity();
    AdministrativeEntity getAdministrativeEntity(int level);
    
    Country getCountry();
}
