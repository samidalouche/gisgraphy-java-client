package com.gisgraphy.client.commons;

import org.junit.Assert;
import org.junit.Test;

public class NamePartTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateNamePartWithNullName() {
	new NamePart(null, null);
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateNamePartWithEmptyName() {
	new NamePart("", null);
    }
    
    @Test public void shouldCreateNamePartWithoutFriendlyCode() {
	NamePart part = new NamePart("Paris", null);
	Assert.assertEquals("Paris", part.getName());
	Assert.assertNull(part.getFriendlyCode());
    }
    
    @Test public void shouldCreateNamePartWithFriendlyCode() {
	NamePart part = new NamePart("California", "CA");
	Assert.assertEquals("California", part.getName());
	Assert.assertEquals("CA", part.getFriendlyCode());
    }
    
    @Test public void toStringShouldDisplayAllProperties() {
	Assert.assertEquals("NamePart[name=California,friendlyCode=CA]", new NamePart("California", "CA").toString());
    }
}
