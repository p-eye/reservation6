package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dao.ReservationPriceDao;
import kr.or.connect.reservation.dao.ReservationResponseDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.param.ReservationParam;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;
import kr.or.connect.reservation.dto.response.ReservationResponse;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private final ReservationInfoDao reservationInfoDao;
	private final ReservationPriceDao reservationPriceDao;
	private final ReservationResponseDao reservationResponseDao;
	private final DisplayInfoService displayInfoService;

	@Autowired
	public ReservationServiceImpl(ReservationInfoDao reservationInfoDao, ReservationPriceDao reservationPriceDao,
			ReservationResponseDao reservationResponseDao, DisplayInfoService displayInfoService) {
		this.reservationInfoDao = reservationInfoDao;
		this.reservationPriceDao = reservationPriceDao;
		this.reservationResponseDao = reservationResponseDao;
		this.displayInfoService = displayInfoService;
	}
	
	/* get */

	@Override
	public ReservationInfoResponse getReservationInfoResponse(String reservationEmail) {

		ReservationInfoResponse reservationInfoResponse = new ReservationInfoResponse();
		List<ReservationInfo> reservationInfoList = getReservationInfoList(reservationEmail);

		reservationInfoResponse.setReservations(reservationInfoList);
		reservationInfoResponse.setSize(reservationInfoList.size());

		return reservationInfoResponse;
	}

	@Override
	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		List<ReservationInfo> reservationInfoList = reservationInfoDao.getReservationInfoList(reservationEmail);

		// Each ReservationInfo
		for (ReservationInfo reservationInfo : reservationInfoList) {
			int displayInfoId = reservationInfo.getDisplayInfoId();
			reservationInfo.setDisplayInfo(displayInfoService.getDisplayInfo(displayInfoId));

			int reservationInfoId = reservationInfo.getReservationInfoId();
			reservationInfo.setTotalPrice(getReservationTotalPrice(reservationInfoId));
		}

		return reservationInfoList;

	}

	@Override
	public int getReservationTotalPrice(int reservationInfoId) {
		return reservationInfoDao.getReservationTotalPrice(reservationInfoId);
	}

	@Override
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId) {
		return reservationPriceDao.getReservationPriceList(reservationInfoId);
	}

	
	/* insert */
	
	@Override
	@Transactional(readOnly = false)
	public ReservationResponse insertReservationInfoAndPrice(ReservationParam reservationParam) {
		int reservationInfoId = insertReservationInfo(reservationParam);
		insertReservationPrice(reservationParam, reservationInfoId);

		return getReservationResponse(reservationInfoId);
	}

	@Override
	public int insertReservationInfo(ReservationParam reservationParam) {
		return reservationInfoDao.insertReservationInfo(reservationParam);
	}

	@Override
	@Transactional
	public void insertReservationPrice(ReservationParam reservationParam, int reservationInfoId) {
		List<ReservationPrice> reservationPriceList = reservationParam.getPrices();

		for (ReservationPrice reservationPrice : reservationPriceList) {
			reservationPrice.setReservationInfoId(reservationInfoId);
			reservationPriceDao.insertReservationPrice(reservationPrice);
		}
	}

	@Override
	public ReservationResponse getReservationResponse(int reservationInfoId) {
		ReservationResponse reservationResponse = reservationResponseDao.getReservationResponse(reservationInfoId);
		reservationResponse.setPrices(getReservationPriceList(reservationInfoId));

		return reservationResponse;
	}

	
	/* update */
	
	@Override
	@Transactional
	public ReservationResponse cancelReservationInfo(int reservationInfoId) {
		reservationInfoDao.cancelReservationInfo(reservationInfoId);
		return getReservationResponse(reservationInfoId);
	}

}
