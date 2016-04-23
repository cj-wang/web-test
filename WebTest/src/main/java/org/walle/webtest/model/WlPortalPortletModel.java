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
 * Model class for WlPortalPortlet
 */
@Entity
@Table(name = "wl_portal_portlet")
@DynamicInsert
@DynamicUpdate
public class WlPortalPortletModel extends BaseModelClass implements OperationLog {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlPortalPortlet";

	public static final class FieldNames {
		/**
		 * portletId
		 */
		public static final String portletId = "portletId";
		/**
		 * portletName
		 */
		public static final String portletName = "portletName";
		/**
		 * title
		 */
		public static final String title = "title";
		/**
		 * description
		 */
		public static final String description = "description";
		/**
		 * screenshot
		 */
		public static final String screenshot = "screenshot";
		/**
		 * type
		 */
		public static final String type = "type";
		/**
		 * src
		 */
		public static final String src = "src";
		/**
		 * parameters
		 */
		public static final String parameters = "parameters";
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
		 * defaultDisplay
		 */
		public static final String defaultDisplay = "defaultDisplay";
		/**
		 * status
		 */
		public static final String status = "status";
		/**
		 * thirdpartyPortlet
		 */
		public static final String thirdpartyPortlet = "thirdpartyPortlet";
		/**
		 * columnIndex
		 */
		public static final String columnIndex = "columnIndex";
		/**
		 * icon
		 */
		public static final String icon = "icon";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//portletId
	private String portletId;
	//portletName
	private String portletName;
	//title
	private String title;
	//description
	private String description;
	//screenshot
	private String screenshot;
	//type
	private String type;
	//src
	private String src;
	//parameters
	private String parameters;
	//width
	private String width;
	//height
	private String height;
	//seq
	private Integer seq;
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
	//defaultDisplay
	private String defaultDisplay;
	//status
	private String status;
	//thirdpartyPortlet
	private String thirdpartyPortlet;
	//columnIndex
	private Integer columnIndex;
	//icon
	private String icon;
	//tenantId
	private String tenantId;

	/**
	 * Get portletId
	 */
	@Column(name = "PORTLET_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
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
	 * Get portletName
	 */
	@Column(name = "PORTLET_NAME")
	public String getPortletName() {
		return portletName;
	}

	/**
	 * Set portletName
	 */
	public void setPortletName(String portletName) {
		this.portletName = portletName;
		addValidField(FieldNames.portletName);
	}

	/**
	 * Get title
	 */
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	/**
	 * Set title
	 */
	public void setTitle(String title) {
		this.title = title;
		addValidField(FieldNames.title);
	}

	/**
	 * Get description
	 */
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	/**
	 * Set description
	 */
	public void setDescription(String description) {
		this.description = description;
		addValidField(FieldNames.description);
	}

	/**
	 * Get screenshot
	 */
	@Column(name = "SCREENSHOT")
	public String getScreenshot() {
		return screenshot;
	}

	/**
	 * Set screenshot
	 */
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
		addValidField(FieldNames.screenshot);
	}

	/**
	 * Get type
	 */
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	/**
	 * Set type
	 */
	public void setType(String type) {
		this.type = type;
		addValidField(FieldNames.type);
	}

	/**
	 * Get src
	 */
	@Column(name = "SRC")
	public String getSrc() {
		return src;
	}

	/**
	 * Set src
	 */
	public void setSrc(String src) {
		this.src = src;
		addValidField(FieldNames.src);
	}

	/**
	 * Get parameters
	 */
	@Column(name = "PARAMETERS")
	public String getParameters() {
		return parameters;
	}

	/**
	 * Set parameters
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
		addValidField(FieldNames.parameters);
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
	 * Get defaultDisplay
	 */
	@Column(name = "DEFAULT_DISPLAY")
	public String getDefaultDisplay() {
		return defaultDisplay;
	}

	/**
	 * Set defaultDisplay
	 */
	public void setDefaultDisplay(String defaultDisplay) {
		this.defaultDisplay = defaultDisplay;
		addValidField(FieldNames.defaultDisplay);
	}

	/**
	 * Get status
	 */
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	/**
	 * Set status
	 */
	public void setStatus(String status) {
		this.status = status;
		addValidField(FieldNames.status);
	}

	/**
	 * Get thirdpartyPortlet
	 */
	@Column(name = "THIRDPARTY_PORTLET")
	public String getThirdpartyPortlet() {
		return thirdpartyPortlet;
	}

	/**
	 * Set thirdpartyPortlet
	 */
	public void setThirdpartyPortlet(String thirdpartyPortlet) {
		this.thirdpartyPortlet = thirdpartyPortlet;
		addValidField(FieldNames.thirdpartyPortlet);
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
