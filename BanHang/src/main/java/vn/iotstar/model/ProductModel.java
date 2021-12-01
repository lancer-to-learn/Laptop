package vn.iotstar.model;

public class ProductModel {
	private int pID;
	private String pName;
	private String description;
	private int price;
	private String image;
	private int categoryID;
	private int sellerID;
	private int amount;
	public ProductModel() {
		super();
	}
	public ProductModel(int pID, String pName, String description, int price, String image, int categoryID,
			int sellerID, int amount) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ProductModel [pID=" + pID + ", pName=" + pName + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", categoryID=" + categoryID + ", sellerID=" + sellerID + ", amount=" + amount
				+ ", getpID()=" + getpID() + ", getpName()=" + getpName() + ", getDescription()=" + getDescription()
				+ ", getPrice()=" + getPrice() + ", getImage()=" + getImage() + ", getCategoryID()=" + getCategoryID()
				+ ", getSellerID()=" + getSellerID() + ", getAmount()=" + getAmount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
