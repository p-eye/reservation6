package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.DisplayInfo;

@Service
public interface DisplayInfoService {

	public DisplayInfo getDisplayInfo(int displayInfoId);
	

}
