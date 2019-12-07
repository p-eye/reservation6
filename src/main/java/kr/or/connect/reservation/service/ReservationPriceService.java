package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationPrice;

@Service
public interface ReservationPriceService {

	
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId);
	
	public int getReservationTotalPrice(int reservationInfoId);

}
