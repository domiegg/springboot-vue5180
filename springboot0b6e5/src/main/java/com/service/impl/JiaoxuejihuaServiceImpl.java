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


import com.dao.JiaoxuejihuaDao;
import com.entity.JiaoxuejihuaEntity;
import com.service.JiaoxuejihuaService;
import com.entity.vo.JiaoxuejihuaVO;
import com.entity.view.JiaoxuejihuaView;

@Service("jiaoxuejihuaService")
public class JiaoxuejihuaServiceImpl extends ServiceImpl<JiaoxuejihuaDao, JiaoxuejihuaEntity> implements JiaoxuejihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoxuejihuaEntity> page = this.selectPage(
                new Query<JiaoxuejihuaEntity>(params).getPage(),
                new EntityWrapper<JiaoxuejihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoxuejihuaEntity> wrapper) {
		  Page<JiaoxuejihuaView> page =new Query<JiaoxuejihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaoxuejihuaVO> selectListVO(Wrapper<JiaoxuejihuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoxuejihuaVO selectVO(Wrapper<JiaoxuejihuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoxuejihuaView> selectListView(Wrapper<JiaoxuejihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoxuejihuaView selectView(Wrapper<JiaoxuejihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
