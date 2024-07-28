public class Transaction {
    private int id;
    private int propertyId;
    private int buyerId;
    private int sellerId;
    private double amount;
    private String date;

    // Constructor
    public Transaction(int id, int propertyId, int buyerId, int sellerId, double amount, String date) {
        this.id = id;
        this.propertyId = propertyId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
