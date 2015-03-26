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
 * TransferRequest
 *
 * @author hjl
 */
public class TransferRequest {
	
	private final String createdAt ;
	private final String description ;
	private final String id ;
	private final String key ;
	private final String projectId ;
	private final String status ;
	private final String targetProjectId ;
	private final String updatedAt ;
	private final String zoneId ;
	private final String zoneName ;
	private final Link links ;
	
	@ConstructorProperties({ "created_at", "description", "id", "key", "project_id", "status", "target_project_id", 
		"updated_at", "zone_id", "zone_name", "links"})
	protected TransferRequest(String createdAt, String description, String id, String key, String projectId, String status,
			String targetProjectId, String updatedAt, String zoneId, String zoneName, Link links) {
		this.createdAt = createdAt ;
		this.description = description ;
		this.id = id ;
		this.key = key ;
		this.projectId = projectId ;
		this.status = status ;
		this.targetProjectId = targetProjectId ;
		this.updatedAt = updatedAt ;
		this.zoneId = zoneId ;
		this.zoneName = zoneName ;
		this.links = links ;
		
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getStatus() {
		return status;
	}

	public String getTargetProjectId() {
		return targetProjectId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getZoneId() {
		return zoneId;
	}

	public String getZoneName() {
		return zoneName;
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
		TransferRequest that = TransferRequest.class.cast(obj);
		return Objects.equal(this.createdAt, that.createdAt)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.id, that.id)
				&& Objects.equal(this.key, that.key)
				&& Objects.equal(this.projectId, that.projectId)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.targetProjectId, that.targetProjectId)
				&& Objects.equal(this.updatedAt, that.updatedAt)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.zoneName, that.zoneName)
				&& Objects.equal(this.links, that.links);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("createdAt", createdAt).add("description", description)
				.add("id", id).add("key", key)
				.add("projectId", projectId).add("status", status)
				.add("targetProjectId", targetProjectId).add("updatedAt", updatedAt)
				.add("zoneId", zoneId).add("zoneName", zoneName).add("links", links);
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
		
		protected String createdAt ;
		protected String description ;
		protected String id ;
		protected String key ;
		protected String projectId ;
		protected String status ;
		protected String targetProjectId ;
		protected String updatedAt ;
		protected String zoneId ;
		protected String zoneName ;
		protected Link links ;
		
		public Builder createdAt(String createdAt) {
			this.createdAt = createdAt;
			return self();
		}
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder key(String key) {
			this.key = key;
			return self();
		}
		
		public Builder projectId(String projectId) {
			this.projectId = projectId;
			return self();
		}
		
		public Builder status(String status) {
			this.status = status;
			return self();
		}
		
		public Builder targetProjectId(String targetProjectId) {
			this.targetProjectId = targetProjectId;
			return self();
		}
		
		public Builder updatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
			return self();
		}
		
		public Builder zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}
		
		public Builder zoneName(String zoneName) {
			this.zoneName = zoneName;
			return self();
		}
		
		public Builder links(Link links) {
			this.links = links;
			return self();
		}
		
		public TransferRequest build() {
			return new TransferRequest(createdAt, description, id, key, projectId, status, targetProjectId, updatedAt, zoneId, zoneName, links);
		}

		public Builder fromServer(TransferRequest in) {
			return this.createdAt(in.getCreatedAt()).description(in.getDescription()).id(in.getId())
					.key(in.getKey()).projectId(in.getProjectId())
					.status(in.getStatus()).targetProjectId(in.getTargetProjectId())
					.updatedAt(in.getUpdatedAt()).zoneId(in.getZoneId())
					.zoneName(in.getZoneName()).links(in.getLinks());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
