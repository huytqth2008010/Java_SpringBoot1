package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Bill;
import com.example.java_springboot.entity.Category;
import com.example.java_springboot.entity.Reply;
import com.example.java_springboot.service.BillService;
import com.example.java_springboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class BillController {

    @Autowired
    BillService billService;


    @RequestMapping(method = RequestMethod.GET, path = "/bills")
    public List<Bill> getList() {
        return billService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/bills")
    public Bill save(@RequestBody Bill bill) {
        billService.save(bill);
        return bill;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bills/{id}")
    public Bill getDetail(@PathVariable Integer id) {
        return billService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/bills/{id}")
    public boolean delete(@PathVariable Bill id) {
        billService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/bills/{id}")
    public Bill update(@PathVariable Integer id, @RequestBody Bill billUpdate) {
        Bill existing = billService.findById(id).get();
        existing.setTotal(billUpdate.getTotal());
        existing.setPaid(billUpdate.getPaid());
        existing.setUnpaid(billUpdate.getUnpaid());
        existing.setPayment(billUpdate.getPayment());
        existing.setId_customer(billUpdate.getId_customer());
        existing.setId_account(billUpdate.getId_account());
        existing.setStatus(billUpdate.getStatus());
        billService.save(existing);
        return billUpdate;
    }

}

