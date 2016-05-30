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
 * Model class for WlOnlineUser
 */
@Entity
@Table(name = "wl_online_user")
@DynamicInsert
@DynamicUpdate
public class WlOnlineUserModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlOnlineUser";

	public static final class FieldNames {
		/**
		 * onlineUserId
		 */
		public static final String onlineUserId = "onlineUserId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * sessionId
		 */
		public static final String sessionId = "sessionId";
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
		 * loginTime
		 */
		public static final String loginTime = "loginTime";
		/**
		 * lastRequestTime
		 */
		public static final String lastRequestTime = "lastRequestTime";
		/**
		 * expired
		 */
		public static final String expired = "expired";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//onlineUserId
	private String onlineUserId;
	//userId
	private String userId;
	//sessionId
	private String sessionId;
	//serverName
	private String serverName;
	//remoteAddress
	private String remoteAddress;
	//remoteUser
	private String remoteUser;
	//loginTime
	private Date loginTime;
	//lastRequestTime
	private Date lastRequestTime;
	//expired
	private String expired;
	//tenantId
	private String tenantId;

	/**
	 * Get onlineUserId
	 */
	@Column(name = "ONLINE_USER_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getOnlineUserId() {
		return onlineUserId;
	}

	/**
	 * Set onlineUserId
	 */
	public void setOnlineUserId(String onlineUserId) {
		this.onlineUserId = onlineUserId;
		addValidField(FieldNames.onlineUserId);
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
	 * Get sessionId
	 */
	@Column(name = "SESSION_ID")
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Set sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
		addValidField(FieldNames.sessionId);
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
	 * Get loginTime
	 */
	@Column(name = "LOGIN_TIME")
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * Set loginTime
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
		addValidField(FieldNames.loginTime);
	}

	/**
	 * Get lastRequestTime
	 */
	@Column(name = "LAST_REQUEST_TIME")
	public Date getLastRequestTime() {
		return lastRequestTime;
	}

	/**
	 * Set lastRequestTime
	 */
	public void setLastRequestTime(Date lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
		addValidField(FieldNames.lastRequestTime);
	}

	/**
	 * Get expired
	 */
	@Column(name = "EXPIRED")
	public String getExpired() {
		return expired;
	}

	/**
	 * Set expired
	 */
	public void setExpired(String expired) {
		this.expired = expired;
		addValidField(FieldNames.expired);
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
