package cn.edu.zjnu.AutoGenPaperSystem.dao;

import cn.edu.zjnu.AutoGenPaperSystem.model.Knowledge;
import cn.edu.zjnu.AutoGenPaperSystem.model.KnowledgeList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface KnowledgeMapper {
    int deleteByPrimaryKey(Integer knowledgeId);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(Integer knowledgeId);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);

    int updateIsDeleteById(Integer knowledgeId);


    List<Knowledge> selectKnowledgeBySubjectId(Integer subjectId);


    List<Knowledge> selectFirstKnowledgeBySubjectId(Integer subjectId);

    List<Knowledge> selectSecondKnowledgeByKnowId1(Integer knowId1);

    Map<String,Integer> selectKnowledgeByName(String name);

    Map<String,Integer> selectKnowledgeById(Integer id);


    List<KnowledgeList> selectKnowledgeList(String name);
}