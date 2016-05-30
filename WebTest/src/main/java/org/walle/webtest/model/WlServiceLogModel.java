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
 * Model class for WlServiceLog
 */
@Entity
@Table(name = "wl_service_log")
@DynamicInsert
@DynamicUpdate
public class WlServiceLogModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlServiceLog";

	public static final class FieldNames {
		/**
		 * serviceLogId
		 */
		public static final String serviceLogId = "serviceLogId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * serverName
		 */
		public static final String serverName = "serverName";
		/**
		 * remoteAddress
		 */
		public static final String remoteAddress = "remoteAddress";
		/**
		 * remoteUser
		 */
		public static final String remoteUser = "remoteUser";
		/**
		 * serviceName
		 */
		public static final String serviceName = "serviceName";
		/**
		 * methodName
		 */
		public static final String methodName = "methodName";
		/**
		 * args
		 */
		public static final String args = "args";
		/**
		 * result
		 */
		public static final String result = "result";
		/**
		 * logTime
		 */
		public static final String logTime = "logTime";
		/**
		 * timeUsed
		 */
		public static final String timeUsed = "timeUsed";
		/**
		 * accessIndex
		 */
		public static final String accessIndex = "accessIndex";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//serviceLogId
	private String serviceLogId;
	//userId
	private String userId;
	//serverName
	private String serverName;
	//remoteAddress
	private String remoteAddress;
	//remoteUser
	private String remoteUser;
	//serviceName
	private String serviceName;
	//methodName
	private String methodName;
	//args
	private String args;
	//result
	private String result;
	//logTime
	private Date logTime;
	//timeUsed
	private Long timeUsed;
	//accessIndex
	private String accessIndex;
	//tenantId
	private String tenantId;

	/**
	 * Get serviceLogId
	 */
	@Column(name = "SERVICE_LOG_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getServiceLogId() {
		return serviceLogId;
	}

	/**
	 * Set serviceLogId
	 */
	public void setServiceLogId(String serviceLogId) {
		this.serviceLogId = serviceLogId;
		addValidField(FieldNames.serviceLogId);
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
	 * Get serverName
	 */
	@Column(name = "SERVER_NAME")
	public String getServerName() {
		return serverName;
	}

	/**
	 * Set serverName
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
		addValidField(FieldNames.serverName);
	}

	/**
	 * Get remoteAddress
	 */
	@Column(name = "REMOTE_ADDRESS")
	public String getRemoteAddress() {
		return remoteAddress;
	}

	/**
	 * Set remoteAddress
	 */
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
		addValidField(FieldNames.remoteAddress);
	}

	/**
	 * Get remoteUser
	 */
	@Column(name = "REMOTE_USER")
	public String getRemoteUser() {
		return remoteUser;
	}

	/**
	 * Set remoteUser
	 */
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
		addValidField(FieldNames.remoteUser);
	}

	/**
	 * Get serviceName
	 */
	@Column(name = "SERVICE_NAME")
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Set serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
		addValidField(FieldNames.serviceName);
	}

	/**
	 * Get methodName
	 */
	@Column(name = "METHOD_NAME")
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Set methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
		addValidField(FieldNames.methodName);
	}

	/**
	 * Get args
	 */
	@Column(name = "ARGS")
	public String getArgs() {
		return args;
	}

	/**
	 * Set args
	 */
	public void setArgs(String args) {
		this.args = args;
		addValidField(FieldNames.args);
	}

	/**
	 * Get result
	 */
	@Column(name = "RESULT")
	public String getResult() {
		return result;
	}

	/**
	 * Set result
	 */
	public void setResult(String result) {
		this.result = result;
		addValidField(FieldNames.result);
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
	 * Get accessIndex
	 */
	@Column(name = "ACCESS_INDEX")
	public String getAccessIndex() {
		return accessIndex;
	}

	/**
	 * Set accessIndex
	 */
	public void setAccessIndex(String accessIndex) {
		this.accessIndex = accessIndex;
		addValidField(FieldNames.accessIndex);
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
