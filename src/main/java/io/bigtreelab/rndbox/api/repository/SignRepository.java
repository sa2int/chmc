package io.bigtreelab.rndbox.api.repository;

import java.util.List;

import io.bigtreelab.rndbox.api.domain.user.UserDevice;
import org.apache.ibatis.annotations.Mapper;

import io.bigtreelab.rndbox.api.domain.user.NickName;
import io.bigtreelab.rndbox.api.domain.user.User;
import io.bigtreelab.rndbox.api.domain.user.UserRoles;
import io.bigtreelab.rndbox.api.dto.user.UserSignupRequestDto;


@Mapper
public interface SignRepository { 
	User findByUserNo(long userNo);

	void saveUser(User user);
	void saveUserRoles(UserRoles userRoles);
	List<String> findUserRoles(long userNo);
	User findByUserNo(String userNo);
	User findByUserId(UserSignupRequestDto param);

	User findByUserId(String userId);

	int saveMember(User user);

	User findMemberByCellphone(UserSignupRequestDto build);

	User findUserByCellphone(UserSignupRequestDto build);

	User findUserByUserId(UserSignupRequestDto build);
	//레지스트레이션아이디 초기화

//	void initRegistrationIdInUser(User user);

	void initRegistrationId(User param);



	void updateUserWithLastLoginDate(User user);

	void updateNickNameCadidate(NickName nickName);

	int countNickName();
	NickName getNickName();
	NickName getNickName1(int idx);
	NickName getNickName2(int idx);

	void saveUserDevice(UserDevice param);
}
