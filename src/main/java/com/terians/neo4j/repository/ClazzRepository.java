package com.terians.neo4j.repository;

import com.terians.neo4j.model.Clazz;
import com.terians.neo4j.model.Method;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ClazzRepository extends GraphRepository<Clazz> {

    @Query("MATCH (c:Clazz) RETURN c")
    Set<Clazz> findAllClazzes();

    @Query("MATCH (c:Clazz {teriansId:{0}}) RETURN c")
    Clazz findClazz(String clazzId);

    @Query("MATCH(c:Clazz {teriansId:{0}})-[:HAS_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllMethods(String clazzId);

    @Query("MATCH(c:Clazz {teriansId:{0}})-[:HAS_METHOD]->(m:Method {teriansId:{1}}) RETURN m")
    Method findMethod(String clazzId, String methodId);

}
