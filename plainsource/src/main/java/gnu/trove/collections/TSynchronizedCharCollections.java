///////////////////////////////////////////////////////////////////////////////
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

package gnu.trove.collections;

//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


import gnu.trove.TCharCollection;
import gnu.trove.impl.sync.TSynchronizedCharCollection;


public class TSynchronizedCharCollections {

    // Disallow creation of instances of this class
    private TSynchronizedCharCollections() { }

    /**
     * Returns a synchronized (thread-safe) Trove collection backed by the specified
     * Trove collection.  In order to guarantee serial access, it is critical that
     * <strong>all</strong> access to the backing collection is accomplished
     * through the returned collection.<p>
     *
     * It is imperative that the user manually synchronize on the returned
     * collection when iterating over it:
     * <pre>
     *  TCharCollection c = TSynchronizedCharCollections.wrap( myCollection );
     *     ...
     *  synchronized( c ) {
     *      TCharIterator i = c.iterator(); // Must be in the synchronized block
     *      while ( i.hasNext() )
     *         foo( i.next() );
     *  }
     * </pre>
     * Failure to follow this advice may result in non-deterministic behavior.
     *
     * <p>The returned collection does <i>not</i> pass the <tt>hashCode</tt>
     * and <tt>equals</tt> operations through to the backing collection, but
     * relies on <tt>Object</tt>'s equals and hashCode methods.  This is
     * necessary to preserve the contracts of these operations in the case
     * that the backing collection is a set or a list.<p>
     *
     * The returned collection will be serializable if the specified collection
     * is serializable.
     *
     * @param  c the collection to be "wrapped" in a synchronized collection.
     * @return a synchronized view of the specified collection.
     */
    public static TCharCollection wrap( TCharCollection c ) {
	    return new TSynchronizedCharCollection(c);
    }

    static TCharCollection wrap( TCharCollection c, Object mutex ) {
	    return new TSynchronizedCharCollection( c, mutex );
    }
}