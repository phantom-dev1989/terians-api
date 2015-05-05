package com.terians.neo4j.service;

import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface PackageService {

    PackagesDTO findAllPackages();

    PackageDTO findPackage(String packageId);

    ClazzesDTO findAllClazzes(String packageId);

    ClazzDTO findClazz(String packageId, String clazzId);

    MethodsDTO findAllMethods(String packageId, String clazzId);

    MethodDTO findMethod(String packageId, String clazzId, String methodId);

}
