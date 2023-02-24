package rw.jazzyBruno.todo.v1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.jazzyBruno.todo.v1.dto.AuthenticateDTO;
import rw.jazzyBruno.todo.v1.serviceImpls.JwtUtils;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticateDTO authenticateDTO
            ){
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateDTO.getEmail(),
                        authenticateDTO.getPassword()
                )
        );
         final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateDTO.getEmail());
         if(userDetails != null){
            return ResponseEntity.ok( jwtUtils.generateToken(userDetails));
         }
         return ResponseEntity.status(400).body("Some error has happened");
    }
}
