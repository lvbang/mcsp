package cn.com.syscom.mysql.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PTLFExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PTLFExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andDatDatIsNull() {
            addCriterion("DAT_DAT is null");
            return (Criteria) this;
        }

        public Criteria andDatDatIsNotNull() {
            addCriterion("DAT_DAT is not null");
            return (Criteria) this;
        }

        public Criteria andDatDatEqualTo(Date value) {
            addCriterionForJDBCDate("DAT_DAT =", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatNotEqualTo(Date value) {
            addCriterionForJDBCDate("DAT_DAT <>", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatGreaterThan(Date value) {
            addCriterionForJDBCDate("DAT_DAT >", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DAT_DAT >=", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatLessThan(Date value) {
            addCriterionForJDBCDate("DAT_DAT <", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DAT_DAT <=", value, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatIn(List<Date> values) {
            addCriterionForJDBCDate("DAT_DAT in", values, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatNotIn(List<Date> values) {
            addCriterionForJDBCDate("DAT_DAT not in", values, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DAT_DAT between", value1, value2, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatDatNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DAT_DAT not between", value1, value2, "datDat");
            return (Criteria) this;
        }

        public Criteria andDatTimIsNull() {
            addCriterion("DAT_TIM is null");
            return (Criteria) this;
        }

        public Criteria andDatTimIsNotNull() {
            addCriterion("DAT_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andDatTimEqualTo(Date value) {
            addCriterionForJDBCTime("DAT_TIM =", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimNotEqualTo(Date value) {
            addCriterionForJDBCTime("DAT_TIM <>", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimGreaterThan(Date value) {
            addCriterionForJDBCTime("DAT_TIM >", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("DAT_TIM >=", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimLessThan(Date value) {
            addCriterionForJDBCTime("DAT_TIM <", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("DAT_TIM <=", value, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimIn(List<Date> values) {
            addCriterionForJDBCTime("DAT_TIM in", values, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimNotIn(List<Date> values) {
            addCriterionForJDBCTime("DAT_TIM not in", values, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("DAT_TIM between", value1, value2, "datTim");
            return (Criteria) this;
        }

        public Criteria andDatTimNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("DAT_TIM not between", value1, value2, "datTim");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNull() {
            addCriterion("CARD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("CARD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("CARD_NUM =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("CARD_NUM <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("CARD_NUM >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_NUM >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("CARD_NUM <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("CARD_NUM <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("CARD_NUM like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("CARD_NUM not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("CARD_NUM in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("CARD_NUM not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("CARD_NUM between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("CARD_NUM not between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andTraceNumberIsNull() {
            addCriterion("TRACE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTraceNumberIsNotNull() {
            addCriterion("TRACE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNumberEqualTo(String value) {
            addCriterion("TRACE_NUMBER =", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberNotEqualTo(String value) {
            addCriterion("TRACE_NUMBER <>", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberGreaterThan(String value) {
            addCriterion("TRACE_NUMBER >", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("TRACE_NUMBER >=", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberLessThan(String value) {
            addCriterion("TRACE_NUMBER <", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberLessThanOrEqualTo(String value) {
            addCriterion("TRACE_NUMBER <=", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberLike(String value) {
            addCriterion("TRACE_NUMBER like", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberNotLike(String value) {
            addCriterion("TRACE_NUMBER not like", value, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberIn(List<String> values) {
            addCriterion("TRACE_NUMBER in", values, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberNotIn(List<String> values) {
            addCriterion("TRACE_NUMBER not in", values, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberBetween(String value1, String value2) {
            addCriterion("TRACE_NUMBER between", value1, value2, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andTraceNumberNotBetween(String value1, String value2) {
            addCriterion("TRACE_NUMBER not between", value1, value2, "traceNumber");
            return (Criteria) this;
        }

        public Criteria andFiidIsNull() {
            addCriterion("FIID is null");
            return (Criteria) this;
        }

        public Criteria andFiidIsNotNull() {
            addCriterion("FIID is not null");
            return (Criteria) this;
        }

        public Criteria andFiidEqualTo(String value) {
            addCriterion("FIID =", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidNotEqualTo(String value) {
            addCriterion("FIID <>", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidGreaterThan(String value) {
            addCriterion("FIID >", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidGreaterThanOrEqualTo(String value) {
            addCriterion("FIID >=", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidLessThan(String value) {
            addCriterion("FIID <", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidLessThanOrEqualTo(String value) {
            addCriterion("FIID <=", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidLike(String value) {
            addCriterion("FIID like", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidNotLike(String value) {
            addCriterion("FIID not like", value, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidIn(List<String> values) {
            addCriterion("FIID in", values, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidNotIn(List<String> values) {
            addCriterion("FIID not in", values, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidBetween(String value1, String value2) {
            addCriterion("FIID between", value1, value2, "fiid");
            return (Criteria) this;
        }

        public Criteria andFiidNotBetween(String value1, String value2) {
            addCriterion("FIID not between", value1, value2, "fiid");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("CARD_TYPE =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("CARD_TYPE <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("CARD_TYPE >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("CARD_TYPE <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("CARD_TYPE like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("CARD_TYPE not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("CARD_TYPE in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("CARD_TYPE not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("CARD_TYPE between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_TYPE not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andExpDatIsNull() {
            addCriterion("EXP_DAT is null");
            return (Criteria) this;
        }

        public Criteria andExpDatIsNotNull() {
            addCriterion("EXP_DAT is not null");
            return (Criteria) this;
        }

        public Criteria andExpDatEqualTo(String value) {
            addCriterion("EXP_DAT =", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatNotEqualTo(String value) {
            addCriterion("EXP_DAT <>", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatGreaterThan(String value) {
            addCriterion("EXP_DAT >", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatGreaterThanOrEqualTo(String value) {
            addCriterion("EXP_DAT >=", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatLessThan(String value) {
            addCriterion("EXP_DAT <", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatLessThanOrEqualTo(String value) {
            addCriterion("EXP_DAT <=", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatLike(String value) {
            addCriterion("EXP_DAT like", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatNotLike(String value) {
            addCriterion("EXP_DAT not like", value, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatIn(List<String> values) {
            addCriterion("EXP_DAT in", values, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatNotIn(List<String> values) {
            addCriterion("EXP_DAT not in", values, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatBetween(String value1, String value2) {
            addCriterion("EXP_DAT between", value1, value2, "expDat");
            return (Criteria) this;
        }

        public Criteria andExpDatNotBetween(String value1, String value2) {
            addCriterion("EXP_DAT not between", value1, value2, "expDat");
            return (Criteria) this;
        }

        public Criteria andTranTypeIsNull() {
            addCriterion("TRAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTranTypeIsNotNull() {
            addCriterion("TRAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTranTypeEqualTo(String value) {
            addCriterion("TRAN_TYPE =", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeNotEqualTo(String value) {
            addCriterion("TRAN_TYPE <>", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeGreaterThan(String value) {
            addCriterion("TRAN_TYPE >", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_TYPE >=", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeLessThan(String value) {
            addCriterion("TRAN_TYPE <", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeLessThanOrEqualTo(String value) {
            addCriterion("TRAN_TYPE <=", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeLike(String value) {
            addCriterion("TRAN_TYPE like", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeNotLike(String value) {
            addCriterion("TRAN_TYPE not like", value, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeIn(List<String> values) {
            addCriterion("TRAN_TYPE in", values, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeNotIn(List<String> values) {
            addCriterion("TRAN_TYPE not in", values, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeBetween(String value1, String value2) {
            addCriterion("TRAN_TYPE between", value1, value2, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranTypeNotBetween(String value1, String value2) {
            addCriterion("TRAN_TYPE not between", value1, value2, "tranType");
            return (Criteria) this;
        }

        public Criteria andTranCdeIsNull() {
            addCriterion("TRAN_CDE is null");
            return (Criteria) this;
        }

        public Criteria andTranCdeIsNotNull() {
            addCriterion("TRAN_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andTranCdeEqualTo(String value) {
            addCriterion("TRAN_CDE =", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeNotEqualTo(String value) {
            addCriterion("TRAN_CDE <>", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeGreaterThan(String value) {
            addCriterion("TRAN_CDE >", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_CDE >=", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeLessThan(String value) {
            addCriterion("TRAN_CDE <", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeLessThanOrEqualTo(String value) {
            addCriterion("TRAN_CDE <=", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeLike(String value) {
            addCriterion("TRAN_CDE like", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeNotLike(String value) {
            addCriterion("TRAN_CDE not like", value, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeIn(List<String> values) {
            addCriterion("TRAN_CDE in", values, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeNotIn(List<String> values) {
            addCriterion("TRAN_CDE not in", values, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeBetween(String value1, String value2) {
            addCriterion("TRAN_CDE between", value1, value2, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranCdeNotBetween(String value1, String value2) {
            addCriterion("TRAN_CDE not between", value1, value2, "tranCde");
            return (Criteria) this;
        }

        public Criteria andTranAmountIsNull() {
            addCriterion("TRAN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTranAmountIsNotNull() {
            addCriterion("TRAN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTranAmountEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMOUNT =", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountNotEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMOUNT <>", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountGreaterThan(BigDecimal value) {
            addCriterion("TRAN_AMOUNT >", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMOUNT >=", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountLessThan(BigDecimal value) {
            addCriterion("TRAN_AMOUNT <", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRAN_AMOUNT <=", value, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountIn(List<BigDecimal> values) {
            addCriterion("TRAN_AMOUNT in", values, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountNotIn(List<BigDecimal> values) {
            addCriterion("TRAN_AMOUNT not in", values, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRAN_AMOUNT between", value1, value2, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andTranAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRAN_AMOUNT not between", value1, value2, "tranAmount");
            return (Criteria) this;
        }

        public Criteria andRetailerIdIsNull() {
            addCriterion("RETAILER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRetailerIdIsNotNull() {
            addCriterion("RETAILER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRetailerIdEqualTo(String value) {
            addCriterion("RETAILER_ID =", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdNotEqualTo(String value) {
            addCriterion("RETAILER_ID <>", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdGreaterThan(String value) {
            addCriterion("RETAILER_ID >", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdGreaterThanOrEqualTo(String value) {
            addCriterion("RETAILER_ID >=", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdLessThan(String value) {
            addCriterion("RETAILER_ID <", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdLessThanOrEqualTo(String value) {
            addCriterion("RETAILER_ID <=", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdLike(String value) {
            addCriterion("RETAILER_ID like", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdNotLike(String value) {
            addCriterion("RETAILER_ID not like", value, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdIn(List<String> values) {
            addCriterion("RETAILER_ID in", values, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdNotIn(List<String> values) {
            addCriterion("RETAILER_ID not in", values, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdBetween(String value1, String value2) {
            addCriterion("RETAILER_ID between", value1, value2, "retailerId");
            return (Criteria) this;
        }

        public Criteria andRetailerIdNotBetween(String value1, String value2) {
            addCriterion("RETAILER_ID not between", value1, value2, "retailerId");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNull() {
            addCriterion("SEQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNotNull() {
            addCriterion("SEQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNumEqualTo(String value) {
            addCriterion("SEQ_NUM =", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotEqualTo(String value) {
            addCriterion("SEQ_NUM <>", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThan(String value) {
            addCriterion("SEQ_NUM >", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ_NUM >=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThan(String value) {
            addCriterion("SEQ_NUM <", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThanOrEqualTo(String value) {
            addCriterion("SEQ_NUM <=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLike(String value) {
            addCriterion("SEQ_NUM like", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotLike(String value) {
            addCriterion("SEQ_NUM not like", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumIn(List<String> values) {
            addCriterion("SEQ_NUM in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotIn(List<String> values) {
            addCriterion("SEQ_NUM not in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumBetween(String value1, String value2) {
            addCriterion("SEQ_NUM between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotBetween(String value1, String value2) {
            addCriterion("SEQ_NUM not between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andAprvCdeIsNull() {
            addCriterion("APRV_CDE is null");
            return (Criteria) this;
        }

        public Criteria andAprvCdeIsNotNull() {
            addCriterion("APRV_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andAprvCdeEqualTo(String value) {
            addCriterion("APRV_CDE =", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeNotEqualTo(String value) {
            addCriterion("APRV_CDE <>", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeGreaterThan(String value) {
            addCriterion("APRV_CDE >", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeGreaterThanOrEqualTo(String value) {
            addCriterion("APRV_CDE >=", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeLessThan(String value) {
            addCriterion("APRV_CDE <", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeLessThanOrEqualTo(String value) {
            addCriterion("APRV_CDE <=", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeLike(String value) {
            addCriterion("APRV_CDE like", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeNotLike(String value) {
            addCriterion("APRV_CDE not like", value, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeIn(List<String> values) {
            addCriterion("APRV_CDE in", values, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeNotIn(List<String> values) {
            addCriterion("APRV_CDE not in", values, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeBetween(String value1, String value2) {
            addCriterion("APRV_CDE between", value1, value2, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andAprvCdeNotBetween(String value1, String value2) {
            addCriterion("APRV_CDE not between", value1, value2, "aprvCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeIsNull() {
            addCriterion("RESP_CDE is null");
            return (Criteria) this;
        }

        public Criteria andRespCdeIsNotNull() {
            addCriterion("RESP_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andRespCdeEqualTo(String value) {
            addCriterion("RESP_CDE =", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeNotEqualTo(String value) {
            addCriterion("RESP_CDE <>", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeGreaterThan(String value) {
            addCriterion("RESP_CDE >", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeGreaterThanOrEqualTo(String value) {
            addCriterion("RESP_CDE >=", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeLessThan(String value) {
            addCriterion("RESP_CDE <", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeLessThanOrEqualTo(String value) {
            addCriterion("RESP_CDE <=", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeLike(String value) {
            addCriterion("RESP_CDE like", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeNotLike(String value) {
            addCriterion("RESP_CDE not like", value, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeIn(List<String> values) {
            addCriterion("RESP_CDE in", values, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeNotIn(List<String> values) {
            addCriterion("RESP_CDE not in", values, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeBetween(String value1, String value2) {
            addCriterion("RESP_CDE between", value1, value2, "respCde");
            return (Criteria) this;
        }

        public Criteria andRespCdeNotBetween(String value1, String value2) {
            addCriterion("RESP_CDE not between", value1, value2, "respCde");
            return (Criteria) this;
        }

        public Criteria andOriginatorIsNull() {
            addCriterion("ORIGINATOR is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIsNotNull() {
            addCriterion("ORIGINATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorEqualTo(String value) {
            addCriterion("ORIGINATOR =", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotEqualTo(String value) {
            addCriterion("ORIGINATOR <>", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorGreaterThan(String value) {
            addCriterion("ORIGINATOR >", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINATOR >=", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorLessThan(String value) {
            addCriterion("ORIGINATOR <", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorLessThanOrEqualTo(String value) {
            addCriterion("ORIGINATOR <=", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorLike(String value) {
            addCriterion("ORIGINATOR like", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotLike(String value) {
            addCriterion("ORIGINATOR not like", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorIn(List<String> values) {
            addCriterion("ORIGINATOR in", values, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotIn(List<String> values) {
            addCriterion("ORIGINATOR not in", values, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorBetween(String value1, String value2) {
            addCriterion("ORIGINATOR between", value1, value2, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotBetween(String value1, String value2) {
            addCriterion("ORIGINATOR not between", value1, value2, "originator");
            return (Criteria) this;
        }

        public Criteria andResponderIsNull() {
            addCriterion("RESPONDER is null");
            return (Criteria) this;
        }

        public Criteria andResponderIsNotNull() {
            addCriterion("RESPONDER is not null");
            return (Criteria) this;
        }

        public Criteria andResponderEqualTo(String value) {
            addCriterion("RESPONDER =", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderNotEqualTo(String value) {
            addCriterion("RESPONDER <>", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderGreaterThan(String value) {
            addCriterion("RESPONDER >", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONDER >=", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderLessThan(String value) {
            addCriterion("RESPONDER <", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderLessThanOrEqualTo(String value) {
            addCriterion("RESPONDER <=", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderLike(String value) {
            addCriterion("RESPONDER like", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderNotLike(String value) {
            addCriterion("RESPONDER not like", value, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderIn(List<String> values) {
            addCriterion("RESPONDER in", values, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderNotIn(List<String> values) {
            addCriterion("RESPONDER not in", values, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderBetween(String value1, String value2) {
            addCriterion("RESPONDER between", value1, value2, "responder");
            return (Criteria) this;
        }

        public Criteria andResponderNotBetween(String value1, String value2) {
            addCriterion("RESPONDER not between", value1, value2, "responder");
            return (Criteria) this;
        }

        public Criteria andTranDatIsNull() {
            addCriterion("TRAN_DAT is null");
            return (Criteria) this;
        }

        public Criteria andTranDatIsNotNull() {
            addCriterion("TRAN_DAT is not null");
            return (Criteria) this;
        }

        public Criteria andTranDatEqualTo(Date value) {
            addCriterionForJDBCDate("TRAN_DAT =", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatNotEqualTo(Date value) {
            addCriterionForJDBCDate("TRAN_DAT <>", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatGreaterThan(Date value) {
            addCriterionForJDBCDate("TRAN_DAT >", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TRAN_DAT >=", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatLessThan(Date value) {
            addCriterionForJDBCDate("TRAN_DAT <", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TRAN_DAT <=", value, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatIn(List<Date> values) {
            addCriterionForJDBCDate("TRAN_DAT in", values, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatNotIn(List<Date> values) {
            addCriterionForJDBCDate("TRAN_DAT not in", values, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TRAN_DAT between", value1, value2, "tranDat");
            return (Criteria) this;
        }

        public Criteria andTranDatNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TRAN_DAT not between", value1, value2, "tranDat");
            return (Criteria) this;
        }

        public Criteria andEntryTimIsNull() {
            addCriterion("ENTRY_TIM is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimIsNotNull() {
            addCriterion("ENTRY_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimEqualTo(Date value) {
            addCriterion("ENTRY_TIM =", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimNotEqualTo(Date value) {
            addCriterion("ENTRY_TIM <>", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimGreaterThan(Date value) {
            addCriterion("ENTRY_TIM >", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimGreaterThanOrEqualTo(Date value) {
            addCriterion("ENTRY_TIM >=", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimLessThan(Date value) {
            addCriterion("ENTRY_TIM <", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimLessThanOrEqualTo(Date value) {
            addCriterion("ENTRY_TIM <=", value, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimIn(List<Date> values) {
            addCriterion("ENTRY_TIM in", values, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimNotIn(List<Date> values) {
            addCriterion("ENTRY_TIM not in", values, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimBetween(Date value1, Date value2) {
            addCriterion("ENTRY_TIM between", value1, value2, "entryTim");
            return (Criteria) this;
        }

        public Criteria andEntryTimNotBetween(Date value1, Date value2) {
            addCriterion("ENTRY_TIM not between", value1, value2, "entryTim");
            return (Criteria) this;
        }

        public Criteria andExitTimIsNull() {
            addCriterion("EXIT_TIM is null");
            return (Criteria) this;
        }

        public Criteria andExitTimIsNotNull() {
            addCriterion("EXIT_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andExitTimEqualTo(Date value) {
            addCriterion("EXIT_TIM =", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimNotEqualTo(Date value) {
            addCriterion("EXIT_TIM <>", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimGreaterThan(Date value) {
            addCriterion("EXIT_TIM >", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimGreaterThanOrEqualTo(Date value) {
            addCriterion("EXIT_TIM >=", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimLessThan(Date value) {
            addCriterion("EXIT_TIM <", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimLessThanOrEqualTo(Date value) {
            addCriterion("EXIT_TIM <=", value, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimIn(List<Date> values) {
            addCriterion("EXIT_TIM in", values, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimNotIn(List<Date> values) {
            addCriterion("EXIT_TIM not in", values, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimBetween(Date value1, Date value2) {
            addCriterion("EXIT_TIM between", value1, value2, "exitTim");
            return (Criteria) this;
        }

        public Criteria andExitTimNotBetween(Date value1, Date value2) {
            addCriterion("EXIT_TIM not between", value1, value2, "exitTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimIsNull() {
            addCriterion("RE_ENTRY_TIM is null");
            return (Criteria) this;
        }

        public Criteria andReEntryTimIsNotNull() {
            addCriterion("RE_ENTRY_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andReEntryTimEqualTo(Date value) {
            addCriterion("RE_ENTRY_TIM =", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimNotEqualTo(Date value) {
            addCriterion("RE_ENTRY_TIM <>", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimGreaterThan(Date value) {
            addCriterion("RE_ENTRY_TIM >", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimGreaterThanOrEqualTo(Date value) {
            addCriterion("RE_ENTRY_TIM >=", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimLessThan(Date value) {
            addCriterion("RE_ENTRY_TIM <", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimLessThanOrEqualTo(Date value) {
            addCriterion("RE_ENTRY_TIM <=", value, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimIn(List<Date> values) {
            addCriterion("RE_ENTRY_TIM in", values, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimNotIn(List<Date> values) {
            addCriterion("RE_ENTRY_TIM not in", values, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimBetween(Date value1, Date value2) {
            addCriterion("RE_ENTRY_TIM between", value1, value2, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andReEntryTimNotBetween(Date value1, Date value2) {
            addCriterion("RE_ENTRY_TIM not between", value1, value2, "reEntryTim");
            return (Criteria) this;
        }

        public Criteria andTranTimIsNull() {
            addCriterion("TRAN_TIM is null");
            return (Criteria) this;
        }

        public Criteria andTranTimIsNotNull() {
            addCriterion("TRAN_TIM is not null");
            return (Criteria) this;
        }

        public Criteria andTranTimEqualTo(Date value) {
            addCriterion("TRAN_TIM =", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimNotEqualTo(Date value) {
            addCriterion("TRAN_TIM <>", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimGreaterThan(Date value) {
            addCriterion("TRAN_TIM >", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimGreaterThanOrEqualTo(Date value) {
            addCriterion("TRAN_TIM >=", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimLessThan(Date value) {
            addCriterion("TRAN_TIM <", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimLessThanOrEqualTo(Date value) {
            addCriterion("TRAN_TIM <=", value, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimIn(List<Date> values) {
            addCriterion("TRAN_TIM in", values, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimNotIn(List<Date> values) {
            addCriterion("TRAN_TIM not in", values, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimBetween(Date value1, Date value2) {
            addCriterion("TRAN_TIM between", value1, value2, "tranTim");
            return (Criteria) this;
        }

        public Criteria andTranTimNotBetween(Date value1, Date value2) {
            addCriterion("TRAN_TIM not between", value1, value2, "tranTim");
            return (Criteria) this;
        }

        public Criteria andIssCdeIsNull() {
            addCriterion("ISS_CDE is null");
            return (Criteria) this;
        }

        public Criteria andIssCdeIsNotNull() {
            addCriterion("ISS_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andIssCdeEqualTo(String value) {
            addCriterion("ISS_CDE =", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeNotEqualTo(String value) {
            addCriterion("ISS_CDE <>", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeGreaterThan(String value) {
            addCriterion("ISS_CDE >", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeGreaterThanOrEqualTo(String value) {
            addCriterion("ISS_CDE >=", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeLessThan(String value) {
            addCriterion("ISS_CDE <", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeLessThanOrEqualTo(String value) {
            addCriterion("ISS_CDE <=", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeLike(String value) {
            addCriterion("ISS_CDE like", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeNotLike(String value) {
            addCriterion("ISS_CDE not like", value, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeIn(List<String> values) {
            addCriterion("ISS_CDE in", values, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeNotIn(List<String> values) {
            addCriterion("ISS_CDE not in", values, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeBetween(String value1, String value2) {
            addCriterion("ISS_CDE between", value1, value2, "issCde");
            return (Criteria) this;
        }

        public Criteria andIssCdeNotBetween(String value1, String value2) {
            addCriterion("ISS_CDE not between", value1, value2, "issCde");
            return (Criteria) this;
        }

        public Criteria andTermIdIsNull() {
            addCriterion("TERM_ID is null");
            return (Criteria) this;
        }

        public Criteria andTermIdIsNotNull() {
            addCriterion("TERM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTermIdEqualTo(String value) {
            addCriterion("TERM_ID =", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdNotEqualTo(String value) {
            addCriterion("TERM_ID <>", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdGreaterThan(String value) {
            addCriterion("TERM_ID >", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_ID >=", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdLessThan(String value) {
            addCriterion("TERM_ID <", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdLessThanOrEqualTo(String value) {
            addCriterion("TERM_ID <=", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdLike(String value) {
            addCriterion("TERM_ID like", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdNotLike(String value) {
            addCriterion("TERM_ID not like", value, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdIn(List<String> values) {
            addCriterion("TERM_ID in", values, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdNotIn(List<String> values) {
            addCriterion("TERM_ID not in", values, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdBetween(String value1, String value2) {
            addCriterion("TERM_ID between", value1, value2, "termId");
            return (Criteria) this;
        }

        public Criteria andTermIdNotBetween(String value1, String value2) {
            addCriterion("TERM_ID not between", value1, value2, "termId");
            return (Criteria) this;
        }

        public Criteria andTermCityIsNull() {
            addCriterion("TERM_CITY is null");
            return (Criteria) this;
        }

        public Criteria andTermCityIsNotNull() {
            addCriterion("TERM_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andTermCityEqualTo(String value) {
            addCriterion("TERM_CITY =", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityNotEqualTo(String value) {
            addCriterion("TERM_CITY <>", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityGreaterThan(String value) {
            addCriterion("TERM_CITY >", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_CITY >=", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityLessThan(String value) {
            addCriterion("TERM_CITY <", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityLessThanOrEqualTo(String value) {
            addCriterion("TERM_CITY <=", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityLike(String value) {
            addCriterion("TERM_CITY like", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityNotLike(String value) {
            addCriterion("TERM_CITY not like", value, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityIn(List<String> values) {
            addCriterion("TERM_CITY in", values, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityNotIn(List<String> values) {
            addCriterion("TERM_CITY not in", values, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityBetween(String value1, String value2) {
            addCriterion("TERM_CITY between", value1, value2, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermCityNotBetween(String value1, String value2) {
            addCriterion("TERM_CITY not between", value1, value2, "termCity");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameIsNull() {
            addCriterion("TERM_OWNER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameIsNotNull() {
            addCriterion("TERM_OWNER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameEqualTo(String value) {
            addCriterion("TERM_OWNER_NAME =", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameNotEqualTo(String value) {
            addCriterion("TERM_OWNER_NAME <>", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameGreaterThan(String value) {
            addCriterion("TERM_OWNER_NAME >", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_OWNER_NAME >=", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameLessThan(String value) {
            addCriterion("TERM_OWNER_NAME <", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("TERM_OWNER_NAME <=", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameLike(String value) {
            addCriterion("TERM_OWNER_NAME like", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameNotLike(String value) {
            addCriterion("TERM_OWNER_NAME not like", value, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameIn(List<String> values) {
            addCriterion("TERM_OWNER_NAME in", values, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameNotIn(List<String> values) {
            addCriterion("TERM_OWNER_NAME not in", values, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameBetween(String value1, String value2) {
            addCriterion("TERM_OWNER_NAME between", value1, value2, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermOwnerNameNotBetween(String value1, String value2) {
            addCriterion("TERM_OWNER_NAME not between", value1, value2, "termOwnerName");
            return (Criteria) this;
        }

        public Criteria andTermNameLocIsNull() {
            addCriterion("TERM_NAME_LOC is null");
            return (Criteria) this;
        }

        public Criteria andTermNameLocIsNotNull() {
            addCriterion("TERM_NAME_LOC is not null");
            return (Criteria) this;
        }

        public Criteria andTermNameLocEqualTo(String value) {
            addCriterion("TERM_NAME_LOC =", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocNotEqualTo(String value) {
            addCriterion("TERM_NAME_LOC <>", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocGreaterThan(String value) {
            addCriterion("TERM_NAME_LOC >", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_NAME_LOC >=", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocLessThan(String value) {
            addCriterion("TERM_NAME_LOC <", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocLessThanOrEqualTo(String value) {
            addCriterion("TERM_NAME_LOC <=", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocLike(String value) {
            addCriterion("TERM_NAME_LOC like", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocNotLike(String value) {
            addCriterion("TERM_NAME_LOC not like", value, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocIn(List<String> values) {
            addCriterion("TERM_NAME_LOC in", values, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocNotIn(List<String> values) {
            addCriterion("TERM_NAME_LOC not in", values, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocBetween(String value1, String value2) {
            addCriterion("TERM_NAME_LOC between", value1, value2, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andTermNameLocNotBetween(String value1, String value2) {
            addCriterion("TERM_NAME_LOC not between", value1, value2, "termNameLoc");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeIsNull() {
            addCriterion("RVRL_CDE is null");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeIsNotNull() {
            addCriterion("RVRL_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeEqualTo(String value) {
            addCriterion("RVRL_CDE =", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeNotEqualTo(String value) {
            addCriterion("RVRL_CDE <>", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeGreaterThan(String value) {
            addCriterion("RVRL_CDE >", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeGreaterThanOrEqualTo(String value) {
            addCriterion("RVRL_CDE >=", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeLessThan(String value) {
            addCriterion("RVRL_CDE <", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeLessThanOrEqualTo(String value) {
            addCriterion("RVRL_CDE <=", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeLike(String value) {
            addCriterion("RVRL_CDE like", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeNotLike(String value) {
            addCriterion("RVRL_CDE not like", value, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeIn(List<String> values) {
            addCriterion("RVRL_CDE in", values, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeNotIn(List<String> values) {
            addCriterion("RVRL_CDE not in", values, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeBetween(String value1, String value2) {
            addCriterion("RVRL_CDE between", value1, value2, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andRvrlCdeNotBetween(String value1, String value2) {
            addCriterion("RVRL_CDE not between", value1, value2, "rvrlCde");
            return (Criteria) this;
        }

        public Criteria andPinIndIsNull() {
            addCriterion("PIN_IND is null");
            return (Criteria) this;
        }

        public Criteria andPinIndIsNotNull() {
            addCriterion("PIN_IND is not null");
            return (Criteria) this;
        }

        public Criteria andPinIndEqualTo(String value) {
            addCriterion("PIN_IND =", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndNotEqualTo(String value) {
            addCriterion("PIN_IND <>", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndGreaterThan(String value) {
            addCriterion("PIN_IND >", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndGreaterThanOrEqualTo(String value) {
            addCriterion("PIN_IND >=", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndLessThan(String value) {
            addCriterion("PIN_IND <", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndLessThanOrEqualTo(String value) {
            addCriterion("PIN_IND <=", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndLike(String value) {
            addCriterion("PIN_IND like", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndNotLike(String value) {
            addCriterion("PIN_IND not like", value, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndIn(List<String> values) {
            addCriterion("PIN_IND in", values, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndNotIn(List<String> values) {
            addCriterion("PIN_IND not in", values, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndBetween(String value1, String value2) {
            addCriterion("PIN_IND between", value1, value2, "pinInd");
            return (Criteria) this;
        }

        public Criteria andPinIndNotBetween(String value1, String value2) {
            addCriterion("PIN_IND not between", value1, value2, "pinInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndIsNull() {
            addCriterion("TRACK_IND is null");
            return (Criteria) this;
        }

        public Criteria andTrackIndIsNotNull() {
            addCriterion("TRACK_IND is not null");
            return (Criteria) this;
        }

        public Criteria andTrackIndEqualTo(String value) {
            addCriterion("TRACK_IND =", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndNotEqualTo(String value) {
            addCriterion("TRACK_IND <>", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndGreaterThan(String value) {
            addCriterion("TRACK_IND >", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndGreaterThanOrEqualTo(String value) {
            addCriterion("TRACK_IND >=", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndLessThan(String value) {
            addCriterion("TRACK_IND <", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndLessThanOrEqualTo(String value) {
            addCriterion("TRACK_IND <=", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndLike(String value) {
            addCriterion("TRACK_IND like", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndNotLike(String value) {
            addCriterion("TRACK_IND not like", value, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndIn(List<String> values) {
            addCriterion("TRACK_IND in", values, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndNotIn(List<String> values) {
            addCriterion("TRACK_IND not in", values, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndBetween(String value1, String value2) {
            addCriterion("TRACK_IND between", value1, value2, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTrackIndNotBetween(String value1, String value2) {
            addCriterion("TRACK_IND not between", value1, value2, "trackInd");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeIsNull() {
            addCriterion("TRAN_CRNCY_CDE is null");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeIsNotNull() {
            addCriterion("TRAN_CRNCY_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeEqualTo(String value) {
            addCriterion("TRAN_CRNCY_CDE =", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeNotEqualTo(String value) {
            addCriterion("TRAN_CRNCY_CDE <>", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeGreaterThan(String value) {
            addCriterion("TRAN_CRNCY_CDE >", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_CRNCY_CDE >=", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeLessThan(String value) {
            addCriterion("TRAN_CRNCY_CDE <", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeLessThanOrEqualTo(String value) {
            addCriterion("TRAN_CRNCY_CDE <=", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeLike(String value) {
            addCriterion("TRAN_CRNCY_CDE like", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeNotLike(String value) {
            addCriterion("TRAN_CRNCY_CDE not like", value, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeIn(List<String> values) {
            addCriterion("TRAN_CRNCY_CDE in", values, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeNotIn(List<String> values) {
            addCriterion("TRAN_CRNCY_CDE not in", values, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeBetween(String value1, String value2) {
            addCriterion("TRAN_CRNCY_CDE between", value1, value2, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyCdeNotBetween(String value1, String value2) {
            addCriterion("TRAN_CRNCY_CDE not between", value1, value2, "tranCrncyCde");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtIsNull() {
            addCriterion("TRAN_CRNCY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtIsNotNull() {
            addCriterion("TRAN_CRNCY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtEqualTo(String value) {
            addCriterion("TRAN_CRNCY_AMT =", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtNotEqualTo(String value) {
            addCriterion("TRAN_CRNCY_AMT <>", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtGreaterThan(String value) {
            addCriterion("TRAN_CRNCY_AMT >", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_CRNCY_AMT >=", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtLessThan(String value) {
            addCriterion("TRAN_CRNCY_AMT <", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtLessThanOrEqualTo(String value) {
            addCriterion("TRAN_CRNCY_AMT <=", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtLike(String value) {
            addCriterion("TRAN_CRNCY_AMT like", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtNotLike(String value) {
            addCriterion("TRAN_CRNCY_AMT not like", value, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtIn(List<String> values) {
            addCriterion("TRAN_CRNCY_AMT in", values, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtNotIn(List<String> values) {
            addCriterion("TRAN_CRNCY_AMT not in", values, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtBetween(String value1, String value2) {
            addCriterion("TRAN_CRNCY_AMT between", value1, value2, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andTranCrncyAmtNotBetween(String value1, String value2) {
            addCriterion("TRAN_CRNCY_AMT not between", value1, value2, "tranCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeIsNull() {
            addCriterion("BILL_CRNCY_CDE is null");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeIsNotNull() {
            addCriterion("BILL_CRNCY_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeEqualTo(String value) {
            addCriterion("BILL_CRNCY_CDE =", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeNotEqualTo(String value) {
            addCriterion("BILL_CRNCY_CDE <>", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeGreaterThan(String value) {
            addCriterion("BILL_CRNCY_CDE >", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_CRNCY_CDE >=", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeLessThan(String value) {
            addCriterion("BILL_CRNCY_CDE <", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeLessThanOrEqualTo(String value) {
            addCriterion("BILL_CRNCY_CDE <=", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeLike(String value) {
            addCriterion("BILL_CRNCY_CDE like", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeNotLike(String value) {
            addCriterion("BILL_CRNCY_CDE not like", value, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeIn(List<String> values) {
            addCriterion("BILL_CRNCY_CDE in", values, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeNotIn(List<String> values) {
            addCriterion("BILL_CRNCY_CDE not in", values, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeBetween(String value1, String value2) {
            addCriterion("BILL_CRNCY_CDE between", value1, value2, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyCdeNotBetween(String value1, String value2) {
            addCriterion("BILL_CRNCY_CDE not between", value1, value2, "billCrncyCde");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtIsNull() {
            addCriterion("BILL_CRNCY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtIsNotNull() {
            addCriterion("BILL_CRNCY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtEqualTo(String value) {
            addCriterion("BILL_CRNCY_AMT =", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtNotEqualTo(String value) {
            addCriterion("BILL_CRNCY_AMT <>", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtGreaterThan(String value) {
            addCriterion("BILL_CRNCY_AMT >", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_CRNCY_AMT >=", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtLessThan(String value) {
            addCriterion("BILL_CRNCY_AMT <", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtLessThanOrEqualTo(String value) {
            addCriterion("BILL_CRNCY_AMT <=", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtLike(String value) {
            addCriterion("BILL_CRNCY_AMT like", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtNotLike(String value) {
            addCriterion("BILL_CRNCY_AMT not like", value, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtIn(List<String> values) {
            addCriterion("BILL_CRNCY_AMT in", values, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtNotIn(List<String> values) {
            addCriterion("BILL_CRNCY_AMT not in", values, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtBetween(String value1, String value2) {
            addCriterion("BILL_CRNCY_AMT between", value1, value2, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillCrncyAmtNotBetween(String value1, String value2) {
            addCriterion("BILL_CRNCY_AMT not between", value1, value2, "billCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateIsNull() {
            addCriterion("BILL_CONVERSION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateIsNotNull() {
            addCriterion("BILL_CONVERSION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateEqualTo(String value) {
            addCriterion("BILL_CONVERSION_RATE =", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateNotEqualTo(String value) {
            addCriterion("BILL_CONVERSION_RATE <>", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateGreaterThan(String value) {
            addCriterion("BILL_CONVERSION_RATE >", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_CONVERSION_RATE >=", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateLessThan(String value) {
            addCriterion("BILL_CONVERSION_RATE <", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateLessThanOrEqualTo(String value) {
            addCriterion("BILL_CONVERSION_RATE <=", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateLike(String value) {
            addCriterion("BILL_CONVERSION_RATE like", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateNotLike(String value) {
            addCriterion("BILL_CONVERSION_RATE not like", value, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateIn(List<String> values) {
            addCriterion("BILL_CONVERSION_RATE in", values, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateNotIn(List<String> values) {
            addCriterion("BILL_CONVERSION_RATE not in", values, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateBetween(String value1, String value2) {
            addCriterion("BILL_CONVERSION_RATE between", value1, value2, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andBillConversionRateNotBetween(String value1, String value2) {
            addCriterion("BILL_CONVERSION_RATE not between", value1, value2, "billConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeIsNull() {
            addCriterion("SETL_CRNCY_CDE is null");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeIsNotNull() {
            addCriterion("SETL_CRNCY_CDE is not null");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeEqualTo(String value) {
            addCriterion("SETL_CRNCY_CDE =", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeNotEqualTo(String value) {
            addCriterion("SETL_CRNCY_CDE <>", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeGreaterThan(String value) {
            addCriterion("SETL_CRNCY_CDE >", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeGreaterThanOrEqualTo(String value) {
            addCriterion("SETL_CRNCY_CDE >=", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeLessThan(String value) {
            addCriterion("SETL_CRNCY_CDE <", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeLessThanOrEqualTo(String value) {
            addCriterion("SETL_CRNCY_CDE <=", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeLike(String value) {
            addCriterion("SETL_CRNCY_CDE like", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeNotLike(String value) {
            addCriterion("SETL_CRNCY_CDE not like", value, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeIn(List<String> values) {
            addCriterion("SETL_CRNCY_CDE in", values, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeNotIn(List<String> values) {
            addCriterion("SETL_CRNCY_CDE not in", values, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeBetween(String value1, String value2) {
            addCriterion("SETL_CRNCY_CDE between", value1, value2, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyCdeNotBetween(String value1, String value2) {
            addCriterion("SETL_CRNCY_CDE not between", value1, value2, "setlCrncyCde");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtIsNull() {
            addCriterion("SETL_CRNCY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtIsNotNull() {
            addCriterion("SETL_CRNCY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtEqualTo(String value) {
            addCriterion("SETL_CRNCY_AMT =", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtNotEqualTo(String value) {
            addCriterion("SETL_CRNCY_AMT <>", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtGreaterThan(String value) {
            addCriterion("SETL_CRNCY_AMT >", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtGreaterThanOrEqualTo(String value) {
            addCriterion("SETL_CRNCY_AMT >=", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtLessThan(String value) {
            addCriterion("SETL_CRNCY_AMT <", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtLessThanOrEqualTo(String value) {
            addCriterion("SETL_CRNCY_AMT <=", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtLike(String value) {
            addCriterion("SETL_CRNCY_AMT like", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtNotLike(String value) {
            addCriterion("SETL_CRNCY_AMT not like", value, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtIn(List<String> values) {
            addCriterion("SETL_CRNCY_AMT in", values, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtNotIn(List<String> values) {
            addCriterion("SETL_CRNCY_AMT not in", values, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtBetween(String value1, String value2) {
            addCriterion("SETL_CRNCY_AMT between", value1, value2, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlCrncyAmtNotBetween(String value1, String value2) {
            addCriterion("SETL_CRNCY_AMT not between", value1, value2, "setlCrncyAmt");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateIsNull() {
            addCriterion("SETL_CONVERSION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateIsNotNull() {
            addCriterion("SETL_CONVERSION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateEqualTo(String value) {
            addCriterion("SETL_CONVERSION_RATE =", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateNotEqualTo(String value) {
            addCriterion("SETL_CONVERSION_RATE <>", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateGreaterThan(String value) {
            addCriterion("SETL_CONVERSION_RATE >", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateGreaterThanOrEqualTo(String value) {
            addCriterion("SETL_CONVERSION_RATE >=", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateLessThan(String value) {
            addCriterion("SETL_CONVERSION_RATE <", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateLessThanOrEqualTo(String value) {
            addCriterion("SETL_CONVERSION_RATE <=", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateLike(String value) {
            addCriterion("SETL_CONVERSION_RATE like", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateNotLike(String value) {
            addCriterion("SETL_CONVERSION_RATE not like", value, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateIn(List<String> values) {
            addCriterion("SETL_CONVERSION_RATE in", values, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateNotIn(List<String> values) {
            addCriterion("SETL_CONVERSION_RATE not in", values, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateBetween(String value1, String value2) {
            addCriterion("SETL_CONVERSION_RATE between", value1, value2, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andSetlConversionRateNotBetween(String value1, String value2) {
            addCriterion("SETL_CONVERSION_RATE not between", value1, value2, "setlConversionRate");
            return (Criteria) this;
        }

        public Criteria andLocalDateIsNull() {
            addCriterion("LOCAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLocalDateIsNotNull() {
            addCriterion("LOCAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLocalDateEqualTo(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE =", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE <>", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE >", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE >=", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateLessThan(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE <", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOCAL_DATE <=", value, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateIn(List<Date> values) {
            addCriterionForJDBCDate("LOCAL_DATE in", values, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LOCAL_DATE not in", values, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOCAL_DATE between", value1, value2, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOCAL_DATE not between", value1, value2, "localDate");
            return (Criteria) this;
        }

        public Criteria andLocalTimeIsNull() {
            addCriterion("LOCAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLocalTimeIsNotNull() {
            addCriterion("LOCAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLocalTimeEqualTo(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME =", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME <>", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME >", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME >=", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeLessThan(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME <", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("LOCAL_TIME <=", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeIn(List<Date> values) {
            addCriterionForJDBCTime("LOCAL_TIME in", values, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("LOCAL_TIME not in", values, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("LOCAL_TIME between", value1, value2, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("LOCAL_TIME not between", value1, value2, "localTime");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNull() {
            addCriterion("MERCHANT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("MERCHANT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(String value) {
            addCriterion("MERCHANT_TYPE =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(String value) {
            addCriterion("MERCHANT_TYPE >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(String value) {
            addCriterion("MERCHANT_TYPE <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLike(String value) {
            addCriterion("MERCHANT_TYPE like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotLike(String value) {
            addCriterion("MERCHANT_TYPE not like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<String> values) {
            addCriterion("MERCHANT_TYPE in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<String> values) {
            addCriterion("MERCHANT_TYPE not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeIsNull() {
            addCriterion("ACQ_COUNTYR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeIsNotNull() {
            addCriterion("ACQ_COUNTYR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeEqualTo(String value) {
            addCriterion("ACQ_COUNTYR_CODE =", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeNotEqualTo(String value) {
            addCriterion("ACQ_COUNTYR_CODE <>", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeGreaterThan(String value) {
            addCriterion("ACQ_COUNTYR_CODE >", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACQ_COUNTYR_CODE >=", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeLessThan(String value) {
            addCriterion("ACQ_COUNTYR_CODE <", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeLessThanOrEqualTo(String value) {
            addCriterion("ACQ_COUNTYR_CODE <=", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeLike(String value) {
            addCriterion("ACQ_COUNTYR_CODE like", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeNotLike(String value) {
            addCriterion("ACQ_COUNTYR_CODE not like", value, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeIn(List<String> values) {
            addCriterion("ACQ_COUNTYR_CODE in", values, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeNotIn(List<String> values) {
            addCriterion("ACQ_COUNTYR_CODE not in", values, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeBetween(String value1, String value2) {
            addCriterion("ACQ_COUNTYR_CODE between", value1, value2, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andAcqCountyrCodeNotBetween(String value1, String value2) {
            addCriterion("ACQ_COUNTYR_CODE not between", value1, value2, "acqCountyrCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeIsNull() {
            addCriterion("POINT_SERVICE_ENTRY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeIsNotNull() {
            addCriterion("POINT_SERVICE_ENTRY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeEqualTo(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE =", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeNotEqualTo(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE <>", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeGreaterThan(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE >", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE >=", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeLessThan(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE <", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeLessThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE <=", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeLike(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE like", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeNotLike(String value) {
            addCriterion("POINT_SERVICE_ENTRY_CODE not like", value, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeIn(List<String> values) {
            addCriterion("POINT_SERVICE_ENTRY_CODE in", values, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeNotIn(List<String> values) {
            addCriterion("POINT_SERVICE_ENTRY_CODE not in", values, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_ENTRY_CODE between", value1, value2, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceEntryCodeNotBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_ENTRY_CODE not between", value1, value2, "pointServiceEntryCode");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumIsNull() {
            addCriterion("CARD_SEQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumIsNotNull() {
            addCriterion("CARD_SEQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumEqualTo(String value) {
            addCriterion("CARD_SEQ_NUM =", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumNotEqualTo(String value) {
            addCriterion("CARD_SEQ_NUM <>", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumGreaterThan(String value) {
            addCriterion("CARD_SEQ_NUM >", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_SEQ_NUM >=", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumLessThan(String value) {
            addCriterion("CARD_SEQ_NUM <", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumLessThanOrEqualTo(String value) {
            addCriterion("CARD_SEQ_NUM <=", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumLike(String value) {
            addCriterion("CARD_SEQ_NUM like", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumNotLike(String value) {
            addCriterion("CARD_SEQ_NUM not like", value, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumIn(List<String> values) {
            addCriterion("CARD_SEQ_NUM in", values, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumNotIn(List<String> values) {
            addCriterion("CARD_SEQ_NUM not in", values, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumBetween(String value1, String value2) {
            addCriterion("CARD_SEQ_NUM between", value1, value2, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andCardSeqNumNotBetween(String value1, String value2) {
            addCriterion("CARD_SEQ_NUM not between", value1, value2, "cardSeqNum");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeIsNull() {
            addCriterion("POINT_SERVICE_COND_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeIsNotNull() {
            addCriterion("POINT_SERVICE_COND_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeEqualTo(String value) {
            addCriterion("POINT_SERVICE_COND_CODE =", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeNotEqualTo(String value) {
            addCriterion("POINT_SERVICE_COND_CODE <>", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeGreaterThan(String value) {
            addCriterion("POINT_SERVICE_COND_CODE >", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_COND_CODE >=", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeLessThan(String value) {
            addCriterion("POINT_SERVICE_COND_CODE <", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeLessThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_COND_CODE <=", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeLike(String value) {
            addCriterion("POINT_SERVICE_COND_CODE like", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeNotLike(String value) {
            addCriterion("POINT_SERVICE_COND_CODE not like", value, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeIn(List<String> values) {
            addCriterion("POINT_SERVICE_COND_CODE in", values, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeNotIn(List<String> values) {
            addCriterion("POINT_SERVICE_COND_CODE not in", values, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_COND_CODE between", value1, value2, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServiceCondCodeNotBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_COND_CODE not between", value1, value2, "pointServiceCondCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeIsNull() {
            addCriterion("POINT_SERVICE_PIN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeIsNotNull() {
            addCriterion("POINT_SERVICE_PIN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeEqualTo(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE =", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeNotEqualTo(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE <>", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeGreaterThan(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE >", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE >=", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeLessThan(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE <", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeLessThanOrEqualTo(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE <=", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeLike(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE like", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeNotLike(String value) {
            addCriterion("POINT_SERVICE_PIN_CODE not like", value, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeIn(List<String> values) {
            addCriterion("POINT_SERVICE_PIN_CODE in", values, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeNotIn(List<String> values) {
            addCriterion("POINT_SERVICE_PIN_CODE not in", values, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_PIN_CODE between", value1, value2, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andPointServicePinCodeNotBetween(String value1, String value2) {
            addCriterion("POINT_SERVICE_PIN_CODE not between", value1, value2, "pointServicePinCode");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIsNull() {
            addCriterion("TRANSACTION_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIsNotNull() {
            addCriterion("TRANSACTION_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeEqualTo(String value) {
            addCriterion("TRANSACTION_FEE =", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotEqualTo(String value) {
            addCriterion("TRANSACTION_FEE <>", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeGreaterThan(String value) {
            addCriterion("TRANSACTION_FEE >", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_FEE >=", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeLessThan(String value) {
            addCriterion("TRANSACTION_FEE <", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_FEE <=", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeLike(String value) {
            addCriterion("TRANSACTION_FEE like", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotLike(String value) {
            addCriterion("TRANSACTION_FEE not like", value, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeIn(List<String> values) {
            addCriterion("TRANSACTION_FEE in", values, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotIn(List<String> values) {
            addCriterion("TRANSACTION_FEE not in", values, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeBetween(String value1, String value2) {
            addCriterion("TRANSACTION_FEE between", value1, value2, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeNotBetween(String value1, String value2) {
            addCriterion("TRANSACTION_FEE not between", value1, value2, "transactionFee");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeIsNull() {
            addCriterion("ACQ_INST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeIsNotNull() {
            addCriterion("ACQ_INST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeEqualTo(String value) {
            addCriterion("ACQ_INST_CODE =", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeNotEqualTo(String value) {
            addCriterion("ACQ_INST_CODE <>", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeGreaterThan(String value) {
            addCriterion("ACQ_INST_CODE >", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACQ_INST_CODE >=", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeLessThan(String value) {
            addCriterion("ACQ_INST_CODE <", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeLessThanOrEqualTo(String value) {
            addCriterion("ACQ_INST_CODE <=", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeLike(String value) {
            addCriterion("ACQ_INST_CODE like", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeNotLike(String value) {
            addCriterion("ACQ_INST_CODE not like", value, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeIn(List<String> values) {
            addCriterion("ACQ_INST_CODE in", values, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeNotIn(List<String> values) {
            addCriterion("ACQ_INST_CODE not in", values, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeBetween(String value1, String value2) {
            addCriterion("ACQ_INST_CODE between", value1, value2, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andAcqInstCodeNotBetween(String value1, String value2) {
            addCriterion("ACQ_INST_CODE not between", value1, value2, "acqInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeIsNull() {
            addCriterion("FORW_INST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeIsNotNull() {
            addCriterion("FORW_INST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeEqualTo(String value) {
            addCriterion("FORW_INST_CODE =", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeNotEqualTo(String value) {
            addCriterion("FORW_INST_CODE <>", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeGreaterThan(String value) {
            addCriterion("FORW_INST_CODE >", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FORW_INST_CODE >=", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeLessThan(String value) {
            addCriterion("FORW_INST_CODE <", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeLessThanOrEqualTo(String value) {
            addCriterion("FORW_INST_CODE <=", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeLike(String value) {
            addCriterion("FORW_INST_CODE like", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeNotLike(String value) {
            addCriterion("FORW_INST_CODE not like", value, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeIn(List<String> values) {
            addCriterion("FORW_INST_CODE in", values, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeNotIn(List<String> values) {
            addCriterion("FORW_INST_CODE not in", values, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeBetween(String value1, String value2) {
            addCriterion("FORW_INST_CODE between", value1, value2, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andForwInstCodeNotBetween(String value1, String value2) {
            addCriterion("FORW_INST_CODE not between", value1, value2, "forwInstCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataIsNull() {
            addCriterion("ADDITIONAL_RESP_DATA is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataIsNotNull() {
            addCriterion("ADDITIONAL_RESP_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataEqualTo(String value) {
            addCriterion("ADDITIONAL_RESP_DATA =", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataNotEqualTo(String value) {
            addCriterion("ADDITIONAL_RESP_DATA <>", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataGreaterThan(String value) {
            addCriterion("ADDITIONAL_RESP_DATA >", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataGreaterThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_RESP_DATA >=", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataLessThan(String value) {
            addCriterion("ADDITIONAL_RESP_DATA <", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataLessThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_RESP_DATA <=", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataLike(String value) {
            addCriterion("ADDITIONAL_RESP_DATA like", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataNotLike(String value) {
            addCriterion("ADDITIONAL_RESP_DATA not like", value, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataIn(List<String> values) {
            addCriterion("ADDITIONAL_RESP_DATA in", values, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataNotIn(List<String> values) {
            addCriterion("ADDITIONAL_RESP_DATA not in", values, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_RESP_DATA between", value1, value2, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalRespDataNotBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_RESP_DATA not between", value1, value2, "additionalRespData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataIsNull() {
            addCriterion("ADDITIONAL_DATA is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataIsNotNull() {
            addCriterion("ADDITIONAL_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataEqualTo(String value) {
            addCriterion("ADDITIONAL_DATA =", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataNotEqualTo(String value) {
            addCriterion("ADDITIONAL_DATA <>", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataGreaterThan(String value) {
            addCriterion("ADDITIONAL_DATA >", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataGreaterThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_DATA >=", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataLessThan(String value) {
            addCriterion("ADDITIONAL_DATA <", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataLessThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_DATA <=", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataLike(String value) {
            addCriterion("ADDITIONAL_DATA like", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataNotLike(String value) {
            addCriterion("ADDITIONAL_DATA not like", value, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataIn(List<String> values) {
            addCriterion("ADDITIONAL_DATA in", values, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataNotIn(List<String> values) {
            addCriterion("ADDITIONAL_DATA not in", values, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_DATA between", value1, value2, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalDataNotBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_DATA not between", value1, value2, "additionalData");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountIsNull() {
            addCriterion("ADDITIONAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountIsNotNull() {
            addCriterion("ADDITIONAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountEqualTo(String value) {
            addCriterion("ADDITIONAL_AMOUNT =", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountNotEqualTo(String value) {
            addCriterion("ADDITIONAL_AMOUNT <>", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountGreaterThan(String value) {
            addCriterion("ADDITIONAL_AMOUNT >", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountGreaterThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_AMOUNT >=", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountLessThan(String value) {
            addCriterion("ADDITIONAL_AMOUNT <", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountLessThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_AMOUNT <=", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountLike(String value) {
            addCriterion("ADDITIONAL_AMOUNT like", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountNotLike(String value) {
            addCriterion("ADDITIONAL_AMOUNT not like", value, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountIn(List<String> values) {
            addCriterion("ADDITIONAL_AMOUNT in", values, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountNotIn(List<String> values) {
            addCriterion("ADDITIONAL_AMOUNT not in", values, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_AMOUNT between", value1, value2, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalAmountNotBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_AMOUNT not between", value1, value2, "additionalAmount");
            return (Criteria) this;
        }

        public Criteria andChipDataField55IsNull() {
            addCriterion("CHIP_DATA_FIELD55 is null");
            return (Criteria) this;
        }

        public Criteria andChipDataField55IsNotNull() {
            addCriterion("CHIP_DATA_FIELD55 is not null");
            return (Criteria) this;
        }

        public Criteria andChipDataField55EqualTo(String value) {
            addCriterion("CHIP_DATA_FIELD55 =", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55NotEqualTo(String value) {
            addCriterion("CHIP_DATA_FIELD55 <>", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55GreaterThan(String value) {
            addCriterion("CHIP_DATA_FIELD55 >", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55GreaterThanOrEqualTo(String value) {
            addCriterion("CHIP_DATA_FIELD55 >=", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55LessThan(String value) {
            addCriterion("CHIP_DATA_FIELD55 <", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55LessThanOrEqualTo(String value) {
            addCriterion("CHIP_DATA_FIELD55 <=", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55Like(String value) {
            addCriterion("CHIP_DATA_FIELD55 like", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55NotLike(String value) {
            addCriterion("CHIP_DATA_FIELD55 not like", value, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55In(List<String> values) {
            addCriterion("CHIP_DATA_FIELD55 in", values, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55NotIn(List<String> values) {
            addCriterion("CHIP_DATA_FIELD55 not in", values, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55Between(String value1, String value2) {
            addCriterion("CHIP_DATA_FIELD55 between", value1, value2, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andChipDataField55NotBetween(String value1, String value2) {
            addCriterion("CHIP_DATA_FIELD55 not between", value1, value2, "chipDataField55");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforIsNull() {
            addCriterion("ADDITIONAL_POS_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforIsNotNull() {
            addCriterion("ADDITIONAL_POS_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforEqualTo(String value) {
            addCriterion("ADDITIONAL_POS_INFOR =", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforNotEqualTo(String value) {
            addCriterion("ADDITIONAL_POS_INFOR <>", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforGreaterThan(String value) {
            addCriterion("ADDITIONAL_POS_INFOR >", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforGreaterThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_POS_INFOR >=", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforLessThan(String value) {
            addCriterion("ADDITIONAL_POS_INFOR <", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforLessThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_POS_INFOR <=", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforLike(String value) {
            addCriterion("ADDITIONAL_POS_INFOR like", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforNotLike(String value) {
            addCriterion("ADDITIONAL_POS_INFOR not like", value, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforIn(List<String> values) {
            addCriterion("ADDITIONAL_POS_INFOR in", values, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforNotIn(List<String> values) {
            addCriterion("ADDITIONAL_POS_INFOR not in", values, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_POS_INFOR between", value1, value2, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andAdditionalPosInforNotBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_POS_INFOR not between", value1, value2, "additionalPosInfor");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceIsNull() {
            addCriterion("CUSTOM_PAYMENT_SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceIsNotNull() {
            addCriterion("CUSTOM_PAYMENT_SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceEqualTo(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE =", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceNotEqualTo(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE <>", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceGreaterThan(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE >", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE >=", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceLessThan(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE <", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE <=", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceLike(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE like", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceNotLike(String value) {
            addCriterion("CUSTOM_PAYMENT_SERVICE not like", value, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceIn(List<String> values) {
            addCriterion("CUSTOM_PAYMENT_SERVICE in", values, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceNotIn(List<String> values) {
            addCriterion("CUSTOM_PAYMENT_SERVICE not in", values, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceBetween(String value1, String value2) {
            addCriterion("CUSTOM_PAYMENT_SERVICE between", value1, value2, "customPaymentService");
            return (Criteria) this;
        }

        public Criteria andCustomPaymentServiceNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_PAYMENT_SERVICE not between", value1, value2, "customPaymentService");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}