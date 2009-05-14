package com.gisgraphy.client.domain;

import java.util.List;
import java.util.Map;

public class FullTextQueryResult {

    private double score;
    private String countryCode;
    private String adm1Name;
    private String adm1Code;
    private String adm2Name;
    private String adm2Code;
    private String adm3Name;
    private String adm3Code;
    private String adm4Name;
    private String adm4Code;
    private String countryFlagUrl;
    private String countryName;
    private int elevation;
    private String featureClass;
    private String featureCode;
    private long featureId;
    private String fullyQualifiedName;
    private String googleMapUrl;
    private int gTopo30;
    private double latitude;
    private double longitude;
    private String name;
    private String asciiName;
    private int population;
    private String timezone;
    private String placeType;
    private String yahooMapUrl;
    private Map<String, List<String>> alternateNames;
    private Map<String, List<String>> countryAlternateNames;
    private Map<String, List<String>> adm1AlternateNames;
    private Map<String, List<String>> adm2AlternateNames;
    private Map<String, List<String>> adm3AlternateNames;
    private Map<String, List<String>> adm4AlternateNames;

    public static FullTextQueryResultBuilder newFullTextQueryResult() {
        return new FullTextQueryResultBuilder();
    }

    public static class FullTextQueryResultBuilder {

        private FullTextQueryResult fullTextQueryResult = new FullTextQueryResult();

        public FullTextQueryResultBuilder withPlaceType(String placeType) {
            fullTextQueryResult.placeType = placeType;
            return this;
        }

        public FullTextQueryResultBuilder withScore(double score) {
            fullTextQueryResult.score = score;
            return this;
        }

        public FullTextQueryResultBuilder withAdm1Code(String adm1Code) {
            fullTextQueryResult.adm1Code = adm1Code;
            return this;
        }

        public FullTextQueryResultBuilder withAdm2Code(String adm2Code) {
            fullTextQueryResult.adm2Code = adm2Code;
            return this;
        }

        public FullTextQueryResultBuilder withAdm3Code(String adm3Code) {
            fullTextQueryResult.adm3Code = adm3Code;
            return this;
        }

        public FullTextQueryResultBuilder withAdm4Code(String adm4Code) {
            fullTextQueryResult.adm4Code = adm4Code;
            return this;
        }

        public FullTextQueryResultBuilder withAdm1Name(String adm1Name) {
            fullTextQueryResult.adm1Name = adm1Name;
            return this;
        }

        public FullTextQueryResultBuilder withAdm2Name(String adm2Name) {
            fullTextQueryResult.adm2Name = adm2Name;
            return this;
        }

        public FullTextQueryResultBuilder withAdm3Name(String adm3Name) {
            fullTextQueryResult.adm3Name = adm3Name;
            return this;
        }

        public FullTextQueryResultBuilder withAdm4Name(String adm4Name) {
            fullTextQueryResult.adm4Name = adm4Name;
            return this;
        }

        public FullTextQueryResultBuilder withCountryCode(String countryCode) {
            fullTextQueryResult.countryCode = countryCode;
            return this;
        }

        public FullTextQueryResultBuilder withCountryFlagUrl(String countryFlagUrl) {
            fullTextQueryResult.countryFlagUrl = countryFlagUrl;
            return this;
        }

        public FullTextQueryResultBuilder withCountryName(String countryName) {
            fullTextQueryResult.countryName = countryName;
            return this;
        }

        public FullTextQueryResultBuilder withElevation(int elevation) {
            fullTextQueryResult.elevation = elevation;
            return this;
        }

        public FullTextQueryResultBuilder withFeatureClass(String featureClass) {
            fullTextQueryResult.featureClass = featureClass;
            return this;
        }

        public FullTextQueryResultBuilder withFeatureCode(String featureCode) {
            fullTextQueryResult.featureCode = featureCode;
            return this;
        }

        public FullTextQueryResultBuilder withFeatureId(long featureId) {
            fullTextQueryResult.featureId = featureId;
            return this;
        }

