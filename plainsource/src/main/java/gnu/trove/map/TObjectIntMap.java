///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001, Eric D. Friedman All Rights Reserved.
// Copyright (c) 2009, Rob Eden All Rights Reserved.
// Copyright (c) 2009, Jeff Randall All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove.map;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.iterator.TObjectIntIterator;

import java.util.Map;
import java.util.Set;


//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


/**
 * Interface for a primitive map of Object keys and int values.
 */
public interface TObjectIntMap<K> {

    // Query Operations

    /**
     * Returns the value that will be returned from {@link #get} or {@link #put} if no
     * entry exists for a given key. The default value is generally zero, but can be
     * configured during construction of the collection.
     *
     * @return the value that represents a null value in this collection.
     */
    int getNoEntryValue();


    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of key-value mappings in this map
     */
    int size();


    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    boolean isEmpty();


    /**
     * Checks for the present of <tt>key</tt> in the keys of the map.
     */
    boolean containsKey( Object key );


    /**
     * Checks for the presence of <tt>val</tt> in the values of the map.
     */
    boolean containsValue( int value );


    /**
     * Retrieves the value for <tt>key</tt>.
     *
     * @return the previous value associated with <tt>key</tt>, or the "no entry" value
     *         if none was found (see {@link #getNoEntryValue}).
     */
    int get( Object key );


    // Modification Operations

    /**
     * Inserts a key/value pair into the map.
     *
     * @return the previous value associated with <tt>key</tt>, or the "no entry" value
     *         if none was found (see {@link #getNoEntryValue}).
     */
    int put( K key, int value);


    /**
     * Inserts a key/value pair into the map if the specified key is not already
     * associated with a value.
     *
     * @param key key with which the specified value is to be associated
     * @param value an <tt>int</tt> value to be associated with the specified key
     *
     * @return the previous value associated with <tt>key</tt>, or the "no entry" value
     *         if none was found (see {@link #getNoEntryValue}).
     */
    int putIfAbsent( K key, int value );


    /**
     * Deletes a key/value pair from the map.
     *
     * @param key an <code>#k#</code> value
     *
     * @return the previous value associated with <tt>key</tt>, or the "no entry" value
     *         if none was found (see {@link #getNoEntryValue}).
     */
    int remove( Object key );


    // Bulk Operations

    /**
     * Copies all of the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,int) put(k, v)} on this map once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified map.  The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this map
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified map prevents it from being stored in this map
     * @throws NullPointerException if the specified map is null, or if
     *         this map does not permit null keys or values, and the
     *         specified map contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified map prevents it from being stored in this map
     */
    void putAll( Map<? extends K, ? extends Integer> m);


    /**
     * Put all the entries from the given map into this map.
     *
     * @param map   The map from which entries will be obtained to put into this map.
     */
    void putAll( TObjectIntMap<? extends K> map );


    /**
     * Removes all of the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this map
     */
    void clear();


