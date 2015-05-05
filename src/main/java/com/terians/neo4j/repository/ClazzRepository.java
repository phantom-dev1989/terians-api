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
    public Set<Clazz> findAllClazzes();

    @Query("MATCH (c:Clazz {teriansId:{0}}) RETURN c")
    public Clazz findClazz(String clazzId);

    @Query("MATCH(c:Clazz {teriansId:{0}})-[:HAS_METHOD]->(m:Method) RETURN m")
    public Set<Method> findAllMethods(String clazzId);

    @Query("MATCH(c:Clazz {teriansId:{0}})-[:HAS_METHOD]->(m:Method {teriansId:{1}}) RETURN m")
    public Method findMethod(String clazzId, String methodId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(c:Clazz) "
            + "RETURN order by c.afferent desc Limit {1}")
    public Set<Clazz> findClazzesByScanOrderedByAfferentCount(String scanId,
                                                              int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(c:Clazz) "
            + "RETURN order by c.efferent desc Limit {1}")
    public Set<Clazz> findClazzesByScanOrderedByEfferentCount(String scanId,
                                                              int limit);

}
