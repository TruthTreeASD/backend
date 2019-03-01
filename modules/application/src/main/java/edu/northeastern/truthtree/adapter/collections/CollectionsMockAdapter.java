package edu.northeastern.truthtree.adapter.collections;

import static edu.northeastern.truthtree.AppConst.COLLECTIONS_FILE_PATH;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

public class CollectionsMockAdapter implements ICollectionsAdapter {


  @Override
  public Object getCollections() {
    return JSONUtil.readJSONFile(COLLECTIONS_FILE_PATH);
  }

  @Override
  public Object getCollectionsByLocationId(Integer locationId) {
    // TODO Auto-generated method stub
    return null;
  }

}
