/*
 * This program uses java.lang.Number and its children Integer, Long, Float, Double, or BigInteger
 */
package IEEE754;

/**
 * Define the IEEE-754 single precision floating point standard uses an 8-bit exponent (with a bias of 127) and a 23-bit significant
 * @author Farbod Sedghi
 */
public class Float32 extends IEEE754 {

    /**
     *
     * @param number as Float
     */
    public Float32(Float number) {
        super(number);
    }

    /**
     * 
     * @return 32bits value stored as Integer
     */
    public Integer getFloat32() {
        // TODO
        return Float.floatToRawIntBits((Float) number);
    }

    @Override
    public String toHexadecimal() {
        if (number.floatValue() == 0) {
            return String.format("0x%08d", 0);
        }
        return String.format("0x%x", getFloat32());
    }

    @Override
    public String toBinaryString() {
         return String.format("%32s", Integer.toBinaryString(getFloat32())).replace(' ', '0');
    }
    
    @Override
    public String toString(){
        if (number.floatValue() == 0) {
            return String.format("0x%08d", 0);
        }
        return String.format("0x%x", getFloat32());
    }

}
