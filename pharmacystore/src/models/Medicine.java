package models;

public class Medicine {
    private String name;
    private int id;
    private double price;
    private String type;

    private int stockAvailable;

    public Medicine(){

    }

    public Medicine(String name, int id, double price, String type, int stockAvailable){
        this.name=name;
        this.id=id;
        this.price=price;
        this.type=type;
        this.stockAvailable=stockAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(int stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    @Override
    public String toString() {
        return name+" "+id+" "+price+" "+type+" "+stockAvailable;
    }
}
