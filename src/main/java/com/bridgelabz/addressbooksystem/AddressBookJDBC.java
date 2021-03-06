package com.bridgelabz.addressbooksystem;
import java.util.List;
import java.util.Scanner;


public class AddressBookJDBC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            System.out.println("\n 1   Retrieve data \n 2  Exit");
            switch (scanner.nextInt()) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    exit = true;
            }
        }
    }

    private static void retrieveData() {
        AddressBookRepo addressBookRepo = new AddressBookRepo();
        List<ContactDetails> employeeInfoList = addressBookRepo.retrieveData();
        for (ContactDetails employee : employeeInfoList
        ) {
            System.out.println(employee + "\n");
        }
    }
}
