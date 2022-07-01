package com.user.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.bookingInfo;
import com.user.service.bookingInfoBao;
import com.user.service.bookingInfoRepository;
import com.user.service.bookingService;
import com.user.service.userDetailsRepository;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping("/flight")
public class userController {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	bookingService bookingService;
	@Autowired
	bookingInfoRepository brepo;
	@Autowired
	userDetailsRepository userRepo;

	@GetMapping("/search")
	public List getSearchResult(@RequestParam String origin, @RequestParam String destination,
			@RequestParam String startDate) throws ParseException {
		startDate=startDate+" 00:00:00";
		//http://localhost:9092/getSearchResult/?origin=HYD&destination=BAN&startDate=2022-06-23 16:00:00
		List flights=this.restTemplate.getForObject("http://admin-service/flight/search/?origin="+origin+"&destination="+destination+"&startDate="+startDate, List.class);
		return flights;

	}
	
	@PostMapping("/booking")
	public Integer airlineBooking(@RequestBody bookingInfo bookingInfo) {
		
//		Integer value=id;
//		List flights =this.restTemplate.getForObject("http://admin-service/flight/1", List.class);
//		System.out.println(flights);
		Integer idValue=bookingService.bookFlight(bookingInfo);
		return idValue;
	}
	
	@GetMapping("/booking/history/{email}")
	public List<bookingInfoBao> getByEmail(@PathVariable("email")String email) {
		
		List<bookingInfoBao>bookinInfolist=bookingService.findByEmail(email);
		return bookinInfolist;
	}
	
	
	@GetMapping("/ticket/{pnrNumber}")
	public List<bookingInfoBao> pnrNumber(@PathVariable("pnrNumber")String pnrNumber) {
		
		List<bookingInfoBao> bookinInfolist=bookingService.findBypnrNumber(pnrNumber);
		return bookinInfolist; 
	}
	
	@DeleteMapping(value = "/booking/cancel/{pnr}")
	public ResponseEntity<bookingInfo> deleteStudent(@PathVariable("pnr") String pnr) {

		ResponseEntity<bookingInfo> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			bookingService.cancelFlight(pnr);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		brepo.deleteAll();
		userRepo.deleteAll();		
	}

}
