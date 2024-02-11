package com.loan.loanservice.service;

import com.loan.loanservice.entity.LoanEntity;
import com.loan.loanservice.exception.InvalidInputException;
import com.loan.loanservice.exception.LoanNotFoundException;
import com.loan.loanservice.model.Loan;
import com.loan.loanservice.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public String createLoan(Loan loan) {
        validateLoanRequest(loan);
        LoanEntity loanEntity=new LoanEntity();
        loanEntity.setAddress(loan.getAddres());
        loanEntity.setName(loan.getName());
        loanEntity.setAmount(loan.getAmount());
        LoanEntity loanEntity1=loanRepository.save(loanEntity);
        return Long.toString(loanEntity1.getId());
    }

    private void validateLoanRequest(Loan loan) {
        if (loan.getName()==null){
            throw new InvalidInputException("Name Must not be null::"+loan.getName());
        } else if (loan.getAddres()==null){
            throw new InvalidInputException("Address Must not be null::"+loan.getAddres());
        }
    }

    public Loan getLoanById(String id) {
        LoanEntity loanEntity1 = loanRepository.findById(Long.valueOf(id)).orElseThrow(()->new LoanNotFoundException("Loan account number not found"));
        Loan loan=new Loan();
        loan.setId(String.valueOf(loanEntity1.getId()));
        loan.setName(loanEntity1.getName());
        loan.setAddres(loanEntity1.getAddress());
        loan.setAmount(loanEntity1.getAmount());
        return loan;
    }

    public Loan updateLoan(Loan loan, String id) {
        LoanEntity loanEntity = loanRepository.
    }
}
