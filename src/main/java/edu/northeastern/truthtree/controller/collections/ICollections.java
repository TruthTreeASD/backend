package edu.northeastern.truthtree.controller.collections;

import org.springframework.http.ResponseEntity;

import edu.northeastern.truthtree.controller.attributes.IAttributes;

/**
 * Represents interface for collection. A collection is grouping of one ore more
 * similar attributes in Truthtree. To know more about attributes, see
 * {@link IAttributes}
 * 
 * @author nehashukla
 *
 */
public interface ICollections {
	/**
	 * Represents method to fetch collections with an optional query parameter of
	 * locationId, using which user can search for all the collections in the
	 * TruthTree Application. If user provides locationId, additionally, this api
	 * would filter out collections relevant to that location.
	 * 
	 * @param locationId
	 *            in Integer which represents unique identifier for a location.
	 * 
	 * @author nehashukla
	 *
	 */
	public ResponseEntity<Object> getCollections(Integer locationId);
}
