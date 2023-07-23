package com.activeMQ.project.controller;

import com.activeMQ.project.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/producer")
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody String message) {
        return producerService.sendMessage(message);
    }
}
