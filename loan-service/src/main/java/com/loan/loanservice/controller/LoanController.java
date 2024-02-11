package com.loan.loanservice.controller;

import com.loan.loanservice.model.Loan;
import com.loan.loanservice.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoanController {
    private final LoanService loanService;




    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @PostMapping("/loan")
    public String createLoan(@RequestBody Loan loan){
        return loanService.createLoan(loan);
    }
 @GetMapping("/loan/{id}")
    public Loan getLoanById(@PathVariable("id") String id){
        return loanService.getLoanById(id);
 }
    @PutMapping("/loan/{id}")
    public Loan updateLoan(@RequestBody Loan loan,@PathVariable("id") String id){
        return loanService.updateLoan(loan,id);
    }
}

