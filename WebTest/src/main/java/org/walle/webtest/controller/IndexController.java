package org.walle.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for index page
 * @author Changjiang.Wang
 *
 */
@Controller
public class IndexController {
	
	/**
	 * index main page
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

}
