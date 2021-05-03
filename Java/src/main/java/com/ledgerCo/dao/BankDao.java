package com.ledgerCo.dao;

import com.ledgerCo.models.Bank;

import java.util.HashMap;

public class BankDao implements Dao<Bank> {
    private final HashMap<String, Bank> banks = new HashMap<>();

    @Override
    public Bank get(String name) {
        return banks.getOrDefault(name, null);
    }

    @Override
    public HashMap<String, Bank> getAll() {
        return banks;
    }

    @Override
    public void save(Bank bank) {
        banks.put(bank.getName(), bank);
    }
}
