package cn.vo.dao;

import cn.vo.pojo.RoleModule;
import cn.vo.pojo.RoleModuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleModuleMapper {
    int countByExample(RoleModuleExample example);

    int deleteByExample(RoleModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    List<RoleModule> selectByExample(RoleModuleExample example);

    RoleModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleModule record, @Param("example") RoleModuleExample example);

    int updateByExample(@Param("record") RoleModule record, @Param("example") RoleModuleExample example);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);
}