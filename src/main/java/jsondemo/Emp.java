package jsondemo;

public class Emp {
    private String itemNo;
    private String itemName;
    private String sortno;
    public Emp() {
    }
    public Emp(String itemNo, String itemName, String sortno) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.sortno = sortno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "itemNo='" + itemNo + '\'' +
                ", itemName='" + itemName + '\'' +
                ", sortno='" + sortno + '\'' +
                '}';
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSortno() {
        return sortno;
    }

    public void setSortno(String sortno) {
        this.sortno = sortno;
    }
}
