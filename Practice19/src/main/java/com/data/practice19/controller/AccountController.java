package com.data.practice19.controller;

import com.data.practice19.entity.Account;
import com.data.practice19.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "accounts_list";
    }

    @GetMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("account", new Account());
        return "form";
    }

    @PostMapping("/save")
    public String saveAccount(Account account) {
        if (account.getId() == 0 ) {
            accountService.save(account);
        } else {
            accountService.update(account);
        }
        return "redirect:/accounts";
    }

    @GetMapping("/edit/{id}")
    public String editAccount(@PathVariable("id") int id, Model model ) {
        model.addAttribute("account", accountService.findById(id));
        return "form";
    }

//    @PostMapping("/update/{id}")
//    public String updateAccount(@PathVariable("id") Account account) {
//        accountService.update(account);
//        return "redirect:/accounts";
//    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") int id) {
        accountService.deleteById(id);
        return "redirect:/accounts";
    }

}
