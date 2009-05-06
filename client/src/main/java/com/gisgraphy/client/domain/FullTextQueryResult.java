package com.gisgraphy.client.domain;

public class FullTextQueryResult {
	private double score;
	private String countryCode;
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
	
	
}
