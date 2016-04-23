package org.walle.webtest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Data model for ServiceNow returned Tasks data
 * @author Changjiang.Wang
 *
 */
public class ServiceNowTaskSLAs implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public static class TaskSLA implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String task;
		private String sla;
		private Date sys_updated_on;
		private Incident incident;

		public String getTask() {
			return task;
		}
		public void setTask(String task) {
			this.task = task;
		}
		public String getSla() {
			return sla;
		}
		public void setSla(String sla) {
			this.sla = sla;
		}
		public Date getSys_updated_on() {
			return sys_updated_on;
		}
		public void setSys_updated_on(Date sys_updated_on) {
			this.sys_updated_on = sys_updated_on;
		}
		public Incident getIncident() {
			return incident;
		}
		public void setIncident(Incident incident) {
			this.incident = incident;
		}
	}
	
	public static class Incident implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String number;
		private String company;
		private String short_description;
		private String priority;
		private String incident_state;
		private Date opened_at;
		private String days_opened;
		private String assigned_to;
		
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getShort_description() {
			return short_description;
		}
		public void setShort_description(String short_description) {
			this.short_description = short_description;
		}
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public String getIncident_state() {
			return incident_state;
		}
		public void setIncident_state(String incident_state) {
			this.incident_state = incident_state;
		}
		public Date getOpened_at() {
			return opened_at;
		}
		public void setOpened_at(Date opened_at) {
			this.opened_at = opened_at;
		}
		public String getDays_opened() {
			return days_opened;
		}
		public void setDays_opened(String days_opened) {
			this.days_opened = days_opened;
		}
		public String getAssigned_to() {
			return assigned_to;
		}
		public void setAssigned_to(String assigned_to) {
			this.assigned_to = assigned_to;
		}
	}
	
	
	private List<TaskSLA> records;

	public List<TaskSLA> getRecords() {
		return records;
	}
	public void setRecords(List<TaskSLA> records) {
		this.records = records;
	}
	
}
