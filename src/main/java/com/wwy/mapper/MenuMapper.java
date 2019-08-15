package com.wwy.mapper;

import com.wwy.pojo.Menu;
import com.wwy.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    @Select("select * from menu where id in(select mid from role_menu where rid=#{id})")
    List<Menu> selByRole(Role role);
}
