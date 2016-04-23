package org.walle.webtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.walle.framework.core.model.BaseModelClass;
import cn.walle.framework.core.model.OperationLog;

/**
 * Model class for WlUserLoginLog
 */
@Entity
@Table(name = "wl_user_login_log")
@DynamicInsert
@DynamicUpdate
public class WlUserLoginLogModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlUserLoginLog";

	public static final class FieldNames {
		/**
		 * userLoginLogId
		 */
		public static final String userLoginLogId = "userLoginLogId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * loginTime
		 */
		public static final String loginTime = "loginTime";
		/**
		 * logoutTime
		 */
		public static final String logoutTime = "logoutTime";
		/**
		 * tryTimes
		 */
		public static final String tryTimes = "tryTimes";
		/**
		 * userIp
		 */
		public static final String userIp = "userIp";
		/**
		 * hostName
		 */
		public static final String hostName = "hostName";
		/**
		 * creator
		 */
		public static final String creator = "creator";
		/**
		 * createTime
		 */
		public static final String createTime = "createTime";
		/**
		 * modifier
		 */
		public static final String modifier = "modifier";
		/**
		 * modifyTime
		 */
		public static final String modifyTime = "modifyTime";
		/**
		 * recVer
		 */
		public static final String recVer = "recVer";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//userLoginLogId
	private String userLoginLogId;
	//userId
	private String userId;
	//loginTime
	private Date loginTime;
	//logoutTime
	private Date logoutTime;
	//tryTimes
	private Integer tryTimes;
	//userIp
	private String userIp;
	//hostName
	private String hostName;
	//creator
	private String creator;
	//createTime
	private Date createTime;
	//modifier
	private String modifier;
	//modifyTime
	private Date modifyTime;
	//recVer
	private Long recVer;
	//tenantId
	private String tenantId;

	/**
	 * Get userLoginLogId
	 */
	@Column(name = "USER_LOGIN_LOG_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getUserLoginLogId() {
		return userLoginLogId;
	}

	/**
	 * Set userLoginLogId
	 */
	public void setUserLoginLogId(String userLoginLogId) {
		this.userLoginLogId = userLoginLogId;
		addValidField(FieldNames.userLoginLogId);
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
	 * Get logoutTime
	 */
	@Column(name = "LOGOUT_TIME")
	public Date getLogoutTime() {
		return logoutTime;
	}

	/**
	 * Set logoutTime
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
		addValidField(FieldNames.logoutTime);
	}

	/**
	 * Get tryTimes
	 */
	@Column(name = "TRY_TIMES")
	public Integer getTryTimes() {
		return tryTimes;
	}

	/**
	 * Set tryTimes
	 */
	public void setTryTimes(Integer tryTimes) {
		this.tryTimes = tryTimes;
		addValidField(FieldNames.tryTimes);
	}

	/**
	 * Get userIp
	 */
	@Column(name = "USER_IP")
	public String getUserIp() {
		return userIp;
	}

	/**
	 * Set userIp
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
		addValidField(FieldNames.userIp);
	}

	/**
	 * Get hostName
	 */
	@Column(name = "HOST_NAME")
	public String getHostName() {
		return hostName;
	}

	/**
	 * Set hostName
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
		addValidField(FieldNames.hostName);
	}

	/**
	 * Get creator
	 */
	@Column(name = "CREATOR")
	public String getCreator() {
		return creator;
	}

	/**
	 * Set creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
		addValidField(FieldNames.creator);
	}

	/**
	 * Get createTime
	 */
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Set createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		addValidField(FieldNames.createTime);
	}

	/**
	 * Get modifier
	 */
	@Column(name = "MODIFIER")
	public String getModifier() {
		return modifier;
	}

	/**
	 * Set modifier
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
		addValidField(FieldNames.modifier);
	}

	/**
	 * Get modifyTime
	 */
	@Column(name = "MODIFY_TIME")
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * Set modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		addValidField(FieldNames.modifyTime);
	}

	/**
	 * Get recVer
	 */
	@Column(name = "REC_VER")
	@Version
	public Long getRecVer() {
		return recVer;
	}

	/**
	 * Set recVer
	 */
	public void setRecVer(Long recVer) {
		this.recVer = recVer;
		addValidField(FieldNames.recVer);
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
