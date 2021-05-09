package com.vacunas.back.businessDelegatePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class Client {
    @Autowired
    BusinessDelegate businessService;

    public void setClient(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public Object add(String o) throws ExecutionException, InterruptedException {
        return businessService.add(o);
    }

    public String delete(String o) throws ExecutionException, InterruptedException {
        return businessService.delete(o);
    }

    public Iterable findAll() throws ExecutionException, InterruptedException {
        return businessService.findAll();
    }

    public Object findByName(String name) throws ExecutionException, InterruptedException {
        return businessService.findByName(name);
    }
}
