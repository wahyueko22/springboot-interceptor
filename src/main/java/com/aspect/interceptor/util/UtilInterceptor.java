package com.aspect.interceptor.util;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aspect.interceptor.controller.HolidayController;
import com.aspect.interceptor.model.Customer;
import com.aspect.interceptor.object.HroOverrideDownloadTransactionList;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Component
public class UtilInterceptor {
	private static Logger logger = LoggerFactory.getLogger(UtilInterceptor.class);

	public static void writeCustomer(PrintWriter writer, List<Customer> lsCustomer) throws Exception{
		final CsvCustomMappingStrategy<Customer> mappingStrategy = new CsvCustomMappingStrategy<Customer>();
		mappingStrategy.setType(Customer.class);

		StatefulBeanToCsv<Customer> csvWriter = new StatefulBeanToCsvBuilder<Customer>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withMappingStrategy(mappingStrategy)
               // .withMappingStrategy(new HeaderColumnNameAndOrderMappingStrategy<>(HroOverrideDownloadTransactionList.class))
                .withOrderedResults(false)
                .build();
	  //write all users to csv file
	    csvWriter.write(lsCustomer);
	}
	
	public static void writeHroOverrideDownloadTransactionList(PrintWriter writer, List<HroOverrideDownloadTransactionList> lsHRo) throws Exception{
		final CsvCustomMappingStrategy<HroOverrideDownloadTransactionList> mappingStrategy = new CsvCustomMappingStrategy<HroOverrideDownloadTransactionList>();
		mappingStrategy.setType(HroOverrideDownloadTransactionList.class);

		StatefulBeanToCsv<HroOverrideDownloadTransactionList> csvWriter = new StatefulBeanToCsvBuilder<HroOverrideDownloadTransactionList>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withMappingStrategy(mappingStrategy)
               // .withMappingStrategy(new HeaderColumnNameAndOrderMappingStrategy<>(HroOverrideDownloadTransactionList.class))
                .withOrderedResults(false)
                .build();
	  //write all users to csv file
	    csvWriter.write(lsHRo);
	}
	
	@Value("${leave.type.code}")
	private  String leaveCodeType;
	public  boolean  isCDT(String type) {
		List<String> lsTypeCode = Arrays.asList(leaveCodeType.split("-"));
		boolean bol = Boolean.FALSE;
		if(lsTypeCode.contains(type))
			bol = Boolean.TRUE;
		return bol;
	}
}
