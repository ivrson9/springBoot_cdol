package com.cdol.template.mapper;

import java.util.List;

import com.cdol.template.contents.dto.ContentsVO;
import com.cdol.template.menu.dto.MenuVO;

public interface ContentsMapper {
	public List<ContentsVO> contentsList()throws Exception;
	public List<MenuVO> menuList()throws Exception;
}
