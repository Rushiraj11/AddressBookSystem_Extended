package com.bridgelabz.addressbooksystem;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
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
    @Test
    public void CSV_Test() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        AddressBook[] arrayOfPer = {
                new AddressBook("Tanmay", "Kansal", "Chandi Mandir", "Hapur", "UP", "9874568547" , "xyz@gmail.com", 245101),
                new AddressBook("Prasad", "Kale", "Kannauj", "Kanpur", "UP", "98754788777" , "xyabxt@gmail.com", 245524)
        };
        AddressBookCSVFile addressBookCsvReader = new AddressBookCSVFile();
        addressBookCsvReader.writeDataInCSVFile(Arrays.asList(arrayOfPer));
        int count = addressBookCsvReader.readData();
        Assertions.assertEquals(3,count);
    }
}
