package com.spring.mvc.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		
		//회원 비밀번호 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 하기 전 : "+user.getPassword());
		
		//비밀번호를 암호화 해서 user객체에 다시 저장
		String securePw = encoder.encode(user.getPassword());
		System.out.println("암호화 후 : "+securePw);
		user.setPassword(securePw);
		
		mapper.register(user);
	}

	@Override
	public int checkId(String account) {
		return mapper.checkId(account);
	}

	@Override
	public void delete(String account) {
		mapper.checkId(account);
		
	}

	@Override
	public UserVO selectOne(String account) {
		return mapper.selectOne(account);
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keepLogin(String sessionId, Date limitTime, String account) {
		Map<String, Object> datas = new HashMap<>();
		datas.put("sessionId", sessionId);
		datas.put("limitDate", limitTime);
		datas.put("account", account);
		
		mapper.keepLogin(datas);
		
		
	}

	@Override
	public UserVO getUserWithSessionId(String sessionId) {
		return mapper.getUserWithSessionId(sessionId);
	}

}
