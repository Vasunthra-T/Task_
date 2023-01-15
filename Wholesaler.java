import java.util.List;
import java.util.ArrayList;

public class Wholesaler extends Product {
    String wholesaler_name;
    int wholesaler_id;
    static List<Product> wholesaler_product_list= new ArrayList<Product>();

   // product_copy.id = product.id;
    public Wholesaler(int wholesaler_id,String wholesaler_name){
        this.wholesaler_name = wholesaler_name;
        this.wholesaler_id = wholesaler_id;
    }
    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

    public List<Product> getProduct_list() {
        return wholesaler_product_list;
    }

    public void setProduct_list(List<Product> wholesaler_product_list) {
        this.wholesaler_product_list = wholesaler_product_list;
    }





    //ArrayList<> w_products = new ArrayList<>();

}