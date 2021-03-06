/*******************************************************************************
 * Copyright (c) 2015, 2016 David Green.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.greensopinion.finance.services.transaction;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.greensopinion.finance.services.transaction.EntityReferences;

public class EntityReferencesTest {

	@Test
	public void nameToEntityReferences() {
		assertNameToEntityReferences("#38", "amp");
		assertNameToEntityReferences("#8822", "LessGreater");
	}

	@Test
	public void namedEntityToString() {
		assertNamedEntityToString("&", "amp");
		assertNamedEntityToString("≶", "LessGreater");
		assertNamedEntityToString("Ã", "#195");
	}

	private void assertNamedEntityToString(String expected, String named) {
		assertEquals(expected, EntityReferences.instance().namedEntityToString(named));
	}

	private void assertNameToEntityReferences(String expected, String named) {
		List<String> references = EntityReferences.instance().nameToEntityReferences(named);
		assertEquals(ImmutableList.of(expected), references);
	}
}
