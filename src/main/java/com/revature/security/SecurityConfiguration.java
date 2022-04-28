/*
 * package com.revature.security;
 * 
 * 
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfiguration extends
 * WebSecurityConfigurerAdapter{
 * 
 * 
 * 
 * @Autowired private UserDetailsService userDetailService;
 * 
 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
 * }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth .userDetailsService(userDetailService) .passwordEncoder(encoder()) ; }
 * 
 * @Autowired DataSource dataSource;
 * 
 * @Autowired BCryptPasswordEncoder bCryptEncoder;
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.jdbcAuthentication()
 * .usersByUsernameQuery("select username, password, enabled "+
 * "from ers_user where username = ?" )
 * .authoritiesByUsernameQuery("select username, role "+
 * "from ers_user where username = ?") .dataSource(dataSource)
 * .passwordEncoder(bCryptEncoder);
 * 
 * }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * 
 * 
 * .antMatchers("/admins/signup").hasAnyAuthority("ADMIN")
 * .antMatchers("/students/signup").hasAnyAuthority("ADMIN")
 * 
 * 
 * 
 * http .authorizeRequests()
 * 
 * .antMatchers("/reimbursements/**") .hasAnyAuthority("USER")
 * .antMatchers("/reimbursements/**") .hasAnyAuthority("ADMIN")
 * .antMatchers("/users/**") .hasAnyAuthority("ADMIN") .and() //.hasRole("USER")
 * .and() .authorizeRequests() .antMatchers("/register") .permitAll() .and()
 * .formLogin() //.loginPage("/login").defaultSuccessUrl(
 * "/reimbursement/reimbursementrequest")
 * 
 * .and() .logout().logoutSuccessUrl("/");
 * 
 * http .authorizeRequests() .antMatchers("/", "/register").permitAll()
 * .antMatchers("/users/list").hasAnyAuthority("ADMIN")
 * .antMatchers("/reimbursements/**").hasAnyAuthority("ADMIN") .and()
 * .formLogin() .loginPage("/home") .permitAll() .and() .logout() .permitAll();
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */