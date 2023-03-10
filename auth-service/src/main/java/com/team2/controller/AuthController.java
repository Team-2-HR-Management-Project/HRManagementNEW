package com.team2.controller;

import com.team2.dto.request.*;
import com.team2.dto.response.*;
import com.team2.service.AuthService;
import com.team2.utility.JwtTokenManager;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.team2.constants.ApiUrls.*;
import static com.team2.constants.ApiUrls.ACTIVATEAUTH;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(REGISTER)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "This method is for saving a user")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(REGISTERBYMAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "This method is for saving a user by sending mail")
    public ResponseEntity<RegisterByMailResponseDto> registerByMail(@RequestBody @Valid RegisterByMailRequestDto dto) {
        return ResponseEntity.ok(authService.registerByMail(dto));
    }

    @PostMapping(LOGIN)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "This method is for signing in")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto).get());
    }

    @DeleteMapping(DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Boolean> deleteAuth(@PathVariable String token) {

        return ResponseEntity.ok(authService.deleteAuth(token));
    }

    @PostMapping("/createpassword")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CreatePasswordResponseDto> activateUser(@RequestBody CreatePasswordRequestDto dto){
        return ResponseEntity.ok(authService.createPassword(dto));
    }
    @PostMapping(FORGETPASSWORDMAIL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "This method is for saving a user by sending mail")
    public ResponseEntity<ForgetPasswordMailResponseDto> registerByMail(@RequestBody @Valid ForgetPasswordMailRequestDto dto) {
        return ResponseEntity.ok(authService.forgetPasswordMail(dto));
    }


}
