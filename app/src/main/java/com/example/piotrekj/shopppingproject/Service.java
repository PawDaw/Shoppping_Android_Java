package com.example.piotrekj.shopppingproject;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Service {

    private boolean InitUsed = false;

    ArrayList<Product> fileproducts = new ArrayList<Product>();

    public ArrayList<Product> getFileproducts() {
        return fileproducts;
    }

    public void setFileproducts(ArrayList<Product> fileproducts) {
        this.fileproducts = fileproducts;
    }

    public Context productListActivity = null;

    public ProductListActivity  productList;


    // ---------------Singleton pattern--------------------------
    /**
     * Singleton pattern - It is used when you want to eliminate the option of instantiating more than one object !!! We can use in STORAGE, SERVICE
     */

    private static Service instance = new Service();

    Service() {
        //
    }

    public static Service getInstance() {
        return instance;
    }

    // ------------------------------------------------------------

    // -------------  Shop functionality  ------------------------

    public Shop createShop(String title, String description, int id) {
        Shop s = new Shop(title, description, id);
        Storage.getInstance().setShop(s);
        return s;
    }

    // ------------------------------------------------------------

    // -------------  BILKA functionality  ------------------------


    public List<Product> getBilkaProducts() {

        return Storage.getInstance().getBilkaProducts();
    }

    public Product createBilkaProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().addBilkaProduct(pr);
        return pr;
    }

    public Product removeBilkaProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().removeBilkaProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- FOTEX functionality ------------------------


    public List<Product> getFotexProducts() {

        return Storage.getInstance().getFotexProducts();
    }

    public Product createFotexProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().setFotexProduct(pr);
        return pr;
    }

    public Product removeFotexProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().removeFotexProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- NETTO functionality -------------------------

    public List<Product> getNettoProducts() {

        return Storage.getInstance().getNettoProducts();
    }


    public Product createNettoProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().setNettoProduct(pr);
        return pr;
    }

    public Product removeNettoProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().removeNettoProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- REMA 1000 functionality -------------------------

    public List<Product> getRemaProducts() {

        return Storage.getInstance().getRemaProducts();
    }

    public Product createRemaProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().setRemaProduct(pr);
        return pr;
    }

    public Product removeRemaProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().RemoveRemaProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- KVICKLY functionality -------------------------

    public List<Product> getKvicklyProducts() {

        return Storage.getInstance().getKvicklyProducts();
    }

    public Product createKvicklyProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().setKvicklyProduct(pr);
        return pr;
    }

    public Product removeKvicklyProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().removeKvicklyProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- KIWI functionality -------------------------

    public List<Product> getKiwiProducts() {

        return Storage.getInstance().getKiwiProducts();
    }

    public Product createKiwiProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().setKiwiProduct(pr);
        return pr;
    }

    public Product removeKiwiProduct(String name, String unit, int price, int shopsPrice, int id) {
        Product pr = new Product(name, unit, price, shopsPrice, id);
        Storage.getInstance().removeKiwiProduct(pr);
        return pr;
    }

    // -------------- ShoppingBasket -------------------------

    public List<Product> getShoppingBasket() {
        return Storage.getInstance().getShoppingBasket();
    }

    public void clearBasket() {

        Storage.getInstance().clear();
    }

    // -------------- Clear counter from produckt items -------------------------

    public void clearCounter() {


        for (Product i : Service.getInstance().getFotexProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getBilkaProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getNettoProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getKiwiProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getKvicklyProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getRemaProducts()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        ;
    }


    // -------------- create Basket With Items -------------------------

    public void createBasketWithItems() {



        Storage.getInstance().clear();


        for (Product i : Service.getInstance().getFileproducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);
            }
        }


        for (Product i : Service.getInstance().getFotexProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getBilkaProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getNettoProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getKiwiProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getKvicklyProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getRemaProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;
    }

    // ----------  TOTAL Amount from basket ------------

    public double totalAmountFromBasket() {

        double total = 0;

        for (Product i : Service.getInstance().getShoppingBasket()) {
            total = (i.getShopsPrice() * i.getCounter()) + total;
        }

        return total;
    }

    public double totalPriceForProduct(Product pr) {
        double total = 0;

        total = pr.getShopsPrice() * pr.getCounter();


        return total;
    }


    // -------------- Update Counter  -------------------------

    public void updateProductCounterIncrease(Product pr) {

        pr.setCounter(pr.getCounter() + 1);

    }

    public void updateProductCounterDecrease(Product pr) {

        if (pr.getCounter() > 0) {
            pr.setCounter((pr.getCounter() - 1));
        }

    }


    public int getCounter(Product pr) {

        return pr.getCounter();
    }

