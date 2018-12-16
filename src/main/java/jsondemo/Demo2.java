package jsondemo;


public class Demo2 {
    public static void main(String args[]){
        try {
            JsonUtil.writeFile(
                    JsonUtil.EmpList2Json(
                            JsonUtil.changeString2Emp(
                                    JsonUtil.readFileByLines("地址.txt"))).toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
