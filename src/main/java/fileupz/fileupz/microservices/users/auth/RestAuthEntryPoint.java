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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Class to handle rest authentication 
 *  
 * @author Lokraan
 */
public class RestAuthEntryPoint implements AuthenticationEntryPoint {

  /**
   * Basic response for failed authentication. This is invoked when a user tries
   * to access a secured REST resource without suppliyng any credentials and
   * sends a 401 unauthorized response header.
   * 
   * @param request The reqest from user browser.
   * @param response The reponse to be passed to the user
   * @param authException Exception for auth.
   */
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authException) throws IOException, ServletException {
    
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");;
  }
}
