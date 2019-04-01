package cn.com.syscom.mysql.model;

public class ProcessParam {
    private Integer interfaceId;

    private String institutionNum;

    private String swtichtypeVisa;

    private String reportingnameVisa;

    private String sicCode;

    private String currencyCode;

    private String defaulttermNum;

    private Integer preauthType;

    private Integer preauthNum;

    private Integer messageDuration;

    private Integer maxTimeout;

    private Integer reportTime;

    private Integer maxProcessingtime;

    private Integer maxResendnum;

    private String autoSignon;

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInstitutionNum() {
        return institutionNum;
    }

    public void setInstitutionNum(String institutionNum) {
        this.institutionNum = institutionNum == null ? null : institutionNum.trim();
    }

    public String getSwtichtypeVisa() {
        return swtichtypeVisa;
    }

    public void setSwtichtypeVisa(String swtichtypeVisa) {
        this.swtichtypeVisa = swtichtypeVisa == null ? null : swtichtypeVisa.trim();
    }

    public String getReportingnameVisa() {
        return reportingnameVisa;
    }

    public void setReportingnameVisa(String reportingnameVisa) {
        this.reportingnameVisa = reportingnameVisa == null ? null : reportingnameVisa.trim();
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode == null ? null : sicCode.trim();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public String getDefaulttermNum() {
        return defaulttermNum;
    }

    public void setDefaulttermNum(String defaulttermNum) {
        this.defaulttermNum = defaulttermNum == null ? null : defaulttermNum.trim();
    }

    public Integer getPreauthType() {
        return preauthType;
    }

    public void setPreauthType(Integer preauthType) {
        this.preauthType = preauthType;
    }

    public Integer getPreauthNum() {
        return preauthNum;
    }

    public void setPreauthNum(Integer preauthNum) {
        this.preauthNum = preauthNum;
    }

    public Integer getMessageDuration() {
        return messageDuration;
    }

    public void setMessageDuration(Integer messageDuration) {
        this.messageDuration = messageDuration;
    }

    public Integer getMaxTimeout() {
        return maxTimeout;
    }

    public void setMaxTimeout(Integer maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    public Integer getReportTime() {
        return reportTime;
    }

    public void setReportTime(Integer reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getMaxProcessingtime() {
        return maxProcessingtime;
    }

    public void setMaxProcessingtime(Integer maxProcessingtime) {
        this.maxProcessingtime = maxProcessingtime;
    }

    public Integer getMaxResendnum() {
        return maxResendnum;
    }

    public void setMaxResendnum(Integer maxResendnum) {
        this.maxResendnum = maxResendnum;
    }

    public String getAutoSignon() {
        return autoSignon;
    }

    public void setAutoSignon(String autoSignon) {
        this.autoSignon = autoSignon == null ? null : autoSignon.trim();
    }
}