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
 * Storage
 *
 * @author hjl
 */
public class Storage {
	
	private final Boolean status ;
	private final String message ;
	
	@ConstructorProperties({ "status", "message"})
	protected Storage(Boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Storage that = Storage.class.cast(obj);
		return Objects.equal(this.status, that.status)
				&& Objects.equal(this.message, that.message);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("status", status).add("message", message);
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
		
		protected Boolean status ;
		protected String message ;
		
		public Builder status(Boolean status) {
			this.status = status;
			return self();
		}
		
		public Builder message(String message) {
			this.message = message;
			return self();
		}
		
		public Storage build() {
			return new Storage(status, message);
		}

		public Builder fromServer(Storage in) {
			return this.status(in.getStatus()).message(in.getMessage());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
