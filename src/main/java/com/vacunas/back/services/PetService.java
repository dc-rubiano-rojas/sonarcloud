package com.vacunas.back.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.vacunas.back.interfaces.BusinessService;
import com.vacunas.back.models.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PetService implements BusinessService {
    public static final String COL_NAME = "pets";

    @Override
    public List<Pet> findAll() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        QuerySnapshot query = future.get();
        List<Pet> pets = null;
        if (!query.isEmpty()) {
            pets = query.toObjects(Pet.class);
            return pets;
        } else {
            return null;
        }
    }

    @Override
    public Pet findByName(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Pet pet = null;
        if (document.exists()) {
            pet = document.toObject(Pet.class);
            return pet;
        } else {
            return null;
        }
    }

    @Override
    public String add(String data) throws InterruptedException, ExecutionException {
        Pet pet = new Gson().fromJson(data, Pet.class);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(pet.getName()).set(pet);
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
