/**
 * 
 */
package cn.itcast.controller;

import cn.itcast.model.BaseDict;
import cn.itcast.model.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.DictService;
import cn.itcast.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="/appLogin")
	public String appLogin(){

		return "ok";
	}
	
}
