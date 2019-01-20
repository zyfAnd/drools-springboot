package com.yanfu.controller;

import com.google.gson.Gson;
import com.yanfu.model.Customer;
import com.yanfu.model.Product;
import com.yanfu.service.CustomerService;
import com.yanfu.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/13.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@RestController
@Api(tags = "接口")
public class DroolsController {
    @Autowired
    ShopService shopService;
    @Autowired
    CustomerService customerService;
    @ApiOperation(value = "测试")
    @RequestMapping(value = "/prod",method = RequestMethod.GET)
    public Product index(@RequestParam String type){
        Product product  = new Product();
        product.setType(type);
        shopService.getProd(product);

        return product;
    }
    @ApiOperation(value = "检验用户的收入")
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public Customer verifyIncome(@RequestBody Customer customer){
        System.out.print(customer.toString());
//        Gson gson = new Gson();
//        Customer customer = gson.fromJson(json,Customer.class);
        Customer cus = customerService.verifyCustomer(customer);
        return cus;
    }
}
