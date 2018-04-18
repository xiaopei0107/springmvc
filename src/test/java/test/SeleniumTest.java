package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumTest {

    static String baseUrl = "http://www.qyer.com";
    public static void main(String args[])
    {
        //创建个log文件
        File logFile = new File("d://logFile.txt");
        if(!logFile.exists())
        {
            try {
                logFile.createNewFile();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        //创建一个webdriver
        WebDriver driver = new InternetExplorerDriver();
        driver.get(baseUrl);
        
        //设置等待
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception 
            e.printStackTrace();
        }
        //获得所有a标签
        List<WebElement> aList = driver.findElements(By.tagName("a"));
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //遍历所有标签 
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(logFile);
            for(WebElement a:aList){
                System.out.println(a.getAttribute("href"));
                
                //获得a标签h ref属性
                String urlStr = a.getAttribute("href");
                if(urlStr.contains("place"))
                {
                    urlStr+="\r\n";
                    //将url写入文件中
                    fs.write(urlStr.getBytes());
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                fs.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }    
    }
}