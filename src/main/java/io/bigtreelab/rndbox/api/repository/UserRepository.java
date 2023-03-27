package io.bigtreelab.rndbox.api.repository;

import java.util.List;

import io.bigtreelab.rndbox.api.domain.user.UserDevice;
import io.bigtreelab.rndbox.api.domain.user.UserLog;
import io.bigtreelab.rndbox.api.dto.user.*;
import org.apache.ibatis.annotations.Mapper;

import io.bigtreelab.rndbox.api.domain.user.User;
import io.bigtreelab.rndbox.api.domain.user.UserRoles;

@Mapper
public interface UserRepository { 
	
	public UserResponseDto findByUserNo(UserRequestDto param);

	public UserResponseDto findFail();

	public int saveUser(UserRequestDto user);

	public int saveUser(User user);

	public void saveUserRoles(UserRoles userRoles);

	public UserResponseDto findUserInfo(Long userNo);

	public int selectAppAlarmCount(Long userNo);

	public int selectPushAlarmCount(Long userNo);

	public Long getUserNoWithUserId(String cipherText);

	public void updateUser(User user);

	public void updatePayAmount(User user);

	public UserResponseDto findUserInfo(UserRequestDto param);

	public int countUserInqueryList(UserInqueryCriteria userInqueryCriteria);

	public List<UserInqueryDto> selectUserInqueryList(UserInqueryCriteria userInqueryCriteria);

	public UserInqueryDto selectUserInqueryDetail(UserInqueryRequestDto userInqueryRequestDto);

	public void updatePushAlarm(User param);

	public void updateUserCellphone(User param);
	public String getUserPhone(String cellphone);

	public void updateUserQuit(User param);
	public List<User> selectMember(UserRequestDto param);
	public void updateMemberQuit(User param);

	public User selectUserInQuitY(User param);

	public void updateUserCancelQuit(User param);

	public void updateUserCancelQuitForWeChat(User param);

	public int findUserDevice(Long userNo);
	public int findUserLog(Long userNo);
	public void saveUserDevice(UserDevice param);
	public void updateUserDevice(UserDevice param);
	public void saveUserLog(UserLog param);
	public void updateUserLog(UserLog param);

	public int selectBanUser(Long userNo);

	public UserDeviceRequestDto getUserDevice(Long userNo);
}
