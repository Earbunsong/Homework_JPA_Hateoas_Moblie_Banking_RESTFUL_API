package co.cstad.song.s_advance_jpa_restful_hw1.api.accountype.web;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accountype.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accountTypes")
public class AccountTypeController {
    private final AccountTypeService accountTypeService;
    @GetMapping
    public CollectionModel<?> getAllAccType(){
        return accountTypeService.findAllAccountType();
    }
    @GetMapping("/{id}")
    public EntityModel<?> getUserById(@PathVariable Long id){
        return accountTypeService.findAccountTypeById(id);
    }
}