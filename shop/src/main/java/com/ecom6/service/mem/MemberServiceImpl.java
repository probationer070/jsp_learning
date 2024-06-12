package com.ecom6.service.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom6.VO.mem.MemberVO;
import com.ecom6.dao.mem.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public MemberVO getMember(MemberVO mvo) {
		return memberDao.getMember(mvo);
	}

	@Override
	public int idCheck(String mem_id) {
		return memberDao.idCheck(mem_id);
	}

	@Override
	public int memberJoin(MemberVO mvo) {
		return memberDao.memberJoin(mvo);
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		return  memberDao.memberUpdate(mvo);
	}

}
