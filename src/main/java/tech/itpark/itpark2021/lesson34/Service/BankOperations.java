package tech.itpark.itpark2021.lesson34.Service;

import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.math.BigDecimal;
import java.util.Set;

public interface BankOperations {

    Set<BankAccountDto> getAllClients();

    BankAccountDto getClient(long id);

    BankAccountDto createClient(BankAccountDto account);

    BigDecimal getBalance(long id);

    void deposit(long id, BigDecimal value);

    void withdraw(long id, BigDecimal value);
}
