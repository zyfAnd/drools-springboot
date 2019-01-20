package com.yanfu.service;

import com.yanfu.model.Customer;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/13.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@Service
public class CustomerService {
    private final KieContainer kieContainer ;

    public CustomerService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
    public Customer verifyCustomer(Customer customer){
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(customer);
        kieSession.fireAllRules();
        kieSession.dispose();
        return customer;
    }
}
