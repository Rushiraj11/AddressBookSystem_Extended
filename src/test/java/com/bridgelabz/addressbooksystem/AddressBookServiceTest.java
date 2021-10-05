package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class AddressBookServiceTest {
    @Test
    public void given3ContactDetailsWhenWrittenToFile() {
        AddressBook[] arrayOfEmps = {
                new AddressBook("Rushiraj", "Ghatge", "Plot no11", "Pune", "Maharashtra", "9890335681", "xyz@gmail.com", 411025)
        };
        AddressBookIOService addressBookService;
        addressBookService = new AddressBookIOService();
        addressBookService.writeData(Arrays.asList(arrayOfEmps));
        addressBookService.readData();
        long entries = addressBookService.countDataEntries();
        Assertions.assertEquals(1, entries);

    }
}
