package com.cdol.template.contents.service;

import java.util.List;
import com.cdol.template.contents.dto.ContentsVO;

public interface ContentsService {
	public List<ContentsVO> getContents()throws Exception;
}
