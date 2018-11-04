/**
 * 
 */
package cn.itcast.service;

import java.util.List;

import cn.itcast.model.BaseDict;

/**
 * @author:沈坤林
 * @datetime: 2017年10月31日 上午11:04:34
 * @path:cn.itcast.service.DictService.java
 * @description:
 */
public interface DictService {

	/**
	 * @param string
	 * @return
	 */
	List<BaseDict> getByTypeCode(String string);

}
