package com.algore.application.user.dao;

import com.algore.application.auth.AuthUserDTO;
import com.algore.application.user.dto.UserMemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinMapper {

    AuthUserDTO loginSham(String username);

//    List<UserMemberDTO>selectAll();

    int registUser(UserMemberDTO insertUserMemberDTO);

    String findId(String userName);
// 서비스에서 자동으로 받아 만들어 짐

}
