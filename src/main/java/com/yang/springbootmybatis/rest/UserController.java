package com.yang.springbootmybatis.rest;

import com.yang.springbootmybatis.domain.User;
import com.yang.springbootmybatis.mapper.UserMapper;
import com.yang.springbootmybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * rest风格参数
     *
     * @param id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    /**
     * 在get请求的url中只需要带上字段名就可以了 http://localhost:9090/user/addUser?name=kkk&age=2&isMarried=1
     *
     * @param user
     * @return
     */
    @GetMapping("/addUser")
    public Object addUser(@ModelAttribute User user) {
        this.userService.addUser(user);
        return "success";
    }

    @GetMapping("/updateUser")
    public Object updateUser(@ModelAttribute User user) {
        this.userService.updateUser(user);
        return "success";
    }

    @GetMapping("/getUserByPageInfo")
    public Object getUserByPageInfo(@RequestParam Integer page, @RequestParam Integer size) {
        return this.userService.getUserByPageInfo(page, size);
    }

    @GetMapping("/getUserByPage")
    public Object getUserByPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.userService.getUserByPage(page, size);
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/procedure/{id}")
    public User procedureTest(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        this.userMapper.procedureTest(user);
        return user;
    }

    @GetMapping("/function/{id}")
    public Integer functionTest(@PathVariable("id") Integer id) {
        return this.userMapper.functionTest(id);
    }
}
