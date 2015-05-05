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

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN order by p.afferent desc Limit {1}")
    public Set<Package> findPackagesByScanOrderedByAfferentCount(String scanId,
                                                                 int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN order by p.efferent desc Limit {1}")
    public Set<Package> findPackagesByScanOrderedByEfferentCount(String scanId,
                                                                 int limit);

    @Query("MATCH (p:Package) RETURN p")
    public Set<Package> findAllPackages();

    @Query("MATCH (p:Package {teriansId:{0}}) RETURN p")
    public Package findPackage(String packageId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz) RETURN c")
    public Set<Clazz> findAllClazzes(String packageId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}}) RETURN c")
    public Clazz findClazz(String packageId, String clazzId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}})-[:HAS_METHOD]->(m:Method) RETURN m")
    public Set<Method> findAllMethods(String packageId, String clazzId);

    @Query("MATCH (p:Package {teriansId:{0}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{1}})-[:HAS_METHOD]->"
            + "(m:Method {teriansId:{2}}) RETURN m")
    public Method findMethod(String packageId, String clazzId, String methodId);

}
