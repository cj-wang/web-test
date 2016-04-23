package org.walle.webtest.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.walle.webtest.entity.ServiceNowTaskSLAs;
import org.walle.webtest.entity.ServiceNowTaskSLAs.Incident;
import org.walle.webtest.entity.ServiceNowTaskSLAs.TaskSLA;

/**
 * Controller for test
 * @author Changjiang.Wang
 *
 */
@RestController
public class TestController {
	
	/**
	 * query SLA missed tickets
	 * @return
	 */
	@RequestMapping("/querySlaMissedTickets")
	public ServiceNowTaskSLAs querySlaMissedTickets() {
		ServiceNowTaskSLAs taskSLAs = new ServiceNowTaskSLAs();
		
		taskSLAs.setRecords(new ArrayList<TaskSLA>());
		TaskSLA taskSLA = new TaskSLA();
		taskSLAs.getRecords().add(taskSLA);
		taskSLAs.getRecords().add(taskSLA);
		taskSLAs.getRecords().add(taskSLA);
		taskSLAs.getRecords().add(taskSLA);
		taskSLAs.getRecords().add(taskSLA);
		
		taskSLA.setTask("xxxxxxxxxxxxxx");
		taskSLA.setSla("xxxxxxxxxxxxxx xxxxxxxxxxxxxx xxxxxxxxxxxxxx xxxxxxxxxxxxxx");
		taskSLA.setSys_updated_on(new Date());
		
		Incident incident = new Incident();
		taskSLA.setIncident(incident);
		incident.setCompany("xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx");
		incident.setShort_description("xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx");
		incident.setAssigned_to("xxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxx");
		
		return taskSLAs;
	}
	
}
