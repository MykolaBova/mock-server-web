package com.bova.services.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Myko Bova
 */
public abstract class AbstractController {

    @ModelAttribute
    public void setDefaultContentType(HttpServletResponse response) {
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    }
}
