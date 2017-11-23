import java.util.ArrayList;

public class OrderSystem {
    private ArrayList<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }
    
    public ArrayList<Order> getOrders() {
        return this.orders;
    }
    
    public Dozen compileBakingList(String date) {
        Dozen todaysBakingList = new Dozen();
        
        for (Order order : this.orders) {
            if (order.getBakingDate().equals(date)) {
                todaysBakingList.setChocolateChip(todaysBakingList.getChocolateChip() + order.getCookieTypes().getChocolateChip());
                todaysBakingList.setPeanutButter(todaysBakingList.getPeanutButter() + order.getCookieTypes().getPeanutButter());
                todaysBakingList.setOatmealRaisin(todaysBakingList.getOatmealRaisin() + order.getCookieTypes().getOatmealRaisin());
            }
        }
        
        return todaysBakingList;
    }

    public ArrayList<Order> compileDeliveryList(String deliveryDate) {
        ArrayList<Order> todaysDeliveryList = new ArrayList<Order>();
        
        for (Order order : this.orders) {
            if (order.getDeliveryDate().equals(deliveryDate)) {
                todaysDeliveryList.add(order);
            }
        }
        
        return todaysDeliveryList;
    }
}