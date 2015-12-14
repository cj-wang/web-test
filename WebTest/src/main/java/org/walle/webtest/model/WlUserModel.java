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
 * Model class for WlUser
 */
@Entity
@Table(name = "wl_user")
@DynamicInsert
@DynamicUpdate
public class WlUserModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlUser";

	public static final class FieldNames {
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * code
		 */
		public static final String code = "code";
		/**
		 * loginName
		 */
		public static final String loginName = "loginName";
		/**
		 * name
		 */
		public static final String name = "name";
		/**
		 * organizeId
		 */
		public static final String organizeId = "organizeId";
		/**
		 * reportToUserId
		 */
		public static final String reportToUserId = "reportToUserId";
		/**
		 * certifiTypeId
		 */
		public static final String certifiTypeId = "certifiTypeId";
		/**
		 * certifiCode
		 */
		public static final String certifiCode = "certifiCode";
		/**
		 * password
		 */
		public static final String password = "password";
		/**
		 * allowChangePassword
		 */
		public static final String allowChangePassword = "allowChangePassword";
		/**
		 * workTypeId
		 */
		public static final String workTypeId = "workTypeId";
		/**
		 * userTypeId
		 */
		public static final String userTypeId = "userTypeId";
		/**
		 * checkFlag
		 */
		public static final String checkFlag = "checkFlag";
		/**
		 * educationTypeId
		 */
		public static final String educationTypeId = "educationTypeId";
		/**
		 * homeTel
		 */
		public static final String homeTel = "homeTel";
		/**
		 * officeTel
		 */
		public static final String officeTel = "officeTel";
		/**
		 * mobileTele
		 */
		public static final String mobileTele = "mobileTele";
		/**
		 * addrId
		 */
		public static final String addrId = "addrId";
		/**
		 * email
		 */
		public static final String email = "email";
		/**
		 * createDate
		 */
		public static final String createDate = "createDate";
		/**
		 * effectDate
		 */
		public static final String effectDate = "effectDate";
		/**
		 * expireDate
		 */
		public static final String expireDate = "expireDate";
		/**
		 * multiLoginFlag
		 */
		public static final String multiLoginFlag = "multiLoginFlag";
		/**
		 * lastLoginLogId
		 */
		public static final String lastLoginLogId = "lastLoginLogId";
		/**
		 * tryTimes
		 */
		public static final String tryTimes = "tryTimes";
		/**
		 * lockFlag
		 */
		public static final String lockFlag = "lockFlag";
		/**
		 * isLogin
		 */
		public static final String isLogin = "isLogin";
		/**
		 * remarks
		 */
		public static final String remarks = "remarks";
		/**
		 * state
		 */
		public static final String state = "state";
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
		 * qq
		 */
		public static final String qq = "qq";
		/**
		 * icon
		 */
		public static final String icon = "icon";
		/**
		 * iconSmall
		 */
		public static final String iconSmall = "iconSmall";
		/**
		 * msn
		 */
		public static final String msn = "msn";
		/**
		 * onlineStatus
		 */
		public static final String onlineStatus = "onlineStatus";
		/**
		 * unitsId
		 */
		public static final String unitsId = "unitsId";
		/**
		 * issendmsg
		 */
		public static final String issendmsg = "issendmsg";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
		/**
		 * userType
		 */
		public static final String userType = "userType";
		/**
		 * branchId
		 */
		public static final String branchId = "branchId";
	}

	//userId
	private String userId;
	//code
	private String code;
	//loginName
	private String loginName;
	//name
	private String name;
	//organizeId
	private String organizeId;
	//reportToUserId
	private Double reportToUserId;
	//certifiTypeId
	private Double certifiTypeId;
	//certifiCode
	private String certifiCode;
	//password
	private String password;
	//allowChangePassword
	private String allowChangePassword;
	//workTypeId
	private Double workTypeId;
	//userTypeId
	private Double userTypeId;
	//checkFlag
	private String checkFlag;
	//educationTypeId
	private Double educationTypeId;
	//homeTel
	private String homeTel;
	//officeTel
	private String officeTel;
	//mobileTele
	private String mobileTele;
	//addrId
	private String addrId;
	//email
	private String email;
	//createDate
	private Date createDate;
	//effectDate
	private Date effectDate;
	//expireDate
	private Date expireDate;
	//multiLoginFlag
	private Double multiLoginFlag;
	//lastLoginLogId
	private Double lastLoginLogId;
	//tryTimes
	private Double tryTimes;
	//lockFlag
	private String lockFlag;
	//isLogin
	private String isLogin;
	//remarks
	private String remarks;
	//state
	private String state;
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
	//qq
	private String qq;
	//icon
	private String icon;
	//iconSmall
	private String iconSmall;
	//msn
	private String msn;
	//onlineStatus
	private String onlineStatus;
	//unitsId
	private String unitsId;
	//issendmsg
	private String issendmsg;
	//tenantId
	private String tenantId;
	//userType
	private String userType;
	//branchId
	private Integer branchId;

	/**
	 * Get userId
	 */
	@Column(name = "USER_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
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
	 * Get code
	 */
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	/**
	 * Set code
	 */
	public void setCode(String code) {
		this.code = code;
		addValidField(FieldNames.code);
	}

	/**
	 * Get loginName
	 */
	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Set loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
		addValidField(FieldNames.loginName);
	}

	/**
	 * Get name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 */
	public void setName(String name) {
		this.name = name;
		addValidField(FieldNames.name);
	}

	/**
	 * Get organizeId
	 */
	@Column(name = "ORGANIZE_ID")
	public String getOrganizeId() {
		return organizeId;
	}

	/**
	 * Set organizeId
	 */
	public void setOrganizeId(String organizeId) {
		this.organizeId = organizeId;
		addValidField(FieldNames.organizeId);
	}

	/**
	 * Get reportToUserId
	 */
	@Column(name = "REPORT_TO_USER_ID")
	public Double getReportToUserId() {
		return reportToUserId;
	}

	/**
	 * Set reportToUserId
	 */
	public void setReportToUserId(Double reportToUserId) {
		this.reportToUserId = reportToUserId;
		addValidField(FieldNames.reportToUserId);
	}

	/**
	 * Get certifiTypeId
	 */
	@Column(name = "CERTIFI_TYPE_ID")
	public Double getCertifiTypeId() {
		return certifiTypeId;
	}

	/**
	 * Set certifiTypeId
	 */
	public void setCertifiTypeId(Double certifiTypeId) {
		this.certifiTypeId = certifiTypeId;
		addValidField(FieldNames.certifiTypeId);
	}

	/**
	 * Get certifiCode
	 */
	@Column(name = "CERTIFI_CODE")
	public String getCertifiCode() {
		return certifiCode;
	}

	/**
	 * Set certifiCode
	 */
	public void setCertifiCode(String certifiCode) {
		this.certifiCode = certifiCode;
		addValidField(FieldNames.certifiCode);
	}

	/**
	 * Get password
	 */
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 */
	public void setPassword(String password) {
		this.password = password;
		addValidField(FieldNames.password);
	}

	/**
	 * Get allowChangePassword
	 */
	@Column(name = "ALLOW_CHANGE_PASSWORD")
	public String getAllowChangePassword() {
		return allowChangePassword;
	}

	/**
	 * Set allowChangePassword
	 */
	public void setAllowChangePassword(String allowChangePassword) {
		this.allowChangePassword = allowChangePassword;
		addValidField(FieldNames.allowChangePassword);
	}

	/**
	 * Get workTypeId
	 */
	@Column(name = "WORK_TYPE_ID")
	public Double getWorkTypeId() {
		return workTypeId;
	}

	/**
	 * Set workTypeId
	 */
	public void setWorkTypeId(Double workTypeId) {
		this.workTypeId = workTypeId;
		addValidField(FieldNames.workTypeId);
	}

	/**
	 * Get userTypeId
	 */
	@Column(name = "USER_TYPE_ID")
	public Double getUserTypeId() {
		return userTypeId;
	}

	/**
	 * Set userTypeId
	 */
	public void setUserTypeId(Double userTypeId) {
		this.userTypeId = userTypeId;
		addValidField(FieldNames.userTypeId);
	}

	/**
	 * Get checkFlag
	 */
	@Column(name = "CHECK_FLAG")
	public String getCheckFlag() {
		return checkFlag;
	}

	/**
	 * Set checkFlag
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
		addValidField(FieldNames.checkFlag);
	}

	/**
	 * Get educationTypeId
	 */
	@Column(name = "EDUCATION_TYPE_ID")
	public Double getEducationTypeId() {
		return educationTypeId;
	}

	/**
	 * Set educationTypeId
	 */
	public void setEducationTypeId(Double educationTypeId) {
		this.educationTypeId = educationTypeId;
		addValidField(FieldNames.educationTypeId);
	}

	/**
	 * Get homeTel
	 */
	@Column(name = "HOME_TEL")
	public String getHomeTel() {
		return homeTel;
	}

	/**
	 * Set homeTel
	 */
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
		addValidField(FieldNames.homeTel);
	}

	/**
	 * Get officeTel
	 */
	@Column(name = "OFFICE_TEL")
	public String getOfficeTel() {
		return officeTel;
	}

	/**
	 * Set officeTel
	 */
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
		addValidField(FieldNames.officeTel);
	}

	/**
	 * Get mobileTele
	 */
	@Column(name = "MOBILE_TELE")
	public String getMobileTele() {
		return mobileTele;
	}

	/**
	 * Set mobileTele
	 */
	public void setMobileTele(String mobileTele) {
		this.mobileTele = mobileTele;
		addValidField(FieldNames.mobileTele);
	}

	/**
	 * Get addrId
	 */
	@Column(name = "ADDR_ID")
	public String getAddrId() {
		return addrId;
	}

	/**
	 * Set addrId
	 */
	public void setAddrId(String addrId) {
		this.addrId = addrId;
		addValidField(FieldNames.addrId);
	}

	/**
	 * Get email
	 */
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	/**
	 * Set email
	 */
	public void setEmail(String email) {
		this.email = email;
		addValidField(FieldNames.email);
	}

	/**
	 * Get createDate
	 */
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Set createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		addValidField(FieldNames.createDate);
	}

	/**
	 * Get effectDate
	 */
	@Column(name = "EFFECT_DATE")
	public Date getEffectDate() {
		return effectDate;
	}

	/**
	 * Set effectDate
	 */
	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
		addValidField(FieldNames.effectDate);
	}

	/**
	 * Get expireDate
	 */
	@Column(name = "EXPIRE_DATE")
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * Set expireDate
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
		addValidField(FieldNames.expireDate);
	}

	/**
	 * Get multiLoginFlag
	 */
	@Column(name = "MULTI_LOGIN_FLAG")
	public Double getMultiLoginFlag() {
		return multiLoginFlag;
	}

	/**
	 * Set multiLoginFlag
	 */
	public void setMultiLoginFlag(Double multiLoginFlag) {
		this.multiLoginFlag = multiLoginFlag;
		addValidField(FieldNames.multiLoginFlag);
	}

	/**
	 * Get lastLoginLogId
	 */
	@Column(name = "LAST_LOGIN_LOG_ID")
	public Double getLastLoginLogId() {
		return lastLoginLogId;
	}

	/**
	 * Set lastLoginLogId
	 */
	public void setLastLoginLogId(Double lastLoginLogId) {
		this.lastLoginLogId = lastLoginLogId;
		addValidField(FieldNames.lastLoginLogId);
	}

	/**
	 * Get tryTimes
	 */
	@Column(name = "TRY_TIMES")
	public Double getTryTimes() {
		return tryTimes;
	}

	/**
	 * Set tryTimes
	 */
	public void setTryTimes(Double tryTimes) {
		this.tryTimes = tryTimes;
		addValidField(FieldNames.tryTimes);
	}

	/**
	 * Get lockFlag
	 */
	@Column(name = "LOCK_FLAG")
	public String getLockFlag() {
		return lockFlag;
	}

	/**
	 * Set lockFlag
	 */
	public void setLockFlag(String lockFlag) {
		this.lockFlag = lockFlag;
		addValidField(FieldNames.lockFlag);
	}

	/**
	 * Get isLogin
	 */
	@Column(name = "IS_LOGIN")
	public String getIsLogin() {
		return isLogin;
	}

	/**
	 * Set isLogin
	 */
	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
		addValidField(FieldNames.isLogin);
	}

	/**
	 * Get remarks
	 */
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Set remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
		addValidField(FieldNames.remarks);
	}

	/**
	 * Get state
	 */
	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	/**
	 * Set state
	 */
	public void setState(String state) {
		this.state = state;
		addValidField(FieldNames.state);
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
	 * Get qq
	 */
	@Column(name = "QQ")
	public String getQq() {
		return qq;
	}

	/**
	 * Set qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
		addValidField(FieldNames.qq);
	}

	/**
	 * Get icon
	 */
	@Column(name = "ICON")
	public String getIcon() {
		return icon;
	}

	/**
	 * Set icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
		addValidField(FieldNames.icon);
	}

	/**
	 * Get iconSmall
	 */
	@Column(name = "ICON_SMALL")
	public String getIconSmall() {
		return iconSmall;
	}

	/**
	 * Set iconSmall
	 */
	public void setIconSmall(String iconSmall) {
		this.iconSmall = iconSmall;
		addValidField(FieldNames.iconSmall);
	}

	/**
	 * Get msn
	 */
	@Column(name = "MSN")
	public String getMsn() {
		return msn;
	}

	/**
	 * Set msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
		addValidField(FieldNames.msn);
	}

	/**
	 * Get onlineStatus
	 */
	@Column(name = "ONLINE_STATUS")
	public String getOnlineStatus() {
		return onlineStatus;
	}

	/**
	 * Set onlineStatus
	 */
	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
		addValidField(FieldNames.onlineStatus);
	}

	/**
	 * Get unitsId
	 */
	@Column(name = "UNITS_ID")
	public String getUnitsId() {
		return unitsId;
	}

	/**
	 * Set unitsId
	 */
	public void setUnitsId(String unitsId) {
		this.unitsId = unitsId;
		addValidField(FieldNames.unitsId);
	}

	/**
	 * Get issendmsg
	 */
	@Column(name = "ISSENDMSG")
	public String getIssendmsg() {
		return issendmsg;
	}

	/**
	 * Set issendmsg
	 */
	public void setIssendmsg(String issendmsg) {
		this.issendmsg = issendmsg;
		addValidField(FieldNames.issendmsg);
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

	/**
	 * Get userType
	 */
	@Column(name = "USER_TYPE")
	public String getUserType() {
		return userType;
	}

	/**
	 * Set userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
		addValidField(FieldNames.userType);
	}

	/**
	 * Get branchId
	 */
	@Column(name = "BRANCH_ID")
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * Set branchId
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
		addValidField(FieldNames.branchId);
	}

}
