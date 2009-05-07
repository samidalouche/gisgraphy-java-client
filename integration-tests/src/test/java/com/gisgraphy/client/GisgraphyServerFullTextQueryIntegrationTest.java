/**
 * ImgServer Java REST Client
 * Copyright (C) 2008 Sami Dalouche
 *
 * This file is part of ImgServer Java REST Client.
 *
 * ImgServer Java REST Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ImgServer Java REST Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ImgServer.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gisgraphy.client;

import java.io.IOException;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.domain.FullTextQueryResult;
import com.gisgraphy.client.impl.SearchQuery;
import com.gisgraphy.client.parser.StaxParser;

public class GisgraphyServerFullTextQueryIntegrationTest extends AbstractGisgraphyClientIntegrationTestCase {
	private static final StaxParser parser = new StaxParser();

    @Before @After
    public void clean() {
	
    }
    
    @Test
    public void shouldExecuteFullTextSearchForParisWithoutPlaceTypeIncludesOtherTypes() throws IOException {
    	InputStreamSource iss = httpGisgraphyServer.fullTextSearch(SearchQuery.newSearchQuery().withQueryString("paris").build());
    	Iterable<FullTextQueryResult> results = parser.parseFullTextSearchResult(iss.getInputStream());
    	Iterator<FullTextQueryResult> iterator = results.iterator();
    	for (int i = 0; i < 10; i++) {
    		Assert.assertTrue(iterator.hasNext());
    		FullTextQueryResult place = iterator.next();
    		if (i == 1) Assert.assertEquals("Département de Ville-de-Paris", place.getName());
    	}
    	
    	Assert.assertFalse(iterator.hasNext());
    }
    
    @Test
    public void shouldExecuteFullTextSearchForParisWithPlaceTypeOnlyIncludesCities() throws IOException {
    	InputStreamSource iss = httpGisgraphyServer.fullTextSearch(SearchQuery.newSearchQuery().withQueryString("paris").withPlaceType("City").build());
    	Iterable<FullTextQueryResult> results = parser.parseFullTextSearchResult(iss.getInputStream());
    	Iterator<FullTextQueryResult> iterator = results.iterator();
    	for (int i = 0; i < 10; i++) {
    		Assert.assertTrue(iterator.hasNext());
    		FullTextQueryResult city = iterator.next();
    		Assert.assertEquals("City", city.getPlaceType());
    		Assert.assertTrue(city.getName().contains("Paris") || city.getName().equals("La Défense"));
    	}
    	
    	Assert.assertFalse(iterator.hasNext());
    }
    
    

    /*
    @Test
    public void shouldThrowResourceNotExistingExceptionWhenResourceNotFound() throws IOException {
	ImageReference imageReference = originalImage("anyImageThatNobodyHasEverUploadedOnThisPlanet");
	try {
	    InputStreamSource source = imageServer.downloadImage(imageReference);
	    source.getInputStream();
	    fail();
	} catch(ResourceNotExistingException e) {
	    assertEquals(imageReference, e.getImageReference());
	} 
    }
    
    @Test
    public void shouldThrowBadUploadRequestExceptionWhenUploadingGarbage() throws IOException {
	ImageId imageId = imageId("anImageThatIsNeverGoingToBeUploaded");
	try {
	    imageServer.uploadImage(imageId, JPEG, textfileresource());
	    fail();
	} catch(BadUploadRequestException e) {
	    assertEquals(imageId, e.getImageId());
	    assertEquals(JPEG, e.getImageFormat());
	} 
    }
    
    @Test
    public void shouldThrowImageIdAlreadyExistsExceptionWhenUploadingSameImageTwice() throws IOException {
	ImageId imageId = yemmaGourayaId();
	imageServer.uploadImage(imageId, JPEG, yemmaGourayaOriginalPictureStream());
	try {
	    imageServer.uploadImage(imageId, JPEG, yemmaGourayaOriginalPictureStream());
	    fail();
	} catch(ImageAlreadyExistsException e) {
	    assertEquals(imageId, e.getImageId());
	    assertEquals(JPEG, e.getImageFormat());
	} 
    }
    
    @Test
    public void shouldUploadAndDownloadOriginalYemmaGourayaPicture() throws IOException {
	ImageReference yemmaGouraya = imageServer.uploadImage(yemmaGourayaId(), JPEG, yemmaGourayaOriginalPictureStream());
	InputStreamSource source = imageServer.downloadImage(yemmaGouraya);
	assertNotNull(source);
	assertTrue(isYemmaGourayaPicture(source));
	assertFalse(isCornicheKabylePicture(source));
    }
    
    @Test(expected=ResourceNotExistingException.class)
    public void shouldNotDownloadDeletedYemmaGourayaPicture() throws IOException {
	imageServer.uploadImage(yemmaGourayaId(), JPEG, yemmaGourayaOriginalPictureStream());
	imageServer.deleteImage(yemmaGourayaId());
	ImageReference imageReference = yemmaGouraya();
	InputStreamSource source = imageServer.downloadImage(imageReference);
	source.getInputStream();
    }
    
    @Test
    public void shouldUploadSeveralPicturesAndDownloadCornicheKabylePicture() throws IOException {
	imageServer.uploadImage(yemmaGourayaId(), JPEG, yemmaGourayaOriginalPictureStream());
	ImageReference cornicheKabyle = imageServer.uploadImage(cornicheKabyleId(), JPEG, PictureStreamSourceObjectMother.cornicheKabyleOriginalPictureStream());
	InputStreamSource source = imageServer.downloadImage(cornicheKabyle);
	assertNotNull(source);
	assertFalse(isYemmaGourayaPicture(source));
	assertTrue(isCornicheKabylePicture(source));
    }
    @Test
    public void shouldUploadYemmaGourayaAndDownloadDerivedPicture() throws IOException {
	ImageReference yemmaGouraya = imageServer.uploadImage(yemmaGourayaId(), JPEG, yemmaGourayaOriginalPictureStream());
	InputStreamSource source = imageServer.downloadImage(yemmaGouraya.rescaledTo(width(100).by(100)).convertedTo(JPEG));
	assertNotNull(source);
	assertTrue(is100x100CornicheKabylePicture(source));
	assertFalse(isCornicheKabylePicture(source));
    }
    
    @Test
    public void shouldNotDownloadDerivedPictureWhenRequestedSizeIsForbidden() throws IOException {
	ImageReference yemmaGouraya = imageServer.uploadImage(yemmaGourayaId(), JPEG, yemmaGourayaOriginalPictureStream());
	try {
	    InputStreamSource source = imageServer.downloadImage(yemmaGouraya.rescaledTo(width(10000).by(10000)).convertedTo(JPEG));
	    source.getInputStream();
	    fail();
	} catch(ForbiddenRequestException e) {
	    // ok
	}
    }
    */
}
