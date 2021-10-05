package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookIOService {
    public static File AddressBookPath = new File( "AddressBook.txt");
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program");
    }
        public void writeData(List<AddressBook> addressBooks) {
            StringBuffer contactBufferString = new StringBuffer();
            addressBooks.forEach(contact -> {
                String contactDataString = contact.toString().concat("\n");
                contactBufferString.append(contactDataString);
            });
            try {
                Files.write(Paths.get(String.valueOf(AddressBookPath)),contactBufferString.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void readData(){
            try {
                Files.lines(new File("AddressBook.txt").toPath()).forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public long countDataEntries() {
            long entries = 0;
            try {
                entries = Files.lines(new File("AddressBook.txt").toPath()).count();
                System.out.println(entries);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return entries;
        }
    }







