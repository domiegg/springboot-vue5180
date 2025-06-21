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


import com.dao.XueshengyonghuDao;
import com.entity.XueshengyonghuEntity;
import com.service.XueshengyonghuService;
import com.entity.vo.XueshengyonghuVO;
import com.entity.view.XueshengyonghuView;

@Service("xueshengyonghuService")
public class XueshengyonghuServiceImpl extends ServiceImpl<XueshengyonghuDao, XueshengyonghuEntity> implements XueshengyonghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengyonghuEntity> page = this.selectPage(
                new Query<XueshengyonghuEntity>(params).getPage(),
                new EntityWrapper<XueshengyonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengyonghuEntity> wrapper) {
		  Page<XueshengyonghuView> page =new Query<XueshengyonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengyonghuVO> selectListVO(Wrapper<XueshengyonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengyonghuVO selectVO(Wrapper<XueshengyonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengyonghuView> selectListView(Wrapper<XueshengyonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengyonghuView selectView(Wrapper<XueshengyonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
