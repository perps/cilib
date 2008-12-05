/*
 * Copyright (C) 2003 - 2008
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.type.types;

/**
 * Definition of the <tt>Numeric</tt> type.
 * 
 * @author Gary Pampara
 */
public abstract class Numeric extends AbstractType implements Comparable<Numeric> {
	private static final long serialVersionUID = 3795529161693499589L;

    private Bounds bounds;

    protected Numeric() {
        this.bounds = new Bounds();
    }
	
	/**
	 * {@inheritDoc}
	 */
	public abstract Numeric getClone();
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object other) {
		if (this == other)
			return true;
		
		if ((other == null) || (this.getClass() != other.getClass()))
			return false;
		
		Numeric numeric = (Numeric) other;
//		return (Double.valueOf(this.lowerBound).equals(Double.valueOf(numeric.lowerBound))) &&
//			(Double.valueOf(this.upperBound).equals(Double.valueOf(numeric.upperBound)));
        return this.bounds.equals(numeric.bounds);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		int hash = 7;
        hash = 31 * hash + this.bounds.hashCode();
//		hash = 31 * hash + Double.valueOf(lowerBound).hashCode();
//		hash = 31 * hash + Double.valueOf(upperBound).hashCode();
		return hash;
	}
	
	/**
	 * Set the value of the {@linkplain Numeric}.
	 * @param value The {@linkplain String} value to be parsed.
	 */
	public abstract void set(String value);
	
	/**
	 * Set the value of the {@linkplain Numeric}.
	 * @param value The {@literal boolean} value representing the value for this {@linkplain Type}.
	 */
	public abstract void set(boolean value);
	
	/**
	 * Set the value of the {@linkplain Numeric}.
	 * @param value The {@literal int} value representing the value for this {@linkplain Type}.
	 */
	public abstract void set(int value);
	
	/**
	 * Set the value of the {@linkplain Numeric}.
	 * @param value The {@literal double} value representing the value for this {@linkplain Type}.
	 */
	public abstract void set(double value);
	
	/**
	 * Get the value of this {@linkplain Numeric}.
	 * @return The value of this {@linkplain Numeric} as a {@literal boolean}.
	 */
	public abstract boolean getBit();
	
	/**
	 * Set the bit value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setBit(boolean value);
	
	/**
	 * Set the bit value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setBit(String value);
	
	/**
	 * Get the value of this {@linkplain Numeric}.
	 * @return The value of this {@linkplain Numeric} as a {@literal int}.
	 */
	public abstract int getInt();
	
	/**
	 * Set the integer value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setInt(int value);
	
	/**
	 * Set the integer value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setInt(String value);
	
	/**
	 * Get the value of this {@linkplain Numeric}.
	 * @return The value of this {@linkplain Numeric} as a {@literal double}.
	 */
	public abstract double getReal();
	
	/**
	 * Set the real value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setReal(double value);
	
	/**
	 * Set the real value with the provided value.
	 * @param value The value to set.
	 */
	public abstract void setReal(String value);

	/**
	 * {@inheritDoc}
	 */
	public abstract int compareTo(Numeric other);

	/**
	 * {@inheritDoc}
	 */
	public boolean isInsideBounds() {
		return true;
	}

	/**
	 * Return the dimension of the {@linkplain Type}. {@linkplain Numeric} objects are defined to
	 * have a dimension of {@literal 1}.
	 * @return The dimension value of 1. 
	 */
	public int getDimension() {
		return 1;
	}

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public void setBounds(double lower, double upper) {
        this.setBounds(BoundsFactory.create(lower, upper));
    }
	
}
