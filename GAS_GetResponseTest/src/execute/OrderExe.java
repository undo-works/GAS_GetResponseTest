package execute;

import java.util.ArrayList;

import bean.Item;
import model.GetItemList;

public class OrderExe {

	public static void main(String[] args) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = GetItemList.getItemList();
		
		for(Item item : itemList) {
			System.out.println(item.getItemId() + "," + item.getItemName() +
					"," + item.getSize() + "," + item.getPrice());
		}
	}

}
