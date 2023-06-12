package com.javarush.repository;




import java.util.Optional;

public interface EntityRepository <T>{



    void delete (T tableEntity);

     void save(T tableEntity);

    void update(T tableEntity);

    T findById(long id);


}