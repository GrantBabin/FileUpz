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

package fileupz.fileupz.microservices.fileupload;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fileupz.fileupz.microservices.users.User;

@Entity
@Table(name = "T_FILEUPLOAD")
public class FileUpload implements Serializable {
  private static final long serialVersionUID = 2L;

  @Id
  private String id;

  @Column
  private String name;

  @ManyToOne
  private User owner;

  public FileUpload(User owner, String name) {
    this.id = generateId();
    this.name = name;
    this.owner = owner;
  }

  private String generateId() {
    return UUID.randomUUID().toString();
  }
}
