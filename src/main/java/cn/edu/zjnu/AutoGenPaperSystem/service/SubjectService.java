package cn.edu.zjnu.AutoGenPaperSystem.service;

import cn.edu.zjnu.AutoGenPaperSystem.model.Subject;

import java.util.List;

/**
 * Created by zseapeng on 2016/9/22.
 */
public interface SubjectService {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    String selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    int updateIsDeleteBySubId(Integer subId);

    List selectAllSubject();

    List selectAllSubjectOnAdmin();

    List<Subject> selectByGradeId(int id);

    int selectBysubName(String subName);

    int updateIsDeleteBySubName(String subName);
}
