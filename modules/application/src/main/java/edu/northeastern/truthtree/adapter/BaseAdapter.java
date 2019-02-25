package edu.northeastern.truthtree.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by steven on 2019/2/23.
 */
@Component
public abstract class BaseAdapter {
  @Autowired
  protected RestTemplate restTemplate;
}