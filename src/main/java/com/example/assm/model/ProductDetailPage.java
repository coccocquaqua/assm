package com.example.assm.model;

import java.util.List;

public class ProductDetailPage extends ProductDetail {
    private List<ProductDetail> products;
    private int currentPage;
    private int totalPages;

    public ProductDetailPage() {
    }

    public ProductDetailPage(List<ProductDetail> products, int currentPage, int totalPages) {
        this.products = products;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<ProductDetail> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetail> products) {
        this.products = products;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
