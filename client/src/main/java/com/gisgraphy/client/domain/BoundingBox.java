package com.gisgraphy.client.domain;

public class BoundingBox {
    /**
     * @see #getBoundingBoxEast()
     */
    private Double boundingBoxEast;

    /**
     * @see #getBoundingBoxNorth()
     */
    private Double boundingBoxNorth;

    /**
     * @see #getBoundingBoxSouth()
     */
    private Double boundingBoxSouth;

    /**
     * @see #getBoundingBoxWest()
     */
    private Double boundingBoxWest;
    
    public Double getBoundingBoxEast() {
	return this.boundingBoxEast;
    }

    public Double getBoundingBoxNorth() {
	return this.boundingBoxNorth;
    }

    public Double getBoundingBoxSouth() {
	return this.boundingBoxSouth;
    }

    public Double getBoundingBoxWest() {
	return this.boundingBoxWest;
    }

}
