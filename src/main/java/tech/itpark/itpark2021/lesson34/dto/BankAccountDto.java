package tech.itpark.itpark2021.lesson34.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {

    private long id;
    private String name;
    private BigDecimal balance;
}
