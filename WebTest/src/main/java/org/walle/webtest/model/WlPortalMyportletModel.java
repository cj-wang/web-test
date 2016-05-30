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
 * Model class for WlPortalMyportlet
 */
@Entity
@Table(name = "wl_portal_myportlet")
@DynamicInsert
@DynamicUpdate
public class WlPortalMyportletModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlPortalMyportlet";

	public static final class FieldNames {
		/**
		 * myportletId
		 */
		public static final String myportletId = "myportletId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * portletId
		 */
		public static final String portletId = "portletId";
		/**
		 * width
		 */
		public static final String width = "width";
		/**
		 * height
		 */
		public static final String height = "height";
		/**
		 * seq
		 */
		public static final String seq = "seq";
		/**
		 * columnIndex
		 */
		public static final String columnIndex = "columnIndex";
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

	//myportletId
	private String myportletId;
	//userId
	private String userId;
	//portletId
	private String portletId;
	//width
	private String width;
	//height
	private String height;
	//seq
	private Integer seq;
	//columnIndex
	private Integer columnIndex;
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
	 * Get myportletId
	 */
	@Column(name = "MYPORTLET_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getMyportletId() {
		return myportletId;
	}

	/**
	 * Set myportletId
	 */
	public void setMyportletId(String myportletId) {
		this.myportletId = myportletId;
		addValidField(FieldNames.myportletId);
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
	 * Get portletId
	 */
	@Column(name = "PORTLET_ID")
	public String getPortletId() {
		return portletId;
	}

	/**
	 * Set portletId
	 */
	public void setPortletId(String portletId) {
		this.portletId = portletId;
		addValidField(FieldNames.portletId);
	}

	/**
	 * Get width
	 */
	@Column(name = "WIDTH")
	public String getWidth() {
		return width;
	}

	/**
	 * Set width
	 */
	public void setWidth(String width) {
		this.width = width;
		addValidField(FieldNames.width);
	}

	/**
	 * Get height
	 */
	@Column(name = "HEIGHT")
	public String getHeight() {
		return height;
	}

	/**
	 * Set height
	 */
	public void setHeight(String height) {
		this.height = height;
		addValidField(FieldNames.height);
	}

	/**
	 * Get seq
	 */
	@Column(name = "SEQ")
	public Integer getSeq() {
		return seq;
	}

	/**
	 * Set seq
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
		addValidField(FieldNames.seq);
	}

	/**
	 * Get columnIndex
	 */
	@Column(name = "COLUMN_INDEX")
	public Integer getColumnIndex() {
		return columnIndex;
	}

	/**
	 * Set columnIndex
	 */
	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
		addValidField(FieldNames.columnIndex);
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
