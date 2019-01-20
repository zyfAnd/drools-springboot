package com.yanfu.service;

import com.yanfu.model.Product;
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
public class ShopService {
    private final KieContainer kieContainer;

    public ShopService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
    public Product getProd(Product product){
        KieSession kieSession  = kieContainer.newKieSession("rulesSession");
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        return product;

    }
}
