/**
 * 
 */
package cn.itcast.service;

import java.util.List;
import java.util.Map;

import cn.itcast.model.Customer;
import cn.itcast.util.Page;

/**
 * @author:沈坤林
 * @datetime: 2017年10月31日 上午11:18:31
 * @path:cn.itcast.service.CustomerService.java
 * @description:
 */
public interface CustomerService {

	/**
	 * @param dataMap
	 * @return
	 */
	//List<Customer> getCustomerByMap(Map<String, Object> dataMap);
	Page<Customer> getCustomerByMap(Map<String, Object> dataMap);

	/**
	 * @param id
	 * @return
	 */
	Customer getById(Long id);

	/**
	 * @param customer
	 * @return
	 */
	int updateCustomer(Customer customer);

	/**
	 * @param id
	 * @return
	 */
	int deleteById(Long id);

}
