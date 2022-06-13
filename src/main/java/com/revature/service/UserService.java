package com.revature.service;



import com.revature.model.Role;
import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    //As a Customer, I can view available Cars on the lot
    //As a Customer, I can make an Offer on an available Car
    //As a Customer, I can view my open offers
    //As a Customer, I can view the Cars that I own
    private List<User> users;

    public UserService(){
        users = new ArrayList<>();
    }
    public UserService(List<User> users){
        this.users=users;
    }

    public boolean  createUser(User user){
        return users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }

    public List<User> getAllUsersByRole(Role role){
        List<User> filteredUsers = new ArrayList<>();

        for(User user: users){
            if(user.getRole().equals(role)){
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    public User getUserById(int id){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }

    public boolean deleteUserById(int id){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}
