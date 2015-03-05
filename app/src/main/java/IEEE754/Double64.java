/*
 * This program uses java.lang.Number and its children Integer, Long, Float, Double, or BigInteger
 */
package IEEE754;

/**
 * Define the IEEE-754 double precision standard uses an 11-bit exponent (with a bias of 1023) and a 52-bit significant 
 * @author Farbod Sedghi
 */
public class Double64 extends IEEE754 {

    /**
     * 
     * @param number as Double
     */
    public Double64(Double number) {
        super(number);
    }

    /**
     *
     * @return 64bits value stored as Long
     */
    public Long getDouble64() {
        // TODO
        return Double.doubleToRawLongBits((Double) number);
    }

    @Override
    public String toHexadecimal() {
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return String.format("0x%x", getDouble64());
    }

    @Override
    public String toBinaryString() {
         return String.format("%64s", Long.toBinaryString(getDouble64())).replace(' ', '0');
    }
    
    @Override
    public String toString(){
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return String.format("0x%x", getDouble64());
    }
}
