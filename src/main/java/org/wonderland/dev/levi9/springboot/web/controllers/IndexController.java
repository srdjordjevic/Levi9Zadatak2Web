package org.wonderland.dev.levi9.springboot.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.wonderland.dev.levi9.springboot.web.mock.ArbitrageMock;
import org.wonderland.dev.levi9.springboot.web.model.ClientPOSTRequest;
import org.wonderland.dev.levi9.springboot.web.model.SubmittedMessage;

@Controller
public class IndexController {
	
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
			ArbitrageMock page = restTemplate.postForObject(url, req, ArbitrageMock.class);
			System.out.println(page);
			model.addAttribute("message", new SubmittedMessage());
			return "index";
		} catch (Exception e) {
			return "servicedown";
		}
    }
}
