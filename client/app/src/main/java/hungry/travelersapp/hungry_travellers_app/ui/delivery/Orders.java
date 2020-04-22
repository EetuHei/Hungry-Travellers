package hungry.travelersapp.hungry_travellers_app.ui.delivery;

public class Orders {

    String orderId;
    String orderName;
    String orderAddress;
    String orderNumber;

    public Orders() {

    }

    public Orders(String orderId, String orderName, String orderAddress, String orderNumber) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderAddress = orderAddress;
        this.orderNumber = orderNumber;
    }

    public String getOrderId() { return orderId; }

    public String getOrderName() { return orderName; }

    public String getOrderAddress() { return orderAddress; }

    public String getOrderNumber() { return orderNumber; }
    
}
