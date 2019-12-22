package com.aspect.interceptor.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspect.interceptor.object.*;
import com.sun.mail.imap.protocol.Item;


@Validated
@RestController
public class HolidayController {
	private static Logger logger = LoggerFactory.getLogger(HolidayController.class);
	
	 @RequestMapping(value="/tm/shared/get-holidays", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<HolidayResponseDTO> getHolidays(HolidayReqDTO reqDTO) {
		 System.out.println(reqDTO.getStartDate());
		 HolidayResponseDTO holidayDto = new HolidayResponseDTO();
		 DetailHolidayResponseDTO detailHolidayDTO = new DetailHolidayResponseDTO();
		 SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		 detailHolidayDTO.setDate("date");
		 detailHolidayDTO.setDescription("description");
		 
		 List<DetailHolidayResponseDTO> lsDetailHoliday =new ArrayList<DetailHolidayResponseDTO>();
		 lsDetailHoliday.add(detailHolidayDTO);
		 
		 holidayDto.setData(lsDetailHoliday);
		 holidayDto.setCode(55555);
		 holidayDto.setMessage("sukseess");
		 System.out.println("holidayyy uuuuu : " + holidayDto.getMessage());
		 ResponseEntity<HolidayResponseDTO> response = new  ResponseEntity<HolidayResponseDTO>(holidayDto,HttpStatus.OK);
		 return response;
	 }
	 
	 
	 @RequestMapping(value="/post/tm/shared/get-holidays", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<HolidayResponseDTO> postHolidays(@RequestBody HolidayReqDTO reqDTO) {
		 System.out.println(reqDTO.getStartDate());
		 HolidayResponseDTO holidayDto = new HolidayResponseDTO();
		 DetailHolidayResponseDTO detailHolidayDTO = new DetailHolidayResponseDTO();
		 SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		 detailHolidayDTO.setDate(simple.format(reqDTO.getStartDate()));
		 detailHolidayDTO.setDescription("description");
		 
		 List<DetailHolidayResponseDTO> lsDetailHoliday =new ArrayList<DetailHolidayResponseDTO>();
		 lsDetailHoliday.add(detailHolidayDTO);
		 
		 holidayDto.setData(lsDetailHoliday);
		 holidayDto.setCode(55555);
		 holidayDto.setMessage("sukseess");
		 
		 ResponseEntity<HolidayResponseDTO> response = new  ResponseEntity<HolidayResponseDTO>(holidayDto,HttpStatus.OK);
		 return response;
	 }
	 
	 @RequestMapping(value="/holiday/objectException", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> postHolidayException(@RequestBody @Valid HolidayReqDTO lsReqDTO) throws Exception {
		 logger.info("data A : {}",lsReqDTO);
		 if (true)throw new Exception();
		 return new ResponseEntity<>("ok", HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/holiday/object", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> postHolidayObject(@RequestBody @Valid HolidayReqDTO lsReqDTO) throws Exception {
		 logger.info("data A : {}",lsReqDTO);
		 return new ResponseEntity<>("ok", HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/holiday/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Object> postHolidayList( @RequestBody @Valid List<HolidayReqDTO> lsReqDTO) {
		 lsReqDTO.stream().forEach(item -> logger.info("data A : {}",item.getEmployeeId()));
		 BaseDTO bsDTO = new BaseDTO(200, 2000, "ok", "12213123");
		 return new ResponseEntity<Object>(bsDTO, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/holiday/object-list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> postHolidayObjList(@RequestBody @Valid ValidList<HolidayReqDTO> lsReqDTO) {
		 lsReqDTO.stream().forEach(item -> logger.info("data A : {}",item.getEmployeeId()));
		 return new ResponseEntity<>("ok", HttpStatus.OK);
	 }
}
