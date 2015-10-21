package org.walle.webtest.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.walle.webtest.model.ServiceNowTaskSLAs;
import org.walle.webtest.model.ServiceNowTaskSLAs.Incident;
import org.walle.webtest.model.ServiceNowTaskSLAs.TaskSLA;

/**
 * Controller for Thymeleaf demos
 * @author Changjiang.Wang
 *
 */
@Controller
public class LeafDemoController {
	
	/**
	 * leaf demo
	 * @return
	 */
	@RequestMapping("/leafdemo")
	public String leafdemo(Model model) {
		//get data
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
		
		//put data object in model
		model.addAttribute("taskSLAs", taskSLAs);
		model.addAttribute("total", taskSLAs.getRecords().size());
		
		//return view name
		return "views/leafdemo/leafdemo";
	}
	
}
