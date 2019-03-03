package client.dao;

import com.vue.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceDAO {
    @Select("select * from province")
    List<Province> findAll();
}
