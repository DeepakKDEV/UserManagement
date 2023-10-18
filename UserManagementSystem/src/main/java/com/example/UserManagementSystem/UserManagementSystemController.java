package com.example.UserManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagementSystemController<UserManagement> {
    @Autowired
    List<UserManagementSystem> Listobj;

    //create user
    // add a user
    @PostMapping("user")
    public String addUser(@RequestBody UserManagementSystem myuser) {
        Listobj.add(myuser);
        return "user added";
    }

    // get userid
    @GetMapping("user/id/userid/{Id}")
    public String getId(@PathVariable Integer Id) {
        for (UserManagementSystem user1 : Listobj) {
            if (user1.getUserId().equals(Id)) {
                return "user id exist is" + user1;
            }

        }
        return "invalid Id";
    }

    // get all user
    @GetMapping("users")
    public List<UserManagementSystem> getAllUser() {
        return Listobj;
    }

    //update userinfo
    @PutMapping("updateId/id/{id}/updateId")
    public String setStatusById(@PathVariable Integer id,@RequestParam Integer updateId)
    {
        for(UserManagementSystem todo : Listobj)
        {
            if(todo.getUserId().equals(id))
            {
                todo.setUserId(updateId);
                return "userId : "   + id  + " updated to " +  updateId;
            }
        }

        return "Invalid id";
    }

    //delete user
    @DeleteMapping("user/{id}")
    public String removeById(@PathVariable Integer id) {
        for (UserManagementSystem user : Listobj) {
            if (user.getUserId().equals(id)) {
                Listobj.remove(user);
                return "userId :" + id + "removed";
            }
        }
        return "Invalid userId";
    }
}

