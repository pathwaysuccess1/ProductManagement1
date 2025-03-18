package model;

public class Review {
    private int id;
    private String account;
    private String productId;
    private int rating;
    private String comment;
    private String reviewDate;

    public Review(int id, String account, String productId, int rating, String comment, String reviewDate) {
        this.id = id;
        this.account = account;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getId() { return id; }
    public String getAccount() { return account; }
    public String getProductId() { return productId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public String getReviewDate() { return reviewDate; }
}