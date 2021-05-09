package com.vacunas.back.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.vacunas.back.interfaces.BusinessService;
import com.vacunas.back.models.Vaccine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VaccineService implements BusinessService {
    public static final String COL_NAME = "vaccines";

    @Override
    public List<Vaccine> findAll() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        QuerySnapshot query = future.get();
        List<Vaccine> vaccines = null;
        if (!query.isEmpty()) {
            vaccines = query.toObjects(Vaccine.class);
            return vaccines;
        } else {
            return null;
        }
    }

    @Override
    public Vaccine findByName(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Vaccine vaccine = null;
        if (document.exists()) {
            vaccine = document.toObject(Vaccine.class);
            return vaccine;
        } else {
            return null;
        }
    }

    @Override
    public String add(String data) throws InterruptedException, ExecutionException {
        Vaccine vaccine = new Gson().fromJson(data, Vaccine.class);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(vaccine.getFileName()).set(vaccine);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String delete(String name) throws  InterruptedException,
            ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Pet with name "+name+" has been deleted";
    }
}
