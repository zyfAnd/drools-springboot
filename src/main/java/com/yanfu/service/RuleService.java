package com.yanfu.service;

import com.yanfu.dao.RuleDao;
import com.yanfu.model.Person;
import com.yanfu.model.Rules;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/20.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@Service
public class RuleService {

    @Autowired
    RuleDao ruleDao;

    Logger logger = Logger.getLogger("Rules");
    /**
     *
     * @param id rule id
     * @param person 对象
     * @return 结果对象
     */
    public Person getRulesWrite(Integer id, Person person){
        String rules = "";
        Rules ru = ruleDao.getById(id);
        if (ru!=null&&ru.getRule()!=null){
            rules = ru.getRule();
            logger.info(rules);

        }
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kieBase = kieContainer.getKieBase();
        KieSession ksession = kieBase.newKieSession();
        ksession.insert(person);
        ksession.fireAllRules();
        logger.info("end");
        return person;
    }
}
