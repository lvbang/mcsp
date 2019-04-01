package cn.com.syscom.iso8583.tlv;

import java.util.ArrayList;
import java.util.List;

public class BerTlvs {

    protected BerTlvs(List<BerTlv> aTlvs) {
        tlvs = aTlvs;
    }

    public BerTlv find(BerTag aTag) {
        for (BerTlv tlv : tlvs) {
            BerTlv found = tlv.find(aTag);
            if(found!=null) {
                return found;
            }
        }
        return null;
    }

    public BerTlv find(BerDataset aBerDataset,BerTag aTag) {
        for (BerTlv tlv : tlvs) {
            BerTlv found = tlv.find(aBerDataset,aTag);
            if(found!=null) {
                return found;
            }
        }
        return null;
    }
    
    public List<BerTlv> findAll(BerTag aTag) {
        List<BerTlv> list = new ArrayList<BerTlv>();
        for (BerTlv tlv : tlvs) {
            list.addAll(tlv.findAll(aTag));
        }
        return list;
    }


    public List<BerTlv> getList() {
        return tlvs;
    }

    private final List<BerTlv> tlvs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BerTlvs berTlvs = (BerTlvs) o;

        return tlvs != null ? tlvs.equals(berTlvs.tlvs) : berTlvs.tlvs == null;
    }

    @Override
    public int hashCode() {
        return tlvs != null ? tlvs.hashCode() : 0;
    }

    @Override
    public String toString() {
//        return "BerTlvs{" +
//                "tlvs=" + tlvs +
//                '}';
//    	return tlvs.toString();
    	StringBuilder sb = new StringBuilder();
        if (tlvs!=null) {
	        for (BerTlv tlv : tlvs) {
	        	sb.append(tlv.toString());
	        }
        }
        return sb.toString();
    }

	public void update(BerDataset berDataset, BerTag berTag, byte[] aValue) {
		// TODO Auto-generated method stub
		BerTlv found = find(berDataset, berTag);
		if (found != null) {
			found.setByteValue(aValue);
		}
	}

	public void addTlv(int i, BerTlv berTlv) {
		// TODO Auto-generated method stub
		getList().add(i, berTlv);
		if (getList().get(i+1).getDataset().isNewDataset()) {
			getList().get(i+1).getDataset().setNewDataset(false);
			getList().get(i).getDataset().setNewDataset(true);
		}
	}

}
