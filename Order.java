import java.util.Calendar;

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
        int deliveryMonth = 0;
        int deliveryDay = 0;
        int deliveryYear = 0;
        int bakingMonth = 0;
        int bakingDay = 0;
        int bakingYear = 0;
        String bakingMonthPrefix = "";
        String bakingDayPrefix = "";
        String bakingDate = "";
        String[] dateElements = this.deliveryDate.split("/");
        Calendar calendar = Calendar.getInstance();
        
        deliveryMonth = Integer.parseInt(dateElements[0]) - 1;
        deliveryDay = Integer.parseInt(dateElements[1]);
        deliveryYear = Integer.parseInt(dateElements[2]);
        
        calendar.set(deliveryYear, deliveryMonth, deliveryDay);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        
        bakingMonth = calendar.get(Calendar.MONTH) + 1;
        bakingDay = calendar.get(Calendar.DAY_OF_MONTH);
        bakingYear = calendar.get(Calendar.YEAR);
        
        if (bakingMonth < 10) {
            bakingMonthPrefix = "0";
        }
        
        if (bakingDay < 10) {
            bakingDayPrefix = "0";
        }
        
        
        bakingDate = bakingMonthPrefix + bakingMonth + "/" + bakingDayPrefix + bakingDay + "/" + bakingYear;
        
        return bakingDate;
    }

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