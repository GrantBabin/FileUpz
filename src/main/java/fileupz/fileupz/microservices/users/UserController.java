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

package fileupz.fileupz.microservices.users;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * RESTFul controller for accessing account information.
 * 
 * @author Lokraan
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(UsersConfiguration.class)
public class UserController {
}
