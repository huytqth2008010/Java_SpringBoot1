package com.example.java_springboot.service;

import com.example.java_springboot.entity.Bill;
import com.example.java_springboot.respository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Page<Bill> findAll(int page, int limit) {
        return billRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Optional<Bill> findById(Integer id) {
        return billRepository.findById(id);
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public void deleteById(Bill id) {
        billRepository.deleteById(id);
    }
}
