package dy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String name;
    private int age;
    private String sex;
    @JsonFormat(timezone = "GMT+8", pattern="yyyy-MM-dd")
    private Date birthday;

}
