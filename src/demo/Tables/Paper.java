package demo.Tables;

public class Paper extends Base {
    public String name; // ������������
    public String type; // ��� - � ����� ������ ������, �����, ������
    public int price; // ���������
    public int pages; // ��� - �� �������




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Paper(long id, String name, String type, int price, int pages) {
        super(id);
        this.name = name;
        this.type = type;
        this.price = price;
        this.pages = pages;
    }


}
