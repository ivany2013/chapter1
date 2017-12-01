package org.smart4j.chapter1.service;

import org.smart4j.chapter1.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.proxy.TransactionProxy;

import java.util.List;

/**
 * Created by mysteel-xl on 2017/11/13.
 */
@Service
public class CustomerService{
	
    public List<Customer> getCustomerList() {
        List<Customer> customerList ;
        String sql = "select * from customer";
        customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
        return customerList;
    }
    public Customer getCusomer(Long id) {
        return null;
    }
    public Boolean createCusomer(Customer customer){
        return null;
    }
    
    @Transaction
    public Integer updateCusomer(Customer customer){
    	String sql = "update customer set name = '3' ";
    	int exUpdate = DatabaseHelper.exUpdate(sql, null);
//    	int i = 1/0;
        return exUpdate;
    }

}
