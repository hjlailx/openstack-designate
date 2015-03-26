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

package org.jclouds.openstack.designate.v1.domain;

import java.beans.ConstructorProperties;

import com.google.common.base.Objects;

/**
 * Domain
 *
 * @author hjl
 */
public class Domain {
	
	private final String id ;
	private final String name ;
	private final String ttl ;
	private final String serial ;
	private final String email ;
	private final String createdAt ;
	private final String updatedAt ;
	private final String description ;
	
	@ConstructorProperties({ "id", "name", "ttl", "serial", "email", "created_at", "updated_at", "description"})
	protected Domain(String id, String name, String ttl, String serial, String email, String createdAt, String updatedAt, String description) {
		this.id = id;
		this.name = name;
		this.ttl = ttl ;
		this.serial = serial ;
		this.email = email ;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.description = description ;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Domain that = Domain.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.ttl, that.ttl)
				&& Objects.equal(this.serial, that.serial)
				&& Objects.equal(this.email, that.email)
				&& Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.description, that.description);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("ttl", ttl).add("serial", serial)
				.add("email", email).add("createdAt", createdAt)
				.add("updatedAt", updatedAt).add("description", description);
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
		protected String name;
		protected String ttl ;
		protected String serial ;
		protected String email ;
		protected String createdAt;
		protected String updatedAt;
		protected String description ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
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
		
		public Builder email(String email) {
			this.email = email;
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
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Domain build() {
			return new Domain(id, name, ttl, serial, email, createdAt, updatedAt, description);
		}

		public Builder fromServer(Domain in) {
			return this.id(in.getId()).name(in.getName())
					.ttl(in.getTtl()).serial(in.getSerial())
					.email(in.getEmail()).createdAt(in.getCreatedAt())
					.updatedAt(in.getUpdatedAt()).description(in.getDescription());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
