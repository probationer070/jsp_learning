package com.ecom6.dao.mem;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.VO.mem.MemberVO;

@Mapper
public interface MemberDao {

	MemberVO getMember(MemberVO mvo);

	int idCheck(String mem_id);

	int memberJoin(MemberVO mvo);

}
