package com.gisgraphy.client.impl.resultparser;

public final class GeolocalisationResult {
	public static class GeolocalisationResultBuilder {
		private GeolocalisationResult result;
		
		public GeolocalisationResultBuilder() {
			this.result = new GeolocalisationResult();
		}
		
		public GeolocalisationResult build() {
			return result;
		}
		
		public GeolocalisationResultBuilder withAdm1Code(String adm1Code) {
			result.adm1Code = adm1Code;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm1Name(String adm1Name) {
			result.adm1Name = adm1Name;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm2Code(String adm2Code) {
			result.adm2Code = adm2Code;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm2Name(String adm2Name) {
			result.adm2Name = adm2Name;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm3Code(String adm3Code) {
			result.adm3Code = adm3Code;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm3Name(String adm3Name) {
			result.adm3Name = adm3Name;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm4Code(String adm4Code) {
			result.adm4Code = adm4Code;
			return this;
		}
		
		public GeolocalisationResultBuilder withAdm4Name(String adm4Name) {
			result.adm4Name = adm4Name;
			return this;
		}
		
		public GeolocalisationResultBuilder withAsciiName(String asciiName) {
			result.asciiName = asciiName;
			return this;
		}
		
		public GeolocalisationResultBuilder withCountryCode(String countryCode) {
			result.countryCode = countryCode;
			return this;
		}
		
		public GeolocalisationResultBuilder withCountryFlagUrl(String countryFlagUrl) {
			result.countryFlagUrl = countryFlagUrl;
			return this;
		}
		
		public GeolocalisationResultBuilder withDistance(Double distance) {
			result.distance = distance;
			return this;
		}
		
		public GeolocalisationResultBuilder withFeatureClass(String featureClass) {
			result.featureClass = featureClass;
			return this;
		}
		
		public GeolocalisationResultBuilder withFeatureCode(String featureCode) {
			result.featureCode = featureCode;
			return this;
		}
		
		public GeolocalisationResultBuilder withFeatureId(Long featureId) {
			result.featureId = featureId;
			return this;
		}
		
		public GeolocalisationResultBuilder withGoogleMapUrl(String googleMapUrl) {
			result.googleMapUrl = googleMapUrl;
			return this;
		}
		
		public GeolocalisationResultBuilder withGTopo30(Integer gTopo30) {
			result.gTopo30 = gTopo30;
			return this;
		}
		
		public GeolocalisationResultBuilder withLatitude(Double latitude) {
			result.latitude = latitude;
			return this;
		}
		
		public GeolocalisationResultBuilder withLongitude(Double longitude) {
			result.longitude = longitude;
			return this;
		}
		
		public GeolocalisationResultBuilder withName(String name) {
			result.name = name;
			return this;
		}
		
		public GeolocalisationResultBuilder withPlaceType(String placeType) {
			result.placeType = placeType;
			return this;
		}
		
		public GeolocalisationResultBuilder withPopulation(Integer population) {
			result.population = population;
			return this;
		}
		
		public GeolocalisationResultBuilder withTimezone(String timezone) {
			result.timezone = timezone;
			return this;
		}
		
		public GeolocalisationResultBuilder withYahooMapUrl(String yahooMapUrl) {
			result.yahooMapUrl = yahooMapUrl;
			return this;
		}
		
		public GeolocalisationResultBuilder withZipCode(String zipCode) {
			result.zipCode = zipCode;
			return this;
		}
	}
	public static GeolocalisationResultBuilder newGeolocalisationResult() {
		return new GeolocalisationResultBuilder();
	}
	private String adm1Code;
	private String adm1Name;
	private String adm2Code;
	private String adm2Name;
	private String adm3Code;
	private String adm3Name;
	private String adm4Code;
	private String adm4Name;
	private String asciiName;
	private String countryCode;
	private String countryFlagUrl;
	private Double distance;
	private String featureClass;
	private String featureCode;
	private Long featureId;
	private String googleMapUrl;
	private Integer gTopo30;
	private Double latitude;
	private Double longitude;
	private String name;
	private String placeType;
	private Integer population;
	private String timezone;
	
	private String yahooMapUrl;
	
	private String zipCode;

	public String getAdm1Code() {
		return adm1Code;
	}

	public String getAdm1Name() {
		return adm1Name;
	}

	public String getAdm2Code() {
		return adm2Code;
	}

	public String getAdm2Name() {
		return adm2Name;
	}

	public String getAdm3Code() {
		return adm3Code;
	}

	public String getAdm3Name() {
		return adm3Name;
	}

	public String getAdm4Code() {
		return adm4Code;
	}

	public String getAdm4Name() {
		return adm4Name;
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

	public Double getDistance() {
		return distance;
	}

	public String getFeatureClass() {
		return featureClass;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public Long getFeatureId() {
		return featureId;
	}

	public String getGoogleMapUrl() {
		return googleMapUrl;
	}

	public Integer getGTopo30() {
		return gTopo30;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getPlaceType() {
		return placeType;
	}

	public Integer getPopulation() {
		return population;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getYahooMapUrl() {
		return yahooMapUrl;
	}

	public String getZipCode() {
		return zipCode;
	}
	
	
}
