package com.gisgraphy.client.commons;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public final class NamePart {

    private String name;
    private String friendlyCode;
    
    public NamePart(String name, String friendlyCode) {
	super();
	Validate.notEmpty(name);
	this.name = name;
	this.friendlyCode = friendlyCode;
    }

    public String getName() {
        return name;
    }

    public String getFriendlyCode() {
        return friendlyCode;
    }

    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((friendlyCode == null) ? 0 : friendlyCode.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	NamePart other = (NamePart) obj;
	if (friendlyCode == null) {
	    if (other.friendlyCode != null)
		return false;
	} else if (!friendlyCode.equals(other.friendlyCode))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", name)
		.append("friendlyCode", friendlyCode)
		.toString();
    }
    
    
}
