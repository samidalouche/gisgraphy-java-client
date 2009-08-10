package com.gisgraphy.client.commons;

import com.gisgraphy.client.nameformatters.FakeFullyQualifiedNameProvider;
import com.google.common.collect.ImmutableList;

public class NameProviderObjectMother {

    public static NameProvider losAngelesNameProvider() {
	return new FakeFullyQualifiedNameProvider(
		ImmutableList.of(
			new NamePart("United States", "US"),
			new NamePart("California", "CA"),
			new NamePart("Los Angeles county", null),
			new NamePart("Los Angeles", null)));
    }
    
    public static NameProvider twoPartsNameProvider() {
	return new FakeFullyQualifiedNameProvider(
		ImmutableList.of(
			new NamePart("United States", "US"),
			new NamePart("Los Angeles", null)));
    }
    
    public static NameProvider onePartNameProvider() {
	return new FakeFullyQualifiedNameProvider(
		ImmutableList.of(
			new NamePart("Los Angeles", null)));
    }
}
