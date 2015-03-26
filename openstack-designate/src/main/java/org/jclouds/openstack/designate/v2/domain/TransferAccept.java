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
 * TransferAccept
 *
 * @author hjl
 */
public class TransferAccept {
	
	private final String id ;
	private final String status ;
	private final Link links ;
	
	@ConstructorProperties({ "id", "status", "links"})
	protected TransferAccept(String id,String status,Link links) {
		this.id = id ;
		this.status = status ;
		this.links = links ;
		
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
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
		TransferAccept that = TransferAccept.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.links, that.links);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("status", status).add("links", links);
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
		
		protected String id ;
		protected String status ;
		protected Link links ;
		
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder status(String status) {
			this.status = status;
			return self();
		}
		
		public Builder links(Link links) {
			this.links = links;
			return self();
		}
		
		public TransferAccept build() {
			return new TransferAccept(id, status,links);
		}

		public Builder fromServer(TransferAccept in) {
			return this.id(in.getId()).status(in.getStatus()).links(in.getLinks());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
