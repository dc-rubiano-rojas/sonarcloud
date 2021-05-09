package com.vacunas.back.interfaces;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface BusinessService {
    public String add(String o) throws InterruptedException, ExecutionException;
    public String delete(String o) throws InterruptedException, ExecutionException;
    public Iterable findAll() throws InterruptedException, ExecutionException;
    public Object findByName(String name) throws InterruptedException, ExecutionException;
}
