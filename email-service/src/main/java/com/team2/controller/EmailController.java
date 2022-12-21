
package com.team2.controller;

import com.team2.dto.response.RegisterByMailResponseDto;
import com.team2.service.EmailSenderService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import static com.team2.constants.ApiUrls.EMAIL;


@RestController
@RequestMapping(EMAIL)
public class EmailController {
    @Autowired
    private  EmailSenderService emailSenderService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public void sendMail( @RequestBody RegisterByMailResponseDto dto){
        try{
            emailSenderService.sendEmail(dto.getEmail(),"Your temporary password: ",dto.getTemppassword());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}




//@RestController
//@RequestMapping(EMAIL)
//@RequiredArgsConstructor
//public class EmailController {
//
//    private final EmailSenderService emailSenderService;
//
//    @PostMapping(TEMPPASSWORD)
//    public ResponseEntity<Void> sendTempPassword(@RequestBody RegisterByMailResponseDto dto) {
//        emailSenderService.sendTempPassword(dto);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//}
