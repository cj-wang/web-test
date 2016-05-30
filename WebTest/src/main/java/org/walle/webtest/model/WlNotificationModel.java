package org.walle.webtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.walle.framework.core.model.BaseModelClass;

/**
 * Model class for WlNotification
 */
@Entity
@Table(name = "wl_notification")
@DynamicInsert
@DynamicUpdate
public class WlNotificationModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "WlNotification";

	public static final class FieldNames {
		/**
		 * notificationId
		 */
		public static final String notificationId = "notificationId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * type
		 */
		public static final String type = "type";
		/**
		 * subject
		 */
		public static final String subject = "subject";
		/**
		 * content
		 */
		public static final String content = "content";
		/**
		 * actionTarget
		 */
		public static final String actionTarget = "actionTarget";
		/**
		 * sourceId
		 */
		public static final String sourceId = "sourceId";
		/**
		 * createTime
		 */
		public static final String createTime = "createTime";
		/**
		 * notificationTime
		 */
		public static final String notificationTime = "notificationTime";
	}

	//notificationId
	private String notificationId;
	//userId
	private String userId;
	//type
	private String type;
	//subject
	private String subject;
	//content
	private String content;
	//actionTarget
	private String actionTarget;
	//sourceId
	private String sourceId;
	//createTime
	private Date createTime;
	//notificationTime
	private Date notificationTime;

	/**
	 * Get notificationId
	 */
	@Column(name = "NOTIFICATION_ID")
	@Id @GeneratedValue(generator = "UUIDGenerator")
	public String getNotificationId() {
		return notificationId;
	}

	/**
	 * Set notificationId
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
		addValidField(FieldNames.notificationId);
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
	 * Get subject
	 */
	@Column(name = "SUBJECT")
	public String getSubject() {
		return subject;
	}

	/**
	 * Set subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
		addValidField(FieldNames.subject);
	}

	/**
	 * Get content
	 */
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	/**
	 * Set content
	 */
	public void setContent(String content) {
		this.content = content;
		addValidField(FieldNames.content);
	}

	/**
	 * Get actionTarget
	 */
	@Column(name = "ACTION_TARGET")
	public String getActionTarget() {
		return actionTarget;
	}

	/**
	 * Set actionTarget
	 */
	public void setActionTarget(String actionTarget) {
		this.actionTarget = actionTarget;
		addValidField(FieldNames.actionTarget);
	}

	/**
	 * Get sourceId
	 */
	@Column(name = "SOURCE_ID")
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * Set sourceId
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
		addValidField(FieldNames.sourceId);
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
	 * Get notificationTime
	 */
	@Column(name = "NOTIFICATION_TIME")
	public Date getNotificationTime() {
		return notificationTime;
	}

	/**
	 * Set notificationTime
	 */
	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
		addValidField(FieldNames.notificationTime);
	}

}
