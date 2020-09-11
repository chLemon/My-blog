package cn.edu.buaa.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.buaa.myblog.dao")
public class MyblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyblogApplication.class, args);
    }

}
