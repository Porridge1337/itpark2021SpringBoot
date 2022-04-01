package tech.itpark.itpark2021.lesson34.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson34.Service.BankOperations;
import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BankController {

    private final BankOperations bankOperations;

    @GetMapping("/allClients")
    public Set<BankAccountDto> allClients() {
        return bankOperations.getAllClients();
    }

    @PatchMapping("/client/{id}/deposit")
    public void deposit(@PathVariable long id,
                        @RequestParam(name = "depo") BigDecimal value) {
        BankAccountDto accountDto = bankOperations.getClient(id);
        bankOperations.deposit(accountDto, value);
    }

    @PatchMapping("/client/{id}/withdraw")
    public void withdraw(@PathVariable long id,
                         @RequestParam(name = "withdr") BigDecimal value) {
        BankAccountDto accountDto = bankOperations.getClient(id);
        bankOperations.withdraw(accountDto, value);
    }

    @GetMapping("/client/{id}")
    public BankAccountDto getClient(@PathVariable long id) {
        return bankOperations.getClient(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/client/{id}/deleteClient")
    public void deleteClient(@PathVariable long id) {
        bankOperations.deleteClient(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addClient")
    public void addNewClient(@RequestBody BankAccountDto account) {
        bankOperations.createClient(account);
        System.out.println(bankOperations.getAllClients());
    }

}
