package com.vacunas.back.businessDelegatePattern;

import com.vacunas.back.interfaces.BusinessService;
import com.vacunas.back.services.PetService;
import com.vacunas.back.services.UserService;
import com.vacunas.back.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessLookUp {

    @Autowired
    PetService petService;
    @Autowired
    VaccineService vaccineService;
    @Autowired
    UserService userService;

    public BusinessService getBusinessService(String serviceType)
    {
        switch (serviceType.toLowerCase()) {
            case "pets":
                return  petService;
            case "vaccines":
                return vaccineService;
            case "users":
                return userService;
            default:
                return null;
        }
    }
}
