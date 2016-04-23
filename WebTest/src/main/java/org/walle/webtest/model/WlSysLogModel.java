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
 * Model class for WlSysLog
 */
@Entity
@Table(name = "wl_sys_log")
@DynamicInsert
@DynamicUpdate
public class WlSysLogModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlSysLog";

	public static final class FieldNames {
		/**
		 * logId
		 */
		public static final String logId = "logId";
		/**
		 * operUserId
		 */
		public static final String operUserId = "operUserId";
		/**
		 * logDate
		 */
		public static final String logDate = "logDate";
		/**
		 * operOject
		 */
		public static final String operOject = "operOject";
		/**
		 * operAction
		 */
		public static final String operAction = "operAction";
		/**
		 * modiRecords
		 */
		public static final String modiRecords = "modiRecords";
		/**
		 * logDesc
		 */
		public static final String logDesc = "logDesc";
		/**
		 * result
		 */
		public static final String result = "result";
		/**
		 * state
		 */
		public static final String state = "state";
		/**
		 * remarks
		 */
		public static final String remarks = "remarks";
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

	//logId
	private String logId;
	//operUserId
	private String operUserId;
	//logDate
	private Date logDate;
	//operOject
	private String operOject;
	//operAction
	private String operAction;
	//modiRecords
	private Long modiRecords;
	//logDesc
	private String logDesc;
	//result
	private String result;
	//state
	private String state;
	//remarks
	private String remarks;
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
	 * Get logId
	 */
	@Column(name = "LOG_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getLogId() {
		return logId;
	}

	/**
	 * Set logId
	 */
	public void setLogId(String logId) {
		this.logId = logId;
		addValidField(FieldNames.logId);
	}

	/**
	 * Get operUserId
	 */
	@Column(name = "OPER_USER_ID")
	public String getOperUserId() {
		return operUserId;
	}

	/**
	 * Set operUserId
	 */
	public void setOperUserId(String operUserId) {
		this.operUserId = operUserId;
		addValidField(FieldNames.operUserId);
	}

	/**
	 * Get logDate
	 */
	@Column(name = "LOG_DATE")
	public Date getLogDate() {
		return logDate;
	}

	/**
	 * Set logDate
	 */
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
		addValidField(FieldNames.logDate);
	}

	/**
	 * Get operOject
	 */
	@Column(name = "OPER_OJECT")
	public String getOperOject() {
		return operOject;
	}

	/**
	 * Set operOject
	 */
	public void setOperOject(String operOject) {
		this.operOject = operOject;
		addValidField(FieldNames.operOject);
	}

	/**
	 * Get operAction
	 */
	@Column(name = "OPER_ACTION")
	public String getOperAction() {
		return operAction;
	}

	/**
	 * Set operAction
	 */
	public void setOperAction(String operAction) {
		this.operAction = operAction;
		addValidField(FieldNames.operAction);
	}

	/**
	 * Get modiRecords
	 */
	@Column(name = "MODI_RECORDS")
	public Long getModiRecords() {
		return modiRecords;
	}

	/**
	 * Set modiRecords
	 */
	public void setModiRecords(Long modiRecords) {
		this.modiRecords = modiRecords;
		addValidField(FieldNames.modiRecords);
	}

	/**
	 * Get logDesc
	 */
	@Column(name = "LOG_DESC")
	public String getLogDesc() {
		return logDesc;
	}

	/**
	 * Set logDesc
	 */
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
		addValidField(FieldNames.logDesc);
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
