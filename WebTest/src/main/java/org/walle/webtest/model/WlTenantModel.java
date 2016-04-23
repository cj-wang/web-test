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
 * Model class for WlTenant
 */
@Entity
@Table(name = "wl_tenant")
@DynamicInsert
@DynamicUpdate
public class WlTenantModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlTenant";

	public static final class FieldNames {
		/**
		 * uuid
		 */
		public static final String uuid = "uuid";
		/**
		 * tenantName
		 */
		public static final String tenantName = "tenantName";
		/**
		 * recVer
		 */
		public static final String recVer = "recVer";
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
	}

	//uuid
	private String uuid;
	//tenantName
	private String tenantName;
	//recVer
	private Long recVer;
	//creator
	private String creator;
	//createTime
	private Date createTime;
	//modifier
	private String modifier;
	//modifyTime
	private Date modifyTime;

	/**
	 * Get uuid
	 */
	@Column(name = "UUID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getUuid() {
		return uuid;
	}

	/**
	 * Set uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
		addValidField(FieldNames.uuid);
	}

	/**
	 * Get tenantName
	 */
	@Column(name = "TENANT_NAME")
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * Set tenantName
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
		addValidField(FieldNames.tenantName);
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

}
