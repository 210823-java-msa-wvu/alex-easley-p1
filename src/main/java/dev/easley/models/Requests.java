package dev.easley.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Requests {


    private String eventType;
    private Integer employeeId;
    private String grade;
    private String justify;
    private Integer cost;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date reqDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    private String location;
    private String status;
    private String passGrade;
    private Boolean passed;
    private Integer requestId;

    public Requests() {
    }

    public Requests(Integer employeeId, Integer requestId) {
        this.employeeId = employeeId;
        this.requestId = requestId;
    }
    public Requests(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Requests(String eventType, String grade, String justify, Integer cost, String description, Date reqDate, Date startDate, String location) {
        this.eventType = eventType;
        this.grade = grade;
        this.justify = justify;
        this.cost = cost;
        this.description = description;
        this.reqDate = reqDate;
        this.startDate = startDate;
        this.location = location;
    }

    public Requests(String eventType, String grade, String justify, Integer cost, String description, Date reqDate, Date startDate, String location, String status, String passGrade, Boolean passed) {
        this.eventType = eventType;
        this.grade = grade;
        this.justify = justify;
        this.cost = cost;
        this.description = description;
        this.reqDate = reqDate;
        this.startDate = startDate;
        this.location = location;
        this.status = status;
        this.passGrade = passGrade;
        this.passed = passed;
    }

    public Requests(String eventType, Integer employeeId, String grade, String justify, Integer cost, String description, Date reqDate, Date startDate, String location, String status, String passGrade, Boolean passed, Integer requestId) {
        this.eventType = eventType;
        this.employeeId = employeeId;
        this.grade = grade;
        this.justify = justify;
        this.cost = cost;
        this.description = description;
        this.reqDate = reqDate;
        this.startDate = startDate;
        this.location = location;
        this.status = status;
        this.passGrade = passGrade;
        this.passed = passed;
        this.requestId = requestId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getJustify() {
        return justify;
    }

    public void setJustify(String justify) {
        this.justify = justify;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassGrade() {
        return passGrade;
    }

    public void setPassGrade(String passGrade) {
        this.passGrade = passGrade;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Integer getRequestId() { return requestId; }

    public void setRequestId(Integer requestId) { this.requestId = requestId; }




    @Override
    public String toString() {
        return "Requests{" +
                "eventType='" + eventType + '\'' +
                ", employeeId=" + employeeId +
                ", grade='" + grade + '\'' +
                ", justify='" + justify + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", reqDate='" + reqDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", passGrade='" + passGrade + '\'' +
                ", passed=" + passed +
                '}';
    }
}
