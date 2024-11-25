package com.tienda.webConfigSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();*/
        /*deshabilitamos la proteccion CORS para hacer nuestra aplicacion stateless y que funcione con JWT,
        * es decir, nuestra aplicacion no almacenara ninguna sesion, no tendra estado y basaremos su acceso en tokens*/
        /*la autorizacion no se tomara desde una cookie ya que eso es un riesgo de seguridad*/
        /*los metodos que por defecto tienen proteccion CRSF son los metodos POST,PUT y DELETE*/
        http.authorizeHttpRequests(
                (customizeRequest)->{
                    /*dentro del patron del requestMatcher un * significa que estamos aplicando esta regla a solo
                    * el primer nivel del arbol de rutas, y dos ** significa que estamos aplicando esta regla a todas
                    * las rutas del arbol a partir del sufijo. Las autorizaciones deben ir de lo general a lo especifico*/
                    customizeRequest.requestMatchers("/api/auth/**").permitAll();

                    customizeRequest.requestMatchers(HttpMethod.GET,"/productos/*").hasAnyRole("ADMIN","USUARIO");
                    customizeRequest.requestMatchers(HttpMethod.POST,"/productos/*").hasAnyRole("USUARIO");
                    customizeRequest.requestMatchers(HttpMethod.PUT,"/productos/*").hasAnyRole("USUARIO");
                    customizeRequest.requestMatchers(HttpMethod.DELETE,"/productos/*").hasRole("ADMIN");

                    customizeRequest.requestMatchers(HttpMethod.GET,"/categorias/*").hasRole("ADMIN");
                    customizeRequest.requestMatchers(HttpMethod.POST,"/categorias/*").hasRole("ADMIN");
                    customizeRequest.requestMatchers(HttpMethod.PUT,"/categorias/*").hasRole("ADMIN");
                    customizeRequest.requestMatchers(HttpMethod.DELETE,"/categorias/*").hasRole("ADMIN");

                    customizeRequest.requestMatchers(HttpMethod.POST,"/usuarios/nuevousuario").permitAll();

                    //customizeRequest.anyRequest().authenticated();
                }
            )
            .csrf(AbstractHttpConfigurer::disable)
            .cors(Customizer.withDefaults())
                /*habilitamos cors para que la aplicacion pueda recibir peticiones de varios origenes
                * el metodo rest tendra que ser anotado con @CrossOrigin(origins="url del frontend")
                * pero para no tener que anotar asi cada metodo, se crea una configuracion global la cual estara en
                * el archivo CorsConfig que esta en la carpeta config*/
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    /* ---eliminado en el video 12---
    /*para evitar que springboot genere automaticamente un usuario y contraseña por defecto
    debemos crear nuestra propia implementacion de UserDetailsService*-/
    @Bean
    public UserDetailsService memoryUsers(){
        UserDetails admin= User.builder()
                .username("admin")
                //.password("admin")
                /*esto se hace para que spring almacene en memoria el hash de la contraseña*-/
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN").build();
        UserDetails customer= User.builder()
                .username("customer")
                .password(passwordEncoder().encode("customer123"))
                .roles("CUSTOMER").build();
        return new InMemoryUserDetailsManager(admin, customer);
    }
    */
    /*con este bean especificamos cual password encoder queremos utilizar*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
