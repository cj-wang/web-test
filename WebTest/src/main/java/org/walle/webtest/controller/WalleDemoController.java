package org.walle.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Walle demos
 * @author Changjiang.Wang
 *
 */
@Controller
public class WalleDemoController {
	
	/**
	 * select code demo
	 * @return
	 */
	@RequestMapping("/selectCodeDemo")
	public String selectCodeDemo(Model model) {
		//return view name
		return "views/walleDemo/selectCodeDemo";
	}
	
	@RequestMapping("/tableDemo")
	public String tableDemo(Model model) {
		//return view name
		return "views/walleDemo/tableDemo";
	}
	
}
