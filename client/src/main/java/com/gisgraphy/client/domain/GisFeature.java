package com.gisgraphy.client.domain;

public final class GisFeature {
    private String ok = "ok";

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ok == null) ? 0 : ok.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	GisFeature other = (GisFeature) obj;
	if (ok == null) {
	    if (other.ok != null)
		return false;
	} else if (!ok.equals(other.ok))
	    return false;
	return true;
    }
}
