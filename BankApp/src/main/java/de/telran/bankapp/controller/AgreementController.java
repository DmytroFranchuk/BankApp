package de.telran.bankapp.controller;

import de.telran.bankapp.entity.Agreement;
import de.telran.bankapp.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping
    public List<Agreement> getAll() {
        return agreementService.getAll();
    }

}
