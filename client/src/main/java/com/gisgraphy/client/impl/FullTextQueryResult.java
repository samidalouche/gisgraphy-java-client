package com.gisgraphy.client.impl;

import java.util.List;
import java.util.Map;

public final class FullTextQueryResult {

    public static class FullTextQueryResultBuilder {

        private FullTextQueryResult fullTextQueryResult = new FullTextQueryResult();

        public FullTextQueryResult build() {
            return fullTextQueryResult;
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

        public FullTextQueryResultBuilder withAlternateNames(Map<String, List<String>> alternateNames) {
            fullTextQueryResult.alternateNames = alternateNames;
            return this;
        }

        public FullTextQueryResultBuilder withAsciiName(String asciiName) {
            fullTextQueryResult.asciiName = asciiName;
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

        public FullTextQueryResultBuilder withPlaceType(String placeType) {
            fullTextQueryResult.placeType = placeType;
            return this;
        }

        public FullTextQueryResultBuilder withPopulation(int population) {
            fullTextQueryResult.population = population;
            return this;
        }

        public FullTextQueryResultBuilder withScore(double score) {
            fullTextQueryResult.score = score;
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
    }
    public static FullTextQueryResultBuilder newFullTextQueryResult() {
        return new FullTextQueryResultBuilder();
    }
    private String adm1Code;
    private String adm2Code;
    private String adm3Code;
    private String adm4Code;
    private Map<String, List<String>> alternateNames;
    private String asciiName;
    private String countryCode;
    private String countryFlagUrl;
    private int elevation;
    private String featureClass;
    private String featureCode;
    private long featureId;
    private String googleMapUrl;
    private int gTopo30;
    private double latitude;
    private double longitude;
    private String name;
    private String placeType;
    private int population;
    private double score;

    private String timezone;

    private String yahooMapUrl;

    public String getAdm1Code() {
        return adm1Code;
    }

    public String getAdm2Code() {
        return adm2Code;
    }

    public String getAdm3Code() {
        return adm3Code;
    }


    public String getAdm4Code() {
        return adm4Code;
    }

    public Map<String, List<String>> getAlternateNames() {
        return alternateNames;
    }

    public String getAsciiName() {
        return asciiName;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
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

    public String getPlaceType() {
        return placeType;
    }

    public int getPopulation() {
        return population;
    }

    public double getScore() {
        return score;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getYahooMapUrl() {
        return yahooMapUrl;
    }
}
