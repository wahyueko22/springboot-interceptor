package com.aspect.interceptor.object;


public class EmployeeGeneralSapDTO {
    private String username;
    private String employee_id;
    private String name;
    private String echelon;
    private String grade;
    private String manager;
    private String branch_code;
    private String area_code;
    private String branch_type;
    private String email;

    public String getEmployee_id() {
        return employee_id;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public String getBranch_type() {
        return branch_type;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEchelon() {
		return echelon;
	}

	public void setEchelon(String echelon) {
		this.echelon = echelon;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public void setBranch_type(String branch_type) {
		this.branch_type = branch_type;
	}
    
    
    
}
