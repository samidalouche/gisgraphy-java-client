/**
 *
 */
package com.gisgraphy.client.language;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * ISO 639 Language (639-1 -alpha2- and 639-2 -alpha3-)
 * 
 * Codes are written lowercase !!! And ISO 639-2 codes are not considered here
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
 * @see <a href="http://en.wikipedia.org/wiki/ISO_639-3">ISO 639-3</a>
 */
public final class Iso639Language {
    public static class LanguageBuilder {
	private String name;
	
	public LanguageBuilder(String languageName) {
	    this.name = languageName;
	}
	
	public Iso639Language withAlpha3(String iso639Alpha3LanguageCode)  {
	    return new Iso639Language(this.name, iso639Alpha3LanguageCode, null);
	}
    }

    private String alpha2Code;
    private String alpha3Code;
    private String name;

    /**
     * 
     * @param name official ISO name
     * @param alpha2Code  ISO 2 letter code, if available
     * @param alpha3Code ISO-3 lettter code. Must be present
     */
    private Iso639Language(String name, String alpha3Code, String alpha2Code) {
	super();
	//Validate.notEmpty(iso639LanguageName);
	Validate.notEmpty(name);
	Validate.notEmpty(alpha3Code);
	
	this.name = name;
	this.alpha2Code = alpha2Code != null ? alpha2Code.toLowerCase() : null;
	this.alpha3Code = alpha3Code.toLowerCase();
    }
    
    public static LanguageBuilder isoLanguage(String languageName) {
	return new LanguageBuilder(languageName);
    }
    
    public Iso639Language withAlpha2(String iso639Alpha2LanguageCode)  {
	    return new Iso639Language(this.name, this.alpha3Code, iso639Alpha2LanguageCode);
    }
    
    public Iso639Language withAlpha3(String iso639Alpha3LanguageCode)  {
	    return new Iso639Language(this.name, iso639Alpha3LanguageCode, this.alpha2Code);
    }
    
    public Iso639Language withName(String languageName)  {
	    return new Iso639Language(languageName, this.alpha3Code, this.alpha2Code);
}

    /**
     * ISO-639-1 alpha2 code
     * @return
     * @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
     */
    public String getAlpha2Code() {
        return alpha2Code;
    }

    /**
     * ISO-639-3 alpha3 code
     * @return
     * @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
     */
    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((alpha3Code == null) ? 0 : alpha3Code
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
	Iso639Language other = (Iso639Language) obj;
	if (alpha3Code == null) {
	    if (other.alpha3Code != null)
		return false;
	} else if (!alpha3Code.equals(other.alpha3Code))
	    return false;
	return true;
    }
   
    @Override
    public String toString() {
	return new ToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", this.name)	
		.append("alpha2", this.alpha2Code)
		.append("alpha3", this.alpha3Code)
		.toString();
    }
}
