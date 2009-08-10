package com.gisgraphy.client.gisfeature;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gisgraphy.client.impl.InMemoryAlternateNamesProvider;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public final class GisFeatureNames {

    private String name;
    private String asciiName;
    private AlternateNamesProvider alternateNamesProvider = emptyAlternateNamesProvider();

    private GisFeatureNames(String name) {
        this(name, null, emptySet());
    }

    
    private GisFeatureNames(String name, String asciiName, AlternateNamesProvider alternateNamesProvider) {
        super();

        Validate.notEmpty(name);

        this.name = name;
        this.asciiName = asciiName;
        this.alternateNamesProvider = alternateNamesProvider;
    }

    private GisFeatureNames(String name, String asciiName, Iterable<AlternateGisFeatureName> alternateNames) {
        this(name, asciiName, new InMemoryAlternateNamesProvider(ImmutableSet.copyOf(alternateNames)));
    }

    public static GisFeatureNames gisFeatureName(String name) {
        return new GisFeatureNames(name);
    }

    public GisFeatureNames withName(String name) {
        return new GisFeatureNames(name, this.asciiName, this.alternateNamesProvider);
    }

    public GisFeatureNames withAsciiName(String asciiName) {
        return new GisFeatureNames(this.name, asciiName, this.alternateNamesProvider);
    }

    public GisFeatureNames withAlternateNames(Iterable<AlternateGisFeatureName> alternateNames) {
        return new GisFeatureNames(this.name, this.asciiName, alternateNames);
    }
    
    public GisFeatureNames withAlternateNamesProvider(AlternateNamesProvider alternateNamesProvider) {
        return new GisFeatureNames(this.name, this.asciiName, alternateNamesProvider);
    }

    private static ImmutableSet<AlternateGisFeatureName> emptySet() {
        return ImmutableSet.of();
    }

    public String getName() {
        return name;
    }

    public String getAsciiName() {
        return asciiName;
    }

    private AlternateNamesProvider emptyAlternateNamesProvider() {
	return new InMemoryAlternateNamesProvider(emptySet());
    }
    
    public ImmutableSet<AlternateGisFeatureName> getAlternateNames() {
        return this.alternateNamesProvider.getAlternateNames();
    }

    /**
     * 
     * @param language
     * @return the preferred name if it exists, otherwise the default name
     */
    public String getPreferredName(final Iso639Language language) {
        Iterable<AlternateGisFeatureName> alternateGisFeatureNames = Iterables.filter(this.alternateNamesProvider.getAlternateNames(), new Predicate<AlternateGisFeatureName>() {

            public boolean apply(AlternateGisFeatureName input) {
                return input.getLanguage().equals(language) && input.isPreferred();
            }
        });

        return returnFirstAlternateNameAndFallbackOnDefaultName(alternateGisFeatureNames);
    }

    private String returnFirstAlternateNameAndFallbackOnDefaultName(
            Iterable<AlternateGisFeatureName> alternateGisFeatureNames) {
        return Iterables.size(alternateGisFeatureNames) > 0 ? Iterables.get(alternateGisFeatureNames, 0).getName() : this.getName();
    }

    /**
     * 
     * @param language
     * @return the short name if it exists, otherwise the default name 
     */
    public String getShortName(final Iso639Language language) {
        Iterable<AlternateGisFeatureName> alternateGisFeatureNames = Iterables.filter(this.alternateNamesProvider.getAlternateNames(), new Predicate<AlternateGisFeatureName>() {

            public boolean apply(AlternateGisFeatureName input) {
                return input.getLanguage().equals(language) && input.isShort();
            }
        });

        return returnFirstAlternateNameAndFallbackOnDefaultName(alternateGisFeatureNames);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("name", this.name).append("asciiName", this.asciiName).append("alternateNames", this.alternateNamesProvider).toString();
    }
}
