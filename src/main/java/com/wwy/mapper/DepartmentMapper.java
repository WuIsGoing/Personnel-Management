package com.wwy.mapper;

import com.wwy.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {
    //查询所有菜单列表,并自动注入
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "isParent",column = "{id=id}",one = @One(select = "selIsSon")),//isParent:false无效
            @Result(property = "children",column = "{pid=id}",many = @Many(select = "selAllDepartment"))
    })
    @Select("select id,name,pid from department where pid=#{pid}")
    List<Department> selAllDepartment(Map<String,Object> map);

    //使用ztree，异步查询，不会一次显示出来
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "isParent",column = "{id=id}",one = @One(select = "selIsSon"))
    })
    @Select("select id,name,pid from department where pid=#{id}")
    List<Department> selDepartmentById(int id);


    //查询该部门下面是否还有子部门,会被上面的自动调
    @Select("select count(*) from department where pid=#{id}")
    Boolean selIsSon(Map<String,Object> map);

    //根据id删除部门
    @Delete("delete from department where id=#{id}")
    int delById(int id);

    //添加新部门
    @Insert("insert into department (name,pid) values(#{name},#{pid})")
    int insDeapartment(Department department);

    //更改部门名称
    @Update("update department set name=#{newName} where id=#{id}")
    int updDepartmentName(int id,String newName);
}
