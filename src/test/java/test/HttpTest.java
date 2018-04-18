package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTest {
	public static void main(String[] args) {
		String str = postDownloadJson("http://uat.bsteel.com/newexchange/index.do");
		System.out.println(str);
		
	}
	
	
	//获取其他页面的数据
    /**
     * POST请求获取数据
     */
    public static String postDownloadJson(String path){
    	StringBuilder str = new StringBuilder();
    	 try {
             //创建一个URL实例
             URL url = new URL(path);

             try {
                 //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
                 InputStream is = url.openStream();
                 InputStreamReader isr = new InputStreamReader(is,"utf-8");

                 //为字符输入流添加缓冲
                 BufferedReader br = new BufferedReader(isr);
                 String data = br.readLine();//读取数据

                 while (data!=null){//循环读取数据
                     data = br.readLine();
                     if(data.indexOf("<a href=\"/newexchange/") >0){
                    	 System.out.println(data);
                     }
                     //str.append(data);
                 }
                 br.close();
                 isr.close();
                 is.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
        return str.toString();
    }
}
