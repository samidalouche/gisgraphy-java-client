package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.gisfeature.AdministrativeEntity;

public class AdministrativeEntityHierarchy {

    public interface AdministrativeEntityProvider {
	AdministrativeEntity getCurrentAdministrativeEntity();
	AdministrativeEntity getParentAdministrativeEntity();
    }
    
    private AdministrativeEntityProvider administrativeEntityProvider;
    
    public AdministrativeEntityHierarchy(AdministrativeEntityProvider administrativeEntityProvider) {
	super();
	this.administrativeEntityProvider = administrativeEntityProvider;
    }

    public int getAdminitrativeDivisionLevel() {
	return administrativeEntityProvider.getParentAdministrativeEntity().getAdminitrativeDivisionLevel()+1;
    }
    
    public AdministrativeEntity getAdministrativeEntity(int level) {
	int currentLevel = getAdminitrativeDivisionLevel();
	if(level > currentLevel) {
	    throw new IllegalArgumentException(String.format("Current Level (%s) is lower than requested Level (%s)", currentLevel, level));
	} else if (level <= 0) {
	    throw new IllegalArgumentException(String.format("Invalid Level (%s)", level));        
	} else if(level == currentLevel) {
	    return administrativeEntityProvider.getCurrentAdministrativeEntity();
	} else {
	    return administrativeEntityProvider.getParentAdministrativeEntity().getAdministrativeEntity(level);
	}
    } 
}
