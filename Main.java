import com.hankcs.hanlp.HanLP;
import java.util.*;
import java.io.*;
import java.security.*;
public class Main {
    public String buf1="";//存储读取的第一个文件的字符
    public String buf2="";//存储读取的第二个文件的字符
    public String outpath="";
    List<String> wordlist1;//存储第一个文件的字词
    List<String> wordlist2;//存储第二个文件的字词
    ioPart ioTool=new ioPart();//使用方法集读取文件
    public void readText()
    {
        System.out.println("Please enter the dictionary of the first file");//输入第一个文件URL
        ioTool.read();
        buf1=ioTool.buffer;
        System.out.println("Please enter the dictionary of the second file");//输入第二个文件URL
        ioTool.read();
        buf2=ioTool.buffer;
        System.out.println("Please enter the dictionary of the output file");//输入第二个文件URL
        Scanner sc=new Scanner(System.in);
        outpath=sc.nextLine();
    }
    public  float calSame() {
        //使用语言包收集词集
        wordlist1 = HanLP.extractKeyword(buf1, buf1.length());
        wordlist2 = HanLP.extractKeyword(buf2, buf2.length());
        int same=0;
        //遍历，计算有几个词是相同的
        for (int i = 0; i < wordlist1.size(); i++)
            for (int j = 0; j < wordlist2.size(); j++)
            {
                if(wordlist1.get(i).equals(wordlist2.get(j)))
                {
                    same+=1;
                }
            }
        float rec=(float)same/wordlist1.size();
        String data="The average of the same word rate"+rec;
        File writein=new File(outpath);
        try{
        FileWriter fileWritter = new FileWriter(writein.getName(),true);
        fileWritter.write(data);
        fileWritter.close();}catch(Exception e){}
        return  rec;//输出相似度
    }


    public static void main(String args[])
    {
        Main n=new Main();//创建类
        n.readText();//开始运行
        System.out.println(n.calSame());//显示相似度

    }
}