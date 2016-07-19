package com.bova.services;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Myko Bova
 */
@Component
public class JettyEmbeddedServletContainerFactory implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400.jsp"));
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.jsp"));
        container.addErrorPages(new ErrorPage("/errorHeaven"));
    }
}
