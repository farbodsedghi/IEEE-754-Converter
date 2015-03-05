/*
 * This program uses java.lang.Number and its children Integer, Long, Float, Double, or BigInteger
 */
package IEEE754;

import java.math.BigInteger;

/**
 * Define the IEEE-754 an 8-bit exponent (with a bias of 127) and a 23-bit significant to represent single precision floating point standard
 * @author Farbod Sedghi
 */
public class DWord extends IEEE754 {

    /**
     *
     */
    public DWord(){
        super();
    }
    
    /**
     * 
     * @param int32 as Binary String
     */
    public DWord(String int32) {
        super(new BigInteger(int32,2));
    }

    @Override
    public Float getFloatDecimal(String int32) {
        // TODO
        return Float.intBitsToFloat((new BigInteger(int32,2)).intValue());
    }

    @Override
    public Float getDecimal(Integer int32) {
        // TODO
        return Float.intBitsToFloat(int32);
    }
    
    @Override
    public Float getDecimal32(){
        return Float.intBitsToFloat(number.intValue());
    }
    
    @Override
    public String toHexadecimal(){
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return "0x" + Integer.toHexString(number.intValue());
    }

    @Override
    public String toString(){
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return "0x" + Integer.toHexString(number.intValue());
    }

}
