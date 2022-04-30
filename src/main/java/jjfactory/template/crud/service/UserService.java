package jjfactory.template.crud.service;

import jjfactory.template.crud.domain.User;
import jjfactory.template.crud.dto.UserDto;
import jjfactory.template.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable pageable){
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public Long save(UserDto dto){
        User user = dto.toEntity();
        userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }

//    @Transactional
//    public Long changeName(UserDto dto){
//        User user = userRepository.findById(dto.getId()).orElse(null);
//        user.changeName(dto.getName());
//        return user.getId();
//    }
}
