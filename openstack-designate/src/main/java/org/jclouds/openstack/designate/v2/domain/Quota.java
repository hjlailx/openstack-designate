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
 * Quota
 *
 * @author hjl
 */
public class Quota {
	
	private final Integer zones ;
	private final Integer recordsetRecords ;
	private final Integer zoneRecords ;
	private final Integer zoneRecordsets ;
	
	@ConstructorProperties({ "zones", "recordset_records", "zone_records", "zone_recordsets"})
	protected Quota(Integer zones, Integer recordsetRecords, Integer zoneRecords, Integer zoneRecordsets) {
		this.zones = zones;
		this.recordsetRecords = recordsetRecords;
		this.zoneRecords = zoneRecords ;
		this.zoneRecordsets = zoneRecordsets;
	}

	public Integer getZones() {
		return zones;
	}

	public Integer getRecordsetRecords() {
		return recordsetRecords;
	}

	public Integer getZoneRecords() {
		return zoneRecords;
	}

	public Integer getZoneRecordsets() {
		return zoneRecordsets;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Quota that = Quota.class.cast(obj);
		return Objects.equal(this.zones, that.zones)
				&& Objects.equal(this.recordsetRecords, that.recordsetRecords)
				&& Objects.equal(this.zoneRecords, that.zoneRecords)
				&& Objects.equal(this.zoneRecordsets, that.zoneRecordsets);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("zones", zones).add("recordsetRecords", recordsetRecords)
				.add("zoneRecords", zoneRecords).add("zoneRecordsets", zoneRecordsets);
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
		
		protected Integer zones ;
		protected Integer recordsetRecords ;
		protected Integer zoneRecords ;
		protected Integer zoneRecordsets ;
		
		public Builder zones(Integer zones) {
			this.zones = zones;
			return self();
		}
		
		public Builder recordsetRecords(Integer recordsetRecords) {
			this.recordsetRecords = recordsetRecords;
			return self();
		}
		
		public Builder zoneRecords(Integer zoneRecords) {
			this.zoneRecords = zoneRecords;
			return self();
		}
		
		public Builder zoneRecordsets(Integer zoneRecordsets) {
			this.zoneRecordsets = zoneRecordsets;
			return self();
		}
		
		public Quota build() {
			return new Quota(zones, recordsetRecords, zoneRecords, zoneRecordsets);
		}

		public Builder fromServer(Quota in) {
			return this.zones(in.getZones()).recordsetRecords(in.getRecordsetRecords())
					.zoneRecords(in.getZoneRecords()).zoneRecordsets(in.getZoneRecordsets());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
