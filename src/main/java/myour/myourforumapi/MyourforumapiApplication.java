package myour.myourforumapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import javax.servlet.ServletContext;

@SpringBootApplication
public class MyourforumapiApplication {

    @Autowired
    static ServletContext context;

    public static void main(String[] args) {
        SpringApplication.run(MyourforumapiApplication.class, args);
    }

}
