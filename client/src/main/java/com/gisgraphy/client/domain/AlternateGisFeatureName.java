package com.gisgraphy.client.domain;


public class AlternateGisFeatureName implements
	Comparable<AlternateGisFeatureName> {

    /**
     * @see #getAlternateName()
     */
    private String alternateName;

    /**
     * @see #getFeatureNameId()
     */
    private Long featureNameId;

    /**
     * @see #getFeatureNameSource()
     */
    private GisFeatureSourceType featureNameSource = GisFeatureSourceType.GEONAMES;

    /**
     * @see #getGisFeature()
     */
    private GisFeature gisFeature;

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @see #getLanguage()
     */
    private Language language;

    /**
     * @see #isPreferredName()
     */
    private boolean preferredName = false;

    /**
     * @see #isShortName()
     */
    private boolean shortName = false;

    public AlternateGisFeatureName() {
	super();
    }

    public AlternateGisFeatureName(String alternateName, GisFeature gisFeature) {
	super();
	this.alternateName = alternateName;
	this.gisFeature = gisFeature;
    }

    public AlternateGisFeatureName(String alternateName, GisFeature gisFeature,
	    Language language) {
	super();
	this.alternateName = alternateName;
	this.gisFeature = gisFeature;
	this.language = language;
    }

    public int compareTo(AlternateGisFeatureName o) {
	return getAlternateName().compareTo(o.getAlternateName());
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	final AlternateGisFeatureName other = (AlternateGisFeatureName) obj;
	if (featureNameId == null) {
	    if (other.featureNameId != null)
		return false;
	} else if (!featureNameId.equals(other.featureNameId))
	    return false;
	if (featureNameSource == null) {
	    if (other.featureNameSource != null)
		return false;
	} else if (!featureNameSource.equals(other.featureNameSource))
	    return false;
	return true;
    }

    /**
     * The value of the alternate name
     * 
     * @return
     */
    public String getAlternateName() {
	return alternateName;
    }

    /**
     * The ID of the alternate name
     * 
     * @return
     */
    public Long getFeatureNameId() {
	return featureNameId;
    }

    /**
     * Where the Alternate name comes from
     * 
     * @return
     */
    public GisFeatureSourceType getFeatureNameSource() {
	return featureNameSource;
    }

    /**
     * The associated Gis Feature to which we add an alternate name
     * 
     * @return
     */
    public GisFeature getGisFeature() {
	return gisFeature;
    }

    /**
     * The ID
     * 
     * @return
     */
    public Long getId() {
	return id;
    }

    /**
     * 
     * @return null if no alternate name has no {@link Language}
     */
    public String getIso639Alpha2LanguageCode() {
	String s = null;
	if (this.language != null) {
	    s = language.getIso639Alpha2LanguageCode();
	}
	return s;
    }

    /**
     * 
     * @return null if no alternate name has no {@link Language}
     */
    public String getIso639Alpha3LanguageCode() {
	String s = null;
	if (this.language != null) {
	    s = language.getIso639Alpha3LanguageCode();
	}
	return s;
    }

    /**
     * 
     * @return null if no alternate name has no {@link Language}
     */
    public String getIso639LanguageName() {
	String s = null;
	if (this.language != null) {
	    s = language.getIso639LanguageName();
	}
	return s;
    }

    /**
     * The language, if available, of the alternate name
     * 
     * @return
     */
    // @Column(nullable = true) : not allowed
    public Language getLanguage() {
	return language;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result
		+ ((featureNameId == null) ? 0 : featureNameId.hashCode());
	result = PRIME
		* result
		+ ((featureNameSource == null) ? 0 : featureNameSource
			.hashCode());
	return result;
    }

    /**
     * Whether the alternate name is the official one
     * 
     * @return
     */
    public boolean isPreferredName() {
	return preferredName;
    }

    public boolean isShortName() {
	return shortName;
    }

    /**
     * @see #getAlternateName()
     * @param alternateName
     */
    public void setAlternateName(String alternateName) {
	this.alternateName = alternateName;
    }

    /**
     * @see #getFeatureNameId()
     * @param featureNameId
     */
    public void setFeatureNameId(Long featureNameId) {
	this.featureNameId = featureNameId;
    }

    /**
     * @see #getFeatureNameSource()
     * @param featureNameSource
     */
    public void setFeatureNameSource(GisFeatureSourceType featureNameSource) {
	this.featureNameSource = featureNameSource;
    }

    /**
     * @see #getGisFeature()
     * @param gisFeature
     */
    public void setGisFeature(GisFeature gisFeature) {
	this.gisFeature = gisFeature;
    }

    /**
     * @see #getId()
     * @param id
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @see #getLanguage()
     * @param language
     */
    public void setLanguage(Language language) {
	this.language = language;
    }

    /**
     * @see #isPreferredName()
     * @param official
     */
    public void setPreferredName(boolean official) {
	this.preferredName = official;
    }

    public void setShortName(boolean shortName) {
	this.shortName = shortName;
    }

}
