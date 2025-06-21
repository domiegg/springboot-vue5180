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


import com.dao.DiscusszaixiankechengDao;
import com.entity.DiscusszaixiankechengEntity;
import com.service.DiscusszaixiankechengService;
import com.entity.vo.DiscusszaixiankechengVO;
import com.entity.view.DiscusszaixiankechengView;

@Service("discusszaixiankechengService")
public class DiscusszaixiankechengServiceImpl extends ServiceImpl<DiscusszaixiankechengDao, DiscusszaixiankechengEntity> implements DiscusszaixiankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszaixiankechengEntity> page = this.selectPage(
                new Query<DiscusszaixiankechengEntity>(params).getPage(),
                new EntityWrapper<DiscusszaixiankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszaixiankechengEntity> wrapper) {
		  Page<DiscusszaixiankechengView> page =new Query<DiscusszaixiankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszaixiankechengVO> selectListVO(Wrapper<DiscusszaixiankechengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszaixiankechengVO selectVO(Wrapper<DiscusszaixiankechengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszaixiankechengView> selectListView(Wrapper<DiscusszaixiankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszaixiankechengView selectView(Wrapper<DiscusszaixiankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
