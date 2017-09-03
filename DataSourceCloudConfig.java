
package com.vedams.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Configuration of cloud profile. Checking whether the application binds with mysql service
 * instance or not. If mysql service instance is not bound then application will be failed to start
 * in the cloud.
 */
@Configuration
@Profile("cloud")
public class DataSourceCloudConfig extends AbstractCloudConfig {
  private static final Logger logger = LoggerFactory.getLogger(DataSourceCloudConfig.class);

  public DataSourceCloudConfig() {
    logger.info(this.getClass() + " loaded");
  }

  @Bean
  public DataSource dataSource() throws Exception {
    DataSource dataSource = cloud().getSingletonServiceConnector(DataSource.class, null);
    if (!dataSource.getConnection().getMetaData().getDriverName().toLowerCase().contains("mysql")) {
      logger.error("MySQL required when running cloud profile.");
      throw new UnsatisfiedDependencyException("javax.sql.DataSource", "javax.sql.DataSource",
          "javax.sql.DataSource", "MySQL required when running cloud profile.");
    }
    return dataSource;
  }

}


