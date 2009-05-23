package com.gisgraphy.client.domain;

public interface AdministrativeEntity {
    /**
     * ADM0 (Country), ADM1 (First Level ADM), ADM2, ...)
     * @return
     */
    int getAdminitrativeDivisionLevel();
    
    AdministrativeEntity getParentAdminitrativeEntity();
}
