package com.data.session07.service;

import com.data.session07.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberSerive {
    private NumberRepository numberRepo;
    @Override
    public int getTotal(int a, int b) {
        return numberRepo.getTotal(a,b);
    }
}
