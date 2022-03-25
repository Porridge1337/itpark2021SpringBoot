package tech.itpark.itpark2021.lesson34.Service.implementation;

import lombok.Setter;
import org.springframework.stereotype.Service;
import tech.itpark.itpark2021.lesson34.Service.BankOperations;
import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@Setter
public class BankOperationsImpl implements BankOperations {

    private Set<BankAccountDto> clients = new HashSet<>();

    @Override
    public Set<BankAccountDto> getAllClients() {
        return clients;
    }

    @Override
    public BankAccountDto getClient(long id) {
        return clients.stream().filter(clients -> clients.getId() == id).findFirst().orElse(null);
    }

    @Override
    public BankAccountDto createClient(BankAccountDto account) {
        clients.add(account);
        return account;
    }

    @Override
    public BigDecimal getBalance(long id) {
        return clients.stream().filter(clients -> clients.getId() == id).findFirst().get().getBalance();
    }

    @Override
    public void deposit(long id, BigDecimal value) {

    }

    @Override
    public void withdraw(long id, BigDecimal value) {

    }
}
