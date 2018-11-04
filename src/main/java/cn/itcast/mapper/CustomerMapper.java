/**
 * 
 */
package cn.itcast.mapper;

import java.util.List;
import java.util.Map;

import cn.itcast.model.Customer;

public interface CustomerMapper {

	/**
	 * @param dataMap
	 * @return
	 */
	List<Customer> getCustomerByMap(Map<String, Object> dataMap);

	/**
	 * @param dataMap
	 * @return
	 */
	Long getCustomerCountByMap(Map<String, Object> dataMap);

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
