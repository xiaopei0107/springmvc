package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 识别验证码
 * @author Sotiy-赵小沛
 *
 */
public class OctTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ocrIdentificationCode();
			
			//Thread.sleep(3000);
			
			//readCodeText("D:\\code.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//ocr识别
	public static void ocrIdentificationCode() throws Exception
	{      
	    //调用ocr 生成text
	    //Runtime runtime = Runtime.getRuntime();
	    //runtime.exec("cmd.exe /C  tesseract.exe D:\\1.jpg  D:\\code -1");
		
	         
	}
	
	//读取目标文件
    public static void readCodeText(String filePath)
    {
        InputStreamReader isReader = null;
        String codeStr = null;
        try {
            String econding = "GBK";
            File file = new File(filePath);
            if(file.exists()&&file.isFile())//判断文件存在
            {
                isReader = new InputStreamReader(new FileInputStream(file),econding);
                BufferedReader bfReader = new BufferedReader(isReader);
                String lineText = null;
                while((lineText=bfReader.readLine())!= null)
                {
                   System.out.println(lineText);
                   System.out.println("11111111111111111111");
                }
            }else{
                System.out.println("文件不存在");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                isReader.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
            
        }
    }
}
