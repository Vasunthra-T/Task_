class Product {
    int id;
    String name;
    int price;
    int stock;
    int w_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Product() {
    }

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public Product(int id, String name, int price, int stock, int w_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.w_id = w_id;
    }

   // public Product(int w_id,String w_name,)

}
