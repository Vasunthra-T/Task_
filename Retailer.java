import java.util.List;
import java.util.ArrayList;
public class Retailer extends Product {
    String retailer_name;
    int retailer_id;
    static List<Product> retailer_product_list = new ArrayList<Product>();

    public Retailer( int retailer_id,String retailer_name) {
        this.retailer_name = retailer_name;
        this.retailer_id = retailer_id;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    public List<Product> getR_products() {
        return retailer_product_list;
    }

    public void setR_products(List<Product> retailer_product_list) {
        this.retailer_product_list = retailer_product_list;
    }



}
