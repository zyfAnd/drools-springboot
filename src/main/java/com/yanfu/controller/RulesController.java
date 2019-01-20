package com.yanfu.controller;

import com.google.gson.Gson;
import com.yanfu.model.Customer;
import com.yanfu.model.JsonResponse;
import com.yanfu.model.Person;
import com.yanfu.service.RuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/20.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@RequestMapping(value = "/values")
@RestController
public class RulesController {
    @Autowired
    private RuleService ruleService;

    @ApiOperation(value = "Person Rule Check")
    @RequestMapping(value = "/result", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResponse getResult(@RequestParam("id") Integer id, @RequestParam("json") String json) {
        Gson gson = new Gson();
        Person person = gson.fromJson(json, Person.class);
        return new JsonResponse(ruleService.getRulesWrite(id, person));
    }




}
