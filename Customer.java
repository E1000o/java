public class Customer {
    private String name;
    private String phoneNumber;
    
    Customer() {
        this.setName("");
        this.setPhoneNumber("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}