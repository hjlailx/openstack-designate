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
 * Quota
 *
 * @author hjl
 */
public class Quota {
	
	private final Integer domains ;
	private final Integer recordsetRecords ;
	private final Integer domainRecords ;
	private final Integer domainRecordsets ;
	
	@ConstructorProperties({ "domains", "recordset_records", "domain_records", "domain_recordsets"})
	protected Quota(Integer domains, Integer recordsetRecords, Integer domainRecords, Integer domainRecordsets) {
		this.domains = domains;
		this.recordsetRecords = recordsetRecords;
		this.domainRecords = domainRecords ;
		this.domainRecordsets = domainRecordsets;
	}

	public Integer getDomains() {
		return domains;
	}

	public Integer getRecordsetRecords() {
		return recordsetRecords;
	}

	public Integer getDomainRecords() {
		return domainRecords;
	}

	public Integer getDomainRecordsets() {
		return domainRecordsets;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Quota that = Quota.class.cast(obj);
		return Objects.equal(this.domains, that.domains)
				&& Objects.equal(this.recordsetRecords, that.recordsetRecords)
				&& Objects.equal(this.domainRecords, that.domainRecords)
				&& Objects.equal(this.domainRecordsets, that.domainRecordsets);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("domains", domains).add("recordsetRecords", recordsetRecords)
				.add("domainRecords", domainRecords).add("domainRecordsets", domainRecordsets);
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
		protected Integer recordsetRecords ;
		protected Integer domainRecords ;
		protected Integer domainRecordsets ;
		
		public Builder domains(Integer domains) {
			this.domains = domains;
			return self();
		}
		
		public Builder recordsetRecords(Integer recordsetRecords) {
			this.recordsetRecords = recordsetRecords;
			return self();
		}
		
		public Builder domainRecords(Integer domainRecords) {
			this.domainRecords = domainRecords;
			return self();
		}
		
		public Builder domainRecordsets(Integer domainRecordsets) {
			this.domainRecordsets = domainRecordsets;
			return self();
		}
		
		public Quota build() {
			return new Quota(domains, recordsetRecords, domainRecords, domainRecordsets);
		}

		public Builder fromServer(Quota in) {
			return this.domains(in.getDomains()).recordsetRecords(in.getRecordsetRecords())
					.domainRecords(in.getDomainRecords()).domainRecordsets(in.getDomainRecordsets());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
