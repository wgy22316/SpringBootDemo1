package com.example.demo;

import com.example.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){

        List<User> r = new ArrayList<>(users.values());
        System.out.println(r);
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        System.out.println(user);
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping(value = "{id}")
    public String delUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
