package com.example.ygagent.model.mapper;

import com.example.ygagent.model.domain.User;
import com.example.ygagent.model.vo.UserVO;

public class UserVoMapper {

    public static UserVO toVO(User user) {
        UserVO vo = new UserVO();
        vo.displayName = "欢迎你，" + user.getName();
        vo.token = user.getToken();
        return vo;
    }
}
