/*
j8583 A Java implementation of the ISO8583 protocol
Copyright (C) 2011 Enrique Zamudio Lopez

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
*/
package cn.com.syscom.iso8583.parse;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;

import cn.com.syscom.iso8583.util.Bcd;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.CustomField;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;

/** This class is used to parse NUMERIC fields.
 * 
 * @author Enrique Zamudio
 */
public class NumericParseInfo extends AlphaNumericFieldParseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NumericParseInfo() {
		super();
	}
	
	public NumericParseInfo(int len) {
		super(IsoType.NUMERIC, len);
	}

    @Override
	public <T> IsoValue<Number> parseBinary(final int field, final byte[] buf,
                                        final int pos, final CustomField<T> custom)
            throws ParseException {
		if (pos < 0) {
			throw new ParseException(String.format("Invalid bin NUMERIC field %d pos %d",
                    field, pos), pos);
		} else if (pos+(length/2) > buf.length) {
			throw new ParseException(String.format(
                    "Insufficient data for bin %s field %d of length %d, pos %d",
				type, field, length, pos), pos);
		}
		//A long covers up to 18 digits
		if (length < 19) {
			return new IsoValue<Number>(IsoType.NUMERIC, Bcd.decodeToLong(buf, pos, length),
                length, null);
		} else {
			//Use a BigInteger
            try {
                return new IsoValue<Number>(IsoType.NUMERIC,
                    Bcd.decodeToBigInteger(buf, pos, length), length, null);
            } catch (IndexOutOfBoundsException ex) {
                throw new ParseException(String.format(
                    "Insufficient data for bin %s field %d of length %d, pos %d",
                    type, field, length, pos), pos);
            }
		}
	}

}
