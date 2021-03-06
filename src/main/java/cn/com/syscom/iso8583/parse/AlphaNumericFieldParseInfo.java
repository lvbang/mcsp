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

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import cn.com.syscom.iso8583.CustomField;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;
import cn.com.syscom.iso8583.util.HexUtil;

/** This is the common abstract superclass to parse ALPHA and NUMERIC field types.
 * 
 * @author Enrique Zamudio
 */
public abstract class AlphaNumericFieldParseInfo extends FieldParseInfo {

	public AlphaNumericFieldParseInfo(IsoType t, int len) {
		super(t, len);
	}

    public AlphaNumericFieldParseInfo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> IsoValue<?> parse(final int field, final byte[] buf, final int pos,
                             final CustomField<T> custom)
            throws ParseException, UnsupportedEncodingException {

		if (pos < 0) {
			throw new ParseException(String.format("Invalid ALPHA/NUM field %d position %d",
                    field, pos), pos);
		} else if (pos+length > buf.length) {
			throw new ParseException(String.format("Insufficient data for %s field %d of length %d, pos %d",
				type, field, length, pos), pos);
		}
        try {
            String _v = new String(buf, pos, length, getCharacterEncoding());
            if (_v.length() != length) {
                _v = new String(buf, pos, buf.length-pos, getCharacterEncoding()).substring(0, length);
            	// _v = new String(buf, pos, buf.length-pos, getCharacterEncoding());
            }
            if (custom == null) {
                return new IsoValue<>(type, _v, length, null);
            } else {
                T decoded = custom.decodeField(_v);
                return decoded == null ? new IsoValue<>(type, _v, length, null) :
                    new IsoValue<>(type, decoded, length, custom);
            }
        } catch (StringIndexOutOfBoundsException ex) {
            throw new ParseException(String.format(
                    "Insufficient data for %s field %d of length %d, pos %d",
                    type, field, length, pos), pos);
        }
	}

}
