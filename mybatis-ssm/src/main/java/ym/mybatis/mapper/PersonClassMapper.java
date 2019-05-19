package ym.mybatis.mapper;

import ym.mybatis.domain.PersonClass;

public interface PersonClassMapper {
    PersonClass getPersonClassById(int classId);

    PersonClass getClassByClassIdStep(int classId);

    PersonClass getPersonClassByIdPlus(int classId);
}
