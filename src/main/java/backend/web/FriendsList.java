package backend.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import backend.domain.Friend;

@Controller
public class FriendsList {

	List<Friend> allMyFriends = new ArrayList<>();

	@GetMapping("friendsList")
	public String friendsList(Model m) {
		if (allMyFriends.isEmpty()) {
			addOldFriends();
		}
		m.addAttribute("friend", new Friend());
		m.addAttribute("friends", allMyFriends);
		return "FriendsListTemplate";
	}

	@PostMapping("friendsList")
	public String listFriends(@ModelAttribute Friend f, Model m) {
		m.addAttribute("friend", f);
		m.addAttribute("friends", allMyFriends);
		if (addOrNot(f.getName())) {
			allMyFriends.add(f);
		}
		return "FriendsListTemplate";
	}

	private void addOldFriends() {
		Arrays.asList(new String[] { "John West", "Kate Bower", "Mary Smith" }).stream()
				.forEach(s -> allMyFriends.add(new Friend(s)));
	}

	private Boolean addOrNot(String n) {
		return !n.isEmpty() && !allMyFriends.stream().map(mf -> mf.getName()).collect(Collectors.toList()).contains(n);
	}

}
