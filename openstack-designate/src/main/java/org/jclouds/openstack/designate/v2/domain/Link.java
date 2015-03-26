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
 * Link
 *
 * @author hjl
 */
public class Link {
	
	private final String self ;
	private final String zone ;
	
	@ConstructorProperties({ "self", "zone"})
	protected Link(String self, String zone) {
		this.self = self ;
		this.zone = zone ;
	}

	public String getSelf() {
		return self;
	}
	
	public String getZone() {
		return zone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Link that = Link.class.cast(obj);
		return Objects.equal(this.self, that.self)
				&& Objects.equal(this.zone, that.zone);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("self", self).add("zone", zone);
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
		
		protected String self;
		protected String zone ;
		
		public Builder self(String self) {
			this.self = self;
			return self();
		}
		
		public Builder zone(String zone) {
			this.zone = zone;
			return self();
		}
		
		public Link build() {
			return new Link(self, zone);
		}

		public Builder fromServer(Link in) {
			return this.self(in.getSelf()).zone(in.getZone());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
