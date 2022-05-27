package com.ug.Ukraine_students.service;

import com.ug.Ukraine_students.models.MyUsersDetails;
import com.ug.Ukraine_students.models.Users;
import com.ug.Ukraine_students.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUsersDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String usersName) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsersName(usersName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + usersName));

        return user.map(MyUsersDetails::new).get();
    }
}
