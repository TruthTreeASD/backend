package edu.northeastern.truthtree.service.collections;

/**
 * Represents collections service class responsible for implementing business
 * logic. It connects controller and adapter by taking input from the controller
 * passing it to the adapter and returning response back to the controller.
 * 
 * @param locationId
 *            in integer representing unique identifier for the location.
 * 
 * @author nehashukla
 *
 */
public interface ICollectionsService {
	public Object getCollections(Integer locationId);
}
