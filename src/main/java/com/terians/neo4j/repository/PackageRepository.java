package com.terians.neo4j.repository;

import com.terians.neo4j.model.Clazz;
import com.terians.neo4j.model.Method;
import com.terians.neo4j.model.Package;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface PackageRepository extends GraphRepository<Package> {

    @Query("MATCH (p:Package) RETURN p")
    Set<Package> findAllPackages();

    @Query("MATCH (p:Package {teriansId:{0}}) RETURN p")
    Package findPackage(String packageId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllClazzes(String packageId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}}) RETURN c")
    Clazz findClazz(String packageId, String clazzId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}})-[:HAS_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllMethods(String packageId, String clazzId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}})-[:HAS_METHOD]->"
            + "(m:Method {teriansId:{2}}) RETURN m")
    Method findMethod(String packageId, String clazzId, String methodId);

}
