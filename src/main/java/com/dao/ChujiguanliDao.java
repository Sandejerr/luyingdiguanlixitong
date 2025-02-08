package com.dao;

import com.entity.ChujiguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChujiguanliView;

/**
 * 初级管理 Dao 接口
 *
 * @author 
 */
public interface ChujiguanliDao extends BaseMapper<ChujiguanliEntity> {

   List<ChujiguanliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
