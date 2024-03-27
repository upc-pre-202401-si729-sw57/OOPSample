package com.acme.shared.domain.model.valueobjects;

public record Address(String street, String city, String state, String zipCode, String country) {
    public String getAddressAsString() {
        return street + ", " + city + ", " + state + ", " + zipCode + ", " + country;
    }
}
