package de.telran.bankapp.service.impl;

import de.telran.bankapp.entity.Transaction;
import de.telran.bankapp.repository.TransactionRepository;
import de.telran.bankapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }
}
