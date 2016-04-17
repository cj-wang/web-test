package org.walle.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for index page
 * @author Changjiang.Wang
 *
 */
@Controller
public class IndexController {
	
	/**
	 * Generic view mapping
	 * @param viewname
	 * @return
	 */
	@RequestMapping("/**/{viewname:^[^.]*$}")
	public String views(@PathVariable String viewname) {
		return "index";
	}

}
