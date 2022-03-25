package tech.itpark.itpark2021.lesson34.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson34.Service.BankOperations;
import tech.itpark.itpark2021.lesson34.dto.BankAccountDto;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BankController {

    private final BankOperations bankOperations;

    @GetMapping("/allClients")
    public Set<BankAccountDto> allClients() {
        return bankOperations.getAllClients();
    }

    @GetMapping("/client/{id}")
    public BankAccountDto getClient(@PathVariable long id) {
        return bankOperations.getClient(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addClient")
    public void addNewClient(@RequestBody BankAccountDto account) {
        bankOperations.createClient(account);
        System.out.println(bankOperations.getAllClients());
    }


}
