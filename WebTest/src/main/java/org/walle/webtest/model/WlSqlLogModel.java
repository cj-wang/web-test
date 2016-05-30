package org.walle.webtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.walle.framework.core.model.BaseModelClass;

/**
 * Model class for WlSqlLog
 */
@Entity
@Table(name = "wl_sql_log")
@DynamicInsert
@DynamicUpdate
public class WlSqlLogModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlSqlLog";

	public static final class FieldNames {
		/**
		 * sqlLogId
		 */
		public static final String sqlLogId = "sqlLogId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * sqlStatement
		 */
		public static final String sqlStatement = "sqlStatement";
		/**
		 * logTime
		 */
		public static final String logTime = "logTime";
		/**
		 * timeUsed
		 */
		public static final String timeUsed = "timeUsed";
		/**
		 * serviceAccessIndex
		 */
		public static final String serviceAccessIndex = "serviceAccessIndex";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//sqlLogId
	private String sqlLogId;
	//userId
	private String userId;
	//sqlStatement
	private String sqlStatement;
	//logTime
	private Date logTime;
	//timeUsed
	private Long timeUsed;
	//serviceAccessIndex
	private String serviceAccessIndex;
	//tenantId
	private String tenantId;

	/**
	 * Get sqlLogId
	 */
	@Column(name = "SQL_LOG_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getSqlLogId() {
		return sqlLogId;
	}

	/**
	 * Set sqlLogId
	 */
	public void setSqlLogId(String sqlLogId) {
		this.sqlLogId = sqlLogId;
		addValidField(FieldNames.sqlLogId);
	}

	/**
	 * Get userId
	 */
	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	/**
	 * Set userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
		addValidField(FieldNames.userId);
	}

	/**
	 * Get sqlStatement
	 */
	@Column(name = "SQL_STATEMENT")
	public String getSqlStatement() {
		return sqlStatement;
	}

	/**
	 * Set sqlStatement
	 */
	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
		addValidField(FieldNames.sqlStatement);
	}

	/**
	 * Get logTime
	 */
	@Column(name = "LOG_TIME")
	public Date getLogTime() {
		return logTime;
	}

	/**
	 * Set logTime
	 */
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
		addValidField(FieldNames.logTime);
	}

	/**
	 * Get timeUsed
	 */
	@Column(name = "TIME_USED")
	public Long getTimeUsed() {
		return timeUsed;
	}

	/**
	 * Set timeUsed
	 */
	public void setTimeUsed(Long timeUsed) {
		this.timeUsed = timeUsed;
		addValidField(FieldNames.timeUsed);
	}

	/**
	 * Get serviceAccessIndex
	 */
	@Column(name = "SERVICE_ACCESS_INDEX")
	public String getServiceAccessIndex() {
		return serviceAccessIndex;
	}

	/**
	 * Set serviceAccessIndex
	 */
	public void setServiceAccessIndex(String serviceAccessIndex) {
		this.serviceAccessIndex = serviceAccessIndex;
		addValidField(FieldNames.serviceAccessIndex);
	}

	/**
	 * Get tenantId
	 */
	@Column(name = "TENANT_ID")
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * Set tenantId
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
		addValidField(FieldNames.tenantId);
	}

}
