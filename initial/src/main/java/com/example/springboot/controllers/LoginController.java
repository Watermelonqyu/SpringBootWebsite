package com.example.springboot.controllers;

import com.example.springboot.domain.AppUserDetails;
import com.example.springboot.domain.User;
import com.example.springboot.utils.AppConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpSession;


/*
 * LoginController
 */
@SessionAttributes({"currentUser"})
@Controller
public class LoginController {

    /*
     * Logger
     */
    private static final Logger log = LogManager.getLogger(LoginController.class);
    
    /*
     * login
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /*
     * loginError
     */
    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginError(Model model) {
        log.info(AppConstants.LOGIN.getMessage());
        model.addAttribute("error", "true");
        return "login";
    }

    /*
     * logout
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/welcome";
    }

    /*
     * postLogin
     */
    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin(Model model, HttpSession session) {
        log.info("postLogin()");
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((AppUserDetails) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUsername());
        session.setAttribute("userId", loggedInUser.getId());
        return "redirect:/wallPage";
    }

    /*
     * validatePrinciple
     */
    private void validatePrinciple(Object principal) {
        if (!(principal instanceof AppUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
}