package hiweb.conference.codepoem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

@Autowired Environment env;

@Bean
public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("driverClassName"));
    dataSource.setUrl(env.getProperty("url"));
    dataSource.setUsername(env.getProperty("user"));
    dataSource.setPassword(env.getProperty("password"));
    return dataSource;
}
