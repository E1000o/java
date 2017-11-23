import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    
    public int getMenuChoice() {
        int menuChoice = 0;
        
        menuChoice = userInput.nextInt();
        // flush newline character
        userInput.nextLine();
        
        return menuChoice;
    }
    
    public Order getOrderData() {
        Order order;
        Dozen cookieTypes = getCookieTypes();
        Customer customer = getCustomerData();
        Address deliveryAddress = getAddressData();
        String deliveryDate = getDeliveryDate();
        
        order = new Order(cookieTypes, customer, deliveryAddress, deliveryDate);
        return order;
    }

    public Dozen getCookieTypes() {
        Dozen cookieTypes = new Dozen();
        int menuChoice = 0;
        
        while(menuChoice != 4) {
            displayCookieMenu();
            menuChoice = getMenuChoice();
            if (menuChoice == 1) {
                cookieTypes.setChocolateChip(cookieTypes.getChocolateChip() + getDozenAmount("chocolate chip"));
            } else if (menuChoice == 2) {
                cookieTypes.setPeanutButter(cookieTypes.getPeanutButter() + getDozenAmount("peanut butter"));
            } else if (menuChoice == 3) {
                cookieTypes.setOatmealRaisin(cookieTypes.getOatmealRaisin() + getDozenAmount("oatmeal raisin"));
            } else if (menuChoice == 4) {
                displayCookieTypes(cookieTypes);
            } else {
                System.out.println("=== WRONG CHOICE!!! ===");
            }
        }
        
        return cookieTypes;
    }

    public void displayCookieTypes(Dozen cookieTypes) {
        System.out.println("=== YOUR SELECTION ===");
        if (cookieTypes.getChocolateChip() > 0) {
            System.out.println("Chocolate Chip: " + cookieTypes.getChocolateChip() + " dozen");
        }
        
        if (cookieTypes.getPeanutButter() > 0) {
            System.out.println("Peanut Butter: " + cookieTypes.getPeanutButter() + " dozen");
        }
        
        if (cookieTypes.getOatmealRaisin() > 0) {
            System.out.println("Oatmeal Raisin: " + cookieTypes.getOatmealRaisin() + " dozen");
        }
        
    }

    private int getDozenAmount(String cookieType) {
        int dozenAmount = 0;
        
        System.out.print("Enter amount of " + cookieType + " cookies: ");
        dozenAmount = userInput.nextInt();
     // flush newline character
        userInput.nextLine();
        
        return dozenAmount;
    }

    public String getDeliveryDate() {
        String deliveryDate = "";
        
        deliveryDate = getStringWithPrompt("delivery date");
        
        return deliveryDate;
    }
    
    public Address getAddressData() {
        Address address = new Address();
        
        address.setStreet(getStringWithPrompt("street name and number"));
        address.setCity(getStringWithPrompt("city name"));
        address.setZipCode(getStringWithPrompt("ZIP code"));
        address.setState(getStringWithPrompt("State"));
        
        return address;
    }

    public Customer getCustomerData() {
        Customer customer = new Customer();
        
        customer.setName(getStringWithPrompt("customer's name"));
        customer.setPhoneNumber(getStringWithPrompt("customer's phone number"));
        
        return customer;
    }

    private String getStringWithPrompt(String prompt) {
        String string = "";
        
        System.out.println("Enter " + prompt + ": ");
        string = userInput.nextLine();
        
        return string;
    }

    public void displayMainMenu() {
        System.out.println("=======================");
        System.out.println("1. Enter New Order");
        System.out.println("2. Print Baking List");
        System.out.println("3. Print Delivery List");
        System.out.println("4. Exit");
        System.out.println("=======================");
    }

    public void displayCookieMenu() {
        System.out.println("======================");
        System.out.println("1. Chocolate Chip");
        System.out.println("2. Peanut Butter");
        System.out.println("3. Oatmeal Raisin");
        System.out.println("4. Selection complete");
        System.out.println("======================");
    }
    //maybe pass bakingList instead of date
    public void displayBakingList(String date) {
        
    }
    // maybe pass deliveryList instead of date
    public void displayDeliveryList(ArrayList<Order> todaysShippingList) {
        displayAllOrders(todaysShippingList);
    }

    public void displayOrder(Order order) {
        System.out.println("=== YOUR ORDER ===");
        displayCookieTypes(order.getCookieTypes());
        displayCustomerData(order.getCustomer());
        displayAddressData(order.getDeliveryAddress());
        displayDeliveryDate(order.getDeliveryDate());
    }
    
    private void displayDeliveryDate(String deliveryDate) {
        // TEMPORARY
        System.out.println("Delivery date: " + deliveryDate);
        
    }

    private void displayAddressData(Address deliveryAddress) {
        System.out.println("Address: ");
        System.out.println(deliveryAddress.getStreet());
        System.out.println(deliveryAddress.getCity() + ", " + deliveryAddress.getState() + ", " + deliveryAddress.getZipCode());
    }

    private void displayCustomerData(Customer customer) {
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Phone number: " + customer.getPhoneNumber());
    }

    public void displayAllOrders(ArrayList<Order> orders) {
        for (Order order : orders) {
            displayOrder(order);
        }
    }
}