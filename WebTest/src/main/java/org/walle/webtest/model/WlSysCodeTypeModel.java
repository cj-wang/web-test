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
 * Model class for WlSysCodeType
 */
@Entity
@Table(name = "wl_sys_code_type")
@DynamicInsert
@DynamicUpdate
public class WlSysCodeTypeModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlSysCodeType";

	public static final class FieldNames {
		/**
		 * codeTypeId
		 */
		public static final String codeTypeId = "codeTypeId";
		/**
		 * codeTypeName
		 */
		public static final String codeTypeName = "codeTypeName";
		/**
		 * typeCode
		 */
		public static final String typeCode = "typeCode";
		/**
		 * codeTypeDesc
		 */
		public static final String codeTypeDesc = "codeTypeDesc";
		/**
		 * dateType
		 */
		public static final String dateType = "dateType";
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
		 * system
		 */
		public static final String system = "system";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//codeTypeId
	private String codeTypeId;
	//codeTypeName
	private String codeTypeName;
	//typeCode
	private String typeCode;
	//codeTypeDesc
	private String codeTypeDesc;
	//dateType
	private String dateType;
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
	//system
	private String system;
	//tenantId
	private String tenantId;

	/**
	 * Get codeTypeId
	 */
	@Column(name = "CODE_TYPE_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getCodeTypeId() {
		return codeTypeId;
	}

	/**
	 * Set codeTypeId
	 */
	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
		addValidField(FieldNames.codeTypeId);
	}

	/**
	 * Get codeTypeName
	 */
	@Column(name = "CODE_TYPE_NAME")
	public String getCodeTypeName() {
		return codeTypeName;
	}

	/**
	 * Set codeTypeName
	 */
	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
		addValidField(FieldNames.codeTypeName);
	}

	/**
	 * Get typeCode
	 */
	@Column(name = "TYPE_CODE")
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * Set typeCode
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
		addValidField(FieldNames.typeCode);
	}

	/**
	 * Get codeTypeDesc
	 */
	@Column(name = "CODE_TYPE_DESC")
	public String getCodeTypeDesc() {
		return codeTypeDesc;
	}

	/**
	 * Set codeTypeDesc
	 */
	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
		addValidField(FieldNames.codeTypeDesc);
	}

	/**
	 * Get dateType
	 */
	@Column(name = "DATE_TYPE")
	public String getDateType() {
		return dateType;
	}

	/**
	 * Set dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
		addValidField(FieldNames.dateType);
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
	 * Get system
	 */
	@Column(name = "SYSTEM")
	public String getSystem() {
		return system;
	}

	/**
	 * Set system
	 */
	public void setSystem(String system) {
		this.system = system;
		addValidField(FieldNames.system);
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
