package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Ce code permet :
 * D'externaliser la configuration de la base de données dans un fichier .properties.
 * De créer un bean DataSource personnalisé, au lieu de laisser Spring Boot auto-configurer la base (utile si tu veux plus de contrôle).
 * D’injecter cette source de données dans d’autres composants Spring.
 */
/*@Configuration
public class DataSourceConfig {


    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("user"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }

}*/
