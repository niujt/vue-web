package jsondemo;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Json转换类
 * @author jtniu
 *
 */
public class JsonUtil {
    /**
     * 将字符串转换成对象集合
     * @param str 字符串
     * @return 对象集合
     */
    public static List<Emp> changeString2Emp(List<String> str){
        List<Emp> emps=new ArrayList<Emp>();
       // str.forEach(System.out::println);
        //System.out.println(xx[0]+","+xx[1]+","+xx[2]);
        Emp e1=new Emp(str.get(0).split(",")[0].substring(2,str.get(0).split(",")[0].length()-1),str.get(0).split(",")[1].substring(1,str.get(0).split(",")[1].length()-1),str.get(0).split(",")[2].substring(1,str.get(0).split(",")[2].length()-1));
        emps.add(e1);
        for(int i=1;i<str.size();i++){
            String[] xx=str.get(i).split(",");
            //System.out.println(xx[0]+","+xx[1]+","+xx[2]);
           String itemNo=xx[0].substring(1,xx[0].length()-1);
            String itemName= xx[1].substring(1,xx[1].length()-1);
            String sortno=xx[2].substring(1,xx[2].length()-1);
            Emp e=new Emp(itemNo,itemName,sortno);
            emps.add(e);
        }
        return emps;
    }

    /**
     * 读文件
     * @param fileName 文件名
     * @return 字符串集合
     */
    public static List<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> list=new ArrayList<String>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                list.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }

    /**
     * 集合转换成json
     * @param list 集合
     * @return json对象
     */
    public static JSONObject EmpList2Json(List list){
        JSONObject json = new JSONObject();
        json.put("list",list);
        return json;
    }

    /**
     * 将json写入txt文件
     * @param arrays json字符串
     * @return txt文件
     */
    public static void writeFile(String arrays) {
        try {
            PrintWriter pw=new PrintWriter(new FileOutputStream(new File("json.txt")));
            pw.print(arrays);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
