/*
 * The IEEE-754 single precision floating point standard 
 *      uses an 8-bit exponent (with a bias of 127) and a 23-bit significant
 * The IEEE-754 double precision standard 
 *      uses an 11-bit exponent (with a bias of 1023) and a 52-bit significant
 * 
 */
package IEEE754;

/**
 *
 * @author Farbod Sedghi
 */
public interface Binary {

    /**
     *
     * @param decimal as Float
     * @return 32bits Binary represented IEEE 754 Float
     */
    abstract Integer getFloat32(Float decimal);
    
    /**
     *
     * @param decimal as Double
     * @return 64bits Binary represented IEEE 754 Double
     */
    abstract Long getDouble64(Double decimal);

    /**
     * 
     * @param long64 as 64bits String
     * @return IEEE 754 Double
     */
    abstract public Double getDoubleDecimal(String long64);
    
    /**
     *
     * @param double64 64bits value stored as Long
     * @return IEEE 754 Double
     */
    abstract Double getDecimal(Long double64);
    
    /**
     * Default value, number, stores as BigInteger
     * @return IEEE 754 Double
     */
    abstract Double getDecimal64();

    /**
     * 
     * @param int32 as 32bits String
     * @return IEEE 754 Float
     */
    abstract public Float getFloatDecimal(String int32);

    /**
     *
     * @param float32 32bits value stored as Integer
     * @return IEEE 754 Float
     */
    abstract Float getDecimal(Integer float32);
    
    /**
     * Default bits value, number, stores as BigInteger
     * @return IEEE 754 Float
     */
    abstract Float getDecimal32();
    
    /**
     * 
     * @return String represented by default value, number as hexadecimal
     */
    abstract String toHexadecimal();
    
    /**
     * 
     * @return String represented by default value, number as binary
     */
    abstract String toBinaryString();        
}
