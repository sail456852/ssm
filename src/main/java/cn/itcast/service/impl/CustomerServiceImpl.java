/**
 * 
 */
package cn.itcast.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.CustomerMapper;
import cn.itcast.model.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.util.Page;

/**
 * @author:沈坤林
 * @datetime: 2017年10月31日 上午11:18:38
 * @path:cn.itcast.service.impl.CustomerServiceImpl.java
 * @description:
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	/* (non-Javadoc)
	 * @see cn.itcast.service.CustomerService#getCustomerByMap(java.util.Map)
	 */
	/*@Override
	public List<Customer> getCustomerByMap(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerByMap(dataMap);
	}*/
	
	@Override
	public Page<Customer> getCustomerByMap(Map<String, Object> dataMap) {
		//分页信息   当前页
		Integer currentpage = Integer.parseInt(dataMap.get("currenpage").toString());
		
		//每页显示10条
		Integer size = 10;
		
		//1、先查询总记录数
		Long total = customerMapper.getCustomerCountByMap(dataMap);
		
		//第一个参数：总记录数
		//第二个参数：当前页
		//第三个：每页显示多少条
		Page<Customer> page = new Page<Customer>(total, currentpage, size);
		
		//2、查询集合信息     select * from table limit #{start},#{size}
		int start = (currentpage-1)*size;
		dataMap.put("start", start);
		dataMap.put("size", size);
		List<Customer> customers = customerMapper.getCustomerByMap(dataMap);
		
		page.setList(customers);
		return page;
	}

	/* (non-Javadoc)
	 * @see cn.itcast.service.CustomerService#getById(java.lang.Long)
	 */
	@Override
	public Customer getById(Long id) {
		return customerMapper.getById(id);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.service.CustomerService#updateCustomer(cn.itcast.model.Customer)
	 */
	@Override
	public int updateCustomer(Customer customer) {
		//customerMapper修改数据  --- <set>
		return customerMapper.updateCustomer(customer);
	}

	/* (non-Javadoc)
	 * @see cn.itcast.service.CustomerService#deleteById(java.lang.Long)
	 */
	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteById(id);
	}

}
