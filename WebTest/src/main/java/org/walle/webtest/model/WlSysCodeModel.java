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
 * Model class for WlSysCode
 */
@Entity
@Table(name = "wl_sys_code")
@DynamicInsert
@DynamicUpdate
public class WlSysCodeModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlSysCode";

	public static final class FieldNames {
		/**
		 * codeId
		 */
		public static final String codeId = "codeId";
		/**
		 * codeTypeId
		 */
		public static final String codeTypeId = "codeTypeId";
		/**
		 * codeName
		 */
		public static final String codeName = "codeName";
		/**
		 * codeValue
		 */
		public static final String codeValue = "codeValue";
		/**
		 * icon
		 */
		public static final String icon = "icon";
		/**
		 * parentCodeValue
		 */
		public static final String parentCodeValue = "parentCodeValue";
		/**
		 * codeDesc
		 */
		public static final String codeDesc = "codeDesc";
		/**
		 * codeGroup
		 */
		public static final String codeGroup = "codeGroup";
		/**
		 * sort
		 */
		public static final String sort = "sort";
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
		/**
		 * version
		 */
		public static final String version = "version";
	}

	//codeId
	private String codeId;
	//codeTypeId
	private String codeTypeId;
	//codeName
	private String codeName;
	//codeValue
	private String codeValue;
	//icon
	private String icon;
	//parentCodeValue
	private String parentCodeValue;
	//codeDesc
	private String codeDesc;
	//codeGroup
	private String codeGroup;
	//sort
	private Long sort;
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
	//version
	private Long version;

	/**
	 * Get codeId
	 */
	@Column(name = "CODE_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getCodeId() {
		return codeId;
	}

	/**
	 * Set codeId
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
		addValidField(FieldNames.codeId);
	}

	/**
	 * Get codeTypeId
	 */
	@Column(name = "CODE_TYPE_ID")
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
	 * Get codeName
	 */
	@Column(name = "CODE_NAME")
	public String getCodeName() {
		return codeName;
	}

	/**
	 * Set codeName
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
		addValidField(FieldNames.codeName);
	}

	/**
	 * Get codeValue
	 */
	@Column(name = "CODE_VALUE")
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * Set codeValue
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
		addValidField(FieldNames.codeValue);
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
	 * Get parentCodeValue
	 */
	@Column(name = "PARENT_CODE_VALUE")
	public String getParentCodeValue() {
		return parentCodeValue;
	}

	/**
	 * Set parentCodeValue
	 */
	public void setParentCodeValue(String parentCodeValue) {
		this.parentCodeValue = parentCodeValue;
		addValidField(FieldNames.parentCodeValue);
	}

	/**
	 * Get codeDesc
	 */
	@Column(name = "CODE_DESC")
	public String getCodeDesc() {
		return codeDesc;
	}

	/**
	 * Set codeDesc
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
		addValidField(FieldNames.codeDesc);
	}

	/**
	 * Get codeGroup
	 */
	@Column(name = "CODE_GROUP")
	public String getCodeGroup() {
		return codeGroup;
	}

	/**
	 * Set codeGroup
	 */
	public void setCodeGroup(String codeGroup) {
		this.codeGroup = codeGroup;
		addValidField(FieldNames.codeGroup);
	}

	/**
	 * Get sort
	 */
	@Column(name = "SORT")
	public Long getSort() {
		return sort;
	}

	/**
	 * Set sort
	 */
	public void setSort(Long sort) {
		this.sort = sort;
		addValidField(FieldNames.sort);
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

	/**
	 * Get version
	 */
	@Column(name = "VERSION")
	public Long getVersion() {
		return version;
	}

	/**
	 * Set version
	 */
	public void setVersion(Long version) {
		this.version = version;
		addValidField(FieldNames.version);
	}

}
