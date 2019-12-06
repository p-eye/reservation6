package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.DisplayInfoImage;

@Service
public interface DisplayInfoImageService {

	public DisplayInfoImage getDisplayInfoImage(int displayInfoId);
	

}
