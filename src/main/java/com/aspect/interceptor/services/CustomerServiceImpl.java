package com.aspect.interceptor.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aspect.interceptor.dao.CustomerDao;
import com.aspect.interceptor.model.Customer;
import com.aspect.interceptor.object.HroOverrideDownloadTransactionList;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional(rollbackOn =  Exception.class)
	public void saveTransactionList() throws Exception {
		List<Customer> lsCus = new ArrayList<Customer>();
		for (int i=0; i<2; i++) {
			Customer cs = new Customer();
			cs.setCustomerId("56"+ Integer.toString(i));
			cs.setCustomerName("joni");
			cs.setCutomerAge(10);
			lsCus.add(cs);
		}
		
	 int j=0;
	  for (Customer customer : lsCus) {
		 if (j==3) throw new Exception("testt error");
		this.saveTransaction(customer);
		j++;
	}
		
	}
	
	@Transactional
	public void saveTransaction(Customer cus) {
		customerDao.save(cus);
	}
	
	
	public ByteArrayInputStream testExcelApacePoi() throws IOException {
		 List<HroOverrideDownloadTransactionList> lsHro = new ArrayList<HroOverrideDownloadTransactionList>();
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
				lsHro.add(hroDto);
			}
			
		  //excel variable
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Business Request");

        //header style
        CellStyle headerStyle = workbook.createCellStyle();
        
        //create header
        int col = 0;

        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(col++);
        headerCell.setCellValue("Transaction ID");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(col++);
        headerCell.setCellValue("Requester");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(col++);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(col++);
        headerCell.setCellValue("Status");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("Agent");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("Type");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("OverrideDate");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("OverrideTime");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("AreaCode");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("Description");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("CreatedTimestamp");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("CreatedBy");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("ModifiedTimestamp");
        headerCell.setCellStyle(headerStyle);
        
        headerCell = header.createCell(col++);
        headerCell.setCellValue("ModifiedBy");
        headerCell.setCellStyle(headerStyle);
       
       
		  //cell style
        CellStyle style = workbook.createCellStyle();
        int rowNumber = 1;
        for (HroOverrideDownloadTransactionList temp : lsHro) {
        	 // data row
            Row row = sheet.createRow(rowNumber);
            col = 0;
            Cell cell = row.createCell(col++);
            cell.setCellValue(temp.getId());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getRequester());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getName());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getStatus());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getAgent());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getType());
            cell.setCellStyle(style);
            
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getOverrideDate());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getOverrideTime());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getAreaCode());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getDescription());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getCreatedTimestamp());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getCreatedBy());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getModifiedTimestamp());
            cell.setCellStyle(style);
            
            cell = row.createCell(col++);
            cell.setCellValue(temp.getModifiedBy());
            cell.setCellStyle(style);
            
            rowNumber++;
            
		}
        
     // adjust width
        for(int i=0;i<col;i++)
            sheet.autoSizeColumn(i);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	// save file
	private static String UPLOADED_FOLDER = "D://temp//";

	public void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; // next pls
			}
			String extention = file.getOriginalFilename().split("\\.")[1];
			String originalName = file.getOriginalFilename().split("\\.")[0];
			SimpleDateFormat dtFmt = new SimpleDateFormat("yyyyMMdd-HHmmss");
			byte[] bytes = file.getBytes();
			file.getContentType();
			StringBuilder fileName = new StringBuilder();
			fileName.append(originalName).append("_").append(dtFmt.format(new Date())).append(".").append(extention);
			Path path = Paths.get(UPLOADED_FOLDER + fileName.toString());
			Files.write(path, bytes);
			
			//Files.delete
		}

	}
}
