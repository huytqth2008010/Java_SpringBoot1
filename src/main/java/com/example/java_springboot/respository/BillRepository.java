package com.example.java_springboot.respository;

import com.example.java_springboot.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    void deleteById(Bill id);
}
