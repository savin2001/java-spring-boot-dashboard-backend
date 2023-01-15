package com.osukatech.adminDashboard.DTO;

public class EmployeeSaveDTO {
    //  New customer added

    private  String employee_name;
    private  String employee_email;
    private int employee_mobile;

    public EmployeeSaveDTO( String employee_name, String employee_email, int employee_mobile) {
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.employee_mobile = employee_mobile;
    }

    public EmployeeSaveDTO() {
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public int getEmployee_mobile() {
        return employee_mobile;
    }

    public void setEmployee_mobile(int employee_mobile) {
        this.employee_mobile = employee_mobile;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", employee_name='" + employee_name + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", employee_mobile=" + employee_mobile +
                '}';
    }
}
