/**
 * 
 */
package cn.itcast.mapper;

import java.util.List;

import cn.itcast.model.BaseDict;

public interface DictMapper {

	/**
	 * @param string
	 * @return
	 */
	List<BaseDict> getByTypeCode(String string);

}
