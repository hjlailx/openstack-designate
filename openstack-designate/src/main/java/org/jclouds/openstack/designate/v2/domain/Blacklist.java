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
 * Record
 *
 * @author hjl
 */
public class Blacklist {
	
	private final String description ;
	private final Link links ;
	private final String pattern ;
	private final String createdAt ;
	private final String updatedAt ;
	private final String id ;
	
	@ConstructorProperties({ "description", "links", "pattern", "created_at", "updated_at", "id"})
	protected Blacklist(String description, Link links, String pattern, String createdAt, String updatedAt,
			String id) {
		this.description = description;
		this.links = links;
		this.pattern = pattern;
		this.createdAt = createdAt ;
		this.updatedAt = updatedAt ;
		this.id = id ;
	}

	public String getDescription() {
		return description;
	}

	public Link getLinks() {
		return links;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	
	public String getPattern() {
		return pattern;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Blacklist that = Blacklist.class.cast(obj);
		return Objects.equal(this.description, that.description)
				&& Objects.equal(this.links, that.links)
				&& Objects.equal(this.pattern, that.pattern)
				&& Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.id, that.id);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("description", description).add("links", links)
				.add("createdAt", createdAt).add("updatedAt", updatedAt)
				.add("pattern", pattern).add("id", id);
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
		
		protected String description ;
		protected Link links ;
		protected String pattern ;
		protected String createdAt ;
		protected String updatedAt ;
		protected String id ;
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder links(Link links) {
			this.links = links;
			return self();
		}
		
		public Builder pattern(String pattern) {
			this.pattern = pattern;
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
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Blacklist build() {
			return new Blacklist(description, links, pattern, createdAt, updatedAt, id);
		}

		public Builder fromServer(Blacklist in) {
			return this.description(in.getDescription()).links(in.getLinks())
					.pattern(in.getPattern())
					.createdAt(in.getCreatedAt()).updatedAt(in.getUpdatedAt())
					.id(in.getId());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
