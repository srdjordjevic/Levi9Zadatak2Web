package org.wonderland.dev.levi9.springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		System.out.println(servicesURLs);
		SubmittedMessage msg = new SubmittedMessage();
		model.addAttribute("urls", servicesURLs);
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@ModelAttribute SubmittedMessage msg, Model model) {
        servicesURLs.add(msg.getMessage());
        
        model.addAttribute("urls", servicesURLs);
        msg.setMessage("");
        model.addAttribute("msg", msg);
        System.out.println("URLS: " + servicesURLs);
        return "index";
    }
	
	@RequestMapping(value = "/matches", method = RequestMethod.GET)
    public String matches(Model model) {
		model.addAttribute("urls", servicesURLs);
		return "matches";
	}
}
