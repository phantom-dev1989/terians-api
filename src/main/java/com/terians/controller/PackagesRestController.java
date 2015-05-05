package com.terians.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.PackageService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stromero on 3/4/2015.
 */
@RestController
@RequestMapping("/api/v1/packages")
@Api(value = "packages", description = "Packages API")
public class PackagesRestController {

    @Autowired
    private PackageService packageService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Packages", notes = "Returns all packages")
    public PackagesDTO getPackages() {

        return packageService.findAllPackages();
    }

    @RequestMapping(value = "/{packageId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Package", notes = "Returns a package by packageId")
    public PackageDTO getPackage(@PathVariable("packageId") String packageId) {

        return packageService.findPackage(packageId);
    }

    @RequestMapping(value = "/{packageId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Classes", notes = "Returns all classes of a package by packageId")
    public ClazzesDTO getClazzes(@PathVariable("packageId") String packageId) {

        return packageService.findAllClazzes(packageId);
    }

    @RequestMapping(value = "/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Class", notes = "Returns a class of a package by packageId, classId")
    public ClazzDTO getClazz(@PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {

        return packageService.findClazz(packageId, clazzId);
    }

    @RequestMapping(value = "/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods of a class within a "
            + "package by packageId, classId")
    public MethodsDTO getMethods(@PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {

        return packageService.findAllMethods(packageId, clazzId);
    }

    @RequestMapping(value = "/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method of a class within a package "
            + "by packageId, classId, methodId")
    public MethodDTO getMethod(@PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return packageService.findMethod(packageId, clazzId, methodId);
    }
}
