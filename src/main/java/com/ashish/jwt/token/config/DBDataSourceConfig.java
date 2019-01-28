package com.ashish.jwt.token.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
//@EnableTransactionManagement
@EntityScan("com.ashish.jwt.token.db.model")
@EnableJpaRepositories(basePackages = "com.ashish.jwt.token.db.repositories")
public class DBDataSourceConfig {

	/*
	 * @Bean(name = "msdatasource") public DataSource dataSource() {
	 * 
	 * // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
	 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	 * EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2) // .H2 or
	 * .DERBY .addScript("sql/schema.sql") .addScript("sql/data.sql").build();
	 * 
	 * 
	 * return db; }
	 */

	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean
	 * entityManagerFactory( @Qualifier("msdatasource") DataSource ds) {
	 * 
	 * LocalContainerEntityManagerFactoryBean entityManagerFactory = new
	 * LocalContainerEntityManagerFactoryBean();
	 * entityManagerFactory.setDataSource(ds);
	 * entityManagerFactory.setPackagesToScan(new String[] {
	 * "com.ashish.jwt.token.db.model" }); JpaVendorAdapter vendorAdapter = new
	 * HibernateJpaVendorAdapter();
	 * entityManagerFactory.setJpaVendorAdapter(vendorAdapter); return
	 * entityManagerFactory; }
	 * 
	 * @Bean public PlatformTransactionManager
	 * transactionManager(EntityManagerFactory entityManagerFactory) {
	 * JpaTransactionManager transactionManager = new JpaTransactionManager();
	 * transactionManager.setEntityManagerFactory(entityManagerFactory); return
	 * transactionManager; }
	 */
}
