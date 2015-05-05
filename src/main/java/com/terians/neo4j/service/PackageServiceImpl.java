package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public PackagesDTO findAllPackages() {
        return DTOTransformerUtil
                .transformPackageSetToPackagesDTO(packageRepository
                        .findAllPackages());
    }

    @Override
    public PackageDTO findPackage(String packageId) {

        if (packageId != null) {
            return DTOTransformerUtil
                    .transformPackageToPackageDTO(packageRepository
                            .findPackage(packageId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String packageId) {

        if (packageId != null) {
            return DTOTransformerUtil
                    .transformClazzSetToClazzesDTO(packageRepository
                            .findAllClazzes(packageId));
        }
        return null;
    }

    @Override
    public ClazzDTO findClazz(String packageId, String clazzId) {

        if ((packageId != null) && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformClazzToClazzDTO(packageRepository.findClazz(
                            packageId, clazzId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String packageId, String clazzId) {

        if ((packageId != null) && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformMethodSetToMethodsDTO(packageRepository
                            .findAllMethods(packageId, clazzId));
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String packageId, String clazzId,
                                String methodId) {

        if ((packageId != null) && (clazzId != null) && (methodId != null)) {
            return DTOTransformerUtil
                    .transformMethodToMethodDTO(packageRepository.findMethod(
                            packageId, clazzId, methodId));
        }
        return null;
    }
}
