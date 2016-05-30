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
 * Model class for WlFunction
 */
@Entity
@Table(name = "wl_function")
@DynamicInsert
@DynamicUpdate
public class WlFunctionModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlFunction";

	public static final class FieldNames {
		/**
		 * funcId
		 */
		public static final String funcId = "funcId";
		/**
		 * funcCode
		 */
		public static final String funcCode = "funcCode";
		/**
		 * name
		 */
		public static final String name = "name";
		/**
		 * parentId
		 */
		public static final String parentId = "parentId";
		/**
		 * funcLevel
		 */
		public static final String funcLevel = "funcLevel";
		/**
		 * funSeq
		 */
		public static final String funSeq = "funSeq";
		/**
		 * viewname
		 */
		public static final String viewname = "viewname";
		/**
		 * dllPath
		 */
		public static final String dllPath = "dllPath";
		/**
		 * funcImg
		 */
		public static final String funcImg = "funcImg";
		/**
		 * funcArg
		 */
		public static final String funcArg = "funcArg";
		/**
		 * funcType
		 */
		public static final String funcType = "funcType";
		/**
		 * disabled
		 */
		public static final String disabled = "disabled";
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
		 * sys
		 */
		public static final String sys = "sys";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//funcId
	private String funcId;
	//funcCode
	private String funcCode;
	//name
	private String name;
	//parentId
	private String parentId;
	//funcLevel
	private Integer funcLevel;
	//funSeq
	private Integer funSeq;
	//viewname
	private String viewname;
	//dllPath
	private String dllPath;
	//funcImg
	private String funcImg;
	//funcArg
	private String funcArg;
	//funcType
	private String funcType;
	//disabled
	private String disabled;
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
	//sys
	private String sys;
	//tenantId
	private String tenantId;

	/**
	 * Get funcId
	 */
	@Column(name = "FUNC_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getFuncId() {
		return funcId;
	}

	/**
	 * Set funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
		addValidField(FieldNames.funcId);
	}

	/**
	 * Get funcCode
	 */
	@Column(name = "FUNC_CODE")
	public String getFuncCode() {
		return funcCode;
	}

	/**
	 * Set funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
		addValidField(FieldNames.funcCode);
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
	 * Get parentId
	 */
	@Column(name = "PARENT_ID")
	public String getParentId() {
		return parentId;
	}

	/**
	 * Set parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
		addValidField(FieldNames.parentId);
	}

	/**
	 * Get funcLevel
	 */
	@Column(name = "FUNC_LEVEL")
	public Integer getFuncLevel() {
		return funcLevel;
	}

	/**
	 * Set funcLevel
	 */
	public void setFuncLevel(Integer funcLevel) {
		this.funcLevel = funcLevel;
		addValidField(FieldNames.funcLevel);
	}

	/**
	 * Get funSeq
	 */
	@Column(name = "FUN_SEQ")
	public Integer getFunSeq() {
		return funSeq;
	}

	/**
	 * Set funSeq
	 */
	public void setFunSeq(Integer funSeq) {
		this.funSeq = funSeq;
		addValidField(FieldNames.funSeq);
	}

	/**
	 * Get viewname
	 */
	@Column(name = "VIEWNAME")
	public String getViewname() {
		return viewname;
	}

	/**
	 * Set viewname
	 */
	public void setViewname(String viewname) {
		this.viewname = viewname;
		addValidField(FieldNames.viewname);
	}

	/**
	 * Get dllPath
	 */
	@Column(name = "DLL_PATH")
	public String getDllPath() {
		return dllPath;
	}

	/**
	 * Set dllPath
	 */
	public void setDllPath(String dllPath) {
		this.dllPath = dllPath;
		addValidField(FieldNames.dllPath);
	}

	/**
	 * Get funcImg
	 */
	@Column(name = "FUNC_IMG")
	public String getFuncImg() {
		return funcImg;
	}

	/**
	 * Set funcImg
	 */
	public void setFuncImg(String funcImg) {
		this.funcImg = funcImg;
		addValidField(FieldNames.funcImg);
	}

	/**
	 * Get funcArg
	 */
	@Column(name = "FUNC_ARG")
	public String getFuncArg() {
		return funcArg;
	}

	/**
	 * Set funcArg
	 */
	public void setFuncArg(String funcArg) {
		this.funcArg = funcArg;
		addValidField(FieldNames.funcArg);
	}

	/**
	 * Get funcType
	 */
	@Column(name = "FUNC_TYPE")
	public String getFuncType() {
		return funcType;
	}

	/**
	 * Set funcType
	 */
	public void setFuncType(String funcType) {
		this.funcType = funcType;
		addValidField(FieldNames.funcType);
	}

	/**
	 * Get disabled
	 */
	@Column(name = "DISABLED")
	public String getDisabled() {
		return disabled;
	}

	/**
	 * Set disabled
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
		addValidField(FieldNames.disabled);
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
	 * Get sys
	 */
	@Column(name = "SYS")
	public String getSys() {
		return sys;
	}

	/**
	 * Set sys
	 */
	public void setSys(String sys) {
		this.sys = sys;
		addValidField(FieldNames.sys);
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
