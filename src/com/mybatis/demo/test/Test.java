package com.mybatis.demo.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.demo.po.User;

public class Test {
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("MybatisConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session.selectOne(
					"com.mybatis.demo.po.UserMapper.SelectUserByID", 1);
			if(user!=null){
				System.out.println(user);
			}
		} finally {
			session.close();
		}
	}
}
