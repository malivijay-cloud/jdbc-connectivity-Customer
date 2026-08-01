package org.example.Repository;

import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private Connection connection;

    public CustomerRepository(Connection connection) {
        this.connection = connection;
    }
    // CREATE
    public boolean saveCustomer(Customer customer) {

        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getCustomerGender());
            ps.setString(4, customer.getCustomerDob());
            ps.setString(5, customer.getCustomerEmail());
            ps.setString(6, customer.getCustomerPhoneNo());
            ps.setString(7, customer.getCustomerAddress());
            ps.setString(8, customer.getCustomerCity());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM Customer";

        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Customer customer = new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("CustomerName"),
                        rs.getString("CustomerGender"),
                        rs.getString("CustomerDob"),
                        rs.getString("CustomerEmail"),
                        rs.getString("CustomerPhoneNo"),
                        rs.getString("CustomerAddress"),
                        rs.getString("CustomerCity")
                );

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // READ BY ID
    public Customer getCustomerById(int id) {

        String sql = "SELECT * FROM Customer WHERE CustomerId=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("CustomerName"),
                        rs.getString("CustomerGender"),
                        rs.getString("CustomerDob"),
                        rs.getString("CustomerEmail"),
                        rs.getString("CustomerPhoneNo"),
                        rs.getString("CustomerAddress"),
                        rs.getString("CustomerCity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public boolean updateCustomer(Customer customer) {

        String sql = "UPDATE Customer SET CustomerName=?, CustomerGender=?, CustomerDob=?, CustomerEmail=?, CustomerPhoneNo=?, CustomerAddress=?, CustomerCity=? WHERE CustomerId=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerGender());
            ps.setString(3, customer.getCustomerDob());
            ps.setString(4, customer.getCustomerEmail());
            ps.setString(5, customer.getCustomerPhoneNo());
            ps.setString(6, customer.getCustomerAddress());
            ps.setString(7, customer.getCustomerCity());
            ps.setInt(8, customer.getCustomerId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deleteCustomer(int id) {

        String sql = "DELETE FROM Customer WHERE CustomerId=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}