package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.JiesuanDao;
import com.entity.JiesuanEntity;
import com.service.JiesuanService;
import com.entity.view.JiesuanView;

/**
 * 结算 服务实现类
 */
@Service("jiesuanService")
@Transactional
public class JiesuanServiceImpl extends ServiceImpl<JiesuanDao, JiesuanEntity> implements JiesuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<JiesuanView> page =new Query<JiesuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
