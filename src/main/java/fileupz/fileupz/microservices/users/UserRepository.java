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

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Lokraan
 */
public interface UserRepository extends Repository<User, Long> {

  /**
   * Find an account with the specified email.
   * 
   * @param email
   * @return The account if found, null otherwise.
   */
  public User findByEmail(String email);

  /**
   * Find an account/accounts with the specified username;
   *
   * @param username
   * @return The list of account(s) if found, null otherwise.
   */
  public List<User> findByUsername(String username);

  /**
   * Find an account(s) with the specified username but ignore case.
   * 
   * @param username
   * @return The list of account(s) if found, null otherwise.
   */
  public List<User> findByUsernameIgnoreCase(String username);

  /**
   * Fetch the number of accounts within the system.
   * 
   * @return the number of accounts.
   */
  @Query("SELECT count(*) from Account")
  public int countAccounts();
}