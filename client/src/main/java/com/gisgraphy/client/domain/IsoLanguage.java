/**
 *
 */
package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * ISO 639
 * Codes are written lowercase !!!
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * @see <a href="http://en.wikipedia.org/wiki/List_of_languages">List Of Languages</a>
 */
public final class IsoLanguage {
    public static class LanguageBuilder {
	private String languageName;
	
	public LanguageBuilder(String languageName) {
	    this.languageName = languageName;
	}
	
	public IsoLanguage alpha3(String alpha3LanguageCode)  {
	    return new IsoLanguage(this.languageName, alpha3LanguageCode, null);
	}
    }
    
    
    private String alpha2LanguageCode;
    private String alpha3LanguageCode;
    private String languageName;

    /**
     * 
     * @param languageName official ISO name
     * @param alpha2LanguageCode  ISO 2 letter code, if available
     * @param alpha3LanguageCode ISO-3 lettter code. Must be present
     */
    private IsoLanguage(String languageName, String alpha3LanguageCode, String alpha2LanguageCode) {
	super();
	//Validate.notEmpty(iso639LanguageName);
	Validate.notEmpty(languageName);
	Validate.notEmpty(alpha3LanguageCode);
	
	this.languageName = languageName;
	this.alpha2LanguageCode = alpha2LanguageCode != null ? alpha2LanguageCode.toLowerCase() : null;
	this.alpha3LanguageCode = alpha3LanguageCode.toLowerCase();
    }
    
    public static LanguageBuilder isoLanguage(String languageName) {
	return new LanguageBuilder(languageName);
    }
    
    public IsoLanguage alpha2(String iso639Alpha2LanguageCode)  {
	    return new IsoLanguage(this.languageName, this.alpha3LanguageCode, iso639Alpha2LanguageCode);
    }

    public String getAlpha2LanguageCode() {
        return alpha2LanguageCode;
    }

    public String getAlpha3LanguageCode() {
        return alpha3LanguageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((alpha3LanguageCode == null) ? 0 : alpha3LanguageCode
			.hashCode());
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
	IsoLanguage other = (IsoLanguage) obj;
	if (alpha3LanguageCode == null) {
	    if (other.alpha3LanguageCode != null)
		return false;
	} else if (!alpha3LanguageCode.equals(other.alpha3LanguageCode))
	    return false;
	return true;
    }
   
    @Override
    public String toString() {
	return new ToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", this.languageName)	
		.append("alpha2", this.alpha2LanguageCode)
		.append("alpha3", this.alpha3LanguageCode)
		.toString();
    }
}
