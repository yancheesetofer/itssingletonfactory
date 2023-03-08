package id.ac.ui.cs.advprog.tutorial4.authentication.service;

import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyExistsException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameDoesNotExistException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.InvalidPasswordException;
import id.ac.ui.cs.advprog.tutorial4.authentication.core.AuthentiationManager;
import id.ac.ui.cs.advprog.tutorial4.authentication.core.Util;
import id.ac.ui.cs.advprog.tutorial4.authentication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    // Please do not modify this class
    
    @Autowired
    AccountRepository accountRepository;

    // TODO inisialisasi authenticationManager yang sesuai
    AuthentiationManager authenticationManager = AuthentiationManager.getInstance();
    
    // TODO
    //  Pada method-method di bawah ini, jangan lupa handle kasus untuk melakukan throw exception
    
    @Override
    public void register(String username, String password){
        // TODO
        if (accountRepository.doesUsernameExist(username)){
            //if true throw exception
            throw new UsernameAlreadyExistsException();
        }
        accountRepository.register(username, password);
    }
    
    @Override
    public String login(String username, String password){
        // TODO
        if (!accountRepository.doesUsernameExist(username)){
            throw new UsernameAlreadyExistsException();
        }
        if (!accountRepository.getPassword(username).equals(password)){
            throw new InvalidPasswordException();
            //INVALID PASSWORD
        }
        String newToken = Util.generateToken();
        authenticationManager.registerNewToken(newToken,username);

        return newToken;  // return token
    }
    
    @Override
    public void logout(String token){
        authenticationManager.removeToken(token);
        // TODO
    }
    
}
