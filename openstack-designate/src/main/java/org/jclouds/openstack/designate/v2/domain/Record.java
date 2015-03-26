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
import java.util.Set;

import org.jclouds.openstack.designate.enumerate.RecordType;

import com.google.common.base.Objects;

/**
 * Record
 *
 * @author hjl
 */
public class Record {
	
	private final String description ;
	private final Link links ;
	private final String updatedAt ;
	private final Set<String> records ;
	private final Integer ttl ;
	private final String id ;
	private final String name ;
	private final String zoneId ;
	private final String createdAt ;
	private final String version ;
	private final RecordType type ;
	
	@ConstructorProperties({ "description", "links", "updated_at", "records", "ttl", "id", "name", "zone_id", "created_at", "version", "type"})
	protected Record(String description, Link links, String updatedAt, Set<String> records, Integer ttl, 
			String id, String name, String zoneId, String createdAt, String version, RecordType type) {
		this.description = description;
		this.links = links;
		this.updatedAt = updatedAt ;
		this.records = records;
		this.ttl = ttl;
		this.id = id ;
		this.name = name ;
		this.zoneId = zoneId ;
		this.createdAt = createdAt ;
		this.version = version ;
		this.type = type ;
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

	public Set<String> getRecords() {
		return records;
	}

	public Integer getTtl() {
		return ttl;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getZoneId() {
		return zoneId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getVersion() {
		return version;
	}

	public RecordType getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Record that = Record.class.cast(obj);
		return Objects.equal(this.description, that.description)
				&& Objects.equal(this.links, that.links)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.records, that.records)
				&& Objects.equal(this.ttl, that.ttl)
				&& Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.version, that.version)
				&& Objects.equal(this.type, that.type);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("description", description).add("links", links)
				.add("updatedAt", updatedAt).add("records", records)
				.add("ttl", ttl).add("id", id)
				.add("name", name).add("zoneId", zoneId)
				.add("createdAt", createdAt).add("version", version)
				.add("type", type);
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
		protected String updatedAt ;
		protected Set<String> records ;
		protected Integer ttl ;
		protected String id ;
		protected String name ;
		protected String zoneId ;
		protected String createdAt ;
		protected String version ;
		protected RecordType type ;
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder links(Link links) {
			this.links = links;
			return self();
		}
		
		public Builder updatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
			return self();
		}
		
		public Builder records(Set<String> records) {
			this.records = records;
			return self();
		}
		
		public Builder ttl(Integer ttl) {
			this.ttl = ttl;
			return self();
		}
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}
		
		public Builder createdAt(String createdAt) {
			this.createdAt = createdAt;
			return self();
		}
		
		public Builder version(String version) {
			this.version = version;
			return self();
		}
		
		public Builder type(RecordType type) {
			this.type = type;
			return self();
		}
		
		public Record build() {
			return new Record(description, links, updatedAt, records, ttl, id, name, zoneId, createdAt, version, type);
		}

		public Builder fromServer(Record in) {
			return this.description(in.getDescription()).links(in.getLinks())
					.updatedAt(in.getUpdatedAt()).records(in.getRecords())
					.ttl(in.getTtl()).id(in.getId())
					.name(in.getName()).zoneId(in.getZoneId())
					.createdAt(in.getCreatedAt()).version(in.getVersion())
					.type(in.getType());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
