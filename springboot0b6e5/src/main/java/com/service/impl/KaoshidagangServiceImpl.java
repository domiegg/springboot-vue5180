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


import com.dao.KaoshidagangDao;
import com.entity.KaoshidagangEntity;
import com.service.KaoshidagangService;
import com.entity.vo.KaoshidagangVO;
import com.entity.view.KaoshidagangView;

@Service("kaoshidagangService")
public class KaoshidagangServiceImpl extends ServiceImpl<KaoshidagangDao, KaoshidagangEntity> implements KaoshidagangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshidagangEntity> page = this.selectPage(
                new Query<KaoshidagangEntity>(params).getPage(),
                new EntityWrapper<KaoshidagangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshidagangEntity> wrapper) {
		  Page<KaoshidagangView> page =new Query<KaoshidagangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshidagangVO> selectListVO(Wrapper<KaoshidagangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshidagangVO selectVO(Wrapper<KaoshidagangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshidagangView> selectListView(Wrapper<KaoshidagangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshidagangView selectView(Wrapper<KaoshidagangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
