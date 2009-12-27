package com.gisgraphy.client.commons;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
	return new HashCodeBuilder()
		.append(friendlyCode)
		.append(name)
		.toHashCode();
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
	
	return new EqualsBuilder()
		.append(friendlyCode, other.getFriendlyCode())
		.append(name, other.getName())
		.isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("name", name)
		.append("friendlyCode", friendlyCode)
		.toString();
    }
    
    
}
