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

package gnu.trove.lists;

//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


import gnu.trove.list.TFloatList;
import gnu.trove.impl.sync.TSynchronizedFloatList;
import gnu.trove.impl.sync.TSynchronizedRandomAccessFloatList;

import java.util.RandomAccess;


public class TSynchronizedFloatLists {

    // Disallow creation of instances of this class
    private TSynchronizedFloatLists() { }

    /**
     * Returns a synchronized (thread-safe) Trove list backed by the specified
     * list.  In order to guarantee serial access, it is critical that
     * <strong>all</strong> access to the backing list is accomplished
     * through the returned list.<p>
     *
     * It is imperative that the user manually synchronize on the returned
     * list when iterating over it:
     * <pre>
     *  TFloatList list = TSynchronizedFloatLists.wrap( new TFloatArrayList() );
     *      ...
     *  synchronized( list ) {
     *      TFloatIterator i = list.iterator(); // Must be in synchronized block
     *      while ( i.hasNext() )
     *          foo( i.next() );
     *  }
     * </pre>
     * Failure to follow this advice may result in non-deterministic behavior.
     *
     * <p>The returned list will be serializable if the specified list is
     * serializable.
     *
     * @param  list the list to be "wrapped" in a synchronized list.
     * @return a synchronized view of the specified list.
     */
    public static TFloatList wrap( TFloatList list ) {
	    return ( list instanceof RandomAccess ?
                new TSynchronizedRandomAccessFloatList( list ) :
                new TSynchronizedFloatList( list ) );
    }

    static TFloatList wrap( TFloatList list, Object mutex ) {
	    return ( list instanceof RandomAccess ?
                new TSynchronizedRandomAccessFloatList( list, mutex ) :
                new TSynchronizedFloatList( list, mutex ) );
    }
}
