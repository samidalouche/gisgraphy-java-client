/**
 *
 */
package com.gisgraphy.client.domain.crap;


/**
 * 
 * Codes are written lowercase !!!
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * @see <a href="http://en.wikipedia.org/wiki/List_of_languages">List Of
 *      Languages</a>
 */
public class OldLanguage {

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @see #getIso639Alpha2LanguageCode()
     */
    private String iso639Alpha2LanguageCode;

    /**
     * @see #getIso639Alpha3LanguageCode()
     */
    private String iso639Alpha3LanguageCode;

    /**
     * @see #getIso639LanguageName()
     */
    private String iso639LanguageName;

    public OldLanguage() {
	super();
    }

    /**
     * @param iso639LanguageName
     * @param iso639Alpha2LanguageCode
     * @param iso639Alpha3LanguageCode
     */
    public OldLanguage(String iso639LanguageName, String iso639Alpha2LanguageCode,
	    String iso639Alpha3LanguageCode) {
	super();

	this.iso639LanguageName = iso639LanguageName;
	this.iso639Alpha2LanguageCode = iso639Alpha2LanguageCode;
	this.iso639Alpha3LanguageCode = iso639Alpha3LanguageCode;
    }

    public Long getId() {
	return this.id;
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

    /**
     * @see #getId()
     * @param id
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @see #getIso639Alpha2LanguageCode()
     * @param iso639Alpha2LanguageCode
     */
    public void setIso639Alpha2LanguageCode(String iso639Alpha2LanguageCode) {
	this.iso639Alpha2LanguageCode = iso639Alpha2LanguageCode;
    }

    /**
     * @see #getIso639Alpha3LanguageCode()
     * @param iso639Alpha3LanguageCode
     */
    public void setIso639Alpha3LanguageCode(String iso639Alpha3LanguageCode) {
	this.iso639Alpha3LanguageCode = iso639Alpha3LanguageCode;
    }

    /**
     * @see #getIso639LanguageName()
     * @param iso639LanguageName
     */
    public void setIso639LanguageName(String iso639LanguageName) {
	this.iso639LanguageName = iso639LanguageName;
    }
}
