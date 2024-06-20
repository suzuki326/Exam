package bean;

import java.io.Serializable;

//Productクラス...productテーブルを表す
public class Product implements Serializable {
	// フィールド...テーブルの列を表す
	private int id;
	private String name;
	private int price;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return name + "<b>(" + price + "円)</b>";
	}

	public int getTaxPrice() {
		return (int) (price * 1.1);
	}
}
