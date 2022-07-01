package com.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.ResourceNotFoundException;
import com.user.entity.bookingInfo;
import com.user.entity.userDetails;

@Service
public class bookingServiceImpl implements bookingService {

	@Autowired
	bookingInfoRepository bInfoRepo;
	@Autowired
	userDetailsRepository userRepo;

	@Transactional
	@Override
	public Integer bookFlight(bookingInfo bookingInfo) {
		// TODO Auto-generated method stub
		bookingInfo bInfoId = bInfoRepo.save(bookingInfo);
		bInfoId.setPnrNumber("PNR000"+bInfoId.getbId());
		return bInfoId.getbId();
	}

//	rivate Integer bId;
//	private String airlineName;
//	private String flightNumber;
//	private String origin;
//	private String destination;
//	private String name;
//	private String email;
//	private String bookedSeats;
//	private List<userDetailsbao> userDetails;
//	private String pnrNumber;
//	private String meal;
	@Override
	public List<bookingInfoBao> findByEmail(String email) {
		// TODO Auto-generated method stub
		List<bookingInfo> bookingInfoList = bInfoRepo.findByEmail(email);
		List<bookingInfoBao> bookingInfobaoList = new ArrayList<>();
		for (bookingInfo bInfo : bookingInfoList) {
			bookingInfoBao bookingInfo = new bookingInfoBao();
			bookingInfo.setbId(bInfo.getbId());
			bookingInfo.setAirlineName(bInfo.getAirlineName());
			bookingInfo.setFlightNumber(bInfo.getFlightNumber());
			bookingInfo.setOrigin(bInfo.getOrigin());
			bookingInfo.setDestination(bInfo.getDestination());
			bookingInfo.setName(bInfo.getName());
			bookingInfo.setEmail(bInfo.getEmail());
			bookingInfo.setBookedSeats(bInfo.getBookedSeats());
			bookingInfo.setUserDetails(addUserdetails(bInfo.getUserDetails()));
			bookingInfo.setPnrNumber(bInfo.getPnrNumber());
			bookingInfo.setMeal(bInfo.getMeal());
			bookingInfobaoList.add(bookingInfo);
		}
		return bookingInfobaoList;
	}

	public List<userDetailsBao> addUserdetails(List<userDetails> details) {

		List<userDetailsBao> detailsList = new ArrayList<>();
		for (userDetails ud : details) {
			userDetailsBao bao = new userDetailsBao();
			bao.setuId(ud.getuId());
			bao.setName(ud.getName());
			bao.setAge(ud.getAge());
			bao.setGender(ud.getGender());
			bao.setBookingInfoId(ud.getBookingInfo().getbId());
			detailsList.add(bao);
		}
		return detailsList;

	}

	@Override
	public List<bookingInfoBao> findBypnrNumber(String pnrNumber) {
		// TODO Auto-generated method stub
		List<bookingInfoBao> bookingInfobaoList = new ArrayList<>();
		bookingInfo bInfo = bInfoRepo.findBypnrNumber(pnrNumber);
			bookingInfoBao bookingInfo = new bookingInfoBao();
			bookingInfo.setbId(bInfo.getbId());
			bookingInfo.setAirlineName(bInfo.getAirlineName());
			bookingInfo.setFlightNumber(bInfo.getFlightNumber());
			bookingInfo.setOrigin(bInfo.getOrigin());
			bookingInfo.setDestination(bInfo.getDestination());
			bookingInfo.setName(bInfo.getName());
			bookingInfo.setEmail(bInfo.getEmail());
			bookingInfo.setBookedSeats(bInfo.getBookedSeats());
			bookingInfo.setUserDetails(addUserdetails(bInfo.getUserDetails()));
			bookingInfo.setPnrNumber(bInfo.getPnrNumber());
			bookingInfo.setMeal(bInfo.getMeal());
			bookingInfobaoList.add(bookingInfo);
		return bookingInfobaoList;
	}

	@Transactional
	@Override
	public void cancelFlight(String pnr) {
		// TODO Auto-generated method stub
		bookingInfo bInfo = bInfoRepo.findBypnrNumber(pnr);
		bInfoRepo.deleteById(bInfo.getbId());		
	}

}
