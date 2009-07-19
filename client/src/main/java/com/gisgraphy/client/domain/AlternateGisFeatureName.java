package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public final class AlternateGisFeatureName implements Comparable<AlternateGisFeatureName>{
    
    private String name;
    private IsoLanguage language;
    private boolean preferred = false;
    private boolean shortName = false;

    public static AlternateGisFeatureName alternateName(String name) {
	return new AlternateGisFeatureName(name);
    }
    
    private AlternateGisFeatureName(String name) {
	this(name, null, false, false);
    }
    
    private AlternateGisFeatureName(String name, IsoLanguage language, boolean preferred, boolean shortName) {
	super();
	Validate.notEmpty(name);
	
	this.name = name;
	this.language = language;
	this.preferred = preferred;
	this.shortName = shortName;
    }

    public AlternateGisFeatureName withName(String name) {
	return new AlternateGisFeatureName(name, this.language, this.preferred, this.shortName);
    }
    
    public AlternateGisFeatureName withLanguage(IsoLanguage language) {
	return new AlternateGisFeatureName(this.name, language, this.preferred, this.shortName);
    }
    
    public AlternateGisFeatureName preferred(boolean preferredName) {
	return new AlternateGisFeatureName(this.name, this.language, preferredName, this.shortName);
    }
    
    public AlternateGisFeatureName shortName(boolean shortName) {
	return new AlternateGisFeatureName(this.name, this.language, this.preferred, shortName);
    }
    
    public int compareTo(AlternateGisFeatureName o) {
	return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    /**
     * if this alternate name is an official/preferred name
     * for the given gisfeature
     * @return
     */
    public boolean isPreferred() {
        return preferred;
    }

    /**
     * if this is a short name like 'California' for 'State of California'
     * @return
     */
    public boolean isShort() {
        return shortName;
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", this.name)
		.append("language", this.language)
		.append("preferred", this.preferred)
		.append("short", this.shortName).toString();
    }

    public IsoLanguage getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((language == null) ? 0 : language.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	AlternateGisFeatureName other = (AlternateGisFeatureName) obj;
	if (language == null) {
	    if (other.language != null)
		return false;
	} else if (!language.equals(other.language))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }
    
}
