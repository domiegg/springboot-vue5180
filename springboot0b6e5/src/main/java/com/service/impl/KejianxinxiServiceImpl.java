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


import com.dao.KejianxinxiDao;
import com.entity.KejianxinxiEntity;
import com.service.KejianxinxiService;
import com.entity.vo.KejianxinxiVO;
import com.entity.view.KejianxinxiView;

@Service("kejianxinxiService")
public class KejianxinxiServiceImpl extends ServiceImpl<KejianxinxiDao, KejianxinxiEntity> implements KejianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KejianxinxiEntity> page = this.selectPage(
                new Query<KejianxinxiEntity>(params).getPage(),
                new EntityWrapper<KejianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KejianxinxiEntity> wrapper) {
		  Page<KejianxinxiView> page =new Query<KejianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KejianxinxiVO> selectListVO(Wrapper<KejianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KejianxinxiVO selectVO(Wrapper<KejianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KejianxinxiView> selectListView(Wrapper<KejianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KejianxinxiView selectView(Wrapper<KejianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
