package com.terians.neo4j.repository;

import com.terians.neo4j.model.Method;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface MethodRepository extends GraphRepository<Method> {

    @Query("MATCH (m:Method) RETURN m")
    public Set<Method> findAllMethods();

    @Query("MATCH (m:Method {teriansId:{0}}) RETURN m")
    public Method findMethod(String methodId);

}
