package com.bridgelabz.addressbooksystem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookRepo {
    Connection connection;

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost/addressbookservice";
        String username = "root";
        String password = "rushiraj@123456789";
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public List<ContactDetails> retrieveData() {
        ResultSet resultSet = null;
        List<ContactDetails> addressBookList = new ArrayList<ContactDetails>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from AddressBook";
            resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()) {
                ContactDetails contactInfo = new ContactDetails() ;
                contactInfo.setFirstName(resultSet.getString("firstName"));
                contactInfo.setLastName(resultSet.getString("Lastname"));
                contactInfo.setAddress(resultSet.getString("address"));
                contactInfo.setCity(resultSet.getString("city"));
                contactInfo.setState(resultSet.getString("state"));
                contactInfo.setZip(resultSet.getInt("zip"));
                contactInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
                contactInfo.setEmailId(resultSet.getString("email"));
                contactInfo.setBookName(resultSet.getString("bookName"));
                contactInfo.setContactType(resultSet.getString("contactType"));
                contactInfo.setDateAdded(resultSet.getDate("Date_added").toLocalDate());

                addressBookList.add(contactInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return addressBookList;

    }
    }

