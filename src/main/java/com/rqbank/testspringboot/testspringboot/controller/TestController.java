package com.rqbank.testspringboot.testspringboot.controller;

import com.rqbank.testspringboot.testspringboot.domain.User;
import com.rqbank.testspringboot.testspringboot.model.TestModel;
import com.rqbank.testspringboot.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther Behnam Safari
 * date 10/10/18.
 * description
 */
@Controller
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public @ResponseBody TestModel testFunc(){
        TestModel tm = new TestModel();
        tm.setName("Behnam");
        tm.setFamily("Safari");
        return tm;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public @ResponseBody TestModel testFunc2(@RequestParam("id") String id){
        TestModel tm = new TestModel();
        if (id.equals("1")){
        tm.setName("Behnam");
        tm.setFamily("Safari");
        }
        else if (id.equals("2")){
            tm.setName("Reza");
            tm.setFamily("narimani");
        }
        else if (id.equals("3")){
            tm.setName("Ali");
            tm.setFamily("Pournajbar");
        }
        else{
            tm.setName("Error");
            tm.setFamily("Error");
        }

        return tm;
    }

    @RequestMapping(value = "/pass",method = RequestMethod.GET)
    public @ResponseBody User findPass(@RequestParam("un") String username){
        User u = userService.findByUsername(username);
        return u;
    }

    @RequestMapping(value = "/passList",method = RequestMethod.GET)
    public @ResponseBody
    List<User> findPass2(@RequestParam("un") String username){
        List<User> u = userService.findLikeUsername(username);
        return u;
    }
}
