package ru.netology.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {
    
    @GetMapping("read")
    @Secured("ROLE_READ")
    public String read() {
        return "Read allowed";
    }

    @GetMapping("write")
    @RolesAllowed("ROLE_WRITE")
    public String write() {
        return "Write allowed";
    }

    @GetMapping("alter")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String alter() {
        return "Alter allowed";
    }

    @GetMapping("user")
    @PreAuthorize("#username == authentication.principal.username")
    public String user(String username) {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName() + "!";
    }
}
