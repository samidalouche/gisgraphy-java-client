package com.gisgraphy.client.gisfeature;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gisgraphy.client.language.Iso639Language;

public final class AlternateGisFeatureName implements Comparable<AlternateGisFeatureName>{
    
    private String name;
    private Iso639Language language;
    private boolean preferred = false;
    private boolean shortName = false;

    public static AlternateGisFeatureName alternateName(String name) {
	return new AlternateGisFeatureName(name);
    }
    
    private AlternateGisFeatureName(String name) {
	this(name, null, false, false);
    }
    
    private AlternateGisFeatureName(String name, Iso639Language language, boolean preferred, boolean shortName) {
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
    
    public AlternateGisFeatureName withLanguage(Iso639Language language) {
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

    public Iso639Language getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(language)
		.append(name)
		.toHashCode();
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
	
	return new EqualsBuilder()
		.append(language, other.getLanguage())
		.append(name, other.getName())
		.isEquals();
    }
    
}
