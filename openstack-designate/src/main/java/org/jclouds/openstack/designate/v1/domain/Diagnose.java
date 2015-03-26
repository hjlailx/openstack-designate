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
 * Diagnose
 *
 * @author hjl
 */
public class Diagnose {
	
	private final String host ;
	private final Boolean status ;
	private final String backend ;
	private final Storage storage ;
	
	@ConstructorProperties({ "host", "status", "backend", "storage"})
	protected Diagnose(String host, Boolean status, String backend, Storage storage) {
		this.host = host;
		this.status = status;
		this.backend = backend ;
		this.storage = storage;
	}

	public String getHost() {
		return host;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getBackend() {
		return backend;
	}

	public Storage getStorage() {
		return storage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Diagnose that = Diagnose.class.cast(obj);
		return Objects.equal(this.host, that.host)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.backend, that.backend)
				&& Objects.equal(this.storage, that.storage);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("host", host).add("status", status)
				.add("backend", backend).add("storage", storage);
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
		
		protected String host ;
		protected Boolean status ;
		protected String backend ;
		protected Storage storage ;
		
		public Builder host(String host) {
			this.host = host;
			return self();
		}
		
		public Builder status(Boolean status) {
			this.status = status;
			return self();
		}
		
		public Builder backend(String backend) {
			this.backend = backend;
			return self();
		}
		
		public Builder storage(Storage storage) {
			this.storage = storage;
			return self();
		}
		
		public Diagnose build() {
			return new Diagnose(host, status, backend, storage);
		}

		public Builder fromServer(Diagnose in) {
			return this.host(in.getHost()).status(in.getStatus())
					.backend(in.getBackend()).storage(in.getStorage());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
