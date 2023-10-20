package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	// 1번 
	private static MemberDaoImpl dao;
	
	// 2번 
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	

	@Override
	public int insertMember(MemberVO memVo) {
		
		SqlSession session = null;
		int cnt = 0;	// 반환값이 저장될 변수 선언
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.insertMember", memVo);
			
			if(cnt>0) {
				session.commit();
			}
			
			}finally {
			if(session!=null) session.close();
			}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		SqlSession session = null;
		int cnt = 0;	// 반환값이 저장될 변수 선언
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.deleteMember", memId);
			
			if(cnt>0) {
				session.commit();
			}
			
			}finally {
			if(session!=null) session.close();
			}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session = null;
		int cnt = 0; // 반환값이 저장될 변수
		
		try {
			
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember", memVo);
			
			if(cnt>0) {
				
				session.commit();
			}
			
			} finally {
			if(session!=null) session.close();
			}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
	    
	    List<MemberVO> memList = null;  // 반환값이 저장될 변수
	    
	    try {
	    	session = MyBatisSqlSessionFactory.getSqlSession();
			memList= session.selectList("member.getAllMember");
			
			
			
			} finally {
			if(session!=null) session.close();
			}  
	    
	    
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session = null;
	    int count = 0;
	    
	    try {
	    	session = MyBatisSqlSessionFactory.getSqlSession();
			count = session.selectOne("member.getMemberCount", memId);
	    	if(count>0) {
				
				session.commit();
			}
			
			} finally {
			if(session!=null) session.close();
			}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paraMap) {
		SqlSession session = null;
		int cnt =0;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember2", paraMap);
			
			if(cnt>0) session.commit();
		} finally {
		if(session!=null) session.close();
		}
			
		return cnt;
	}

}
