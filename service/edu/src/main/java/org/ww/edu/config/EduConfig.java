package org.ww.edu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.ww.edu.mapper")
public class EduConfig {
}
