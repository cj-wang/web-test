package org.walle.webtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.walle.framework.core.model.BaseModelClass;

/**
 * Model class for WlPortalRolePortlet
 */
@Entity
@Table(name = "wl_portal_role_portlet")
@DynamicInsert
@DynamicUpdate
public class WlPortalRolePortletModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlPortalRolePortlet";

	public static final class FieldNames {
		/**
		 * rolePortletId
		 */
		public static final String rolePortletId = "rolePortletId";
		/**
		 * roleId
		 */
		public static final String roleId = "roleId";
		/**
		 * portletId
		 */
		public static final String portletId = "portletId";
		/**
		 * defaultDisplay
		 */
		public static final String defaultDisplay = "defaultDisplay";
		/**
		 * tenantId
		 */
		public static final String tenantId = "tenantId";
	}

	//rolePortletId
	private String rolePortletId;
	//roleId
	private String roleId;
	//portletId
	private String portletId;
	//defaultDisplay
	private String defaultDisplay;
	//tenantId
	private String tenantId;

	/**
	 * Get rolePortletId
	 */
	@Column(name = "ROLE_PORTLET_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getRolePortletId() {
		return rolePortletId;
	}

	/**
	 * Set rolePortletId
	 */
	public void setRolePortletId(String rolePortletId) {
		this.rolePortletId = rolePortletId;
		addValidField(FieldNames.rolePortletId);
	}

	/**
	 * Get roleId
	 */
	@Column(name = "ROLE_ID")
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Set roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
		addValidField(FieldNames.roleId);
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
