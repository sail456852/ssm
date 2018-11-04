/**
 * 
 */
package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.DictMapper;
import cn.itcast.model.BaseDict;
import cn.itcast.service.DictService;

@Service
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictMapper dictMapper;
	

	@Override
	public List<BaseDict> getByTypeCode(String string) {
		return dictMapper.getByTypeCode(string);
	}
	
	

}
