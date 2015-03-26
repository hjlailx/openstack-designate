/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.openstack.designate.v2.domain;

import java.beans.ConstructorProperties;

import com.google.common.base.Objects;

/**
 * Zone
 *
 * @author hjl
 */
public class Zone {
	
	private final String id ;
	private final String poolId ;
	private final String projectId ;
	private final String name ;
	private final String email ;
	private final String ttl ;
	private final String serial ;
	private final String status ;
	private final String description ;
	private final String version ;
	private final String createdAt ;
	private final String updatedAt ;
	private final Link links ;
	
	@ConstructorProperties({ "id", "pool_id", "project_id", "name", "email", "ttl", "serial", 
		"status", "description", "version", "created_at", "updated_at", "links"})
	protected Zone(String id, String poolId, String projectId, String name, String email, String ttl,
			String serial, String status, String description, String version,String createdAt, String updatedAt,
			Link links) {
		this.id = id ;
		this.poolId = poolId ;
		this.projectId = projectId ;
		this.name = name ;
		this.email = email ;
		this.ttl = ttl ;
		this.serial = serial ;
		this.status = status ;
		this.description = description ;
		this.version = version ;
		this.createdAt = createdAt ;
		this.updatedAt = updatedAt ;
		this.links = links ;
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public String getTtl() {
		return ttl;
	}

	public String getSerial() {
		return serial;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPoolId() {
		return poolId;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getStatus() {
		return status;
	}

	public String getVersion() {
		return version;
	}

	public Link getLinks() {
		return links;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Zone that = Zone.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.poolId, that.poolId)
				&& Objects.equal(this.projectId, that.projectId)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.email, that.email)
				&& Objects.equal(this.ttl, that.ttl)
				&& Objects.equal(this.serial, that.serial)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.version, that.version)
				&& Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.links, that.links);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("poolId", poolId)
				.add("projectId", projectId).add("name", name)
				.add("email", email).add("ttl", ttl)
				.add("serial", serial).add("status", status)
				.add("description", description).add("version", version)
				.add("createdAt", createdAt).add("updatedAt", updatedAt).add("links", links);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromServer(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected String id;
		protected String poolId ;
		protected String projectId ;
		protected String name ;
		protected String email ;
		protected String ttl ;
		protected String serial ;
		protected String status ;
		protected String description ;
		protected String version ;
		protected String createdAt ;
		protected String updatedAt ;
		protected Link links ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder poolId(String poolId) {
			this.poolId = poolId;
			return self();
		}
		
		public Builder projectId(String projectId) {
			this.projectId = projectId;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder email(String email) {
			this.email = email;
			return self();
		}
		
		public Builder ttl(String ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public Builder serial(String serial) {
			this.serial = serial;
			return self();
		}
		
		public Builder status(String status) {
			this.status = status;
			return self();
		}
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder version(String version) {
			this.version = version;
			return self();
		}
		
		public Builder createdAt(String createdAt) {
			this.createdAt = createdAt;
			return self();
		}
		
		public Builder updatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
			return self();
		}
		
		public Builder links(Link links) {
			this.links = links;
			return self();
		}
		
		public Zone build() {
			return new Zone(id, poolId, projectId, name, email, ttl, serial, status, description, version, createdAt, updatedAt, links);
		}

		public Builder fromServer(Zone in) {
			return this.id(in.getId()).poolId(in.getPoolId()).projectId(in.getProjectId())
					.name(in.getName()).email(in.getEmail())
					.ttl(in.getTtl()).serial(in.getSerial())
					.status(in.getStatus()).description(in.getDescription())
					.version(in.getVersion()).createdAt(in.getCreatedAt())
					.updatedAt(in.getUpdatedAt()).links(in.getLinks());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
