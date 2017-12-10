package com.rest.elastic.repository;

import com.rest.elastic.domain.Elastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ElasticRepository extends ElasticsearchCrudRepository<Elastic, Long> {
}
