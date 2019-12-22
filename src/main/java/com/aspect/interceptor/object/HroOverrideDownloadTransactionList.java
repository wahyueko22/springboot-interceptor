package com.aspect.interceptor.object;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;


//@CsvBindByNameOrder
public class HroOverrideDownloadTransactionList {
	
	@CsvBindByPosition(position = 0)
	@CsvBindByName(column = "Id")
	private String id;
	
	@CsvBindByPosition(position = 1)
	@CsvBindByName(column = "Requester")
	private String requester;
	
	@CsvBindByPosition(position = 2)
	@CsvBindByName(column = "Name")
	private String name;
	
	@CsvBindByPosition(position = 3)
	@CsvBindByName(column = "Status")
	private String status;
	
	@CsvBindByPosition(position = 4)
	@CsvBindByName(column = "Agent")
	private String agent;
	
	@CsvBindByPosition(position = 5)
	@CsvBindByName(column = "Type")
	private String type;
	
	@CsvBindByPosition(position = 6)
	@CsvBindByName(column = "OverrideDate")
	private String overrideDate;
	
	@CsvBindByPosition(position = 7)
	@CsvBindByName(column = "OverrideTime")
	private String overrideTime;
	
	@CsvBindByPosition(position = 8)
	@CsvBindByName(column = "AreaCode")
	private String areaCode;
	
	@CsvBindByPosition(position = 9)
	@CsvBindByName(column = "Description")
	private String description;
	
	@CsvBindByPosition(position = 10)
	@CsvBindByName(column = "CreatedTimestamp")
	private String createdTimestamp;
	
	@CsvBindByPosition(position = 11)
	@CsvBindByName(column = "CreatedBy")
	private String createdBy;
	
	@CsvBindByPosition(position = 12)
	@CsvBindByName(column = "ModifiedTimestamp")
	private String modifiedTimestamp;
	
	@CsvBindByPosition(position = 13)
	@CsvBindByName(column = "ModifiedBy")
	private String modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOverrideDate() {
		return overrideDate;
	}

	public void setOverrideDate(String overrideDate) {
		this.overrideDate = overrideDate;
	}

	public String getOverrideTime() {
		return overrideTime;
	}

	public void setOverrideTime(String overrideTime) {
		this.overrideTime = overrideTime;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(String modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
