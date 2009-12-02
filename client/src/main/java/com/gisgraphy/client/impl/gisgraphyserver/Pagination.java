package com.gisgraphy.client.impl.gisgraphyserver;

public final class Pagination {
    public static class PaginationBuilder {
	private Integer offset;
	
	private PaginationBuilder(Integer offset) {
	    this.offset = offset;
	}
	public Pagination andLimit(Integer limit) {
	    return new Pagination(this.offset, limit);
	}
	public Pagination andNoLimit() {
	    return new Pagination(this.offset, null);
	}
    }
    
    private Integer offset = null;
    private Integer limit = null;
    
    public static PaginationBuilder offset(Integer offset) {
	return new PaginationBuilder(offset);
    }
    
    public static PaginationBuilder noOffset() {
	return new PaginationBuilder(null);
    }
    
    public Pagination(Integer offset, Integer limit) {
	super();
	this.offset = offset;
	this.limit = limit;
    }
    
    public Pagination withOffset(Integer offset) {
	return new Pagination(offset, this.limit);
    }
    
    public Pagination withLimit(Integer limit) {
	return new Pagination(this.offset, limit);
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
    
    public boolean isPaginationEnabled() {
	return (offset != null && limit != null);
    }
    
    public Integer getEndOffset() {
	if(isPaginationEnabled()) {
	    return offset + limit;
	} else {
	    return null;
	}	
    }
    
}
