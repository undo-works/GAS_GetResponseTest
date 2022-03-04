package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import bean.Item;

public class GetItemList {
	
	public static ArrayList<Item> getItemList() {
		//GASのデプロイしたURLを入れる
		String urlString = "https://script.google.com/macros/s/AKfycbwJrX4CoQRQTTEQwovl_iu8ZgTir15bByq33mzuVQgtW88jwiPpPzhyWZWB6vFBij1SPg/exec"; //your GASproject's url in here!!
		ArrayList<Item> itemList = new ArrayList<Item>();
	    try {
	        URL url = new URL(urlString);
	        URLConnection uc = url.openConnection();
	        uc.setDoOutput(true);//POST可能にする
	        
	        uc.setRequestProperty("User-Agent", "Gas_ResponseTest");// ヘッダを設定
	        uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
	 
	        OutputStream os = uc.getOutputStream();//POST用のOutputStreamを取得
	        
	        //String encoded = URLEncoder.encode("テスト成功", "UTF-8");
	    
	        //String postStr = "name=undo&foo2=bar2";//POSTするデータ
	        String postStr = "flag=1";
	        
	        PrintStream ps = new PrintStream(os);
	        ps.print(postStr);//データをPOSTする
	        ps.close();
	 
	        InputStream is = uc.getInputStream();//POSTした結果を取得
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        
	        String s;
	        while ((s = reader.readLine()) != null) {
	        	//カンマ区切りで配列にする
	        	String[] array = s.split(",");
	        	for(int i=0; i<array.length; i++) {
	        		Item item = new Item();
	        		//分割した配列をbeanに入力
		        	item.setItemId(array[i++]);
		        	item.setItemName(array[i++]);
		        	
		        	//サイズはnullの場合がある
		        	if(array[i].equals("null")) {
		        		array[i] = null;
		        	}
		        	item.setSize(array[i++]);
		        	
		        	//金額を数字に変える
		        	int num = Integer.parseInt(array[i]);
		        	item.setPrice(num);
		        	
		        	//リストにセット
		        	itemList.add(item);
	        	}
	        	
	        }
	        reader.close();
	        
	    } catch (MalformedURLException e) {
	        System.err.println("不正な形式のURLです。 " + urlString);
	        
	    } catch (IOException e2) {
	        System.err.println("何らかの入出力例外が発生しました。");
	    }
	    
	    return itemList;
	}
}
