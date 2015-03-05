/*
 * This program uses java.lang.Number and its children Integer, Long, Float, Double, or BigInteger
 */
package IEEE754;

import java.math.BigInteger;

/**
 * Define the IEEE-754 an 11-bit exponent (with a bias of 1023) and a 52-bit significant to represent double precision standard
 * @author Farbod Sedghi
 */
public class QWord extends IEEE754 {

    /**
     *
     */
    public QWord() {
        super();
    }

    /**
     * 
     * @param long64 as Binary String
     */
    public QWord(String long64) {
        super(new BigInteger(long64, 2));
    }

    @Override
    public Double getDecimal(Long long64) {
        // TODO
        return Double.longBitsToDouble(long64);
    }

    @Override
    public Double getDecimal64() {
        return Double.longBitsToDouble(number.longValue());
    }

    @Override
    public String toHexadecimal() {
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return "0x" + Long.toHexString(number.longValue());
    }

    @Override
    public String toString() {
        if (number.doubleValue() == 0) {
            return String.format("0x%016d", 0);
        }
        return "0x" + Long.toHexString(number.longValue());
    }
}
