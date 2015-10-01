/* Test Controller
 * 2015/08/06
 * chunming*/
package com.ichunming.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class TestController {
	@RequestMapping(value = "/test")
	public String test() {
		return "index";
	}
}