        public FullTextQueryResultBuilder withFullyQualifiedName(String fullyQualifiedName) {
            fullTextQueryResult.fullyQualifiedName = fullyQualifiedName;
            return this;
        }

        public FullTextQueryResultBuilder withGoogleMapUrl(String googleMapUrl) {
            fullTextQueryResult.googleMapUrl = googleMapUrl;
            return this;
        }

        public FullTextQueryResultBuilder withGTopo30(int gTopo30) {
            fullTextQueryResult.gTopo30 = gTopo30;
            return this;
        }

        public FullTextQueryResultBuilder withLatitude(double latitude) {
            fullTextQueryResult.latitude = latitude;
            return this;
        }

        public FullTextQueryResultBuilder withLongitude(double longitude) {
            fullTextQueryResult.longitude = longitude;
            return this;
        }

        public FullTextQueryResultBuilder withName(String name) {
            fullTextQueryResult.name = name;
            return this;
        }

        public FullTextQueryResultBuilder withAsciiName(String asciiName) {
            fullTextQueryResult.asciiName = asciiName;
            return this;
        }

        public FullTextQueryResultBuilder withPopulation(int population) {
            fullTextQueryResult.population = population;
            return this;
        }

        public FullTextQueryResultBuilder withTimezone(String timezone) {
            fullTextQueryResult.timezone = timezone;
            return this;
        }

        public FullTextQueryResultBuilder withYahooMapUrl(String yahooMapUrl) {
            fullTextQueryResult.yahooMapUrl = yahooMapUrl;
            return this;
        }

        public FullTextQueryResultBuilder withAlternateNames(Map<String, List<String>> alternateNames) {
            fullTextQueryResult.alternateNames = alternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withCountryAlternateNames(Map<String, List<String>> countryAlternateNames) {
            fullTextQueryResult.countryAlternateNames = countryAlternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withAdm1AlternateNames(Map<String, List<String>> adm1AlternateNames) {
            fullTextQueryResult.adm1AlternateNames = adm1AlternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withAdm2AlternateNames(Map<String, List<String>> adm2AlternateNames) {
            fullTextQueryResult.adm2AlternateNames = adm2AlternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withAdm3AlternateNames(Map<String, List<String>> adm3AlternateNames) {
            fullTextQueryResult.adm3AlternateNames = adm3AlternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withAdm4AlternateNames(Map<String, List<String>> adm4AlternateNames) {
            fullTextQueryResult.adm4AlternateNames = adm4AlternateNames;
            return this;
        }

        public FullTextQueryResult build() {
            return fullTextQueryResult;
        }
    }

    public double getScore() {
        return score;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getElevation() {
        return elevation;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public long getFeatureId() {
        return featureId;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public String getGoogleMapUrl() {
        return googleMapUrl;
    }

    public int getGTopo30() {
        return gTopo30;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public int getPopulation() {
        return population;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getYahooMapUrl() {
        return yahooMapUrl;
    }

    public String getPlaceType() {
        return placeType;
    }

    public String getAdm1Name() {
        return adm1Name;
    }

    public String getAdm1Code() {
        return adm1Code;
    }

    public String getAdm2Name() {
        return adm2Name;
    }

    public String getAdm2Code() {
        return adm2Code;
    }

    public String getAdm3Name() {
        return adm3Name;
    }

    public String getAdm3Code() {
        return adm3Code;
    }

    public String getAdm4Name() {
        return adm4Name;
    }

    public String getAdm4Code() {
        return adm4Code;
    }

    public Map<String, List<String>> getAlternateNames() {
        return alternateNames;
    }

    public Map<String, List<String>> getCountryAlternateNames() {
        return countryAlternateNames;
    }

    public Map<String, List<String>> getAdm1AlternateNames() {
        return adm1AlternateNames;
    }

    public Map<String, List<String>> getAdm2AlternateNames() {
        return adm2AlternateNames;
    }

    public Map<String, List<String>> getAdm3AlternateNames() {
        return adm3AlternateNames;
    }

    public Map<String, List<String>> getAdm4AlternateNames() {
        return adm4AlternateNames;
    }
}
