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


import com.dao.ZaixiankechengDao;
import com.entity.ZaixiankechengEntity;
import com.service.ZaixiankechengService;
import com.entity.vo.ZaixiankechengVO;
import com.entity.view.ZaixiankechengView;

@Service("zaixiankechengService")
public class ZaixiankechengServiceImpl extends ServiceImpl<ZaixiankechengDao, ZaixiankechengEntity> implements ZaixiankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixiankechengEntity> page = this.selectPage(
                new Query<ZaixiankechengEntity>(params).getPage(),
                new EntityWrapper<ZaixiankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixiankechengEntity> wrapper) {
		  Page<ZaixiankechengView> page =new Query<ZaixiankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixiankechengVO> selectListVO(Wrapper<ZaixiankechengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixiankechengVO selectVO(Wrapper<ZaixiankechengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixiankechengView> selectListView(Wrapper<ZaixiankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixiankechengView selectView(Wrapper<ZaixiankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
