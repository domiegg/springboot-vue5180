package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhishiyaodianDao;
import com.entity.ZhishiyaodianEntity;
import com.service.ZhishiyaodianService;
import com.entity.vo.ZhishiyaodianVO;
import com.entity.view.ZhishiyaodianView;

@Service("zhishiyaodianService")
public class ZhishiyaodianServiceImpl extends ServiceImpl<ZhishiyaodianDao, ZhishiyaodianEntity> implements ZhishiyaodianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhishiyaodianEntity> page = this.selectPage(
                new Query<ZhishiyaodianEntity>(params).getPage(),
                new EntityWrapper<ZhishiyaodianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhishiyaodianEntity> wrapper) {
		  Page<ZhishiyaodianView> page =new Query<ZhishiyaodianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhishiyaodianVO> selectListVO(Wrapper<ZhishiyaodianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhishiyaodianVO selectVO(Wrapper<ZhishiyaodianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhishiyaodianView> selectListView(Wrapper<ZhishiyaodianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhishiyaodianView selectView(Wrapper<ZhishiyaodianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
