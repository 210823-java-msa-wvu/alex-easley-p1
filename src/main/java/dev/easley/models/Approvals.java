package dev.easley.models;

public class Approvals {

    private Integer approval_id;
    private Integer request_id;
    private Boolean dsapproval;
    private Boolean dsinforequest;
    private String dsdenialreason;
    private Boolean dhapproval;
    private Boolean dhinforequest;
    private Boolean dhinforequestds;
    private String dhdenialreason;
    private Boolean bcapproval;
    private Boolean bcinforequestds;
    private Boolean bcinforequestdh;
    private Boolean bcinforequeste;
    private String employeeinfo;
    private String dsinfo;
    private String dhinfo;


    public Approvals() {
    }

    public Integer getApproval_id() { return approval_id;}

    public void setApproval_id() { this.approval_id = approval_id; }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public Boolean getDsapproval() {
        return dsapproval;
    }

    public void setDsapproval(Boolean dsapproval) {
        this.dsapproval = dsapproval;
    }

    public Boolean getDsinforequest() { return dsinforequest;}

    public void setDsinforequest(Boolean dsinforequest) { this.dsinforequest = dsinforequest; }

    public String getDsdenialreason() {
        return dsdenialreason;
    }

    public void setDsdenialreason(String dsdenialreason) {
        this.dsdenialreason = dsdenialreason;
    }

    public Boolean getDhapproval() {
        return dhapproval;
    }

    public void setDhapproval(Boolean dhapproval) {
        this.dhapproval = dhapproval;
    }

    public Boolean getDhinforequest() {
        return dhinforequest;
    }

    public void setDhinforequest(Boolean dhinforequest) {
        this.dhinforequest = dhinforequest;
    }

    public Boolean getDhinforequestds() {
        return dhinforequestds;
    }

    public void setDhinforequestds(Boolean dhinforequestds) {
        this.dhinforequestds = dhinforequestds;
    }

    public String getDhdenialreason() {
        return dhdenialreason;
    }

    public void setDhdenialreason(String dhdenialreason) {
        this.dhdenialreason = dhdenialreason;
    }

    public Boolean getBcapproval() {
        return bcapproval;
    }

    public void setBcapproval(Boolean bcapproval) {
        this.bcapproval = bcapproval;
    }

    public Boolean getBcinforequestds() {
        return bcinforequestds;
    }

    public void setBcinforequestds(Boolean bcinforequestds) {
        this.bcinforequestds = bcinforequestds;
    }

    public Boolean getBcinforequestdh() {
        return bcinforequestdh;
    }

    public void setBcinforequestdh(Boolean bcinforequestdh) {
        this.bcinforequestdh = bcinforequestdh;
    }

    public Boolean getBcinforequeste() { return bcinforequeste; }

    public void setBcinforequeste(Boolean bcinforequeste) { this.bcinforequeste = bcinforequeste; }

    public String getEmployeeinfo() {
        return employeeinfo;
    }

    public void setEmployeeinfo(String employeeinfo) {
        this.employeeinfo = employeeinfo;
    }

    public String getDsinfo() {
        return dsinfo;
    }

    public void setDsinfo(String dsinfo) {
        this.dsinfo = dsinfo;
    }

    public String getDhinfo() {
        return dhinfo;
    }

    public void setDhinfo(String dhinfo) {
        this.dhinfo = dhinfo;
    }

    @Override
    public String toString() {
        return "Approvals{" +
                "approval_id=" + approval_id +
                ", request_id=" + request_id +
                ", dsapproval=" + dsapproval +
                ", dsinforequest=" + dsinforequest +
                ", dsdenialreason='" + dsdenialreason + '\'' +
                ", dhapproval=" + dhapproval +
                ", dhinforequest=" + dhinforequest +
                ", dhinforequestds=" + dhinforequestds +
                ", dhdenialreason='" + dhdenialreason + '\'' +
                ", bcapproval=" + bcapproval +
                ", bcinforequestds=" + bcinforequestds +
                ", bcinforequestdh=" + bcinforequestdh +
                ", bcinforequeste=" + bcinforequeste +
                ", employeeinfo='" + employeeinfo + '\'' +
                ", dsinfo='" + dsinfo + '\'' +
                ", dhinfo='" + dhinfo + '\'' +
                '}';
    }
}
