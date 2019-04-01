package cn.com.syscom.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FileMaintExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileMaintExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("Date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("Date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("Date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("Date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("Date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("Time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("Time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCTime("Time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("Time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("Time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("Time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCTime("Time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("Time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCTime("Time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("Time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("Time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("Time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andAccountnumberIsNull() {
            addCriterion("AccountNumber is null");
            return (Criteria) this;
        }

        public Criteria andAccountnumberIsNotNull() {
            addCriterion("AccountNumber is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnumberEqualTo(String value) {
            addCriterion("AccountNumber =", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberNotEqualTo(String value) {
            addCriterion("AccountNumber <>", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberGreaterThan(String value) {
            addCriterion("AccountNumber >", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberGreaterThanOrEqualTo(String value) {
            addCriterion("AccountNumber >=", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberLessThan(String value) {
            addCriterion("AccountNumber <", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberLessThanOrEqualTo(String value) {
            addCriterion("AccountNumber <=", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberLike(String value) {
            addCriterion("AccountNumber like", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberNotLike(String value) {
            addCriterion("AccountNumber not like", value, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberIn(List<String> values) {
            addCriterion("AccountNumber in", values, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberNotIn(List<String> values) {
            addCriterion("AccountNumber not in", values, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberBetween(String value1, String value2) {
            addCriterion("AccountNumber between", value1, value2, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andAccountnumberNotBetween(String value1, String value2) {
            addCriterion("AccountNumber not between", value1, value2, "accountnumber");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeIsNull() {
            addCriterion("UpdateCode is null");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeIsNotNull() {
            addCriterion("UpdateCode is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeEqualTo(Integer value) {
            addCriterion("UpdateCode =", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeNotEqualTo(Integer value) {
            addCriterion("UpdateCode <>", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeGreaterThan(Integer value) {
            addCriterion("UpdateCode >", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateCode >=", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeLessThan(Integer value) {
            addCriterion("UpdateCode <", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateCode <=", value, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeIn(List<Integer> values) {
            addCriterion("UpdateCode in", values, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeNotIn(List<Integer> values) {
            addCriterion("UpdateCode not in", values, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeBetween(Integer value1, Integer value2) {
            addCriterion("UpdateCode between", value1, value2, "updatecode");
            return (Criteria) this;
        }

        public Criteria andUpdatecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateCode not between", value1, value2, "updatecode");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionIsNull() {
            addCriterion("CodeDefinition is null");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionIsNotNull() {
            addCriterion("CodeDefinition is not null");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionEqualTo(String value) {
            addCriterion("CodeDefinition =", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionNotEqualTo(String value) {
            addCriterion("CodeDefinition <>", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionGreaterThan(String value) {
            addCriterion("CodeDefinition >", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionGreaterThanOrEqualTo(String value) {
            addCriterion("CodeDefinition >=", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionLessThan(String value) {
            addCriterion("CodeDefinition <", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionLessThanOrEqualTo(String value) {
            addCriterion("CodeDefinition <=", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionLike(String value) {
            addCriterion("CodeDefinition like", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionNotLike(String value) {
            addCriterion("CodeDefinition not like", value, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionIn(List<String> values) {
            addCriterion("CodeDefinition in", values, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionNotIn(List<String> values) {
            addCriterion("CodeDefinition not in", values, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionBetween(String value1, String value2) {
            addCriterion("CodeDefinition between", value1, value2, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andCodedefinitionNotBetween(String value1, String value2) {
            addCriterion("CodeDefinition not between", value1, value2, "codedefinition");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andRespcodeIsNull() {
            addCriterion("RespCode is null");
            return (Criteria) this;
        }

        public Criteria andRespcodeIsNotNull() {
            addCriterion("RespCode is not null");
            return (Criteria) this;
        }

        public Criteria andRespcodeEqualTo(String value) {
            addCriterion("RespCode =", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotEqualTo(String value) {
            addCriterion("RespCode <>", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeGreaterThan(String value) {
            addCriterion("RespCode >", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RespCode >=", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLessThan(String value) {
            addCriterion("RespCode <", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLessThanOrEqualTo(String value) {
            addCriterion("RespCode <=", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLike(String value) {
            addCriterion("RespCode like", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotLike(String value) {
            addCriterion("RespCode not like", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeIn(List<String> values) {
            addCriterion("RespCode in", values, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotIn(List<String> values) {
            addCriterion("RespCode not in", values, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeBetween(String value1, String value2) {
            addCriterion("RespCode between", value1, value2, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotBetween(String value1, String value2) {
            addCriterion("RespCode not between", value1, value2, "respcode");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNull() {
            addCriterion("ExpirationDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNotNull() {
            addCriterion("ExpirationDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateEqualTo(String value) {
            addCriterion("ExpirationDate =", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotEqualTo(String value) {
            addCriterion("ExpirationDate <>", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThan(String value) {
            addCriterion("ExpirationDate >", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThanOrEqualTo(String value) {
            addCriterion("ExpirationDate >=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThan(String value) {
            addCriterion("ExpirationDate <", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThanOrEqualTo(String value) {
            addCriterion("ExpirationDate <=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLike(String value) {
            addCriterion("ExpirationDate like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotLike(String value) {
            addCriterion("ExpirationDate not like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIn(List<String> values) {
            addCriterion("ExpirationDate in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotIn(List<String> values) {
            addCriterion("ExpirationDate not in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateBetween(String value1, String value2) {
            addCriterion("ExpirationDate between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotBetween(String value1, String value2) {
            addCriterion("ExpirationDate not between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("Operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("Operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("Operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("Operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("Operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("Operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("Operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("Operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("Operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("Operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("Operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("Operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("Operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("Operator not between", value1, value2, "operator");
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