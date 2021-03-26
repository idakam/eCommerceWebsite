package com.ecommerce.ecommerceProject.controller;

import com.ecommerce.ecommerceProject.model.Product;
import com.ecommerce.ecommerceProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public String show(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        System.out.println(product);
        model.addAttribute(product);
        return "product";
    }


    // TODO: Either implement admin controls or remove these methods.

    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public String createOrUpdate(@Valid Product product) {
        productService.save(product);
        return "redirect:/product/" + product.getId();
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product newProduct = new Product();
        model.addAttribute("product", newProduct);
        return "addProduct";
    }

}
