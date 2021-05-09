package com.vacunas.back.businessDelegatePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class BusinessDelegate {
    @Autowired
    private BusinessLookUp lookupService;
    private String serviceType;

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public Object add(String o) throws ExecutionException, InterruptedException {
        return lookupService.getBusinessService(serviceType).add(o);
    }

    public String delete(String o) throws ExecutionException, InterruptedException {
        return lookupService.getBusinessService(serviceType).delete(o);
    }

    public Iterable findAll() throws ExecutionException, InterruptedException {
        return lookupService.getBusinessService(serviceType).findAll();
    }

    public Object findByName(String name) throws ExecutionException, InterruptedException {
        return lookupService.getBusinessService(serviceType).findByName(name);
    }
}
