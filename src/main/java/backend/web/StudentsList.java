package backend.web;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backend.domain.Student;

@Controller
public class StudentsList {

	@GetMapping("studentsList")
	public String studentsList(Model m) {
		m.addAttribute("students",
				Arrays.asList(new String[][] { { "Kate", "Cole" }, { "Dan", "Brown" }, { "Mike", "Mars" } }).stream()
						.map(a -> new Student(a[0], a[1])).collect(Collectors.toList()));
		return "StudentsListTemplate";
	}

}
