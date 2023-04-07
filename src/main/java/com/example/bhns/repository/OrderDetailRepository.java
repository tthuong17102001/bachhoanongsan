package com.example.bhns.repository;

import com.example.bhns.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "select * from order_details where order_id=?;",nativeQuery = true)
    List<OrderDetail> findByOrderId(Long id);
    //thong ke so luong sp da ban
    @Query(value = "select p.product_name,sum(o.quantity) as quantity,sum(o.quantity * o.price) as sum,avg(o.price) as avg,min(o.price) as min,max(o.price) as max from order_details o inner join products p on o.product_id = p.product_id group by p.product_name;",nativeQuery = true)
    public List<Object[]> repo();
    @Query(value = "SELECT c.category_name,SUM(o.quantity) as quantity,SUM(o.quantity * o.price) as sum,AVG(o.price) as avg,Min(o.price) as min,max(o.price) as max FROM order_details o INNER JOIN products p ON o.product_id = p.product_id INNER JOIN categories c ON p.category_id = c.category_id GROUP BY c.category_name;", nativeQuery = true)
    public List<Object[]> repoWhereCategory();
    @Query(value = "Select YEAR(od.order_date) ,\r\n"
            + "SUM(o.quantity) as quantity ,\r\n"
            + "SUM(o.quantity * o.price) as sum,\r\n"
            + "AVG(o.price) as avg,\r\n"
            + "Min(o.price) as min,\r\n"
            + "max(o.price) as max \r\n"
            + "FROM order_details o\r\n"
            + "INNER JOIN orders od ON o.order_id = od.order_id\r\n"
            + "GROUP BY YEAR(od.order_date);", nativeQuery = true)
    public List<Object[]> repoWhereYear();
    @Query(value = "Select month(od.order_date) ,\r\n"
            + "SUM(o.quantity) as quantity ,\r\n"
            + "SUM(o.quantity * o.price) as sum,\r\n"
            + "AVG(o.price) as avg,\r\n"
            + "Min(o.price) as min,\r\n"
            + "max(o.price) as max\r\n"
            + "FROM order_details o\r\n"
            + "INNER JOIN orders od ON o.order_id = od.order_id\r\n"
            + "GROUP BY month(od.order_date);", nativeQuery = true)
    public List<Object[]> repoWhereMonth();
    @Query(value = "Select QUARTER(od.order_date),\r\n"
            + "SUM(o.quantity) as quantity ,\r\n"
            + "SUM(o.quantity * o.price) as sum,\r\n"
            + "AVG(o.price) as avg,\r\n"
            + "Min(o.price) as min,\r\n"
            + "max(o.price) as max\r\n"
            + "FROM order_details o\r\n"
            + "INNER JOIN orders od ON o.order_id = od.order_id\r\n"
            + "GROUP By QUARTER(od.order_date);", nativeQuery = true)
    public List<Object[]> repoWhereQUARTER();
    @Query(value = "SELECT c.user_id,\r\n"
            + "SUM(o.quantity) as quantity,\r\n"
            + "SUM(o.quantity * o.price) as sum,\r\n"
            + "AVG(o.price) as avg,\r\n"
            + "Min(o.price) as min,\r\n"
            + "max(o.price) as max\r\n"
            + "FROM order_details o\r\n"
            + "INNER JOIN orders p ON o.order_id = p.order_id\r\n"
            + "INNER JOIN user c ON p.user_id = c.user_id\r\n"
            + "GROUP BY c.user_id;", nativeQuery = true)
    public List<Object[]> reportCustommer(); // nguoi dung dat hang
}
