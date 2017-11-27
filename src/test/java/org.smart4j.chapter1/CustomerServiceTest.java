package org.smart4j.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;

import java.util.List;

/**
 * Created by mysteel-xl on 2017/11/13.
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        //TODO
    }
    @Test
    public void getCustomerListTest(){
        List<Customer> customerList = customerService.getCustomerList();
        System.out.println(customerList.size());
    }
}
