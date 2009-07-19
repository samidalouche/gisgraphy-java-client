package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public final class GisFeatureName {
    
    private String name;
    
    private String asciiName;
    private ImmutableSet<AlternateGisFeatureName> alternateNames = emptySet();
    
    private GisFeatureName(String name) {
	this(name, null, emptySet());
    }

    private GisFeatureName(String name, String asciiName, Iterable<AlternateGisFeatureName> alternateNames) {
	super();
	
	Validate.notEmpty(name);
	
	this.name = name;
	this.asciiName = asciiName;
	this.alternateNames = ImmutableSet.copyOf(alternateNames);
    }

    public static GisFeatureName name(String name) {
	return new GisFeatureName(name);
    }
    
    public GisFeatureName withName(String name) {
	return new GisFeatureName(name, this.asciiName, this.alternateNames);
    }
    
    public GisFeatureName withAsciiName(String asciiName) {
	return new GisFeatureName(this.name, asciiName, this.alternateNames);
    }
    
    public GisFeatureName withAlternateNames(Iterable<AlternateGisFeatureName> alternateNames) {
	return new GisFeatureName(this.name, this.asciiName, alternateNames);
    }
    
    private static ImmutableSet<AlternateGisFeatureName> emptySet() {
	return ImmutableSet.of();
    }

    public String getName() {
        return name;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public ImmutableSet<AlternateGisFeatureName> getAlternateNames() {
        return alternateNames;
    }
    
    /**
     * 
     * @param language
     * @return the preferred name if it exists, otherwise the default name
     */
    public String getPreferredName(final IsoLanguage language) {
	Iterable<AlternateGisFeatureName> alternateGisFeatureNames = Iterables.filter(alternateNames, new Predicate<AlternateGisFeatureName>() {
	    public boolean apply(AlternateGisFeatureName input) {
		return input.getLanguage().equals(language) && input.isPreferred();
	    }
	});
	
	return returnFirstAlternateNameAndFallbackOnDefaultName(alternateGisFeatureNames);
    }

    private String returnFirstAlternateNameAndFallbackOnDefaultName(
	    Iterable<AlternateGisFeatureName> alternateGisFeatureNames) {
	return Iterables.size(alternateGisFeatureNames) > 0 ? Iterables.get(alternateGisFeatureNames, 0).getName() : this.getName();
    }
    
    /**
     * 
     * @param language
     * @return the short name if it exists, otherwise the default name 
     */
    public String getShortName(final IsoLanguage language) {
	Iterable<AlternateGisFeatureName> alternateGisFeatureNames = Iterables.filter(alternateNames, new Predicate<AlternateGisFeatureName>() {
	    public boolean apply(AlternateGisFeatureName input) {
		return input.getLanguage().equals(language) && input.isShort();
	    }
	});
	
	return returnFirstAlternateNameAndFallbackOnDefaultName(alternateGisFeatureNames);
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", this.name)
		.append("asciiName", this.asciiName)
		.append("alternateNames", this.alternateNames)
		.toString();		
    }
    
    
}
