package com.cdol.template.menu.service;

import java.util.List;

import com.cdol.template.menu.dto.MenuVO;

public interface MenuService {
	public List<MenuVO> getMenu()throws Exception;
}
