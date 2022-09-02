package backend.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListFriends {

	private List<String> allMyFriends = new ArrayList<>();

	@GetMapping("index")
	public String listFriends(@RequestParam(name = "friend", required = false, defaultValue = "") String f, Model m) {
		if (allMyFriends.isEmpty()) {
			addOldFriends();
		}
		if (addOrNot(f)) {
			allMyFriends.add(f);
		}
		m.addAttribute("friend", f);
		m.addAttribute("friends", allMyFriends);
		return "IndexTemplate";
	}

	private void addOldFriends() {
		Arrays.asList(new String[] { "John West", "Kate Bower", "Mary Smith" }).stream()
				.forEach(s -> allMyFriends.add(s));
	}

	private Boolean addOrNot(String f) {
		return !f.isEmpty() && !allMyFriends.contains(f);
	}

}
