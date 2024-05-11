package com.fusm.sinu.service;

import com.fusm.sinu.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> getUsers();

}
