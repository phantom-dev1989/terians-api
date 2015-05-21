package com.terians.controller;

import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.neo4j.service.MethodService;
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
@RequestMapping("/api/v1/methods")
@Api(value = "methods", description = "Methods API")
public final class MethodsRestController {

    @Autowired
    private MethodService methodService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods")
    public MethodsDTO getMethods() {

        return methodService.findAllMethods();
    }

    @RequestMapping(value = "/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method by methodId")
    public MethodDTO getMethod(@PathVariable("methodId") String methodId) {

        return methodService.findMethod(methodId);
    }
}
