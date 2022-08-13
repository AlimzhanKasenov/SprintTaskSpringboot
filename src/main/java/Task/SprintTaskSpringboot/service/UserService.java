package Task.SprintTaskSpringboot.service;

import Task.SprintTaskSpringboot.model.User;
import Task.SprintTaskSpringboot.repository.UserRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepos userRepos;

    public UserDetails loadUserByUsername(String  username) throws UsernameNotFoundException{
        User user = userRepos.findAllByEmail(username);
        if (user != null){
            return user;
        }else{
            throw new UsernameNotFoundException("Что то не так");
        }
    }
}
