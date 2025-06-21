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


import com.dao.TiwenjiedaDao;
import com.entity.TiwenjiedaEntity;
import com.service.TiwenjiedaService;
import com.entity.vo.TiwenjiedaVO;
import com.entity.view.TiwenjiedaView;

@Service("tiwenjiedaService")
public class TiwenjiedaServiceImpl extends ServiceImpl<TiwenjiedaDao, TiwenjiedaEntity> implements TiwenjiedaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TiwenjiedaEntity> page = this.selectPage(
                new Query<TiwenjiedaEntity>(params).getPage(),
                new EntityWrapper<TiwenjiedaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TiwenjiedaEntity> wrapper) {
		  Page<TiwenjiedaView> page =new Query<TiwenjiedaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TiwenjiedaVO> selectListVO(Wrapper<TiwenjiedaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TiwenjiedaVO selectVO(Wrapper<TiwenjiedaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TiwenjiedaView> selectListView(Wrapper<TiwenjiedaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TiwenjiedaView selectView(Wrapper<TiwenjiedaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
