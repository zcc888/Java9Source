/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.word;

public interface Unsigned extends ComparableWord {

    /**
     * Returns a Unsigned whose value is {@code (this + val)}.
     *
     * @param val value to be added to this Unsigned.
     * @return {@code this + val}
     */
    Unsigned add(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this - val)}.
     *
     * @param val value to be subtracted from this Unsigned.
     * @return {@code this - val}
     */
    Unsigned subtract(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this Unsigned.
     * @return {@code this * val}
     */
    Unsigned multiply(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this / val)}.
     *
     * @param val value by which this Unsigned is to be divided.
     * @return {@code this / val}
     */
    Unsigned unsignedDivide(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this % val)}.
     *
     * @param val value by which this Unsigned is to be divided, and the remainder computed.
     * @return {@code this % val}
     */
    Unsigned unsignedRemainder(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this << n)}.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     */
    Unsigned shiftLeft(Unsigned n);

    /**
     * Returns a Unsigned whose value is {@code (this >>> n)}. No sign extension is performed.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     */
    Unsigned unsignedShiftRight(Unsigned n);

    /**
     * Returns a Unsigned whose value is {@code (this & val)}.
     *
     * @param val value to be AND'ed with this Unsigned.
     * @return {@code this & val}
     */
    Unsigned and(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this | val)}.
     *
     * @param val value to be OR'ed with this Unsigned.
     * @return {@code this | val}
     */
    Unsigned or(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this ^ val)}.
     *
     * @param val value to be XOR'ed with this Unsigned.
     * @return {@code this ^ val}
     */
    Unsigned xor(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (~this)}.
     *
     * @return {@code ~this}
     */
    Unsigned not();

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this == val}
     */
    boolean equal(Unsigned val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this != val}
     */
    boolean notEqual(Unsigned val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this < val}
     */
    boolean belowThan(Unsigned val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this <= val}
     */
    boolean belowOrEqual(Unsigned val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this > val}
     */
    boolean aboveThan(Unsigned val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this >= val}
     */
    boolean aboveOrEqual(Unsigned val);

    /**
     * Returns a Unsigned whose value is {@code (this + val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be added to this Unsigned.
     * @return {@code this + val}
     */
    Unsigned add(int val);

    /**
     * Returns a Unsigned whose value is {@code (this - val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be subtracted from this Unsigned.
     * @return {@code this - val}
     */
    Unsigned subtract(int val);

    /**
     * Returns a Unsigned whose value is {@code (this * val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be multiplied by this Unsigned.
     * @return {@code this * val}
     */
    Unsigned multiply(int val);

    /**
     * Returns a Unsigned whose value is {@code (this / val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value by which this Unsigned is to be divided.
     * @return {@code this / val}
     */
    Unsigned unsignedDivide(int val);

    /**
     * Returns a Unsigned whose value is {@code (this % val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value by which this Unsigned is to be divided, and the remainder computed.
     * @return {@code this % val}
     */
    Unsigned unsignedRemainder(int val);

    /**
     * Returns a Unsigned whose value is {@code (this << n)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     */
    Unsigned shiftLeft(int n);

    /**
     * Returns a Unsigned whose value is {@code (this >>> n)}. No sign extension is performed.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     */
    Unsigned unsignedShiftRight(int n);

    /**
     * Returns a Unsigned whose value is {@code (this & val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be AND'ed with this Unsigned.
     * @return {@code this & val}
     */
    Unsigned and(int val);

    /**
     * Returns a Unsigned whose value is {@code (this | val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be OR'ed with this Unsigned.
     * @return {@code this | val}
     */
    Unsigned or(int val);

    /**
     * Returns a Unsigned whose value is {@code (this ^ val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be XOR'ed with this Unsigned.
     * @return {@code this ^ val}
     */
    Unsigned xor(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this == val}
     */
    boolean equal(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this != val}
     */
    boolean notEqual(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this < val}
     */
    boolean belowThan(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this <= val}
     */
    boolean belowOrEqual(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this > val}
     */
    boolean aboveThan(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this >= val}
     */
    boolean aboveOrEqual(int val);
}
