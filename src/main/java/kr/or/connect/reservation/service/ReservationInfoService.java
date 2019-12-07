package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationInfo;

@Service
public interface ReservationInfoService {

	
	public List<ReservationInfo> getReservationInfoList(String reservationEmail);

}
