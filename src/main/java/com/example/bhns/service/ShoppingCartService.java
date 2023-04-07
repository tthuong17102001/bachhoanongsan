package com.example.bhns.service;

import com.example.bhns.entity.CartItem;
import com.example.bhns.entity.Product;

import java.util.Collection;

public interface ShoppingCartService {
    int getCount();
    double getAmount();
    void clear();
    Collection<CartItem> getCartItems();
    void remove(CartItem item);
    void add(CartItem item);
    void remove(Product product);
}
