package backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Comparison {

	@GetMapping("comparison")
	public String comparison(@RequestParam(name = "name") String n, @RequestParam(name = "age") int a, Model m) {
		m.addAttribute("name", n);
		m.addAttribute("age", a);
		return "ComparisonTemplate";
	}

}
