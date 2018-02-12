package com.cdol.template.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdol.template.mapper.ContentsMapper;
import com.cdol.template.menu.dto.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	ContentsMapper contentsmapper;
	
	@Override
	public List<MenuVO> getMenu()throws Exception {
		return contentsmapper.menuList();
	}

}
