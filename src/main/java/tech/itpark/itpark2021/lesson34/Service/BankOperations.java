package tech.itpark.itpark2021.lesson34.Service;

import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.math.BigDecimal;
import java.util.Set;

public interface BankOperations {

    Set<BankAccountDto> getAllClients();

    BankAccountDto getClient(long id);

    BankAccountDto createClient(BankAccountDto account);

    void deleteClient(long id);

    BigDecimal getBalance(long id);

    void deposit(BankAccountDto account, BigDecimal value);

    void withdraw(BankAccountDto account, BigDecimal value);
}