//    -----------  SAVE ----------------

    public static void saveData(Context context) {

         //  create file
//       " Windows = \ " " *nix or Mac = / " - separator
        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        if (!directory.exists()) {
//         mkdirs -    creates the directory named by this abstract pathname, including necessary and non-existent parent directories.
            directory.mkdirs();
        }

        String filename = "myfile.txt";

        try {

            FileOutputStream outputStream = new FileOutputStream(directory + File.separator + filename);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            out.writeObject(Service.getInstance().getShoppingBasket());
            out.close();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Toast.makeText(context, "Basket Saved: " + context.getFilesDir(), Toast.LENGTH_SHORT).show();
        System.out.println("Basket saved -----------------------------------------");

    }


// ------------ READ -----------------

    public void readFile(Context context) {

        String filename = "myfile.txt";

        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        try {

            FileInputStream inputStream = new FileInputStream(directory + File.separator + filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);

            fileproducts = (ArrayList<Product>) input.readObject();

            Toast.makeText(context, "Basked was read from last ++ Session ++ ", Toast.LENGTH_SHORT).show();

            input.close();
            inputStream.close();


        }
        catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

//    --------- Clear File -----------
    public void clearFile (Context context){

        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "myfile.txt";

        try {

            FileOutputStream outputStream = new FileOutputStream(directory + File.separator + filename);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            out.writeObject(Service.getInstance().getShoppingBasket());
            out.close();

            Toast.makeText(context, "Basked was Deleted", Toast.LENGTH_SHORT).show();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
// ------------ Retrieve data from last session -----------------



    public void retriveBasketFromLastSession() {


        for (Product i : Service.getInstance().getFileproducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);
            }
        }
    }


    // ----------------- Initializing the Storage in MainActivity ----------------

    public void initStorage() {

        if (InitUsed == false) {

            InitUsed = true;

            // ------------- List of shops ----------------------------------
            Service.getInstance().createShop("Bilka", "Opening hours: 08:00 - 22:00", R.drawable.bilka);
            Service.getInstance().createShop("Fotex", "Opening hours: 08:00 - 22:00", R.drawable.fotex);
            Service.getInstance().createShop("Netto", "Opening hours: 08:00 - 22:00", R.drawable.netto);
            Service.getInstance().createShop("Rema", "Opening hours: 08:00 - 22:00", R.drawable.rema);
            Service.getInstance().createShop("Kvickly", "Opening hours: 08:00 - 22:00", R.drawable.kvickly);
            Service.getInstance().createShop("Kiwi", "Opening hours: 08:00 - 22:00", R.drawable.kiwi);

            // ------------- BILKA produckts ----------------------------------
            Service.getInstance().createBilkaProduct("VAND_BILKA", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createBilkaProduct("MILK_BILKA", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createBilkaProduct("BREAD_BILKA", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createBilkaProduct("SOAP_BILKA", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createBilkaProduct("iPAD_BILKA", "st", 5000, 5000, R.drawable.ipad);

            // ------------- Fotex produckts ----------------------------------
            Service.getInstance().createFotexProduct("VAND_FOTEX", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createFotexProduct("MILK_FOTEX", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createFotexProduct("BREAD_FOTEX", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createFotexProduct("SOAP_FOTEX", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createFotexProduct("iPAD_FOTEX", "st", 5000, 5000, R.drawable.ipad);

            // ------------- NETTO produckts ----------------------------------
            Service.getInstance().createNettoProduct("VAND_Netto", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createNettoProduct("MILK_Netto", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createNettoProduct("BREAD_Netto", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createNettoProduct("SOAP_Netto", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createNettoProduct("iPAD_Netto", "st", 5000, 5000, R.drawable.ipad);

            // ------------- Rema produckts ----------------------------------
            Service.getInstance().createRemaProduct("VAND_REMA", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createRemaProduct("MILKA_REMA", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createRemaProduct("BREAD_REMA", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createRemaProduct("SOAP_REMA", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createRemaProduct("iPAD_REMA", "st", 5000, 5000, R.drawable.ipad);

            // ------------- Kvickly produckts ----------------------------------
            Service.getInstance().createKvicklyProduct("VAND_Kvickly", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createKvicklyProduct("MILK_Kvickly", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createKvicklyProduct("BREAD_Kvickly", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createKvicklyProduct("SOAP_Kvickly", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createKvicklyProduct("iPAD_Kvickly", "st", 5000, 5000, R.drawable.ipad);

            // ------------- Kiwi produckts ----------------------------------
            Service.getInstance().createKiwiProduct("VAND_Kiwi", "liter", 23, 10, R.drawable.water);
            Service.getInstance().createKiwiProduct("MILKA_Kiwi", "liter", 10, 8, R.drawable.milk);
            Service.getInstance().createKiwiProduct("BREAD_Kiwi", "st", 20, 20, R.drawable.bread);
            Service.getInstance().createKiwiProduct("SOAP_Kiwi", "liter", 45, 40, R.drawable.soap);
            Service.getInstance().createKiwiProduct("iPAD_Kiwi", "st", 5000, 5000, R.drawable.ipad);

//            JSON ARRAY


            JSONArray products_JSON = new JSONArray();

            JSONObject objectBilka = new JSONObject();
            try {
                objectBilka.put("Bilka", Service.getInstance().getBilkaProducts().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            products_JSON.put(objectBilka);


            JSONObject objectFotex = new JSONObject();
            try {
                objectFotex.put("Fotex", Service.getInstance().getFotexProducts().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            products_JSON.put(objectFotex);

//          print out the JSON ARRAY :-)

            System.out.println(products_JSON.toString());






        }

////    -----------  SAVE ----------------
//
//        public void saveData(Context context) throws IOException {
//
//            productListActivity = context;
//
////       create file
////        File file = new File(getFilesDir(),"file.txt");
//
//            String filename = "myfile.txt";
//            String string = Storage.getInstance().getShoppingBasket().toString();
////
//            FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//
//
//            Toast.makeText(context, "Basket Saved: " + context.getFilesDir(), Toast.LENGTH_SHORT).show();
//            System.out.println("Basket saved" );
//
//        }
//
//// ------------ READ -----------------
//
//        public void readFile() throws IOException, ClassNotFoundException {
//
//
//
//            System.err.println("Read FRom Basket !!!!!!!!!!  " );
//
//
//            FileInputStream inputStream = productListActivity.openFileInput("myfile.txt");
//            BufferedInputStream bis = new BufferedInputStream(inputStream);
//            StringBuffer b = new StringBuffer();
//
//            while (bis.available() != 0 ){
//                char c = (char) bis.read();
//                b.append(c);
//            }
////        Toast.makeText(productListActivity, "File reded :-) ", Toast.LENGTH_SHORT).show();
//            Toast.makeText(productListActivity, "File reded :-)"+ b.toString(), Toast.LENGTH_SHORT).show();
//
//            bis.close();
//            inputStream.close();
//
//
//
//        }
//
//
    }


}
