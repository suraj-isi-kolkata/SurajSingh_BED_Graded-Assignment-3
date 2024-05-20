package com.tta.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tta.entity.Ticket;
import com.tta.service.TicketService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TicketController {
	
	private final TicketService service;
	
	@GetMapping("/")
	public String allTickets(Model model, String search) {
		
		if(search == null || search.isEmpty()) {
			model.addAttribute("tickets", service.allTickets());
		} else {
			model.addAttribute("tickets", service.findByKeyword(search));
		}		
		
		return "all-tickets";
	}
	
	@GetMapping("/create-new-ticket")
	public String createNewTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create-form";
	}
	
	@PostMapping("/save-new-ticket")
	public String saveNewTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.save(ticket);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateFormPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticketFromDb", service.get(id));
		return "update-form";
	}
	
	@PostMapping("/update-ticket")
	public String updateTicket(@ModelAttribute("ticketFromDb") Ticket ticket) {
		System.out.println("Ticket -> " + ticket);
		service.update(ticket);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable (value = "id") Long id) {
		service.deleteTicketByid(id);
		return "redirect:/";
	}
	
	

}
