package de.telran.bankapp.service;

import de.telran.bankapp.entity.Product;
import de.telran.bankapp.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
}
