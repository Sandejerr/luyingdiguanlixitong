package com.dao;

import com.entity.JiedaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiedaiView;

/**
 * 接待 Dao 接口
 *
 * @author 
 */
public interface JiedaiDao extends BaseMapper<JiedaiEntity> {

   List<JiedaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
