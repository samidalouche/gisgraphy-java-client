package com.gisgraphy.client.domain;

public class CityResult {
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
	private String yahooMapUrl;
	
	public static CityResultBuilder newCityResult() {
		return new CityResultBuilder();
	}
	
	public static class CityResultBuilder {
		private CityResult cityResult = new CityResult();
		
		public CityResultBuilder withScore(double score) {
			cityResult.score = score;
			return this;
		}
		
		public CityResultBuilder withCountryCode(String countryCode) {
			cityResult.countryCode = countryCode;
			return this;
		}
		
		public CityResultBuilder withCountryFlagUrl(String countryFlagUrl) {
			cityResult.countryFlagUrl = countryFlagUrl;
			return this;
		}
		
		public CityResultBuilder withCountryName(String countryName) {
			cityResult.countryName = countryName;
			return this;
		}
		
		public CityResultBuilder withElevation(int elevation) {
			cityResult.elevation = elevation;
			return this;
		}
		
		public CityResultBuilder withFeatureClass(String featureClass) {
			cityResult.featureClass = featureClass;
			return this;
		}
		
		public CityResultBuilder withFeatureCode(String featureCode) {
			cityResult.featureCode = featureCode;
			return this;
		}
		
		public CityResultBuilder withFeatureId(long featureId) {
			cityResult.featureId = featureId;
			return this;
		}
		
		public CityResultBuilder withFullyQualifiedName(String fullyQualifiedName) {
			cityResult.fullyQualifiedName = fullyQualifiedName;
			return this;
		}
		
		public CityResultBuilder withGoogleMapUrl(String googleMapUrl) {
			cityResult.googleMapUrl = googleMapUrl;
			return this;
		}
		
		public CityResultBuilder withGTopo30(int gTopo30) {
			cityResult.gTopo30 = gTopo30;
			return this;
		}
		
		public CityResultBuilder withLatitude(double latitude) {
			cityResult.latitude = latitude;
			return this;
		}
		
		public CityResultBuilder withLongitude(double longitude) {
			cityResult.longitude = longitude;
			return this;
		}
		
		public CityResultBuilder withName(String name) {
			cityResult.name = name;
			return this;
		}
		
		public CityResultBuilder withAsciiName(String asciiName) {
			cityResult.asciiName = asciiName;
			return this;
		}
		
		public CityResultBuilder withPopulation(int population) {
			cityResult.population = population;
			return this;
		}
		
		public CityResultBuilder withTimezone(String timezone) {
			cityResult.timezone = timezone;
			return this;
		}
		
		public CityResultBuilder withYahooMapUrl(String yahooMapUrl) {
			cityResult.yahooMapUrl = yahooMapUrl;
			return this;
		}
		
		public CityResult build() {
			return cityResult;
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
	
	
}
