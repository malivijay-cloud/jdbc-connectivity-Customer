package org.example;

import org.example.Repository.CustomerRepository;
import org.example.model.Customer;
import org.example.service.ConnectionService;
import org.example.service.CustomerService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Connection connection = ConnectionService.getConnection();

        if (connection == null) {
            System.out.println("Database Connection Failed!");
            return;
        }

        CustomerRepository repository = new CustomerRepository(connection);
        CustomerService service = new CustomerService(repository);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========== CUSTOMER MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Edit Customer");
            System.out.println("4. Delete Customer");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Customer ID : ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Customer Name : ");
                    String name = sc.nextLine();

                    System.out.print("Gender : ");
                    String gender = sc.nextLine();

                    System.out.print("DOB : ");
                    String dob = sc.nextLine();

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Address : ");
                    String address = sc.nextLine();

                    System.out.print("City : ");
                    String city = sc.nextLine();

                    Customer customer = new Customer(
                            id,
                            name,
                            gender,
                            dob,
                            email,
                            phone,
                            address,
                            city
                    );

                    if (service.addCustomer(customer))
                        System.out.println("Customer Added Successfully.");
                    else
                        System.out.println("Failed To Add Customer.");

                    break;

                case 2:

                    List<Customer> customers = service.viewCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No Customers Found.");
                    } else {

                        for (Customer c : customers) {

                            System.out.println("-----------------------------------------");
                            System.out.println("ID       : " + c.getCustomerId());
                            System.out.println("Name     : " + c.getCustomerName());
                            System.out.println("Gender   : " + c.getCustomerGender());
                            System.out.println("DOB      : " + c.getCustomerDob());
                            System.out.println("Email    : " + c.getCustomerEmail());
                            System.out.println("Phone    : " + c.getCustomerPhoneNo());
                            System.out.println("Address  : " + c.getCustomerAddress());
                            System.out.println("City     : " + c.getCustomerCity());
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Customer ID : ");
                    int editId = Integer.parseInt(sc.nextLine());

                    Customer editCustomer = service.getCustomerById(editId);

                    if (editCustomer == null) {
                        System.out.println("Customer Not Found.");
                        break;
                    }

                    System.out.println("\nPress Enter to Keep Existing Value");

                    System.out.print("Name (" + editCustomer.getCustomerName() + ") : ");
                    String newName = sc.nextLine();
                    if (!newName.isEmpty())
                        editCustomer.setCustomerName(newName);

                    System.out.print("Gender (" + editCustomer.getCustomerGender() + ") : ");
                    String newGender = sc.nextLine();
                    if (!newGender.isEmpty())
                        editCustomer.setCustomerGender(newGender);

                    System.out.print("DOB (" + editCustomer.getCustomerDob() + ") : ");
                    String newDob = sc.nextLine();
                    if (!newDob.isEmpty())
                        editCustomer.setCustomerDob(newDob);

                    System.out.print("Email (" + editCustomer.getCustomerEmail() + ") : ");
                    String newEmail = sc.nextLine();
                    if (!newEmail.isEmpty())
                        editCustomer.setCustomerEmail(newEmail);

                    System.out.print("Phone (" + editCustomer.getCustomerPhoneNo() + ") : ");
                    String newPhone = sc.nextLine();
                    if (!newPhone.isEmpty())
                        editCustomer.setCustomerPhoneNo(newPhone);

                    System.out.print("Address (" + editCustomer.getCustomerAddress() + ") : ");
                    String newAddress = sc.nextLine();
                    if (!newAddress.isEmpty())
                        editCustomer.setCustomerAddress(newAddress);

                    System.out.print("City (" + editCustomer.getCustomerCity() + ") : ");
                    String newCity = sc.nextLine();
                    if (!newCity.isEmpty())
                        editCustomer.setCustomerCity(newCity);

                    if (service.editCustomer(editCustomer))
                        System.out.println("Customer Updated Successfully.");
                    else
                        System.out.println("Update Failed.");

                    break;

                case 4:

                    System.out.print("Enter Customer ID : ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    if (service.removeCustomer(deleteId))
                        System.out.println("Customer Deleted Successfully.");
                    else
                        System.out.println("Delete Failed.");

                    break;

                case 0:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

        sc.close();

        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}