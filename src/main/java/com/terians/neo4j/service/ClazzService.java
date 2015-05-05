package com.terians.neo4j.service;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ClazzService {

    ClazzesDTO findAllClazzes();

    ClazzDTO findClazz(String clazzId);

    MethodsDTO findAllMethods(String methodId);

    MethodDTO findMethod(String clazzId, String methodId);

}
