/*
 * Copyright (c) 2018-2019 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.security.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.eclipse.jdt.annotation.NonNull;

import de.carne.boot.Exceptions;

/**
 * Utility class providing access to a {@linkplain SecureRandom} instance.
 * <p>
 * The provided {@linkplain SecureRandom} instances are cached on a per thread base.
 * </p>
 */
public final class Randomness {

	private Randomness() {
		// prevent instantiation
	}

	// Shared per thread random source
	@SuppressWarnings("squid:S5164")
	private static final ThreadLocal<@NonNull SecureRandom> RANDOM = ThreadLocal.withInitial(() -> {
		SecureRandom random;

		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw Exceptions.toRuntime(e);
		}
		return random;
	});

	/**
	 * Get the current thread's {@linkplain SecureRandom} instance.
	 *
	 * @return the current thread's {@linkplain SecureRandom} instance.
	 */
	public static SecureRandom get() {
		return RANDOM.get();
	}

}
