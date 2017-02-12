package com.example.piotrekj.shopppingproject;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Storage
{

    // ---------------Singleton pattern---------------
    /**
     * Singleton pattern - It is used when you want to eliminate the option of instantiating more than one object !!! We can use in STORAGE, SERVICE
     */

    private static Storage instance = new Storage();

    Storage() {
        //
    }

    public static Storage getInstance() {
        return instance;
    }

    // -------------------------------------------------


    private List<Shop> shops = new ArrayList<Shop>();
    private List<Product> products = new ArrayList<>();
    private List <Product> bilkaProducts = new ArrayList<>();
    private List <Product> fotexProducts = new ArrayList<>();
    private List <Product> nettoProducts = new ArrayList<>();
    private List <Product> remaProducts = new ArrayList<>();
    private List <Product> kvicklyProducts = new ArrayList<>();
    private List <Product> kiwiProducts = new ArrayList<>();

    private List <Product> shoppingBasket = new ArrayList<>();


    // ----------------- SHOP------------------------

    public List<Shop> getShops() {
        return shops;
    }

    public void setShop(Shop shop) {
        shops.add(shop);
    }

    // --------------- BILKA --------------------------

    public List<Product> getBilkaProducts() {

        return bilkaProducts;
    }

    public void addBilkaProduct(Product bilkaProduct) {

        bilkaProducts.add(bilkaProduct);
    }

    public void removeBilkaProduct(Product bilkaProduct) {

        bilkaProducts.remove(bilkaProduct);
    }

    // ----------------- FOTEX ------------------------

    public List<Product> getFotexProducts() {
            return fotexProducts;
        }

    public void setFotexProduct(Product fotexProduct) {
        fotexProducts.add(fotexProduct);
    }

    public void removeFotexProduct(Product fotexProduct) {
        fotexProducts.remove(fotexProduct);
    }

    // ----------------- NETTO ------------------------

    public List<Product> getNettoProducts() {
        return nettoProducts;
    }

    public void setNettoProduct(Product nettoProduct) {
        nettoProducts.add(nettoProduct);
    }

    public void removeNettoProduct(Product nettoProduct) {
        nettoProducts.remove(nettoProduct);
    }

    // ----------------- REMA 1000------------------------

    public List<Product> getRemaProducts() {
        return remaProducts;
    }

    public void setRemaProduct(Product remaProduct) {
        remaProducts.add(remaProduct);
    }

    public void RemoveRemaProduct(Product remaProduct) {
        remaProducts.remove(remaProduct);
    }

    // ------------------ KVICKLY -----------------------

    public List<Product> getKvicklyProducts() {
        return kvicklyProducts;
    }


    public void setKvicklyProduct(Product kvicklyProduct) {
        kvicklyProducts.add(kvicklyProduct);
    }

    public void removeKvicklyProduct(Product kvicklyProduct) {
    kvicklyProducts.remove(kvicklyProduct);
}

    // ------------------ KIWI -----------------------

    public List<Product> getKiwiProducts() {
        return kiwiProducts;
    }

    public void setKiwiProduct(Product kiwiProduct) {
        kiwiProducts.add(kiwiProduct);
    }

    public void removeKiwiProduct(Product kiwiProduct) {
        kiwiProducts.remove(kiwiProduct);
    }


    // ------------------ShoppingBasket---------------


    public List<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    public void addToBasket(Product item) {
        shoppingBasket.add(item);
    }

    public void removeShoppingBasket(Product Basket) {
        shoppingBasket.remove(Basket);
    }

    public void clear(){
        shoppingBasket.clear();


    }


    // -------------------------------------------
}
