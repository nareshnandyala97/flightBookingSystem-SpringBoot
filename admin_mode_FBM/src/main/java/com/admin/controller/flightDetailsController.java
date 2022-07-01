package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.AuthRequest;
import com.admin.entity.JwtResponse;
import com.admin.entity.flightDetails;
import com.admin.entity.userEntity;
import com.admin.secure.service.CustomUserDetailService;
import com.admin.secure.util.JwtUtil;
import com.admin.service.flightService;
import com.admin.service.userService;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
//@RequestMapping("/flight")
public class flightDetailsController {
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Autowired
	private userService userService;
	
	@Autowired
	flightService flightService;
	
	@PostMapping("/flight/airline/register")
	public Integer addFlight(@RequestBody flightDetails flightDetails) {
		Integer id=flightService.addFlight(flightDetails);
		return id;
	}
	
	@GetMapping("/flight/getAllFlights")
	public List<flightDetails> getAllFlights(){		
		return flightService.getAll();		
	}
	
	@GetMapping("/flight/{id}")
	public flightDetails findById(@PathVariable Integer id) {
		flightDetails fd=flightService.findById(id);
		return fd;
	}
	
	@GetMapping("/flight/search")
	public List<flightDetails> getSearchResult(@RequestParam String origin,@RequestParam String destination,@RequestParam String startDate){		
		return flightService.searchFlight(origin,destination,startDate);		
	}
	
	@PutMapping(value = "/flight/update/{id}")
	public ResponseEntity<flightDetails> updateEmployee(@PathVariable Integer id,
			@RequestBody flightDetails flightDetails) {

		ResponseEntity<flightDetails> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			flightService.updateFlight(flightDetails, id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@DeleteMapping(value = "/flight/delete/{id}")
	public ResponseEntity<flightDetails> deleteEmployee(@PathVariable Integer id) {

		ResponseEntity<flightDetails> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			flightService.deleteFlight(id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
	@PostMapping("/admin/register")
	public Integer register(@RequestBody userEntity user) {
		Integer userId=userService.saveuser(user);		
		return user.getId();	
	}
	
}
