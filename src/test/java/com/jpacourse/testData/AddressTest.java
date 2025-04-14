package com.jpacourse.testData;

import com.jpacourse.persistance.entity.AddressEntity;

public class AddressTest {
    public static AddressEntity addAddress() {
        AddressEntity address = new AddressEntity();
        address.setCity("New York");
        address.setAddressLine1("New York City");
        address.setAddressLine2("Brooklyn");
        address.setPostalCode("12345");
        return address;
    }
}
