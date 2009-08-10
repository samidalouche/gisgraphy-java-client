package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.google.common.collect.ImmutableList;

public interface NamesExtractor {
    ImmutableList<String> extractNames(final ImmutableList<NamePart> nameParts);
}
