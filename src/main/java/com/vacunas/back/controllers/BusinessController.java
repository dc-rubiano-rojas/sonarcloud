package com.vacunas.back.controllers;

import com.vacunas.back.businessDelegatePattern.BusinessDelegate;
import com.vacunas.back.businessDelegatePattern.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class BusinessController {
    @Autowired
    BusinessDelegate delegate;
    @Autowired
    Client client;

    private Client getClient(String serviceType) {
        delegate.setServiceType(serviceType);
        client.setClient(delegate);
        return client;
    }

    @GetMapping("/{type}")
    public Iterable findAll(@PathVariable String type) throws ExecutionException, InterruptedException {
        return getClient(type).findAll();
    }

    @GetMapping("/{type}/{name}")
    public Object findByName(@PathVariable String type, @PathVariable String name) throws ExecutionException, InterruptedException {
       return getClient(type).findByName(name);
    }

    @PostMapping("/{type}")
    public Object add(@PathVariable String type, @RequestBody String o) throws ExecutionException, InterruptedException {
        return getClient(type).add(o);
    }

    @PutMapping("/{type}")
    public Object update(@PathVariable String type, @RequestBody String o) throws ExecutionException, InterruptedException {
        return getClient(type).add(o);
    }

    @DeleteMapping("/{type}/{name}")
    public String delete(@PathVariable String type, @PathVariable String name) throws ExecutionException, InterruptedException {
        Object o = getClient(type).findByName(name);
        if (o != null) {
            getClient(type).delete(name);
            return "deleted Successfully";
        }
        return "Not Exists, Not able to delete";
    }
}