package cn.com.syscom.iso8583.baffle;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoValue;

/**
 * ChannelHandler responsible for logging messages.
 * <p>
 * According to PCI DSS, sensitive cardholder data, like PAN and track data, should not be exposed. When running in secure mode, sensitive cardholder data will be printed masked. </p>
 */

public class IsoMessageLoggingHandler {

    private static final char MASK_CHAR = '*';
    private static final int[] DEFAULT_MASKED_FIELDS = {
            34,// PAN extended
            35,// track 2
            36,// track 3
            45// track 1
    };
    private static char[] MASKED_VALUE = "***".toCharArray();
    private static String[] FIELD_NAMES = new String[128];

    static {
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("iso8583fields.properties")) {
            final Properties properties = new Properties();
            properties.load(stream);
            properties.forEach((key, value) -> {
                int field = Integer.parseInt((String) key);
                FIELD_NAMES[field - 1] = (String) value;
            });
        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException("Unable to load ISO8583 field descriptions", e);
        }
    }

    private final boolean printSensitiveData;
    private final boolean printFieldDescriptions;
    private final int[] maskedFields;

    public IsoMessageLoggingHandler( boolean printSensitiveData,
                                    boolean printFieldDescriptions,
                                    int... maskedFields) {
        this.printSensitiveData = printSensitiveData;
        this.printFieldDescriptions = printFieldDescriptions;
        this.maskedFields = (maskedFields != null && maskedFields.length > 0) ? maskedFields : DEFAULT_MASKED_FIELDS;
    }

    public IsoMessageLoggingHandler() {
        this(true, true);
    }

    private static char[] maskPAN(String fullPan) {
        char[] maskedPan = fullPan.toCharArray();
        for (int i = 6; i < maskedPan.length - 4; i++) {
            maskedPan[i] = MASK_CHAR;
        }
        return maskedPan;
    }

    public String formatIsoMessage(IsoMessage m) {
        StringBuilder sb = new StringBuilder();
        if (printSensitiveData) {
            sb.append("Message: ").append(m.debugString()).append("\n");
        }
        sb.append("\nMTI: 0x").append(String.format("%04x", m.getType()));
        for (int i = 2; i < 128; i++) {
            if (m.hasField(i)) {
                final IsoValue<Object> field = m.getField(i);
                sb.append("\n  F").append(i).append(" [").append(field.getType()).append('(').append(field.getLength())
                .append(")]").append(": ");

                if (printFieldDescriptions) {
                    sb.append(FIELD_NAMES[i - 1]).append(':');
                }

                char[] formattedValue;
                if (printSensitiveData) {
                    formattedValue = field.toString().toCharArray();
                } else {
                    if (i == 2) {
                        formattedValue = maskPAN(field.toString());
                    } else if (Arrays.binarySearch(maskedFields, i) >= 0) {
                        formattedValue = MASKED_VALUE;
                    } else {
                        formattedValue = field.toString().toCharArray();
                    }

                }
                sb.append(" '").append/*(m.getObjectValue(i).toString()).append(" = ").append*/(formattedValue).append('\'');

            }
        }
        return sb.toString();
    }
    
    public String formatMonitorMessage(IsoMessage m) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(m.getObjectValue(7))).append("   ");
         
        final IsoValue<Object> field2 = m.getField(2);
	    char[] formattedValue;
        formattedValue = maskPAN(field2.toString());
        sb.append(formattedValue).append("   ");
        
        String  strField = new String();
        if (m.hasField(4)) {
        	strField =  m.getField(4).toString();
		}
        sb.append(String.format("%-12s",strField.replaceAll("^(0+)", ""))).append("  ");

        sb.append(m.getField(39).toString()).append("  ");
        
        sb.append(m.getField(42).toString());
        return sb.toString();
    }
}
