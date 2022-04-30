package com.codingdojo.safetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.safetravels.models.Expense;
import com.codingdojo.safetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	// List All Expenses
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// Create Expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	// Edit Expense
	public Expense oneExpense(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
	
}
