package jjfactory.template.crud.controller;

import jjfactory.template.crud.dto.ApiRes;
import jjfactory.template.crud.dto.UserDto;
import jjfactory.template.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ApiRes<?> findList() {
        return new ApiRes<>(userService.findAll());
    }

    @GetMapping("/users/{id}")
    public ApiRes<?> findOne(@PathVariable Long id) {
        return new ApiRes<>(userService.findById(id));
    }

    @GetMapping("/users/search")
    public ApiRes<?> searchUser(@RequestParam(required = false) String email,
                                @RequestParam(required = false)String username,
                                @RequestParam(required = false)String name){
        if(email != null) {
            return new ApiRes<>(userService.findByEmail(email));
        }else if(username != null){
            return new ApiRes<>(userService.findByUsername(username));
        }else if(name != null){
            return new ApiRes<>(userService.findByName(name));
        }else {
            return new ApiRes<>(userService.findAll());
        }
    }

    @PostMapping("/users")
    public ApiRes<?> save(@RequestBody UserDto dto) {
        return new ApiRes<>(userService.save(dto));
    }

    @DeleteMapping("/users/{id}")
    public ApiRes<?> delete(@PathVariable Long id){
        return new ApiRes<>(userService.delete(id),"삭제 완료");
    }

//    @PutMapping("/users/{id}")
//    public ApiRes<?> changeName(@PathVariable Long id, @RequestBody UserDto dto){
//        return new ApiRes<>(userService.changeName(dto.getName()));
//}
}

