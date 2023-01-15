import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.lang.String;
import java.util.List;


public class Warehouse {


    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Wholesaler> wholesaler_details = new ArrayList<>();
    static ArrayList<Retailer> retailer_details = new ArrayList<>();

   // static ArrayList<String> p_wholesaler = new ArrayList<>();
  //  static ArrayList<String> p_retailer = new ArrayList<>();
   // static Map<String, ArrayList<Product>> wMap = new HashMap<String, ArrayList<Product>>();
    //List<Product> product_list = new ArrayList<Product>();


    public static void main(String[] args) {
        try {
            String line = "";
            String splitBy = ",";
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/warehouses/src/Product.csv"));
            while ((line = sc1.readLine()) != null)   //returns a Boolean value
            {
                String[] productSplit = line.split(splitBy);    // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1] + ", Price=" + productSplit[2] + ", Stock=" + productSplit[3]);
                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1], Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();

            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/warehouses/src/Wholesaler.csv"));
            while ((line = sc2.readLine()) != null)   //returns a Boolean value
            {
                String[] productSplit = line.split(splitBy);    // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                wholesaler_details.add(new Wholesaler(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();

            BufferedReader sc3 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/warehouses/src/Retailer.csv"));
            while ((line = sc3.readLine()) != null)   //returns a Boolean value
            {
                String[] productSplit = line.split(splitBy);    // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc3.close();




            while (true) {
                System.out.println("Enter the option: ");
                System.out.println("1. View products");
                System.out.println("2. View wholesalers");
                System.out.println("3. View retailers");
                System.out.println("4. Allocate product to wholesaler");
                System.out.println("5. Allocate wholesaler product to retailer");
                System.out.println("6. Display product stock");
                System.out.println("7. Display wholesaler stock");
                System.out.println("8. Display retailer stock");
                System.out.println("9.To exit");
                Scanner sc = new Scanner(System.in);
                int user = sc.nextInt();

                switch (user) {
                    case 1: {
                        //Product sp = new Product();
                        System.out.println("P ID"+" "+"P Name"+" "+"Price"+" "+"Stock");
                        for (Product element : products) {
                            System.out.println(element.id+" "+element.name+" "+element.price+" "+element.stock);
                        }
                        System.out.println("-----------------");
                        break;
                    }
                    case 2: {
                        System.out.println("Wholesaler details");
                        for (Wholesaler element : wholesaler_details) {

                            System.out.println(element.getWholesaler_id()+" "+element.getWholesaler_name());
                        }
                        System.out.println("-----------------");
                        break;

                    }
                    case 3: {
                        System.out.println("Retailer details");
                        for (Retailer element : Warehouse.retailer_details) {
                            System.out.println(element.getRetailer_id()+" "+element.getRetailer_name());

                        }
                        System.out.println("-----------------");
                        break;

                    }
                    case 4: {
                        System.out.println("Enter wholesaler id to allocate product");
                        int w_id = sc.nextInt();
                        System.out.println("Enter the product id");
                        int p_id = sc.nextInt();
                        System.out.println("Enter number of items to buy");
                        int w_item = sc.nextInt();
                      //  allocateProductWholesaler(p_id, w_item);
                       // allocateWholesalerProduct(w_id, p_id, w_item);
                        allocateWholesaler(w_id,p_id,w_item);
                       /* for(Product p:products) {
                            System.out.println(p.stock);
                        }*/

                        System.out.println("-----------------");
                        break;

                        //Wholesaler.showWholesaler();
                        //Wholesaler ws = new Wholesaler();
                        //ws.changeStockProduct(id,items);
                    }
                    case 5: {
                        System.out.println("Enter retailer id to allocate product");
                        int r_id = sc.nextInt();
                        System.out.println("Enter wholesaler id to buy product");
                        int wh_id = sc.nextInt();
                        System.out.println("Enter the product id");
                        int p_id = sc.nextInt();
                        System.out.println("Enter number of items to buy");
                        int r_item = sc.nextInt();
                        allocateRetailer(r_id,wh_id, p_id,r_item);
                        System.out.println("-----------------");
                        break;
                    }
                    case 6: {
                        System.out.println("Enter product id to display stock");
                        int nameProduct = sc.nextInt();
                        displayProduct(nameProduct);
                        System.out.println("-----------------");

                        break;
                    }
                    case 7: {
                        System.out.println("Enter product id to display wholesaler stock");
                        int nameW = sc.nextInt();
                        displayWholesaler(nameW);
                        System.out.println("-----------------");
                        break;
                    }
                    case 8: {
                        System.out.println("Enter product id to display retailer stock");
                        int nameR = sc.nextInt();
                        displayWholesaler(nameR);
                        System.out.println("-----------------");
                        break;
                    }
                    case 9:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  static void allocateWholesaler(int wh_id,int p_id,int w_item)
    {
        for (Wholesaler w : wholesaler_details) {

            if (w.wholesaler_id == wh_id) {
                System.out.println(w.wholesaler_name);
                int w_index = wholesaler_details.indexOf(w);

                for (Product iid : products) {
                    // System.out.println(iid.id);
                    if (p_id == iid.id && iid.stock >= w_item) {
                       // int p_index = products.indexOf(iid);
                        Product p = new Product(iid.id, iid.name, iid.price, 0, wh_id);
                        wholesaler_details.get(w_index).wholesaler_product_list.add(p);
                        iid.stock = iid.stock - w_item;
                        System.out.println("Stock left for the entered product:" + iid.stock);
                        int w_product_index ;
                      //  boolean w_bool[] = new boolean[wholesaler_details.get(w_index).wholesaler_product_list.size()];

                            for (Product wp : wholesaler_details.get(w_index).wholesaler_product_list) {
                               System.out.println(wp.w_id);
                               // w_bool[wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp)] = false;
                               if (wp.w_id == wh_id) {
                                 //  w_bool[wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp)] = true;
                                   w_product_index = wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp);
                                    System.out.println(w_product_index);
                                   wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock += w_item;
                                   System.out.println("Stock added:" + wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock);
                               }
                            }



                        }
                    }

                }
                }
            }
 /*static void allocateWholesaler(int w_id, int p_id,int w_item) {
      for (Wholesaler w : wholesaler_details) {

          if (w.wholesaler_id == w_id) {
              System.out.println(w.wholesaler_name);
              int w_index = wholesaler_details.indexOf(w);

              for (Product iid : products) {
                 // System.out.println(iid.id);
                  if (p_id == iid.id && iid.stock >= w_item) {
                      int p_index = products.indexOf(iid);
                      int w_product_index ;
                      if (wholesaler_details.get(w_index).wholesaler_product_list.isEmpty()) {
                          System.out.println("Method 1");
                          System.out.println(w_index);
                          Product p = new Product(iid.id, iid.name, iid.price, 0, w_id);
                          wholesaler_details.get(w_index).wholesaler_product_list.add(p);
                          for (Product wp : wholesaler_details.get(w_index).wholesaler_product_list) {
                              System.out.println(w_index);
                              if (wp.w_id == w_id) {
                                  System.out.println(wp.w_id);

                                  iid.stock = iid.stock - w_item;
                                  System.out.println("Stock left for the entered product:" + iid.stock);

                                  w_product_index = wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp);
                                  System.out.println(w_product_index);


                                  wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock += w_item;
                                  System.out.println("Stock added to wholesaler product:" + wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock);
                                  break;

                              }
                          }
                      } else if(wholesaler_details.get(w_index).wholesaler_product_list.isEmpty() == false){
                          System.out.println("Method 2");
                          for (Product wp : wholesaler_details.get(w_index).wholesaler_product_list) {
                              System.out.println(wp.id);
                             if (wp.id == p_id) {
                                 //System.out.println(wp.w_id);
                                  iid.stock = iid.stock - w_item;
                                  System.out.println("Stock left for the entered product:" + iid.stock);

                                  w_product_index = wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp);
                                  System.out.println(w_product_index);


                                  wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock += w_item;
                                  System.out.println("Stock added to wholesaler product:" + wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock);
                                  break;

                              }
                              else if(wp.id != p_id){
                                 System.out.println("Method 3");
                                 Product p1 = new Product(iid.id, iid.name, iid.price, 0, w_id);
                                 wholesaler_details.get(w_index).wholesaler_product_list.add(p1);
                                 iid.stock = iid.stock - w_item;
                                 System.out.println("Stock left for the entered product:" + iid.stock);


                                 w_product_index = wholesaler_details.get(w_index).wholesaler_product_list.indexOf(wp);
                                 System.out.println(w_product_index);


                                 wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock += w_item;
                                 System.out.println("Stock added to wholesaler product:" + wholesaler_details.get(w_index).wholesaler_product_list.get(w_product_index).stock);
                                 break;

                             }
                          }
                      }

                  }
              }
          }
      }
  }*/

    static void allocateRetailer(int r_id,int w_id,int p_id,int w_item)
    {
        for(Retailer r: retailer_details)
        {
            if(r.retailer_id == r_id)
            {
                int r_index = retailer_details.indexOf(r);
                for(Wholesaler w: wholesaler_details){
                    if (w.wholesaler_id == w_id) {
                        int w_index = wholesaler_details.indexOf(w);
                        int r_product_index=0;
                        //int w_product_index = -1;
                        for (Product iid : products) {
                            int p_index = products.indexOf(iid);
                          //  int wh_id=wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).id;
                          //  int wh_stock = wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).stock;
                           // System.out.println(wh_id);
                          //  System.out.println();
                            if (iid.id == p_id && iid.stock>= w_item){
                                Product p = new Product(iid.id, iid.name, iid.price, 0, iid.w_id);
                                retailer_details.get(r_index).retailer_product_list.add(p);

                                wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).stock -= w_item;
                                System.out.println("Stock left for the entered product:" +wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).stock  );


                            for (Product rp : Retailer.retailer_product_list) {
                                r_product_index = retailer_details.get(r_index).retailer_product_list.indexOf(rp);
                                System.out.println(r_product_index);
                                }
                                retailer_details.get(r_index).retailer_product_list.get(r_product_index).stock += w_item;
                                System.out.println("Stock" + retailer_details.get(r_index).retailer_product_list.get(r_product_index).stock);

                            }
                        }
                    }
                }
            }
        }
    }
    static void displayProduct(int nameProduct)
    {
        for (Product itr : products) {
            //System.out.println(itr.stock);

            if (itr.id ==nameProduct) {
                System.out.println(itr.stock);
                break;
            }
           /* else{
                System.out.println("Product is not in stock");
            }*/
        }
    }
    static void displayWholesaler(int nameW) {
        for (Wholesaler itr : wholesaler_details) {
            int w_index = wholesaler_details.indexOf(itr);
            int p_index = -1;
            for (Product i : Wholesaler.wholesaler_product_list)
            {
                p_index = wholesaler_details.get(w_index).wholesaler_product_list.indexOf(i);
                if(wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).id == nameW){
                    System.out.println(itr.getWholesaler_id()+" "+itr.getWholesaler_name()+" "+wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).id+" "+
                            wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).name+" "+wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).price
                    +" "+wholesaler_details.get(w_index).wholesaler_product_list.get(p_index).stock);

            }
        }
        System.out.println();

        }
    }
    static void displayRetailer(int nameR) {
        for (Retailer itr : retailer_details) {
            int r_index = retailer_details.indexOf(itr);
            int p_index = -1;
            for (Product i : Retailer.retailer_product_list)
            {
                p_index = retailer_details.get(r_index).retailer_product_list.indexOf(i);
                if(retailer_details.get(r_index).retailer_product_list.get(p_index).id == nameR){
                    System.out.println(itr.getRetailer_id()+" "+itr.getRetailer_name()+" "+retailer_details.get(r_index).retailer_product_list.get(p_index).id+" "+
                            retailer_details.get(r_index).retailer_product_list.get(p_index).name+" "+retailer_details.get(r_index).retailer_product_list.get(p_index).price
                            +" "+retailer_details.get(r_index).retailer_product_list.get(p_index).stock);

                }
            }
            System.out.println();

        }
    }
               // int indexId = Warehouse.p_wholesaler.indexOf(itr);

                //  System.out.println(Warehouse.p_wholesaler.get(indexId).);
                //  Warehouse.p_wholesaler.get(indexId).nameW

            //  System.out.println(itr.get(0).stock);

            //int indexId = values.indexOf(itr);
            // values.get(indexId).name = name;
            //System.out.println(indexId);


        }
       /* for (Wholesaler w : wholesaler_products) {
            System.out.println(w.name);
            if (w.name.equals(w_name)) {
                for (Product pw : products) {
                    if (pw.id == p_id) {
                        int indexId = products.indexOf(pw);
                        //products.get(indexId).id = id;
                        System.out.println(indexId);
                        Warehouse.p_wholesaler.add(indexId, pw.id);
                        Warehouse.p_wholesaler.add(indexId, pw.name);
                        Warehouse.p_wholesaler.add(indexId, pw.price);
                        pw.stock = String.valueOf(Integer.parseInt(pw.stock) + w_stock);
                        Warehouse.p_wholesaler.add(indexId, pw.stock);
                        System.out.println(pw.stock);
                    }


                }
            }
        }
    }
*/











  /*  static void displayWholesaler(String nameW) {
        for (String itr : Warehouse.p_wholesaler) {
            //System.out.println(itr.stock);

            if (itr.equals(nameW)) {
                int indexId = Warehouse.p_wholesaler.indexOf(itr);
                break;
                //  System.out.println(Warehouse.p_wholesaler.get(indexId).);
                //  Warehouse.p_wholesaler.get(indexId).nameW
            }
            //  System.out.println(itr.get(0).stock);

            //int indexId = values.indexOf(itr);
            // values.get(indexId).name = name;
            //System.out.println(indexId);

            else {
                System.out.println("Enter the correct product");
            }
        }
    }
}




           /* for (Wholesaler p: wholesaler_products) {
                System.out.println(p.wholeSaler_name);
            }

            for (Product p: products ){
                System.out.println(p.id);
                System.out.println(p_id);
                if(p.id=="id")
                {
                    continue;
                }
                else if (p.id.equals(p_id)) {
                    System.out.println(p.id);
                    int indexId = products.indexOf(p);
                    //Integer.parseInt(stock);
                    products.get(indexId).stock = String.valueOf(Integer.parseInt(stock) - w_stock);
                    System.out.println(stock);
                }
            }*/
// wholesaler_products.add()



  /*  static int[] w_stock={0,0,0,0,0};
    public void items(){
//        System.out.println("Available Products");
//        for(int i=0;i<pro_name.length;i++){
//            System.out.println(i+" "+pro_name[i] +" Count "+stock[i]);
//        }
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int cou = inp.nextInt();
        if(cou>stock[num]){
            System.out.println("Stock not exist");
        }
        else{
            System.out.println("You have to pay Rs."+price[num]);
            stock[num]-=cou;
            w_stock[num]+=cou;
        }
    }
    public void availpro(){
        System.out.println("Wholesaler Available Products\n");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
        }*/
//}



