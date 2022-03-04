package bean;
import java.io.Serializable;
public class Item implements Serializable{
	private String itemId;    //商品ID
	private String itemName;  //商品名
	private String size;      //サイズ
	private int price;        //単価
	public Item(){}
	public Item(String itemId, String itemName, String size, int price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
	}
	public String getItemId() {		        //商品IDの値を返却する
		return itemId;
	}
	public String getItemName() {		    //商品名の値を返却する
		return itemName;
	}
	public String getSize() {		        //サイズの値を返却する
		return size;
	}
	public int getPrice() {		            //単価の値を返却する
		return price;
	}
	public void setItemId(String itemId) {	    //商品IDを設定する
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {	//商品名を設定する
		this.itemName = itemName;
	}
	public void setSize(String size) {			//サイズを設定する
		this.size = size;
	}
	public void setPrice(int price) {			//単価を設定する
		this.price = price;
	}
}
