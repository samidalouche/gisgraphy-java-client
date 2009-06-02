package com.gisgraphy.client.domain;

import com.google.common.collect.ImmutableList;
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
    private Continent continent;
    private IsoCountryCode isoCountryCode;
    private FipsCountryCode fipsCountryCode;
    private String name;
    private Currency currency;
    private AdministrativeCountryInformation administrativeCountryInformation;
    private GisFeature gisFeature;
}
