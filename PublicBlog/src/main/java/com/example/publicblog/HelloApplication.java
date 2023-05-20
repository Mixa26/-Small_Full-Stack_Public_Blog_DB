package com.example.publicblog;

import com.example.publicblog.filters.AuthFilter;
import com.example.publicblog.repositories.*;
import com.example.publicblog.services.CommentService;
import com.example.publicblog.services.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import com.example.publicblog.services.BlogService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        this.property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", true);
        //property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        AbstractBinder binder = new AbstractBinder() {
            protected void configure() {
                this.bind(MySqlBlogRepository.class).to(BlogRepository.class).in(Singleton.class);
                this.bind(MySqlUserRepository.class).to(UserRepository.class).in(Singleton.class);
                this.bind(MySqlCommentRepository.class).to(CommentRepository.class).in(Singleton.class);

                this.bindAsContract(BlogService.class);
                this.bindAsContract(UserService.class);
                this.bindAsContract(CommentService.class);
            }
        };
        this.register(AuthFilter.class);
        this.register(binder);
        this.packages(new String[]{"com.example.publicblog.resources"});
    }
}