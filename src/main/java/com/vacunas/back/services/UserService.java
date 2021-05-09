package com.vacunas.back.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.vacunas.back.interfaces.BusinessService;
import com.vacunas.back.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService implements BusinessService {
    public static final String COL_NAME = "users";

    @Override
    public List<User> findAll() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        QuerySnapshot query = future.get();
        List<User> users = null;
        if (!query.isEmpty()) {
            users = query.toObjects(User.class);
            return users;
        } else {
            return null;
        }
    }

    @Override
    public User findByName(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user = null;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public String add(String data) throws InterruptedException, ExecutionException {
        User vaccine = new Gson().fromJson(data, User.class);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(vaccine.getEmail()).set(vaccine);
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
