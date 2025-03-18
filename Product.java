package model;

public class Product {
    private String productId;
    private String productName;
    private String productImage;
    private String brief;
    private String postedDate;
    private int typeId;
    private String account;
    private String unit;
    private int price;
    private int discount;

    public Product(String productId, String productName, String productImage, String brief, String postedDate, int typeId, String account, String unit, int price, int discount) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.brief = brief;
        this.postedDate = postedDate;
        this.typeId = typeId;
        this.account = account;
        this.unit = unit;
        this.price = price;
        this.discount = discount;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getProductImage() { return productImage; }
    public String getBrief() { return brief; }
    public String getPostedDate() { return postedDate; }
    public int getTypeId() { return typeId; }
    public String getAccount() { return account; }
    public String getUnit() { return unit; }
    public int getPrice() { return price; }
    public int getDiscount() { return discount; }
    public int getFinalPrice() { return price - (price * discount / 100); }
}