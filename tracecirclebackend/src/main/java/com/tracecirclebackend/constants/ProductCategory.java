package com.tracecirclebackend.constants;

public enum ProductCategory {
	
	STEEL("Steel"),
    TYRES("Tyres"),
    BATTERIES("Batteries"),
    APPAREL("Apparel");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
