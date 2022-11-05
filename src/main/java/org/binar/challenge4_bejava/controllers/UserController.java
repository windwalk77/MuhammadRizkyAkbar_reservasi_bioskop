package org.binar.challenge4_bejava.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.binar.challenge4_bejava.dto.*;
import org.binar.challenge4_bejava.models.entities.RoleEntity;
import org.binar.challenge4_bejava.models.entities.UserDetailImpl;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.RoleRepos;
import org.binar.challenge4_bejava.models.repos.UserRepos;
import org.binar.challenge4_bejava.security.JwtUtils;
import org.binar.challenge4_bejava.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Slf4j
@SecurityRequirement(name = "Authorize")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepos roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepos userRepository;

    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpData signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            log.error("Username is taken");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            log.error("Email is taken");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserEntity user = new UserEntity();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());

                user.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();

        if (strRoles == null) {
            RoleEntity userRole = roleRepository.findByName(EnumRole.CUSTOMER)
                    .orElseThrow(() -> {
                        log.error("Role Not Found");
                        throw new RuntimeException("Error: Role is not found.");

                    });
            roles.add(userRole);
            log.info("Roles is added");
        } else {
            strRoles.forEach(role -> {
                if ("ADMIN".equals(role)) {
                    RoleEntity adminRole = roleRepository.findByName(EnumRole.ADMIN)
                            .orElseThrow(() ->{
                                log.error("Role Not Found");
                                throw new RuntimeException("Error: Role is not found.");

                            });
                    roles.add(adminRole);
                    log.info("Roles is added");
                } else {
                    RoleEntity userRole = roleRepository.findByName(EnumRole.CUSTOMER)
                            .orElseThrow(() -> {
                                log.error("Role Not Found");
                                throw new RuntimeException("Error: Role is not found.");

                            });
                    roles.add(userRole);
                    log.info("Roles is added");
                }
            });
        }

        user.setRoles(roles);
        userService.addUser(user);
        log.info("Registration Successful");
        return ResponseEntity.ok(new MessageResponse("Registrasi Berhasil!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LogInData loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        log.info("Login Successful");
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }


    @GetMapping("/get/{id}")
    public UserEntity findUser(@PathVariable("id") Long ID){

        return userService.findUser(ID);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<UserEntity>> update(@Valid @RequestBody UserEntity user , Errors errors){
        ResponseData<UserEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            log.error("Update user failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(userService.addUser(user));


        return ResponseEntity.ok(responseData);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long ID){
        userService.deleteUser(ID);
    }

    @GetMapping("/get/all")
    public Iterable<UserEntity> findAllFilms(){
        return userService.findAll();
    }

}
