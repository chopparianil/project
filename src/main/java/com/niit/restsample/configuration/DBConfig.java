package com.niit.restsample.configuration;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.restsample.model.Person;




@Configuration
@EnableTransactionManagement
public class DBConfig {
//create an instance
@Bean
public SessionFactory sessionFactory() {
LocalSessionFactoryBuilder lsf=
new LocalSessionFactoryBuilder(getDataSource());
Properties hibernateProperties=new Properties();
hibernateProperties.setProperty(
"hibernate.dialect", "org.hibernate.dialect.OracleDialect");
hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
hibernateProperties.setProperty("hibernate.show_sql", "true");
lsf.addProperties(hibernateProperties);
Class classes[]=new Class[]{Person.class};
return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}
@Bean
public DataSource getDataSource() {
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
dataSource.setUsername("system");
dataSource.setPassword("system");
return dataSource;
}
@Bean
public HibernateTransactionManager hibTransManagement(){
return new HibernateTransactionManager(sessionFactory());
}


}
