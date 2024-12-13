package com.project.web.SweetCRUD.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Value("${DB_SWEETCRUD_URL}")
    private String dbSweetCRUDUrl;
    @Value("${DB_SWEETCRUD_USER}")
    private String dbSweetCRUDUser;
    @Value("${DB_SWEETCRUD_PASS}")
    private String dbSweetCRUDPass;
    @Value("${DB_SWEETCRUD_DRIVER}")
    private String dbSweetCRUDDriver;

    @Bean
    public HikariDataSource HikariCPDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbSweetCRUDUrl);
        config.setUsername(dbSweetCRUDUser);
        config.setPassword(dbSweetCRUDPass);
        config.setDriverClassName(dbSweetCRUDDriver);

        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.
         */
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);

    }

}
