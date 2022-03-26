package tech.itpark.itpark2021.lesson34.Service.implementation;

import lombok.Setter;
import org.springframework.stereotype.Service;
import tech.itpark.itpark2021.lesson34.Service.BankOperations;
import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
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
    public void deleteClient(long id) {
        findAndDelete(id);
    }

    @Override
    public BigDecimal getBalance(long id) {
        return clients.stream().filter(clients -> clients.getId() == id).findFirst().get().getBalance();
    }

    @Override
    public void deposit(BankAccountDto account, BigDecimal value) {
        findAndUpdate(account.getId(), true, value);
    }

    @Override
    public void withdraw(BankAccountDto account, BigDecimal value) {
        findAndUpdate(account.getId(), false, value);
    }

    private void findAndUpdate(long id, boolean depositOrWithdraw, BigDecimal value) {
        for (Iterator<BankAccountDto> i = clients.iterator(); i.hasNext(); ) {
            BankAccountDto accountDto = i.next();
            if (id == accountDto.getId()) {
                if (depositOrWithdraw) {
                    accountDto.setBalance(accountDto.getBalance().add(value));
                } else {
                    accountDto.setBalance(accountDto.getBalance().subtract(value));
                }
            }
        }
    }

    private void findAndDelete(long id) {
        for (Iterator<BankAccountDto> i = clients.iterator(); i.hasNext(); ) {
            BankAccountDto accountDto = i.next();
            if (id == accountDto.getId()) {
                clients.remove(accountDto);
            }
        }
    }
}
