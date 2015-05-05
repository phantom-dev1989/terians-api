package com.terians.controller;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.neo4j.service.ClazzService;
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
@RequestMapping("/api/v1/clazzes")
@Api(value = "classes", description = "Classes API")
public class ClazzesRestController {

    @Autowired
    private ClazzService clazzService;

    // Needs to implement Query Parameter Logic
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Classes", notes = "Returns all classes")
    public ClazzesDTO getClazzes() {

        return clazzService.findAllClazzes();
    }

    @RequestMapping(value = "/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Class", notes = "Returns a class by classId")
    public ClazzDTO getClazz(@PathVariable("clazzId") String clazzId) {

        return clazzService.findClazz(clazzId);
    }

    @RequestMapping(value = "/{clazzId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods of a class by classId")
    public MethodsDTO getMethods(@PathVariable("clazzId") String clazzId) {

        return clazzService.findAllMethods(clazzId);
    }

    @RequestMapping(value = "/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method of a class by classId, methodId")
    public MethodDTO getMethod(@PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return clazzService.findMethod(clazzId, methodId);
    }
}
