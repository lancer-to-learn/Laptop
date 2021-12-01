package vn.iotstar.model;

public class CategoryModel {
	private int cate_id;
	private String cname;
	private String icon;
	
	public CategoryModel() {
		super();
	}
	public CategoryModel(int cate_id, String cname, String icon) {
		super();
		this.cate_id = cate_id;
		this.cname = cname;
		this.icon = icon;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "CategoryModel [cate_id=" + cate_id + ", cname=" + cname + ", icon=" + icon + "]";
	}

}
