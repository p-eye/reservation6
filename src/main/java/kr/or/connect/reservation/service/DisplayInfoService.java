package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;

@Service
public interface DisplayInfoService {

	public DisplayInfo getDisplayInfo(int displayInfoId);
	
	public DisplayInfoImage getDisplayInfoImage(int displayInfoId);
	

}
