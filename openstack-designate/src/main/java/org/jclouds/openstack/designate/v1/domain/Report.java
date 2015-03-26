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
 * Report
 *
 * @author hjl
 */
public class Report {
	
	private final Integer domains ;
	private final Integer records ;
	private final Integer tenants ;
	
	@ConstructorProperties({ "domains", "records", "tenants"})
	protected Report(Integer domains, Integer records, Integer tenants) {
		this.domains = domains;
		this.records = records;
		this.tenants = tenants ;
	}

	public Integer getDomains() {
		return domains;
	}

	public Integer getRecords() {
		return records;
	}

	public Integer getTenants() {
		return tenants;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Report that = Report.class.cast(obj);
		return Objects.equal(this.domains, that.domains)
				&& Objects.equal(this.records, that.records)
				&& Objects.equal(this.tenants, that.tenants);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("domains", domains).add("records", records)
				.add("tenants", tenants);
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
		
		protected Integer domains ;
		protected Integer records ;
		protected Integer tenants ;
		
		public Builder domains(Integer domains) {
			this.domains = domains;
			return self();
		}
		
		public Builder records(Integer records) {
			this.records = records;
			return self();
		}
		
		public Builder tenants(Integer tenants) {
			this.tenants = tenants;
			return self();
		}
		
		public Report build() {
			return new Report(domains, records, tenants);
		}

		public Builder fromServer(Report in) {
			return this.domains(in.getDomains()).records(in.getRecords())
					.tenants(in.getTenants());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
