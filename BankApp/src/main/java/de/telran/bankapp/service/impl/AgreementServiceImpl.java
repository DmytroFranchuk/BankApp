package de.telran.bankapp.service.impl;

import de.telran.bankapp.entity.Agreement;
import de.telran.bankapp.repository.AgreementRepository;
import de.telran.bankapp.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public List<Agreement> getAll() {
        return agreementRepository
                .findAll(Sort.by(Sort.Order.asc("id")));
    }
}
