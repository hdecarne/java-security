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
package de.carne.security.crypto;

import java.security.GeneralSecurityException;

/**
 * {@linkplain StorableCoderId#AES128} factory.
 */
class AES128CoderFactory implements StorableCoderFactory {

	@Override
	public StorableCoder newCoder() throws GeneralSecurityException {
		return AESCoder.newCoder(StorableCoderId.AES128);
	}

	@Override
	public StorableCoder loadCoder(byte[] secret, int off, int len) throws GeneralSecurityException {
		return AESCoder.loadCoder(StorableCoderId.AES128, secret, off, len);
	}

}
