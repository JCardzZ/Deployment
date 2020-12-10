package com.mm.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mm.com.service.UserDetailsServiceImpl;

//Indica que esta clase es de configuracion y necesita ser cargada durante el inicio del server
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/images/**","/js/**","/layer/**","/bootstrap/**","/fonts/**","/images/**", "/tinymce/**"
    };
    
    
//    
//    @Override
//	protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests() 
//            	
//    	// Los recursos estáticos no requieren autenticación estan libres osea publicos
//        .antMatchers(
//                "/bootstrap/**",                        
//                "/images/**",
//                "/tinymce/**",
//                "/logos/**").permitAll()
//        
//        // Las vistas públicas no requieren autenticación estan libres osea publicos
//        .antMatchers("/", 
//        			 "/login",
//        			 "/signup",
//        			 "/search",
//        			 "/bcrypt/**",
//        			 "/about",
//        			 "/vacantes/view/**").permitAll()
//        
//        // Asignar permisos a URLs por ROLES, Recordemos que tenemos tres roles con diferentes funciones
//        .antMatchers("/solicitudes/create/**",
//        			 "/solicitudes/save/**").hasAuthority("USUARIO")
//        
//        .antMatchers("/solicitudes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
//        .antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
//        .antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
//        .antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
//        
//        // Todas las demás URLs del sistema requieren autenticación
//        .anyRequest().authenticated()
//        // El formulario de Login no requiere autenticacion, ya que cualquiera usuario puede crear su cuenta y loguearse
//        .and().formLogin().loginPage("/login").permitAll()        
//        .and().logout().permitAll();
//    }
//	
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
       
      .antMatchers(
      "/bootstrap/**",                        
      "/css/**",
      "/fonts/**",
      "/images/**",
      "/js/**",
      "/tinymce/**",
      "/logos/**").permitAll()
        .antMatchers("/","/index", "/signup", "/cartelera", "/listar", "/form", "/cartel").permitAll()
//      .antMatchers("/peliculas/**").hasAnyAuthority("ROLE_ADMIN","ADMIN") xd
      
    // Las vistas públicas no requieren autenticación estan libres osea publicos
    .antMatchers("/", 
    			 "/login",
    			 "/signup",
    			 "/search",
    			 "/bcrypt/**",
    			 "/about",
    			 "/peliculas/view/**").permitAll()
    
//   Asignar permisos a URLs por ROLES, Recordemos que tenemos tres roles con diferentes funciones
//  .antMatchers("/peliculas/create/**",
//  			 "/peliculas/save/**").hasAuthority("ROLE_ADMIN")
  
.antMatchers("/peliculas/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
.antMatchers("/generos/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
.antMatchers("/noticias/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
.antMatchers("/cartelera/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")




            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .csrf().disable()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login?logout");
    }
    
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
    	//Especificar el encargado del login y encriptacion del password
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
}
