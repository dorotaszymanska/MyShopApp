package com.app1.demo.shop.sklepinternetowy.service;

import com.app1.demo.shop.sklepinternetowy.entity.User;
import com.app1.demo.shop.sklepinternetowy.exception.AuthenticationServiceException;
import com.app1.demo.shop.sklepinternetowy.repository.ClientRepository;
import com.app1.demo.shop.sklepinternetowy.request.RegisterRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    private ClientRepository clientRepository;

    public AuthenticationService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void createUser(RegisterRequest request) {
        if (request.getPassword1().length() <= 5) {
            throw new AuthenticationServiceException("Hasło minimum 6 znaków!");
        }
        if (!request.getPassword1().equals(request.getPassword2())) {
            throw new AuthenticationServiceException("Podano różne hasła");
        }
        if(clientRepository.existsById(request.getMail())){
            throw new AuthenticationServiceException("Ta nazwa jest już zajęta!");
        }

        User user = new User(request.getMail(), request.getPassword1());
        clientRepository.save(user);
    }
}
