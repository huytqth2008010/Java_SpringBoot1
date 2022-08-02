package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Order;
import com.example.java_springboot.entity.Product;
import com.example.java_springboot.service.OrderService;
import com.example.java_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public Page<Product> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "1") int limit) {
        return productService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/get-all")
    public List<Product> getList() {
        return productService.getAll();
    }

//    @PostMapping
//    public ProductRequest save(@RequestBody ProductRequest product) {
////        productService.save(product);
//        return product;
//    }
//
    @RequestMapping(method = RequestMethod.POST, path = "/products")
    public Product save(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
    public Product getDetail(@PathVariable Integer id) {
        return productService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/products/{id}")
    public boolean delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/products/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product updateProduct) {
        Product existing = productService.findById(id).get();
        existing.setName(updateProduct.getName());
        existing.setImage(updateProduct.getImage());
        existing.setDescription(updateProduct.getDescription());
        existing.setUnit_price(updateProduct.getUnit_price());
        existing.setPromotion_price(updateProduct.getPromotion_price());
        existing.setStatus(updateProduct.getStatus());
        existing.setQty(updateProduct.getQty());
        existing.setCategory(updateProduct.getCategory());
        productService.save(existing);
        return updateProduct;
    }

    @RequestMapping(method = RequestMethod.GET, path = "add-order")
    public ResponseEntity<?> addProductToOrder(
            @RequestParam int orderId,
            @RequestParam int productId) {
        // check sự tồn tại cùa product
        Optional<Product> optionalProduct = productService.findById(productId) ;
        // check sự tồn tại của order
        Optional<Order> optionalOrder = orderService.findById(orderId) ;
        // trả về not found nếu một trong 2 trường hợp không tìm thấy
        if (!optionalProduct.isPresent() || !optionalOrder.isPresent()){
            return new ResponseEntity<>( "Not found", HttpStatus.NOT_FOUND) ;
        }
        boolean resutlt = productService.addProductToClass(optionalProduct.get(), optionalOrder.get());
        if (!resutlt) {
            return new ResponseEntity<>("Add product error!", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return new ResponseEntity<>( "Add product success!", HttpStatus.OK);
    }
}