    // Views

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation), the results of
     * the iteration are undefined.  The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
     * operations.
     *
     * @return a set view of the keys contained in this map
     */
    Set<K> keySet();


    /**
     * Returns a copy of the keys of the map as an array.
     * Changes to the array of keys will not be reflected in the map
     * nor vice-versa.
     *
     * @return a copy of the keys of the map as an array.
     */
    Object[] keys();


    /**
     * Returns a copy of the keys of the map as an array.
     * Changes to the array of keys will not be reflected in the map
     * nor vice-versa.
     *
     * @param array   the array into which the elements of the list are to be stored,
     *                if it is big enough; otherwise, a new array of the same type is
     *                allocated for this purpose.
     * @return the keys of the map as an array.
     */
    K[] keys( K[] array );



    /**
     * Returns a {@link TIntCollection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>TIntIterator.remove</tt>,
     * <tt>TIntCollection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a collection view of the values contained in this map
     */
    TIntCollection valueCollection();


    /**
     * Returns the values of the map as an array of <tt>int</tt> values.
     * Changes to the array of values will not be reflected in the map
     * nor vice-versa.
     *
     * @return the values of the map as an array of <tt>int</tt> values.
     */
    int[] values();


    /**
     * Returns the values of the map using an existing array.
     * Changes to the array of values will not be reflected in the map
     * nor vice-versa.
     *
     * @param array   the array into which the elements of the list are to be stored,
     *                if it is big enough; otherwise, a new array of the same type is
     *                allocated for this purpose.
     * @return the values of the map as an array of <tt>int</tt> values.
     */
    int[] values( int[] array );


    /**
     * Returns a <tt>TObjectIntIterator</tt> with access to this map's keys and values.
     *
     * @return a <tt>TObjectIntIterator</tt> with access to this map's keys and values.
     */
    public TObjectIntIterator<K> iterator();


    /**
     * Increments the primitive value mapped to key by 1
     *
     * @param key the key of the value to increment
     * @return true if a mapping was found and modified.
     */
    public boolean increment( K key );


    /**
     * Adds an amount to the primitive value mapped to key. If the key does not exist,
     * the map is not modified (key-value is not inserted).
     *
     * @param key the key of the value to increment
     * @param amount the amount to add to the value; may be positive, zero, or negative
     * @return true if a mapping was found and modified
     * @see #adjustOrPutValue(Object, int, int)
     */
    public boolean adjustValue( K key, int amount );


    /**
     * Adds an amount to the primitive value mapped to the key if the key is present in
     * the map. Otherwise, the <tt>put_amount</tt> is put in the map.
     *
     * @param key the key of the value to increment
     * @param adjust_amount the amount to add to the value; may be positive, zero,
     *        or negative
     * @param put_amount the value put into the map if the key is not present
     *
     * @return the value present in the map after the adjustment or put operation
     */
    public int adjustOrPutValue( K key, int adjust_amount, int put_amount );


    /**
     * Executes <tt>procedure</tt> for each key in the map.
     *
     * @param procedure a <code>TObjectProcedure</code> value
     * @return false if the loop over the keys terminated because
     *         the procedure returned false for some key.
     */
    public boolean forEachKey( TObjectProcedure<? super K> procedure );


    /**
     * Executes <tt>procedure</tt> for each value in the map.
     *
     * @param procedure a <code>TIntProcedure</code> value
     * @return false if the loop over the values terminated because
     *         the procedure returned false for some value.
     */
    public boolean forEachValue( TIntProcedure procedure );


    /**
     * Executes <tt>procedure</tt> for each key/value entry in the
     * map.
     *
     * @param procedure a <code>TOObjectIntProcedure</code> value
     * @return false if the loop over the entries terminated because
     *         the procedure returned false for some entry.
     */
    public boolean forEachEntry( TObjectIntProcedure<? super K> procedure );


    /**
     * Transform the values in this map using <tt>function</tt>.
     *
     * @param function a <code>TIntFunction</code> value
     */
    public void transformValues( TIntFunction function );


    /**
     * Retains only those entries in the map for which the procedure
     * returns a true value.
     *
     * @param procedure determines which entries to keep
     * @return true if the map was modified.
     */
    public boolean retainEntries( TObjectIntProcedure<? super K> procedure );


    // Comparison and hashing

    /**
     * Compares the specified object with this map for equality.  Returns
     * <tt>true</tt> if the given object is also a map and the two maps
     * represent the same mappings.  More formally, two maps <tt>m1</tt> and
     * <tt>m2</tt> represent the same mappings if
     * <tt>m1.entrySet().equals(m2.entrySet())</tt>.  This ensures that the
     * <tt>equals</tt> method works properly across different implementations
     * of the <tt>Map</tt> interface.
     *
     * @param o object to be compared for equality with this map
     * @return <tt>true</tt> if the specified object is equal to this map
     */
    boolean equals( Object o );

    /**
     * Returns the hash code value for this map.  The hash code of a map is
     * defined to be the sum of the hash codes of each entry in the map's
     * <tt>entrySet()</tt> view.  This ensures that <tt>m1.equals(m2)</tt>
     * implies that <tt>m1.hashCode()==m2.hashCode()</tt> for any two maps
     * <tt>m1</tt> and <tt>m2</tt>, as required by the general contract of
     * {@link Object#hashCode}.
     *
     * @return the hash code value for this map
     
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();
}
