package br.com.tenant.example.system;

import br.com.tenant.example.system.properties.DataSourceProperties;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
public class FlywaySchemaInitializer {

     private final TenantRoutingDataSource dataSource;
     private final DataSourceProperties dataSourceProperties;

     @PostConstruct
     public void migrateFlyway() {
         dataSourceProperties.getDatasources().forEach(dataSourceProperty -> {
             if(!dataSourceProperty.getName().contains("db1")) {
                 TenantLocalStorage.setTenantName(dataSourceProperty.getName());
                 Flyway flyway = new Flyway();
                 flyway.setDataSource(dataSource);
                 flyway.migrate();
             }
         });
         TenantLocalStorage.setTenantName("db1");
     }
}