package com.terians.neo4j.service;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository clazzRepository;

    @Override
    public ClazzesDTO findAllClazzes() {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository
                .findAllClazzes());
    }

    @Override
    public ClazzDTO findClazz(String clazzId) {

        if (clazzId != null) {
            return DTOTransformerUtil.transformClazzToClazzDTO(clazzRepository
                    .findClazz(clazzId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String clazzId) {

        if (clazzId != null) {
            return DTOTransformerUtil
                    .transformMethodSetToMethodsDTO(clazzRepository
                            .findAllMethods(clazzId));
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String clazzId, String methodId) {

        if ((clazzId != null) && (methodId != null)) {
            return DTOTransformerUtil
                    .transformMethodToMethodDTO(clazzRepository.findMethod(
                            clazzId, methodId));
        }
        return null;
    }
}
