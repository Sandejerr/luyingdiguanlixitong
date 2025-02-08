package com.dao;

import com.entity.JiesuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiesuanView;

/**
 * 结算 Dao 接口
 *
 * @author 
 */
public interface JiesuanDao extends BaseMapper<JiesuanEntity> {

   List<JiesuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
