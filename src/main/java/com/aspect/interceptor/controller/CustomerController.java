package com.aspect.interceptor.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspect.interceptor.dao.CustomerDao;
import com.aspect.interceptor.model.Customer;
import com.aspect.interceptor.object.BaseDTO;
import com.aspect.interceptor.object.HroOverrideDownloadTransactionList;
import com.aspect.interceptor.object.ResponseByteArray;
import com.aspect.interceptor.object.UploadImageDTO;
import com.aspect.interceptor.services.CustomerServiceImpl;
import com.aspect.interceptor.services.EmailServiceInter;
import com.aspect.interceptor.util.UtilInterceptor;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;




@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private UtilInterceptor utilInterceptor;
	@Autowired
	private CustomerDao customerDao;
	
//	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private EmailServiceInter emailServiceInter;
	
	@RequestMapping(value = "/getDataByte", method = RequestMethod.GET)
	public ResponseEntity<?> uploadUImageGet() throws IOException {
		ResponseByteArray response = new ResponseByteArray();
		File fileImage = new File("D://images//download1.jpg");
		byte[] fileContent = Files.readAllBytes(fileImage.toPath());
		response.setFileName("testFile.jpg");
		response.setFile(fileContent);
		return new ResponseEntity<ResponseByteArray>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> uploadUImage(UploadImageDTO imgDto) {
		if (imgDto.getFile().isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {

			customerServiceImpl.saveUploadedFiles(Arrays.asList(imgDto.getFile()));

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - " + imgDto.getFile().getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@GetMapping("/downloadXls")
	public ResponseEntity<InputStreamResource> downloadGetXls(HttpServletResponse response) throws Exception{
		
		ByteArrayInputStream  in = customerServiceImpl.testExcelApacePoi();        
        HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
        
         return ResponseEntity
                      .ok()
                      .headers(headers)
                      .body(new InputStreamResource(in));
        }
	
	@GetMapping("/downloadXls1")
	public ResponseEntity<InputStreamResource> downloadGetXls1(HttpServletResponse response) throws Exception{
		
		ByteArrayInputStream  in = customerServiceImpl.testExcelApacePoi();        
        HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
        
         return ResponseEntity
                      .ok()
                      .headers(headers)
                      .body(new InputStreamResource(in));
     }
	
	@GetMapping("/downloadHro")
	public void downloadHroGetCsv(HttpServletResponse response) throws Exception{
		SimpleDateFormat dtFmt = new SimpleDateFormat("yyyyMMdd-HHmmss");
		StringBuilder strFileName = new StringBuilder("HroOverride-").append(dtFmt.format(new Date())).append(".csv");
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + strFileName.toString() + "\"");
		List<HroOverrideDownloadTransactionList> lsCustomer = new ArrayList<HroOverrideDownloadTransactionList>();
		for(int i=0; i<5; i++) {
			HroOverrideDownloadTransactionList hroDto = new HroOverrideDownloadTransactionList();
			hroDto.setId("1234");
			hroDto.setRequester("REQ-123");
			hroDto.setName("wahyuuuu");
			hroDto.setStatus("pending");
			hroDto.setAgent("agent");
			hroDto.setType("type");
			hroDto.setOverrideDate("OverrideDate");
			hroDto.setOverrideTime("overrideTime");
			hroDto.setAreaCode("areaCode");
			hroDto.setDescription("description");
			hroDto.setCreatedTimestamp("createdTimestamp");
			hroDto.setCreatedBy("createdBy");
			hroDto.setModifiedBy("modifiedBy");
			hroDto.setModifiedTimestamp("modifiedTimestamp");
			lsCustomer.add(hroDto);
		}
		UtilInterceptor.writeHroOverrideDownloadTransactionList(response.getWriter(), lsCustomer);
	}
	
	@PostMapping("/download")
	public void downloadPostCsv(HttpServletResponse response) throws Exception{
		String filename = "customer.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
	    StatefulBeanToCsv<Customer> writer = new StatefulBeanToCsvBuilder<Customer>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
		List<Customer> lsCustomer = new ArrayList<Customer>();
		for(int i=0; i<5; i++) {
			Customer cus = new Customer();
			cus.setCustomerId("1");
			cus.setCustomerName("joko");
			cus.setCutomerAge(5);
			lsCustomer.add(cus);
		}
		//write all users to csv file
        writer.write(lsCustomer);
	}
	
	
	//@RequestMapping(value = "/download", method = RequestMethod.GET)
	@GetMapping("/download")
	//@PostMapping("/download")
	public void GetDownloadCsv(HttpServletResponse response) throws Exception{
		String filename = "customer.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
	    StatefulBeanToCsv<Customer> writer = new StatefulBeanToCsvBuilder<Customer>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
		List<Customer> lsCustomer = new ArrayList<Customer>();
		for(int i=0; i<5; i++) {
			Customer cus = new Customer();
			cus.setCustomerId("1");
			cus.setCustomerName("joko");
			cus.setCutomerAge(5);
			lsCustomer.add(cus);
		}
		//write all users to csv file
        //writer.write(lsCustomer);
		UtilInterceptor.writeCustomer(response.getWriter(), lsCustomer);
	}
	
	// @RequestMapping(value = "/download", method = RequestMethod.GET)
	@GetMapping("/testSplit")
	// @PostMapping("/download")
	public void testSplit() throws Exception {
		if (utilInterceptor.isCDT("1006"))
			logger.info("okkkk");
	}
	
	@RequestMapping(value = "/getMenu", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Customer>> getEmployees() {
		List<Customer> lsCustomer = customerDao.getCustomerByCriteria();
		return new ResponseEntity<List<Customer>>(lsCustomer, HttpStatus.OK);
	}
	
	//save
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> save() throws Exception{
		customerServiceImpl.saveTransactionList();
		BaseDTO baseDTO = new BaseDTO(200, 200, "OK", "1234");
		//saveTransactionList
		return new ResponseEntity<Object>(baseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/getemail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getEmail() {
		emailServiceInter.sendEmail();
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	


}
