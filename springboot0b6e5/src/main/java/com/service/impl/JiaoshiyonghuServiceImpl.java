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


import com.dao.JiaoshiyonghuDao;
import com.entity.JiaoshiyonghuEntity;
import com.service.JiaoshiyonghuService;
import com.entity.vo.JiaoshiyonghuVO;
import com.entity.view.JiaoshiyonghuView;

@Service("jiaoshiyonghuService")
public class JiaoshiyonghuServiceImpl extends ServiceImpl<JiaoshiyonghuDao, JiaoshiyonghuEntity> implements JiaoshiyonghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoshiyonghuEntity> page = this.selectPage(
                new Query<JiaoshiyonghuEntity>(params).getPage(),
                new EntityWrapper<JiaoshiyonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoshiyonghuEntity> wrapper) {
		  Page<JiaoshiyonghuView> page =new Query<JiaoshiyonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaoshiyonghuVO> selectListVO(Wrapper<JiaoshiyonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoshiyonghuVO selectVO(Wrapper<JiaoshiyonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoshiyonghuView> selectListView(Wrapper<JiaoshiyonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoshiyonghuView selectView(Wrapper<JiaoshiyonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
