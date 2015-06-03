package org.wonderland.dev.levi9.springboot.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
	
	List<String> servicesURLs = new ArrayList<String>() {
		private static final long serialVersionUID = -8601789272417060700L;
	{{
		add("localhost:9000/api/winnerbet/matches");
		add("localhost:9000/api/bestbet/matches");
	}}};
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		SubmittedMessage message = new SubmittedMessage();
		model.addAttribute("message", message);
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@ModelAttribute SubmittedMessage message, Model model) {
		ClientPOSTRequest req = ClientPOSTRequest.submittedMessageToRequest(message);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(req);
		String url = "http://localhost:9001/";
		try {
			ArbitrageMock page = restTemplate.postForObject(url, req, ArbitrageMock.class, new HashMap<String, String>());
			System.out.println(page);
			model.addAttribute("message", new SubmittedMessage());
			return "index";
		} catch (Exception e) {
			return "servicedown";
		}
    }
	
	@RequestMapping(value = "/matches", method = RequestMethod.GET)
    public String matches(Model model) {
		model.addAttribute("urls", servicesURLs);
		return "matches";
	}
}
