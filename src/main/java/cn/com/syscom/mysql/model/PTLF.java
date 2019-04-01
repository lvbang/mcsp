package cn.com.syscom.mysql.model;

import java.math.BigDecimal;
import java.util.Date;

public class PTLF extends PTLFKey {
    private String fiid;

    private String cardType;

    private String expDat;

    private String tranType;

    private String tranCde;

    private BigDecimal tranAmount;

    private String retailerId;

    private String seqNum;

    private String aprvCde;

    private String respCde;

    private String originator;

    private String responder;

    private Date tranDat;

    private Date entryTim;

    private Date exitTim;

    private Date reEntryTim;

    private Date tranTim;

    private String issCde;

    private String termId;

    private String termCity;

    private String termOwnerName;

    private String termNameLoc;

    private String rvrlCde;

    private String pinInd;

    private String trackInd;

    private String tranCrncyCde;

    private String tranCrncyAmt;

    private String billCrncyCde;

    private String billCrncyAmt;

    private String billConversionRate;

    private String setlCrncyCde;

    private String setlCrncyAmt;

    private String setlConversionRate;

    private Date localDate;

    private Date localTime;

    private String merchantType;

    private String acqCountyrCode;

    private String pointServiceEntryCode;

    private String cardSeqNum;

    private String pointServiceCondCode;

    private String pointServicePinCode;

    private String transactionFee;

    private String acqInstCode;

    private String forwInstCode;

    private String additionalRespData;

    private String additionalData;

    private String additionalAmount;

    private String chipDataField55;

    private String additionalPosInfor;

    private String customPaymentService;

    public String getFiid() {
        return fiid;
    }

