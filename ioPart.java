import java.util.*;
import java.io.*;
public class ioPart{
    public static String buffer="";//用以存储读出的字符串
    public static void read(){
        try{
            buffer="";
            Scanner sc=new Scanner(System.in);
            String filePath=sc.nextLine();//读入路径
            System.out.println(filePath);
            FileInputStream fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String strTmp = "";
            while((strTmp = buffReader.readLine())!=null){
                buffer+=strTmp;//逐个读入字符
            }
            buffReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());//故障处理
        }
    }
}