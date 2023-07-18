package com.example.mediquiz.security;

import com.example.mediquiz.security.dto.AuthenticationRequest;
import com.example.mediquiz.security.dto.SignUpRequest;
import com.example.mediquiz.security.role.Role;
import com.example.mediquiz.security.role.RoleRepository;
import com.example.mediquiz.security.user.CustomUserDetails;
import com.example.mediquiz.security.user.User;
import com.example.mediquiz.security.user.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final RoleRepository roleRepository;
    private final UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if(userDetails != null){
            String token = jwtUtils.generateToken(userDetails);
            String userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
            Cookie authCookie = new Cookie("token", token);

            authCookie.setHttpOnly(true);
            authCookie.setPath("/");
            response.addCookie(authCookie);

            return ResponseEntity.ok("{\"token\" : \"" + token + "\", \"userId\" : \"" + userId + "\"}");
        }
        return ResponseEntity.status(400).body("Could not generate token");
    }

/*    @GetMapping(value = "validateToken")
    public ResponseEntity<Boolean> validateToken(){


    }*/

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> signUp(
            @RequestBody SignUpRequest request){

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());


        Collection<Role> userRoles = new ArrayList<>();
        userRoles.add(roleRepository.findByRoleName("ROLE_USER"));
        user.setRoles(userRoles);

        userService.saveUser(user);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        if(userDetails != null){
            return ResponseEntity.ok("{\"token\" : \"" + jwtUtils.generateToken(userDetails)+"\"}");
        }
        return ResponseEntity.status(400).body("Could not generate token");
    }
}
