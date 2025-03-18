package model;

public class Category {
    private int typeId;
    private String categoryName;
    private String memo;

    public Category(int typeId, String categoryName, String memo) {
        this.typeId = typeId;
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public int getTypeId() { return typeId; }
    public String getCategoryName() { return categoryName; }
    public String getMemo() { return memo; }
}