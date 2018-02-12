package com.cdol.template.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdol.template.contents.dto.ContentsVO;
import com.cdol.template.mapper.ContentsMapper;

@Service
public class ContentsServiceImpl implements ContentsService {
	
	@Autowired
	private ContentsMapper contentsMapper;
	
	@Override
	public List<ContentsVO> getContents() throws Exception {
		return contentsMapper.contentsList();
	}

}
