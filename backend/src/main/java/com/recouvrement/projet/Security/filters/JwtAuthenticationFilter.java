package com.recouvrement.projet.Security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            com.recouvrement.projet.Models.User appUser= new ObjectMapper().readValue(request.getInputStream(), com.recouvrement.projet.Models.User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(),appUser.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user=(User)authResult.getPrincipal();
        List<String> roles=new ArrayList<>();
        authResult.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });
        //Access token
        String jwt= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+100*60*1000))
                .sign(Algorithm.HMAC256("mySecret1234"));
        //Refresh token
                String jwtRefreshToken = JWT.create().withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+150*60*1000))
                .withIssuer(request.getRequestURL().toString())
       .withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority())
                            .collect(Collectors.toList()))
                .sign(Algorithm.HMAC256("mySecret1234"));
        System.out.println(request.getRequestURL());
                //regroupe result token
               Map<String,String> idToken=new HashMap<>();
       idToken.put("access-token",jwt);
       idToken.put("refresh-token",jwtRefreshToken);
       new ObjectMapper().writeValue(response.getOutputStream(),idToken);
        response.addHeader("Authorization",jwt);
        response.setContentType("application/json");
    }

}
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//   private AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        System.out.println("attemptAuthentication");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //  System.out.println(username);
//       //  System.out.println(password);
//       //  System.out.println(request.getHeader("Content-Type"));
//
//        UsernamePasswordAuthenticationToken authenticationToken=
//                new UsernamePasswordAuthenticationToken(username,password);
//
//        return authenticationManager.authenticate(authenticationToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        System.out.println("successfulAuthentification");
//        User user=(User) authResult.getPrincipal();
//       // User principal = (User) authentication.getPrincipal();
//
//        // System.out.println(user);
//
//        Algorithm algorithm=Algorithm.HMAC256("mySecret1234");
//        //Access Token
//        String jwtAccessToken = JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis()+100*60*1000))
//                .withIssuer(request.getRequestURL().toString())
//                .withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority() )
//                 .collect(Collectors.toList()))
//                .sign(algorithm);
//        response.setHeader("Authorization",jwtAccessToken);
//       // System.out.println(request.getContentType());
//
//        //Refresh Token
//        String jwtRefreshToken = JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis()+150*60*1000))
//                .withIssuer(request.getRequestURL().toString())
//    //   .withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority())
//    //                        .collect(Collectors.toList()))
//                .sign(algorithm);
//        Map<String,String> idToken=new HashMap<>();
//        idToken.put("access-token",jwtAccessToken);
//        idToken.put("refresh-token",jwtRefreshToken);
//        new ObjectMapper().writeValue(response.getOutputStream(),idToken);
//      //  System.out.println(idToken);
//        response.setHeader("Authorization",jwtAccessToken);
//        response.setContentType("application/json");
//        //super.successfulAuthentication(request, response, chain, authResult);
//      //  System.out.println(user);
//
//    }
//}
