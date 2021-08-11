package com.behsa.smsGw.Repository;

import com.behsa.smsGw.Entity.UserLogin;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl {
    private static EntityManager entityManager = null;

    public void findByUserPass(String username, String password) {
        StoredProcedureQuery findByUserPassProcedure =
                entityManager.createNamedStoredProcedureQuery("findByUserPassProcedure");

        StoredProcedureQuery storedProcedure =
                findByUserPassProcedure.setParameter("P_USERNAME", username);
        findByUserPassProcedure.setParameter("P_PASSWORD", password);

        storedProcedure.getResultList()
                .forEach(c -> {
                    ((UserLogin) c).getUsername().equals(username);
                    ((UserLogin) c).getPassword().equals(password);
                });


    }

}
