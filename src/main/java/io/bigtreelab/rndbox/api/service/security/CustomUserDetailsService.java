package io.bigtreelab.rndbox.api.service.security;


import io.bigtreelab.rndbox.api.advice.exception.CUserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import io.bigtreelab.rndbox.api.domain.user.User;
import io.bigtreelab.rndbox.api.repository.SignRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final SignRepository signRepository;

    @Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = signRepository.findByUserNo(Long.parseLong(userPk));
		user.setRoles(signRepository.findUserRoles(Long.parseLong(userPk)));
        if (ObjectUtils.isEmpty(user) ){
            throw new CUserNotFoundException();
        }
        return  user;
	}

}