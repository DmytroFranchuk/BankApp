package de.telran.bankapp.service.impl;

import de.telran.bankapp.entity.Account;
import de.telran.bankapp.repository.AccountRepository;
import de.telran.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository
                .findAll(Sort.by(Sort.Order.asc("id")));
    }
}
