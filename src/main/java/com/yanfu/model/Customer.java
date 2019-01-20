package com.yanfu.model;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/13.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class Customer {
    private String name;
    private String gender;
    private int income;
    private String IDNo;
    private boolean incomeInvalid;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isIncomeInvalid() {
        return incomeInvalid;
    }

    public void setIncomeInvalid(boolean incomeInvalid) {
        this.incomeInvalid = incomeInvalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }
}
