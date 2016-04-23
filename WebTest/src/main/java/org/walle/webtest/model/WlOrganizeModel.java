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
 * Model class for WlOrganize
 */
@Entity
@Table(name = "wl_organize")
@DynamicInsert
@DynamicUpdate
public class WlOrganizeModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlOrganize";

	public static final class FieldNames {
		/**
		 * 组织Id
		 */
		public static final String organizeId = "organizeId";
		/**
		 * 组织名称
		 */
		public static final String name = "name";
		/**
		 * districtId
		 */
		public static final String districtId = "districtId";
		/**
		 * 组织类型
		 */
		public static final String organizeTypeId = "organizeTypeId";
		/**
		 * parentOrganizeId
		 */
		public static final String parentOrganizeId = "parentOrganizeId";
		/**
		 * 负责人
		 */
		public static final String manage = "manage";
		/**
		 * 联系人名称
		 */
		public static final String contact = "contact";
		/**
		 * 联系人电话
		 */
		public static final String contactTel = "contactTel";
		/**
		 * fax
		 */
		public static final String fax = "fax";
		/**
		 * email
		 */
		public static final String email = "email";
		/**
		 * leve
		 */
		public static final String leve = "leve";
		/**
		 * ex1
		 */
		public static final String ex1 = "ex1";
		/**
		 * ex2
		 */
		public static final String ex2 = "ex2";
		/**
		 * ex3
		 */
		public static final String ex3 = "ex3";
		/**
		 * ex4
		 */
		public static final String ex4 = "ex4";
		/**
		 * ex5
		 */
		public static final String ex5 = "ex5";
		/**
		 * ex6
		 */
		public static final String ex6 = "ex6";
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
		/**
		 * tsId
		 */
		public static final String tsId = "tsId";
		/**
		 * 组织code
		 */
		public static final String orgCode = "orgCode";
		/**
		 * parentCode
		 */
		public static final String parentCode = "parentCode";
		/**
		 * 区域系数
		 */
		public static final String areaModulus = "areaModulus";
	}

	//组织Id
	private String organizeId;
	//组织名称
	private String name;
	//districtId
	private String districtId;
	//组织类型
	private String organizeTypeId;
	//parentOrganizeId
	private String parentOrganizeId;
	//负责人
	private String manage;
	//联系人名称
	private String contact;
	//联系人电话
	private String contactTel;
	//fax
	private String fax;
	//email
	private String email;
	//leve
	private String leve;
	//ex1
	private String ex1;
	//ex2
	private String ex2;
	//ex3
	private String ex3;
	//ex4
	private String ex4;
	//ex5
	private String ex5;
	//ex6
	private String ex6;
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
	//tsId
	private String tsId;
	//组织code
	private String orgCode;
	//parentCode
	private String parentCode;
	//区域系数
	private String areaModulus;

	/**
	 * Get 组织Id
	 */
	@Column(name = "ORGANIZE_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getOrganizeId() {
		return organizeId;
	}

	/**
	 * Set 组织Id
	 */
	public void setOrganizeId(String organizeId) {
		this.organizeId = organizeId;
		addValidField(FieldNames.organizeId);
	}

	/**
	 * Get 组织名称
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Set 组织名称
	 */
	public void setName(String name) {
		this.name = name;
		addValidField(FieldNames.name);
	}

	/**
	 * Get districtId
	 */
	@Column(name = "DISTRICT_ID")
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * Set districtId
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
		addValidField(FieldNames.districtId);
	}

	/**
	 * Get 组织类型
	 */
	@Column(name = "ORGANIZE_TYPE_ID")
	public String getOrganizeTypeId() {
		return organizeTypeId;
	}

	/**
	 * Set 组织类型
	 */
	public void setOrganizeTypeId(String organizeTypeId) {
		this.organizeTypeId = organizeTypeId;
		addValidField(FieldNames.organizeTypeId);
	}

	/**
	 * Get parentOrganizeId
	 */
	@Column(name = "PARENT_ORGANIZE_ID")
	public String getParentOrganizeId() {
		return parentOrganizeId;
	}

	/**
	 * Set parentOrganizeId
	 */
	public void setParentOrganizeId(String parentOrganizeId) {
		this.parentOrganizeId = parentOrganizeId;
		addValidField(FieldNames.parentOrganizeId);
	}

	/**
	 * Get 负责人
	 */
	@Column(name = "MANAGE")
	public String getManage() {
		return manage;
	}

	/**
	 * Set 负责人
	 */
	public void setManage(String manage) {
		this.manage = manage;
		addValidField(FieldNames.manage);
	}

	/**
	 * Get 联系人名称
	 */
	@Column(name = "CONTACT")
	public String getContact() {
		return contact;
	}

	/**
	 * Set 联系人名称
	 */
	public void setContact(String contact) {
		this.contact = contact;
		addValidField(FieldNames.contact);
	}

	/**
	 * Get 联系人电话
	 */
	@Column(name = "CONTACT_TEL")
	public String getContactTel() {
		return contactTel;
	}

	/**
	 * Set 联系人电话
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
		addValidField(FieldNames.contactTel);
	}

	/**
	 * Get fax
	 */
	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}

	/**
	 * Set fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
		addValidField(FieldNames.fax);
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
	 * Get leve
	 */
	@Column(name = "LEVE")
	public String getLeve() {
		return leve;
	}

	/**
	 * Set leve
	 */
	public void setLeve(String leve) {
		this.leve = leve;
		addValidField(FieldNames.leve);
	}

	/**
	 * Get ex1
	 */
	@Column(name = "EX1")
	public String getEx1() {
		return ex1;
	}

	/**
	 * Set ex1
	 */
	public void setEx1(String ex1) {
		this.ex1 = ex1;
		addValidField(FieldNames.ex1);
	}

	/**
	 * Get ex2
	 */
	@Column(name = "EX2")
	public String getEx2() {
		return ex2;
	}

	/**
	 * Set ex2
	 */
	public void setEx2(String ex2) {
		this.ex2 = ex2;
		addValidField(FieldNames.ex2);
	}

	/**
	 * Get ex3
	 */
	@Column(name = "EX3")
	public String getEx3() {
		return ex3;
	}

	/**
	 * Set ex3
	 */
	public void setEx3(String ex3) {
		this.ex3 = ex3;
		addValidField(FieldNames.ex3);
	}

	/**
	 * Get ex4
	 */
	@Column(name = "EX4")
	public String getEx4() {
		return ex4;
	}

	/**
	 * Set ex4
	 */
	public void setEx4(String ex4) {
		this.ex4 = ex4;
		addValidField(FieldNames.ex4);
	}

	/**
	 * Get ex5
	 */
	@Column(name = "EX5")
	public String getEx5() {
		return ex5;
	}

	/**
	 * Set ex5
	 */
	public void setEx5(String ex5) {
		this.ex5 = ex5;
		addValidField(FieldNames.ex5);
	}

	/**
	 * Get ex6
	 */
	@Column(name = "EX6")
	public String getEx6() {
		return ex6;
	}

	/**
	 * Set ex6
	 */
	public void setEx6(String ex6) {
		this.ex6 = ex6;
		addValidField(FieldNames.ex6);
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

	/**
	 * Get tsId
	 */
	@Column(name = "TS_ID")
	public String getTsId() {
		return tsId;
	}

	/**
	 * Set tsId
	 */
	public void setTsId(String tsId) {
		this.tsId = tsId;
		addValidField(FieldNames.tsId);
	}

	/**
	 * Get 组织code
	 * 用于业务处理
	 */
	@Column(name = "org_code")
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * Set 组织code
	 * 用于业务处理
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
		addValidField(FieldNames.orgCode);
	}

	/**
	 * Get parentCode
	 */
	@Column(name = "parent_code")
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * Set parentCode
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
		addValidField(FieldNames.parentCode);
	}

	/**
	 * Get 区域系数
	 */
	@Column(name = "area_modulus")
	public String getAreaModulus() {
		return areaModulus;
	}

	/**
	 * Set 区域系数
	 */
	public void setAreaModulus(String areaModulus) {
		this.areaModulus = areaModulus;
		addValidField(FieldNames.areaModulus);
	}

}
