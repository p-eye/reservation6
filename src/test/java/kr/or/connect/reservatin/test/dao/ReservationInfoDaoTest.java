package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationInfo;

public class ReservationInfoDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ReservationInfoDao reservationInfoDao = ac.getBean(ReservationInfoDao.class);

		/* getResrvationInfoList */
		List<ReservationInfo> reservationInfoList = reservationInfoDao
				.getReservationInfoList("kimjinsu@connect.co.kr");

		for (ReservationInfo reservationInfo : reservationInfoList) {
			System.out.println(reservationInfo);
			System.out.println("==========");

		}

	}

}