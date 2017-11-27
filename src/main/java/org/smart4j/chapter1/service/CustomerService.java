package org.smart4j.chapter1.service;

import org.smart4j.chapter1.help.DataBaseHelper;
import org.smart4j.chapter1.model.Customer;

import java.util.List;

/**
 * Created by mysteel-xl on 2017/11/13.
 */
public class CustomerService {

    public List<Customer> getCustomerList() {
        List<Customer> customerList ;
        String sql = "select * from customer";
        customerList = DataBaseHelper.queryEntityList(Customer.class, sql);
        return customerList;
    }
    public Customer getCusomer(Long id) {
        return null;
    }
    public Boolean createCusomer(Customer customer){
        return null;
    }
    public Boolean updateCusomer(Customer customer){
        return null;
    }

}
