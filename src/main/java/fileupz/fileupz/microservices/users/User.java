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

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fileupz.fileupz.microservices.fileupload.FileUpload;

/**
 * Persistent account entity with JPA markup. Accounts are stored in an H2
 * relational database.
 * 
 * @author Lokraan
 */
@Entity
@Table(
  name="T_USER",
  uniqueConstraints=@UniqueConstraint(columnNames={"email"})
  )
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id @GeneratedValue
  private long id;

  @Column
  private String email;

  @Column
  private String displayname;

  @Column
  private String encryptedPassword;

  @OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
  private List<FileUpload> fileUploads;

  public User() {
  }

  public User(String email, String displayname, String encryptedPassword) {
    this.email = email;
    this.displayname = displayname;
    this.encryptedPassword = encryptedPassword;
  }

  public void setDisplayname(String displayname) {
    this.displayname = displayname;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDisplayname() {
    return this.displayname;
  }

  public String getEmail() {
    return this.email;
  }
}
