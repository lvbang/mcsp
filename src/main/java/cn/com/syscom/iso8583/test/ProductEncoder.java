package cn.com.syscom.iso8583.test;

import cn.com.syscom.iso8583.CustomField;

/** This is an example of a CustomField encoder/decoder.
 * 
 * @author Enrique Zamudio
 */
public class ProductEncoder implements CustomField<ProductData> {

	public ProductData decodeField(String value) {
		ProductData pd = null;
		if (value != null && value.length() > 3) {
			int pipe = value.indexOf('|');
			if (pipe > 0 && pipe < value.length() - 1) {
				pd = new ProductData();
				pd.setCategoryId(Integer.parseInt(value.substring(0, pipe)));
				pd.setProductId(value.substring(pipe + 1));
			}
		}
		return pd;
	}

	public String encodeField(ProductData value) {
		return value == null ? null : String.format("%d|%s", value.getCategoryId(), value.getProductId());
	}

	@Override
	public ProductData decodeBinaryField(byte[] value, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] encodeBinaryField(ProductData value) {
		// TODO Auto-generated method stub
		return null;
	}

}
