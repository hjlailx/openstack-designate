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

import org.jclouds.openstack.designate.enumerate.RecordType;

import com.google.common.base.Objects;

/**
 * Record
 *
 * @author hjl
 */
public class Record {
	
	private final String id ;
	private final String name ;
	private final RecordType type ;
	private final String createdAt ;
	private final String updatedAt ;
	private final String domainId ;
	private final String ttl ;
	private final String priority ;
	private final String data ;
	private final String description ;
	private final String tenantId ;
	private final String version ;
	
	@ConstructorProperties({ "id", "name", "type", "created_at", "updated_at", "domain_id", "ttl", "priority", "data", "description", "tenant_id", "version"})
	protected Record(String id, String name, RecordType type, String createdAt, String updatedAt, String domainId, String ttl,
			String priority, String data, String description, String tenantId, String version) {
		this.id = id;
		this.name = name;
		this.type = type ;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.domainId = domainId ;
		this.ttl = ttl ;
		this.priority = priority ;
		this.data = data ;
		this.description = description ;
		this.tenantId = tenantId ;
		this.version = version ;
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

	public String getDescription() {
		return description;
	}
	
	public RecordType getType() {
		return type;
	}

	public String getDomainId() {
		return domainId;
	}

	public String getPriority() {
		return priority;
	}

	public String getData() {
		return data;
	}
	
	public String getTenantId() {
		return tenantId;
	}

	public String getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Record that = Record.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.ttl, that.ttl)
				&& Objects.equal(this.priority, that.priority)
				&& Objects.equal(this.data, that.data)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.tenantId, that.tenantId)
				&& Objects.equal(this.version, that.version);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("type", type).add("createdAt", createdAt)
				.add("updatedAt", updatedAt).add("domainId", domainId)
				.add("ttl", ttl).add("priority", priority)
				.add("data", data).add("description", description)
				.add("tenantId", tenantId).add("version", version);
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
		protected RecordType type ;
		protected String createdAt;
		protected String updatedAt;
		protected String domainId ;
		protected String ttl ;
		protected String priority ;
		protected String data ;
		protected String description ;
		protected String tenantId ;
		protected String version ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder type(RecordType type) {
			this.type = type;
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
		
		public Builder domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}
		
		public Builder ttl(String ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public Builder priority(String priority) {
			this.priority = priority;
			return self();
		}
		
		public Builder data(String data) {
			this.data = data;
			return self();
		}
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder tenantId(String tenantId) {
			this.tenantId = tenantId;
			return self();
		}
		
		public Builder version(String version) {
			this.version = version;
			return self();
		}
		
		public Record build() {
			return new Record(id, name, type, createdAt, updatedAt, domainId, ttl, priority, data, description, tenantId, version);
		}

		public Builder fromServer(Record in) {
			return this.id(in.getId()).name(in.getName())
					.type(in.getType()).createdAt(in.getCreatedAt())
					.updatedAt(in.getUpdatedAt()).domainId(in.getDomainId())
					.ttl(in.getTtl()).priority(in.getPriority())
					.data(in.getData()).description(in.getDescription())
					.tenantId(in.getTenantId()).version(in.getVersion());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
