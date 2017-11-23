public class Order {
    private Dozen cookieTypes;
    private Customer customer;
    private Address deliveryAddress;
    private String deliveryDate;
    private String bakingDate;
    
    Order(Dozen cookieTypes, Customer customer, Address deliveryAddress, String deliveryDate) {
        this.setCookieTypes(cookieTypes);
        this.setCustomer(customer);
        this.setDeliveryAddress(deliveryAddress);
        this.setDeliveryDate(deliveryDate);
        this.bakingDate = this.getBakingDate();
    }
    
    public String getBakingDate() {
        // TEMPORARY
        return this.deliveryDate;
    }
//    +toString()??

    public Dozen getCookieTypes() {
        return cookieTypes;
    }

    public void setCookieTypes(Dozen cookieTypes) {
        this.cookieTypes = cookieTypes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}