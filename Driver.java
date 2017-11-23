import java.util.ArrayList;

public class Driver {
    private static UserInterface userInterface = new UserInterface();
    private static OrderSystem orderSystem = new OrderSystem();
    
    public static void main(String[] args) {
        int mainMenuChoice = 0;
        
        while(mainMenuChoice != 4) {
            userInterface.displayMainMenu();
            
            mainMenuChoice = userInterface.getMenuChoice();
            
            if (mainMenuChoice == 1) {
                enterNewOrder();
            } else if (mainMenuChoice == 2) {
                printBakingList();
            } else if (mainMenuChoice == 3) {
                printDeliveryList();
            } else if (mainMenuChoice == 4) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Wrong choice!");
            }
        }
        
        userInterface.displayAllOrders(orderSystem.getOrders());
    }

    private static void printDeliveryList() {
        ArrayList<Order> todaysShippingList = new ArrayList<Order>();
        String deliveryDate = userInterface.inputDeliveryDate();

        todaysShippingList = orderSystem.compileDeliveryList(deliveryDate);
        userInterface.displayDeliveryList(todaysShippingList);
    }

    private static void printBakingList() {
        String bakingDate = userInterface.inputBakingDate();
        Dozen todaysBakingList = new Dozen();
        todaysBakingList = orderSystem.compileBakingList(bakingDate);
        userInterface.displayCookieTypes(todaysBakingList);
    }

    private static void enterNewOrder() {
        Order order = userInterface.getOrderData();
        orderSystem.addOrder(order);
    }
}