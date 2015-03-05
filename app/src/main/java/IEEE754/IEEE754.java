/*
 * This program uses java.lang.Number and its children Integer, Long, Float, Double, or BigInteger
 */
package IEEE754;

/**
 *
 * @author Farbod Sedghi
 */
public class IEEE754 implements Binary{

    /**
     * number stores value as Integer, Long, Float, Double, or BigInteger
     */
    protected Number number;

    /**
     *
     */
    public IEEE754() {
        number = 0;
    }        
    
    /**
     * 
     * @param number accept Integer, Long, Float, Double, or BigInteger
     */
    public IEEE754(Number number) {
        this.number = number;
    }
    
    @Override
    public Integer getFloat32(Float decimal) {
        // TODO
        return Float.floatToRawIntBits(decimal);
    }

    @Override
    public Long getDouble64(Double decimal) {
        // TODO
        return Double.doubleToRawLongBits(decimal);
    }

    @Override
    public Double getDoubleDecimal(String long64) {
        // TODO
        return Double.longBitsToDouble(0);
    }
    
    @Override
    public Double getDecimal(Long double64) {
        // TODO
        return Double.longBitsToDouble(double64);
    }    
    
    @Override
    public Double getDecimal64() {
        // TODO
        return 0D;
    }    
    
    @Override
    public Float getFloatDecimal(String int32) {
        // TODO
        return Float.intBitsToFloat(0);
    }

    @Override
    public Float getDecimal(Integer float32) {
        // TODO
        return Float.intBitsToFloat(float32);
    }
    
    @Override
    public Float getDecimal32() {
        // TODO
        return 0F;
    }

    @Override
    public String toHexadecimal(){
        return null;
    }
    
    @Override
    public String toBinaryString(){
        return null;
    }
    
    /**
     * 
     * @return String represented by default value, number, as hexadecimal
     */
    @Override
    public String toString(){                
        return "";
    }
    
}
