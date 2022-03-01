package execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Test_One {

	public static void main(String[] args) {
		//GASのデプロイしたURLを入れる
		String urlString = "your GASproject's url in here!!";
        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);//POST可能にする
            
            uc.setRequestProperty("User-Agent", "Gas_ResponseTest");// ヘッダを設定
            uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
 
            OutputStream os = uc.getOutputStream();//POST用のOutputStreamを取得
            
            String encoded = URLEncoder.encode("テスト成功", "UTF-8");
        
            //String postStr = "name=undo&foo2=bar2";//POSTするデータ
            String postStr = "name=";
            
            PrintStream ps = new PrintStream(os);
            ps.print(postStr+encoded);//データをPOSTする
            ps.close();
 
            InputStream is = uc.getInputStream();//POSTした結果を取得
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            reader.close();
            
        } catch (MalformedURLException e) {
            System.err.println("不正な形式のURLです。 " + urlString);
            
        } catch (IOException e) {
            System.err.println("何らかの入出力例外が発生しました。");
        }
    }
}
