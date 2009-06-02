package com.gisgraphy.client.domain;

import com.ibm.icu.util.Currency;

/**
 * A Country as defined by ISO 3166. 
 * 
 * A country always has an ISO 3166 alpha2, alpha3 and numeric code, but may, or may not have 
 * other names (FIPS, ..). The list of countries has been imported from Geonames Country List.
 * 
 * @see <a
 *      href="http://www.iso.org/iso/en/prods-services/popstds/countrynamecodes.html">Country Name Codes</a>
 * 
 */
public final class Country {

    private IsoCountryCode isoCountryCode;
    private String name;
    private GisFeature gisFeature;
    private Continent continent;
    
    private Currency currency;
    private FipsCountryCode fipsCountryCode;
    private AdministrativeCountryInformation administrativeCountryInformation = AdministrativeCountryInformation.administrativeCountryInformation();
    private GeographicCountryInformation geographicCountryInformation = GeographicCountryInformation.geographicCountryInformation();
}
