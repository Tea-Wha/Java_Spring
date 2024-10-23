package com.kh.jdbcAndOracleSpring;

import com.kh.jdbcAndOracleSpring.dao.EmpDAO;
import com.kh.jdbcAndOracleSpring.vo.EmpVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcAndOracleSpringApplication implements CommandLineRunner {
//	private final EmpDAO dao;
//
//	public JdbcAndOracleSpringApplication(EmpDAO dao){
//		this.dao = dao;
//	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcAndOracleSpringApplication.class, args);
	}

	@Override // 터미널 모드 관련된 코드는 이곳에
	public void run(String... args) throws Exception {
//		List<EmpVO> list = dao.empSelect();
//		dao.empSelectResult(list);
	}
}
