package com.gisgraphy.client.objectmothers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

public class FullTextSearchResultsObjectMother {

    public static InputStreamSource irvine() {
        return new ClassPathResource("/com/gisgraphy/client/sampleFullTextSearchResults/fullTextSearchForIrvine.xml");
    }

    public static InputStreamSource paris() {
        return new ClassPathResource("/com/gisgraphy/client/sampleFullTextSearchResults/fullTextSearchForParis.xml");
    }

    public static InputStreamSource seattle() {
        return new ClassPathResource("/com/gisgraphy/client/sampleFullTextSearchResults/fullTextSearchForSeattleWithFullStyle.xml");
    }
}
