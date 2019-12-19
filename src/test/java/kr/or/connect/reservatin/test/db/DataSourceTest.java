package kr.or.connect.reservatin.test.db;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		System.out.println(ac);
		/*
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if (conn != null)
				System.out.println("접속 성공^^");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}           */ 
	}

}
