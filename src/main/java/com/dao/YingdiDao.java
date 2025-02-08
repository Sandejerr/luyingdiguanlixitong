package com.dao;

import com.entity.YingdiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YingdiView;

/**
 * 营地 Dao 接口
 *
 * @author 
 */
public interface YingdiDao extends BaseMapper<YingdiEntity> {

   List<YingdiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
