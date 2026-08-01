package org.example.model;

public class Customer {
    private int CustomerId;
    private String CustomerName;
    private String CustomerGender;
    private String CustomerDob;
    private String CustomerEmail;
    private String CustomerPhoneNo;
    private String CustomerAddress;
    private String CustomerCity;

    //Constructor

    public Customer(int customerId, String customerName, String customerGender, String customerDob, String customerEmail, String customerPhoneNo, String customerAddress, String customerCity) {
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerGender = customerGender;
        CustomerDob = customerDob;
        CustomerEmail = customerEmail;
        CustomerPhoneNo = customerPhoneNo;
        CustomerAddress = customerAddress;
        CustomerCity = customerCity;
    }

    //Gettar And Setter Method

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    public String getCustomerDob() {
        return CustomerDob;
    }

    public void setCustomerDob(String customerDob) {
        CustomerDob = customerDob;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerPhoneNo() {
        return CustomerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        CustomerPhoneNo = customerPhoneNo;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public void setCustomerCity(String customerCity) {
        CustomerCity = customerCity;
    }

    //ToString

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerGender='" + CustomerGender + '\'' +
                ", CustomerDob='" + CustomerDob + '\'' +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", CustomerPhoneNo='" + CustomerPhoneNo + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", CustomerCity='" + CustomerCity + '\'' +
                '}';
    }
}
