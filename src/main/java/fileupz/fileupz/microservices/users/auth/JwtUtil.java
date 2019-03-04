/**
 * fileupz: Cloud fileupload and storage.
 * <p>
 * Copyright (C) Lokraan
 * <p>
 * This file is part of fileupz.
 * <p>
 * fileupz is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * fileupz is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with fileupz. If not, see <http://www.gnu.org/licenses/>.
 */

package fileupz.fileupz.microservices.users.auth;

import org.springframework.beans.factory.annotation.Value;

import fileupz.fileupz.microservices.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

  @Value("${jwt.secret}")
  private String secret;

  /**
   * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
   * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
   * 
   * @param token the JWT token to parse
   * @return the User object extracted from specified token or null if a token is invalid.
   */
  public User parseToken(String token) {
    try {
      Claims body = Jwts.parser()
              .setSigningKey(secret)
              .parseClaimsJws(token)
              .getBody();

      User u = new User();
      u.setDisplayname(body.getSubject());
      u.setEmail((String) body.get("email"));

      return u;

    } catch (JwtException | ClassCastException e) {
      return null;
    }
  }

  /**
   * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
   * User object. Tokens validity is infinite.
   * 
   * @param u the user for which the token will be generated
   * @return the JWT token
   */
  public String generateToken(User u) {
    Claims claims = Jwts.claims().setSubject(u.getDisplayname());
    claims.put("email", u.getEmail() + "");

    return Jwts.builder()
            .setClaims(claims)
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .compact();
  }
}