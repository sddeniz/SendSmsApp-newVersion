package com.behsa.smsGw.Repository;

import com.behsa.smsGw.Entity.UserLogin;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static EntityManager entityManager ;

    @Override
    public UserLogin findByUsername(String username) {
        return null;
    }

//    @Override
//    public UserLogin findByUserPass(String username,String password) {
//        return null;
//    }

    public UserLogin findByUserPass(String username,String password) {
        StoredProcedureQuery findByUserPassProcedure =
                entityManager.createNamedStoredProcedureQuery("findByUserPassProcedure");

        StoredProcedureQuery storedProcedure =
                findByUserPassProcedure.setParameter("P_USERNAME", username);
        findByUserPassProcedure.setParameter("P_PASSWORD", password);

        storedProcedure.getResultList()
                .forEach(c -> {
                    ((UserLogin) c).getP_USERNAME().equals(username);
                    ((UserLogin) c).getP_PASSWORD().equals(password);
                });


        return null;
    }

    @Override
    public List<UserLogin> findAll() {
        return null;
    }

    @Override
    public List<UserLogin> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserLogin> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserLogin> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserLogin entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserLogin> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserLogin> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UserLogin> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UserLogin> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserLogin> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UserLogin> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<UserLogin> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserLogin getOne(Long aLong) {
        return null;
    }

    @Override
    public UserLogin getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserLogin> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserLogin> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserLogin> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserLogin> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserLogin> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserLogin> boolean exists(Example<S> example) {
        return false;
    }


}
