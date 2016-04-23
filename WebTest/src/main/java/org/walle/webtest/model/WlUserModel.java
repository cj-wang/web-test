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
		 * 员工内部编码
		 */
		public static final String userId = "userId";
		/**
		 * 员工工号
		 */
		public static final String code = "code";
		/**
		 * 登录名
		 */
		public static final String loginName = "loginName";
		/**
		 * 员工姓名
		 */
		public static final String name = "name";
		/**
		 * 所属组
		 */
		public static final String organizeId = "organizeId";
		/**
		 * 直接领导
		 */
		public static final String reportToUserId = "reportToUserId";
		/**
		 * 证件类型
		 */
		public static final String certifiTypeId = "certifiTypeId";
		/**
		 * 证件号码
		 */
		public static final String certifiCode = "certifiCode";
		/**
		 * 登录密码
		 */
		public static final String password = "password";
		/**
		 * 是否允许修改密码
		 */
		public static final String allowChangePassword = "allowChangePassword";
		/**
		 * 职务
		 */
		public static final String workTypeId = "workTypeId";
		/**
		 * 员工类型0在编1非在编
		 */
		public static final String userTypeId = "userTypeId";
		/**
		 * 是否为任务调度负责人(0是
		 */
		public static final String checkFlag = "checkFlag";
		/**
		 * educationTypeId
		 */
		public static final String educationTypeId = "educationTypeId";
		/**
		 * 家庭电话
		 */
		public static final String homeTel = "homeTel";
		/**
		 * 办公电话
		 */
		public static final String officeTel = "officeTel";
		/**
		 * 移动电话
		 */
		public static final String mobileTele = "mobileTele";
		/**
		 * 员工住址
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
		 * 打印软件授权
		 */
		public static final String msn = "msn";
		/**
		 * onlineStatus
		 */
		public static final String onlineStatus = "onlineStatus";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
		/**
		 * 区县code
		 */
		public static final String districtId = "districtId";
		/**
		 * issendmsg
		 */
		public static final String issendmsg = "issendmsg";
		/**
		 * 明文密码
		 */
		public static final String mwpassword = "mwpassword";
		/**
		 * 时间long类型版本
		 */
		public static final String version = "version";
		/**
		 * 手机通讯卡
		 */
		public static final String sim = "sim";
		/**
		 * 手机终端标识码
		 */
		public static final String imei = "imei";
	}

	//员工内部编码
	private String userId;
	//员工工号
	private String code;
	//登录名
	private String loginName;
	//员工姓名
	private String name;
	//所属组
	private String organizeId;
	//直接领导
	private String reportToUserId;
	//证件类型
	private Integer certifiTypeId;
	//证件号码
	private String certifiCode;
	//登录密码
	private String password;
	//是否允许修改密码
	private String allowChangePassword;
	//职务
	private String workTypeId;
	//员工类型0在编1非在编
	private String userTypeId;
	//是否为任务调度负责人(0是
	private String checkFlag;
	//educationTypeId
	private Integer educationTypeId;
	//家庭电话
	private String homeTel;
	//办公电话
	private String officeTel;
	//移动电话
	private String mobileTele;
	//员工住址
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
	private Integer multiLoginFlag;
	//lastLoginLogId
	private Long lastLoginLogId;
	//tryTimes
	private Integer tryTimes;
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
	//打印软件授权
	private String msn;
	//onlineStatus
	private String onlineStatus;
	//tenantId
	private String tenantId;
	//区县code
	private String districtId;
	//issendmsg
	private String issendmsg;
	//明文密码
	private String mwpassword;
	//时间long类型版本
	private Integer version;
	//手机通讯卡
	private String sim;
	//手机终端标识码
	private String imei;

	/**
	 * Get 员工内部编码
	 */
	@Column(name = "USER_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getUserId() {
		return userId;
	}

	/**
	 * Set 员工内部编码
	 */
	public void setUserId(String userId) {
		this.userId = userId;
		addValidField(FieldNames.userId);
	}

	/**
	 * Get 员工工号
	 */
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	/**
	 * Set 员工工号
	 */
	public void setCode(String code) {
		this.code = code;
		addValidField(FieldNames.code);
	}

	/**
	 * Get 登录名
	 */
	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Set 登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
		addValidField(FieldNames.loginName);
	}

	/**
	 * Get 员工姓名
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Set 员工姓名
	 */
	public void setName(String name) {
		this.name = name;
		addValidField(FieldNames.name);
	}

	/**
	 * Get 所属组
	 */
	@Column(name = "ORGANIZE_ID")
	public String getOrganizeId() {
		return organizeId;
	}

	/**
	 * Set 所属组
	 */
	public void setOrganizeId(String organizeId) {
		this.organizeId = organizeId;
		addValidField(FieldNames.organizeId);
	}

	/**
	 * Get 直接领导
	 */
	@Column(name = "REPORT_TO_USER_ID")
	public String getReportToUserId() {
		return reportToUserId;
	}

	/**
	 * Set 直接领导
	 */
	public void setReportToUserId(String reportToUserId) {
		this.reportToUserId = reportToUserId;
		addValidField(FieldNames.reportToUserId);
	}

	/**
	 * Get 证件类型
	 */
	@Column(name = "CERTIFI_TYPE_ID")
	public Integer getCertifiTypeId() {
		return certifiTypeId;
	}

	/**
	 * Set 证件类型
	 */
	public void setCertifiTypeId(Integer certifiTypeId) {
		this.certifiTypeId = certifiTypeId;
		addValidField(FieldNames.certifiTypeId);
	}

	/**
	 * Get 证件号码
	 */
	@Column(name = "CERTIFI_CODE")
	public String getCertifiCode() {
		return certifiCode;
	}

	/**
	 * Set 证件号码
	 */
	public void setCertifiCode(String certifiCode) {
		this.certifiCode = certifiCode;
		addValidField(FieldNames.certifiCode);
	}

	/**
	 * Get 登录密码
	 */
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	/**
	 * Set 登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
		addValidField(FieldNames.password);
	}

	/**
	 * Get 是否允许修改密码
	 */
	@Column(name = "ALLOW_CHANGE_PASSWORD")
	public String getAllowChangePassword() {
		return allowChangePassword;
	}

	/**
	 * Set 是否允许修改密码
	 */
	public void setAllowChangePassword(String allowChangePassword) {
		this.allowChangePassword = allowChangePassword;
		addValidField(FieldNames.allowChangePassword);
	}

	/**
	 * Get 职务
	 */
	@Column(name = "WORK_TYPE_ID")
	public String getWorkTypeId() {
		return workTypeId;
	}

	/**
	 * Set 职务
	 */
	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
		addValidField(FieldNames.workTypeId);
	}

	/**
	 * Get 员工类型0在编1非在编
	 */
	@Column(name = "USER_TYPE_ID")
	public String getUserTypeId() {
		return userTypeId;
	}

	/**
	 * Set 员工类型0在编1非在编
	 */
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
		addValidField(FieldNames.userTypeId);
	}

	/**
	 * Get 是否为任务调度负责人(0是
	 * ，1否）
	 */
	@Column(name = "CHECK_FLAG")
	public String getCheckFlag() {
		return checkFlag;
	}

	/**
	 * Set 是否为任务调度负责人(0是
	 * ，1否）
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
		addValidField(FieldNames.checkFlag);
	}

	/**
	 * Get educationTypeId
	 */
	@Column(name = "EDUCATION_TYPE_ID")
	public Integer getEducationTypeId() {
		return educationTypeId;
	}

	/**
	 * Set educationTypeId
	 */
	public void setEducationTypeId(Integer educationTypeId) {
		this.educationTypeId = educationTypeId;
		addValidField(FieldNames.educationTypeId);
	}

	/**
	 * Get 家庭电话
	 */
	@Column(name = "HOME_TEL")
	public String getHomeTel() {
		return homeTel;
	}

	/**
	 * Set 家庭电话
	 */
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
		addValidField(FieldNames.homeTel);
	}

	/**
	 * Get 办公电话
	 */
	@Column(name = "OFFICE_TEL")
	public String getOfficeTel() {
		return officeTel;
	}

	/**
	 * Set 办公电话
	 */
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
		addValidField(FieldNames.officeTel);
	}

	/**
	 * Get 移动电话
	 */
	@Column(name = "MOBILE_TELE")
	public String getMobileTele() {
		return mobileTele;
	}

	/**
	 * Set 移动电话
	 */
	public void setMobileTele(String mobileTele) {
		this.mobileTele = mobileTele;
		addValidField(FieldNames.mobileTele);
	}

	/**
	 * Get 员工住址
	 */
	@Column(name = "ADDR_ID")
	public String getAddrId() {
		return addrId;
	}

	/**
	 * Set 员工住址
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
	public Integer getMultiLoginFlag() {
		return multiLoginFlag;
	}

	/**
	 * Set multiLoginFlag
	 */
	public void setMultiLoginFlag(Integer multiLoginFlag) {
		this.multiLoginFlag = multiLoginFlag;
		addValidField(FieldNames.multiLoginFlag);
	}

	/**
	 * Get lastLoginLogId
	 */
	@Column(name = "LAST_LOGIN_LOG_ID")
	public Long getLastLoginLogId() {
		return lastLoginLogId;
	}

	/**
	 * Set lastLoginLogId
	 */
	public void setLastLoginLogId(Long lastLoginLogId) {
		this.lastLoginLogId = lastLoginLogId;
		addValidField(FieldNames.lastLoginLogId);
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
	 * Get 打印软件授权
	 */
	@Column(name = "MSN")
	public String getMsn() {
		return msn;
	}

	/**
	 * Set 打印软件授权
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
	 * Get 区县code
	 */
	@Column(name = "DISTRICT_ID")
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * Set 区县code
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
		addValidField(FieldNames.districtId);
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
	 * Get 明文密码
	 */
	@Column(name = "MWPASSWORD")
	public String getMwpassword() {
		return mwpassword;
	}

	/**
	 * Set 明文密码
	 */
	public void setMwpassword(String mwpassword) {
		this.mwpassword = mwpassword;
		addValidField(FieldNames.mwpassword);
	}

	/**
	 * Get 时间long类型版本
	 */
	@Column(name = "VERSION")
	public Integer getVersion() {
		return version;
	}

	/**
	 * Set 时间long类型版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
		addValidField(FieldNames.version);
	}

	/**
	 * Get 手机通讯卡
	 */
	@Column(name = "SIM")
	public String getSim() {
		return sim;
	}

	/**
	 * Set 手机通讯卡
	 */
	public void setSim(String sim) {
		this.sim = sim;
		addValidField(FieldNames.sim);
	}

	/**
	 * Get 手机终端标识码
	 */
	@Column(name = "IMEI")
	public String getImei() {
		return imei;
	}

	/**
	 * Set 手机终端标识码
	 */
	public void setImei(String imei) {
		this.imei = imei;
		addValidField(FieldNames.imei);
	}

}
