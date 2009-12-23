package com.gisgraphy.client.administrativedivision;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.gisgraphy.client.gisfeature.AdministrativeEntity;

public class AdministrativeEntityHiearchyTest {

    @Test public void shouldReturnParentAdministrativeDivisionLevelPlusOne() {
	
	AdministrativeEntity parentAdministrativeEntity = administrativeEntityThatReturnsALevelOf(2);
	
	AdministrativeEntityHierarchy.AdministrativeEntityProvider administrativeEntityProvider = mock(AdministrativeEntityHierarchy.AdministrativeEntityProvider.class);
	when(administrativeEntityProvider.getParentAdministrativeEntity()).thenReturn(parentAdministrativeEntity);
	AdministrativeEntityHierarchy administrativeEntityHierarchy = new AdministrativeEntityHierarchy(administrativeEntityProvider);
	
	Assert.assertEquals(2+1, administrativeEntityHierarchy.getAdminitrativeDivisionLevel());
	verify(administrativeEntityProvider, atLeastOnce()).getParentAdministrativeEntity();
    }
    
    private AdministrativeEntity administrativeEntityThatReturnsALevelOf(int level) {
	AdministrativeEntity administrativeEntity = mock(AdministrativeEntity.class);
	when(administrativeEntity.getAdminitrativeDivisionLevel()).thenReturn(level);
	when(administrativeEntity.getAdministrativeEntity(level)).thenReturn(administrativeEntity);
	return administrativeEntity;
    }
    
    
    
    @Test public void getAdministrativeEntityShouldReturnCurrentAdministrativeEntityWhenRequestedLevelIsCurrentLevel() {
	AdministrativeEntity parentAdministrativeEntity = administrativeEntityThatReturnsALevelOf(2);
	AdministrativeEntity currentAdministrativeEntity = mock(AdministrativeEntity.class);
	
	AdministrativeEntityHierarchy.AdministrativeEntityProvider administrativeEntityProvider = mock(AdministrativeEntityHierarchy.AdministrativeEntityProvider.class);
	when(administrativeEntityProvider.getParentAdministrativeEntity()).thenReturn(parentAdministrativeEntity);
	when(administrativeEntityProvider.getCurrentAdministrativeEntity()).thenReturn(currentAdministrativeEntity);
	
	AdministrativeEntityHierarchy administrativeEntityHierarchy = new AdministrativeEntityHierarchy(administrativeEntityProvider);
	Assert.assertSame(currentAdministrativeEntity, administrativeEntityHierarchy.getAdministrativeEntity(3));
	verify(administrativeEntityProvider).getCurrentAdministrativeEntity();
    }
    
    
    @Test public void getAdministrativeEntityShouldDelegateToParentAdministrativeEntityWhenRequestedLevelIsLowerThanCurrentLevel() {
	AdministrativeEntity parentAdministrativeEntity = administrativeEntityThatReturnsALevelOf(2);
	AdministrativeEntity currentAdministrativeEntity = mock(AdministrativeEntity.class);
	
	AdministrativeEntityHierarchy.AdministrativeEntityProvider administrativeEntityProvider = mock(AdministrativeEntityHierarchy.AdministrativeEntityProvider.class);
	when(administrativeEntityProvider.getParentAdministrativeEntity()).thenReturn(parentAdministrativeEntity);
	when(administrativeEntityProvider.getCurrentAdministrativeEntity()).thenReturn(currentAdministrativeEntity);
	
	AdministrativeEntityHierarchy administrativeEntityHierarchy = new AdministrativeEntityHierarchy(administrativeEntityProvider);
	Assert.assertSame(parentAdministrativeEntity, administrativeEntityHierarchy.getAdministrativeEntity(2));
	verify(administrativeEntityProvider, atLeastOnce()).getParentAdministrativeEntity();
	
    }
    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldThrowExceptionWhenRequestedLevelIsHigherThanCurrentLevel() {
	administrativeEntityHierarchyBasedOnParentAdm2().getAdministrativeEntity(4);
    }

    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldThrowExceptionWhenRequestedLevelIsLowerThanZero() {
	administrativeEntityHierarchyBasedOnParentAdm2().getAdministrativeEntity(-1);
    }
    
    private AdministrativeEntityHierarchy administrativeEntityHierarchyBasedOnParentAdm2() {
	AdministrativeEntity parentAdministrativeEntity = administrativeEntityThatReturnsALevelOf(2);
	
	AdministrativeEntityHierarchy.AdministrativeEntityProvider administrativeEntityProvider = mock(AdministrativeEntityHierarchy.AdministrativeEntityProvider.class);
	when(administrativeEntityProvider.getParentAdministrativeEntity()).thenReturn(parentAdministrativeEntity);
	AdministrativeEntityHierarchy administrativeEntityHierarchy = new AdministrativeEntityHierarchy(administrativeEntityProvider);
	return administrativeEntityHierarchy;
    }
}
