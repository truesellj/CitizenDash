package org.justintruesell.citizendash;

import org.justintruesell.citizendash.models.Role;
import org.justintruesell.citizendash.repositories.RoleRepository;
import org.justintruesell.citizendash.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "org.justintruesell.citizendash.*" })
public class CitizenDashApplication {
    /**
     * on the tenth commit to main branch (commit id# 60bfcf8) I was able to
     * connect to my database in 'update' mode (I had manually already created a database,
     * and tables were created based upon the work done here in this project thus far.
     */
    public static void main(String[] args) {
        SpringApplication.run(CitizenDashApplication.class, args);
    }

}
