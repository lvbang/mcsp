package cn.com.syscom.iso8583.tlv;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 /**
 * @author SYS
 *tag标签，子域取值的长度为固定长度，tag标签为2个字节，子域长度为3个字节
 */
public class FixTlvParser {

    public static List<FixTlv> parseTlvList(String fieldValue) throws ParseException  
    {  
  
        if (null == fieldValue)  
        {  
            throw new IllegalArgumentException("值不能为空!");  
        }  
  
        return builderTLV(fieldValue);  
    }  
  
    private static List<FixTlv> builderTLV(String fieldValue) throws ParseException  
    {  
        List<FixTlv> tlvs = new ArrayList<FixTlv>();  
  
        int position = 0;  
        while (position != fieldValue.length())  
        {  
            String _hexTag = getFixTag(fieldValue, position);  
            position += _hexTag.length();  
              
            LPositon l_position = getPosition(fieldValue, position);  
            int _vl = l_position.get_vL();  
              
            position = l_position.get_position();  
            if (fieldValue.length() < (position + _vl)) {
            	throw new ParseException(String.format(
    					"Insufficient length for tag %s, length %d", _hexTag), _vl);
			}   
            String _value = fieldValue.substring(position, position + _vl);  
              
            position = position + _value.length();  
              
            tlvs.add(new FixTlv(_hexTag, _vl, _value));  
        }  
        return tlvs;  
    } 
    
    
    public static Map<String, FixTlv> parseTlvMap(String fieldValue) throws ParseException  
    {  
  
        if (null == fieldValue)  
        {  
            throw new IllegalArgumentException("值不能为空!");  
        }  
  
        return builderKeyAndTLV(fieldValue);  
    }  
  
    public static Map<String, FixTlv> builderKeyAndTLV(String fieldValue) throws ParseException  
    {  
  
        Map<String, FixTlv> tlvs = new HashMap<String, FixTlv>();  
  
        int position = 0;  
        while (position != fieldValue.length())  
        {  
            String _hexTag = getFixTag(fieldValue, position);  
            position += _hexTag.length();  
            LPositon l_position = getPosition(fieldValue, position);  
            int _vl = l_position.get_vL();  
            position = l_position.get_position();
            if (fieldValue.length() < (position + _vl)) {
            	throw new ParseException(String.format(
    					"Insufficient length for tag %s, length %d", _hexTag,_vl), _vl);
			}
            String _value = fieldValue.substring(position, position + _vl);  
            position = position + _value.length();  
            tlvs.put(_hexTag, new FixTlv(_hexTag, _vl, _value));  
        }  
        return tlvs;  
    }  
    
    
    private static LPositon getPosition(String fieldValue, int position)  
    {  
  
        String lenString = fieldValue.substring(position, position + 3);         
        position = position + 3;
        return new LPositon(Integer.parseInt(lenString), position);  
  
    }  
  
    private static String getFixTag(String fieldValue, int position)  
    {    
    	return fieldValue.substring(position, position + 2);  
    }  
  
    static class LPositon  
    {  
        private int _vL;  
        private int _position;  
  
        public LPositon(int _vL, int position)  
        {  
            this._vL = _vL;  
            this._position = position;  
        }  
  
        public int get_vL()  
        {  
            return _vL;  
        }  
  
        public void set_vL(int _vL)  
        {  
            this._vL = _vL;  
        }  
  
        public int get_position()  
        {  
            return _position;  
        }  
  
        public void set_position(int _position)  
        {  
            this._position = _position;  
        }  
  
    } 
}
