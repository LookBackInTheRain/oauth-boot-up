package club.yuit.oauth.boot.auth.mapper;

import club.yuit.oauth.boot.auth.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author yuit
 * @date 2018/10/16  10:02
 *
 **/
@Repository
public interface ClientMapper extends BaseMapper<Client> {


    @Select("select * from clients where clientId=#{id}")
    Client findClientByClientId(@Param("id") String clientId);

}
