package com.sap.cp.core.config;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"test"})
public class CloudDatabaseConfig extends AbstractCloudConfig{
	
	/*@Bean
    public DataSource dataSource()
    {
        List<String> dataSourceNames =
            Arrays.asList(
                "BasicDbcpPooledDataSourceCreator",
                "TomcatJdbcPooledDataSourceCreator",
                "HikariCpPooledDataSourceCreator",
                "TomcatDbcpPooledDataSourceCreator");
        DataSourceConfig dbConfig = new DataSourceConfig(dataSourceNames);
        return connectionFactory().dataSource(dbConfig);

    }*/
	
	
	
	@Bean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }
//    
//    @Bean
//    @ConfigurationProperties(DataSourceProperties.PREFIX)
//    public DataSource dataSource() {
//      return cloud().getSingletonServiceConnector(DataSource.class, null);
//    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = cloud().getServiceConnector("test-pg-service", DataSource.class, null);
        return dataSource;
    }
	
}