    public void setFiid(String fiid) {
        this.fiid = fiid == null ? null : fiid.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getExpDat() {
        return expDat;
    }

    public void setExpDat(String expDat) {
        this.expDat = expDat == null ? null : expDat.trim();
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType == null ? null : tranType.trim();
    }

    public String getTranCde() {
        return tranCde;
    }

    public void setTranCde(String tranCde) {
        this.tranCde = tranCde == null ? null : tranCde.trim();
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId == null ? null : retailerId.trim();
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum == null ? null : seqNum.trim();
    }

    public String getAprvCde() {
        return aprvCde;
    }

    public void setAprvCde(String aprvCde) {
        this.aprvCde = aprvCde == null ? null : aprvCde.trim();
    }

    public String getRespCde() {
        return respCde;
    }

    public void setRespCde(String respCde) {
        this.respCde = respCde == null ? null : respCde.trim();
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator == null ? null : originator.trim();
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder == null ? null : responder.trim();
    }

    public Date getTranDat() {
        return tranDat;
    }

    public void setTranDat(Date tranDat) {
        this.tranDat = tranDat;
    }

    public Date getEntryTim() {
        return entryTim;
    }

    public void setEntryTim(Date entryTim) {
        this.entryTim = entryTim;
    }

    public Date getExitTim() {
        return exitTim;
    }

    public void setExitTim(Date exitTim) {
        this.exitTim = exitTim;
    }

    public Date getReEntryTim() {
        return reEntryTim;
    }

    public void setReEntryTim(Date reEntryTim) {
        this.reEntryTim = reEntryTim;
    }

    public Date getTranTim() {
        return tranTim;
    }

    public void setTranTim(Date tranTim) {
        this.tranTim = tranTim;
    }

    public String getIssCde() {
        return issCde;
    }

    public void setIssCde(String issCde) {
        this.issCde = issCde == null ? null : issCde.trim();
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId == null ? null : termId.trim();
    }

    public String getTermCity() {
        return termCity;
    }

    public void setTermCity(String termCity) {
        this.termCity = termCity == null ? null : termCity.trim();
    }

    public String getTermOwnerName() {
        return termOwnerName;
    }

    public void setTermOwnerName(String termOwnerName) {
        this.termOwnerName = termOwnerName == null ? null : termOwnerName.trim();
    }

    public String getTermNameLoc() {
        return termNameLoc;
    }

    public void setTermNameLoc(String termNameLoc) {
        this.termNameLoc = termNameLoc == null ? null : termNameLoc.trim();
    }

    public String getRvrlCde() {
        return rvrlCde;
    }

    public void setRvrlCde(String rvrlCde) {
        this.rvrlCde = rvrlCde == null ? null : rvrlCde.trim();
    }

    public String getPinInd() {
        return pinInd;
    }

    public void setPinInd(String pinInd) {
        this.pinInd = pinInd == null ? null : pinInd.trim();
    }

    public String getTrackInd() {
        return trackInd;
    }

    public void setTrackInd(String trackInd) {
        this.trackInd = trackInd == null ? null : trackInd.trim();
    }

    public String getTranCrncyCde() {
        return tranCrncyCde;
    }

    public void setTranCrncyCde(String tranCrncyCde) {
        this.tranCrncyCde = tranCrncyCde == null ? null : tranCrncyCde.trim();
    }

    public String getTranCrncyAmt() {
        return tranCrncyAmt;
    }

    public void setTranCrncyAmt(String tranCrncyAmt) {
        this.tranCrncyAmt = tranCrncyAmt == null ? null : tranCrncyAmt.trim();
    }

    public String getBillCrncyCde() {
        return billCrncyCde;
    }

    public void setBillCrncyCde(String billCrncyCde) {
        this.billCrncyCde = billCrncyCde == null ? null : billCrncyCde.trim();
    }

    public String getBillCrncyAmt() {
        return billCrncyAmt;
    }

    public void setBillCrncyAmt(String billCrncyAmt) {
        this.billCrncyAmt = billCrncyAmt == null ? null : billCrncyAmt.trim();
    }

    public String getBillConversionRate() {
        return billConversionRate;
    }

    public void setBillConversionRate(String billConversionRate) {
        this.billConversionRate = billConversionRate == null ? null : billConversionRate.trim();
    }

    public String getSetlCrncyCde() {
        return setlCrncyCde;
    }

    public void setSetlCrncyCde(String setlCrncyCde) {
        this.setlCrncyCde = setlCrncyCde == null ? null : setlCrncyCde.trim();
    }

    public String getSetlCrncyAmt() {
        return setlCrncyAmt;
    }

    public void setSetlCrncyAmt(String setlCrncyAmt) {
        this.setlCrncyAmt = setlCrncyAmt == null ? null : setlCrncyAmt.trim();
    }

    public String getSetlConversionRate() {
        return setlConversionRate;
    }

    public void setSetlConversionRate(String setlConversionRate) {
        this.setlConversionRate = setlConversionRate == null ? null : setlConversionRate.trim();
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    public String getAcqCountyrCode() {
        return acqCountyrCode;
    }

    public void setAcqCountyrCode(String acqCountyrCode) {
        this.acqCountyrCode = acqCountyrCode == null ? null : acqCountyrCode.trim();
    }

    public String getPointServiceEntryCode() {
        return pointServiceEntryCode;
    }

    public void setPointServiceEntryCode(String pointServiceEntryCode) {
        this.pointServiceEntryCode = pointServiceEntryCode == null ? null : pointServiceEntryCode.trim();
    }

    public String getCardSeqNum() {
        return cardSeqNum;
    }

    public void setCardSeqNum(String cardSeqNum) {
        this.cardSeqNum = cardSeqNum == null ? null : cardSeqNum.trim();
    }

    public String getPointServiceCondCode() {
        return pointServiceCondCode;
    }

    public void setPointServiceCondCode(String pointServiceCondCode) {
        this.pointServiceCondCode = pointServiceCondCode == null ? null : pointServiceCondCode.trim();
    }

    public String getPointServicePinCode() {
        return pointServicePinCode;
    }

    public void setPointServicePinCode(String pointServicePinCode) {
        this.pointServicePinCode = pointServicePinCode == null ? null : pointServicePinCode.trim();
    }

    public String getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee) {
        this.transactionFee = transactionFee == null ? null : transactionFee.trim();
    }

    public String getAcqInstCode() {
        return acqInstCode;
    }

    public void setAcqInstCode(String acqInstCode) {
        this.acqInstCode = acqInstCode == null ? null : acqInstCode.trim();
    }

    public String getForwInstCode() {
        return forwInstCode;
    }

    public void setForwInstCode(String forwInstCode) {
        this.forwInstCode = forwInstCode == null ? null : forwInstCode.trim();
    }

    public String getAdditionalRespData() {
        return additionalRespData;
    }

    public void setAdditionalRespData(String additionalRespData) {
        this.additionalRespData = additionalRespData == null ? null : additionalRespData.trim();
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData == null ? null : additionalData.trim();
    }

    public String getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(String additionalAmount) {
        this.additionalAmount = additionalAmount == null ? null : additionalAmount.trim();
    }

    public String getChipDataField55() {
        return chipDataField55;
    }

    public void setChipDataField55(String chipDataField55) {
        this.chipDataField55 = chipDataField55 == null ? null : chipDataField55.trim();
    }

    public String getAdditionalPosInfor() {
        return additionalPosInfor;
    }

    public void setAdditionalPosInfor(String additionalPosInfor) {
        this.additionalPosInfor = additionalPosInfor == null ? null : additionalPosInfor.trim();
    }

    public String getCustomPaymentService() {
        return customPaymentService;
    }

    public void setCustomPaymentService(String customPaymentService) {
        this.customPaymentService = customPaymentService == null ? null : customPaymentService.trim();
    }
}