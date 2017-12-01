package org.smart4j.chapter1.controller;

import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

import java.util.List;

/**
 * Created by Xul on 2017/11/28.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action(value = "get:/create_customer")
    public View gotoPage(Param param){
        View view = new View("hello.jsp");
        List<Customer> customerList = customerService.getCustomerList();
        view.addModel("list",customerList);
        view.addModel("name",param.getString("name"));
        return view;
    }
    @Action(value = "get:/update_customer")
    public Data updateUser(Param param){
    	Customer customer = new Customer();
    	Integer updateCusomer = customerService.updateCusomer(customer);
    	Data data = new Data(updateCusomer);
    	return data;
    }
}
