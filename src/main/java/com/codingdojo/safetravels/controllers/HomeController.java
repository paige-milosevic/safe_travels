package com.codingdojo.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.safetravels.models.Expense;
import com.codingdojo.safetravels.services.ExpenseService;

@Controller
public class HomeController {

	@Autowired
	ExpenseService expenseService;
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String dashboard(
			@ModelAttribute("expense") Expense expense, 
			Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String createExpense(
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "redirect:/";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}

	}
	
	@GetMapping("/expense/{id}")
	public String expenseDetail(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense",expense);
		return "detailsExpense.jsp";
	}
	
	@GetMapping("/expense/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		
		return "showExpense.jsp";
	}
	
	// Won't work if I use PutMapping
	@PutMapping("/edit/{id}")
	public String updateExpense(
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/expense/edit/{id}";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
	
}
