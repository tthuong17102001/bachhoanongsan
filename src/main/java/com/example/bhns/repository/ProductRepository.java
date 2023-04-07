package com.example.bhns.repository;

import com.example.bhns.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from products where category_id=?",nativeQuery = true)
    public List<Product> listProductByCategory(Long categoryId);
    @Query(value = "select * from products as b where b.category_id = ?;",nativeQuery = true)
    List<Product> listProductByCategory10(Long categoryId);
    //20 ban ghi moi nhat
    @Query(value = "select * from products order by entered_date desc limit 20;",nativeQuery = true)
    public List<Product> listProductNew20();
    @Query(value = "select * from products where product_name like %?1%",nativeQuery = true)
    public List<Product> searchProduct(String productName);
    @Query(value = "select c.category_id,c.category_name,count(*) as SoLuong from products p join categories c on p.category_id = c.category_id group by c.category_id;",nativeQuery = true)
    List<Object[]> listCategoryByProductName();
    @Query(value = "select p.product_id,count(*) as SoLuong from order_details p join products c on p.product_id = c.product_id group by p.product_id order by SoLuong desc limit 20;",nativeQuery = true)
    public List<Object[]> bestSaleProduct20();
    @Query(value = "select * from products o where product_id in :ids",nativeQuery = true)//in: nam trong, ids la 1 danh sach integer
    List<Product> findByInventoryIds(@Param("ids") List<Integer> listProductId);
}
