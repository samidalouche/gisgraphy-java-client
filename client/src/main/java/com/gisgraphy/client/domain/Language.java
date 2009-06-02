/**
 *
 */
package com.gisgraphy.client.domain;

import org.apache.commons.lang.Validate;

/**
 * Codes are written lowercase !!!
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * @see <a href="http://en.wikipedia.org/wiki/List_of_languages">List Of Languages</a>
 */
public class Language {
    private String iso639Alpha2LanguageCode;
    private String iso639Alpha3LanguageCode;
    private String iso639LanguageName;

    public Language() {
	super();
    }

    public Language(String iso639LanguageName, String iso639Alpha2LanguageCode,String iso639Alpha3LanguageCode) {
	super();
	//Validate.notEmpty(iso639LanguageName);
	Validate.notEmpty(iso639Alpha2LanguageCode);
	Validate.notEmpty(iso639Alpha3LanguageCode);
	
	this.iso639LanguageName = iso639LanguageName;
	this.iso639Alpha2LanguageCode = iso639Alpha2LanguageCode != null ? iso639Alpha2LanguageCode.toLowerCase() : null;
	this.iso639Alpha3LanguageCode = iso639Alpha3LanguageCode.toLowerCase();
    }


    /**
     * ISO 2 letter code, if available
     * 
     */
    public String getIso639Alpha2LanguageCode() {
	return this.iso639Alpha2LanguageCode;
    }

    /**
     * ISO-3 lettter code. Must be present
     * 
     */
    public String getIso639Alpha3LanguageCode() {
	return this.iso639Alpha3LanguageCode;
    }

    /**
     * official ISO name
     */
    public String getIso639LanguageName() {
	return this.iso639LanguageName;
    }

}
