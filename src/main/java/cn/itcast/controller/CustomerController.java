/**
 * 
 */
package cn.itcast.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.model.BaseDict;
import cn.itcast.model.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.DictService;
import cn.itcast.util.Page;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private CustomerService customerService;
	
	
	/***
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public String delete(@RequestParam(value="id")Long id){
		int dcount = customerService.deleteById(id);
		return "ok";
	}
	
	/***
	 * 根据ID修改数据
	 * /customer/update.shtml
	 * post
	 */
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Map<String, Object> update(Customer customer){
		int mcount = customerService.updateCustomer(customer);
		
		Map<String, Object> datamap = new HashMap<String,Object>();
		datamap.put("status", 200);
		return datamap;
	}
	
	
	
	/****
	 * 根据用户ID查询用户信息
	 * data:{"id":id},
	 * /customer/edit.shtml
	 * type:"get",
	 * dataType:'json',---Customer
	 */
	//@RequestMapping(value="/edit",method=RequestMethod.GET)
	//@ResponseBody
	@GetMapping(value="/edit")
	public ResponseEntity<Customer> edit(@RequestParam(value="id")Long id){
		//根据ID查询
		Customer customer = customerService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	
	
	
	/****
	 * SpringMVC
	 * @return
	 * @throws IOException 
	 * 1、接收条件实现条件查询
	 */
	@RequestMapping(value="/list")
	public String list(@RequestParam(value="custName",required=false,defaultValue="")String custName,
						@RequestParam(value="custSource",required=false)String custSource,
						@RequestParam(value="custIndustry",required=false)String custIndustry,
						@RequestParam(value="custLevel",required=false)String custLevel,
						@RequestParam(value="currenpage",required=false,defaultValue="1")Integer currenpage,Model model) throws Exception{
		//查询出对应的条件
		//1、客户来源  dict_type_code=002 
		List<BaseDict> fromType = dictService.getByTypeCode("002");
		
		//2、行业类别 dict_type_code='001'
		List<BaseDict> industryType = dictService.getByTypeCode("001");
		
		//3、级别 dict_type_code='006'
		List<BaseDict> levelType = dictService.getByTypeCode("006");
		
		
		//4、查询--->封装POJO|Map
		 Map<String,Object> dataMap = new HashMap<String,Object>();
	     dataMap.put("custName",custName);
	     dataMap.put("custSource",custSource);
	     dataMap.put("custIndustry",custIndustry);
	     dataMap.put("custLevel",custLevel);
	     dataMap.put("currenpage",currenpage);	//分页信息
	     
	     
	    //根据条件查询客户信息
	    //List<Customer> customers = customerService.getCustomerByMap(dataMap);
	     
	    //分页查询信息
	    Page<Customer> page = customerService.getCustomerByMap(dataMap);

	    model.addAttribute("page", page);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//存储条件进行回显
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "list";
	}

}
