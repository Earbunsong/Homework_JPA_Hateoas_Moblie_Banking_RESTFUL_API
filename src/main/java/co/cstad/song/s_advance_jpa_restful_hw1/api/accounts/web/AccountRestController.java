package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountRestController {
    private final AccountService accountService;
    @GetMapping("/all")
    public CollectionModel<?> findAccount() {
        return accountService.findAll();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountById(@PathVariable("uuid") String uuid) {
        return accountService.findByAccountUuid(uuid);
    }

    @PostMapping
    public EntityModel<?> create(@RequestBody CreateAccountDto createAccountDto){
        return accountService.Create(createAccountDto);
    }
    @PostMapping("/{uuid}/limit-transfer")
    public EntityModel<?> transferLimit(
            @PathVariable String uuid,@RequestBody TransferLimitDto transferLimitDto){
      return accountService.TransferLimitByUuid(uuid,transferLimitDto);
    }
    @PostMapping("/{uuid}/rename")
    public EntityModel<?> renameAccountUuid(@PathVariable String uuid,@RequestBody RenameDto renameDto){
        return accountService.renameAccountByUuid(uuid,renameDto);
    }
    @PutMapping("/{uuid}/close")
    public String accountDisable(@PathVariable String uuid){
       return accountService.disable(uuid);
    }
}