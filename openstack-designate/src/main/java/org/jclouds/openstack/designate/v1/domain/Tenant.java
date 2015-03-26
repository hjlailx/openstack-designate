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
import java.util.Set;

import com.google.common.base.Objects;

/**
 * Report
 *
 * @author hjl
 */
public class Tenant {
	
	private final String id ;
	private final Integer domainCount ;
	private final Set<Domain> domains ;
	
	@ConstructorProperties({ "id", "domain_count", "domains"})
	protected Tenant(String id, Integer domainCount, Set<Domain> domains) {
		this.id = id;
		this.domainCount = domainCount;
		this.domains = domains ;
	}

	public String getId() {
		return id;
	}

	public Integer getDomainCount() {
		return domainCount;
	}

	public Set<Domain> getDomains() {
		return domains;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Tenant that = Tenant.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.domainCount, that.domainCount)
				&& Objects.equal(this.domains, that.domains);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("domainCount", domainCount)
				.add("domains", domains);
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
		protected Integer domainCount ;
		protected Set<Domain> domains ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder domainCount(Integer domainCount) {
			this.domainCount = domainCount;
			return self();
		}
		
		public Builder domains(Set<Domain> domains) {
			this.domains = domains;
			return self();
		}
		
		public Tenant build() {
			return new Tenant(id, domainCount, domains);
		}

		public Builder fromServer(Tenant in) {
			return this.id(in.getId()).domainCount(in.getDomainCount())
					.domains(in.getDomains());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
