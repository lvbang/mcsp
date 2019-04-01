package cn.com.syscom.iso8583.tlv;

import java.util.Arrays;

public class BerDataset {
    public final byte[] bytes;
    private boolean isNewDataset;
    
    public boolean isNewDataset() {
		return isNewDataset;
	}

	public void setNewDataset(boolean isNewDataset) {
		this.isNewDataset = isNewDataset;
	}

	public BerDataset(byte[] aBuf) {
        this(aBuf, 0, aBuf.length);
    }

    public BerDataset(int aFirstByte) {
        bytes = new byte[]{(byte) aFirstByte};
    }
    
	public BerDataset(byte[] aBuf, int aOffset, int aLength) {
		// TODO Auto-generated constructor stub
        byte[] temp = new byte[aLength];
        System.arraycopy(aBuf, aOffset, temp, 0, aLength);
        bytes = temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bytes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BerDataset other = (BerDataset) obj;
		if (!Arrays.equals(bytes, other.bytes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  HexUtil.toHexString(bytes, 0, bytes.length);
	}
    
    
}
