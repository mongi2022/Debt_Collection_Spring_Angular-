package com.recouvrement.projet.Security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtAuthorizationFilter  extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            String jwtToken = request.getHeader("Authorization");
          //  System.out.println("Token=" + jwtToken);
            if (jwtToken == null || !jwtToken.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("mySecret1234")).build();
            String jwt = jwtToken.substring(7);
            DecodedJWT decodedJWT = verifier.verify(jwt);
          //  System.out.println("JWT=" + jwt);
            String username = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
          //  System.out.println("username=" + username);
          //  System.out.println("roles=" + roles);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            roles.forEach(rn -> {
                authorities.add(new SimpleGrantedAuthority(rn));
            });
            UsernamePasswordAuthenticationToken user =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(user);
            filterChain.doFilter(request, response);
        }
    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//    String authorizationToken=request.getHeader("Authorization");
//        if (authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
//         try{
//             String jwt= authorizationToken.substring(7);
//             Algorithm algorithm=Algorithm.HMAC256("mySecret1234");
//             JWTVerifier jwtVerifier= JWT.require(algorithm).build();
//             DecodedJWT decodedJWT=   jwtVerifier.verify(jwt);
//             String username=decodedJWT.getSubject();
//             String[] roles=decodedJWT.getClaim("roles").asArray(String.class);
//             Collection<GrantedAuthority> authorities=new ArrayList<>();
//             for (String r:roles ) {
//                 authorities.add(new SimpleGrantedAuthority(r));
//
//             }
//             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
//                     new UsernamePasswordAuthenticationToken(username,null,authorities);
//             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            filterChain.doFilter(request,response);
//         }catch (Exception e){
//           response.setHeader("erroe-message",e.getMessage());
//           response.sendError(HttpServletResponse.SC_FORBIDDEN);
//         }
//
//
//        }else{
//            filterChain.doFilter(request,response);
//
//        }
//    }
}
