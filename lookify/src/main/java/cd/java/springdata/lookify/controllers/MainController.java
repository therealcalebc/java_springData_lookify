/**
 * 
 */
package cd.java.springdata.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ccomstock
 *
 */
@Controller
public class MainController {

	@GetMapping("/start")
	public String start() {
		return "redirect:/dashboard";
	}
	
}
