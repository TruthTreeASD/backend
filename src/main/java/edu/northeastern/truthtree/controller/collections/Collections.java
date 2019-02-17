package edu.northeastern.truthtree.controller.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.collections.ICollectionsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
/**
 * Represents implementation for {@link ICollection}. A collection is grouping
 * of one ore more similar attributes in Truthtree. To know more about
 * attributes, see {@link IAttributes}
 * 
 * @author nehashukla
 *
 */
public class Collections implements ICollections {
	private ICollectionsService service;

	@Autowired
	public Collections(ICollectionsService service) {
		this.service = service;
	}

	/**
	 * Represents collections interface. With an optional query parameter of
	 * locationId, user can search for all the collections in the TruthTree
	 * Application. If user provides locationId, additionally, this api would filter
	 * out collections relevant to that location.
	 * 
	 * @param locationId
	 *            which represents unique identifier for a location.
	 * 
	 *
	 */
	@Override
	@RequestMapping(value = "/api/collections", method = RequestMethod.GET)
	public ResponseEntity<Object> getCollections(
			@RequestParam(name = "locationId", required = false) Integer locationId) {
		Object response = service.getCollections(locationId);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
