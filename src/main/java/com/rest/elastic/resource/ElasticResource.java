package com.rest.elastic.resource;

import com.rest.elastic.domain.Elastic;
import com.rest.elastic.repository.ElasticRepository;
import org.elasticsearch.ElasticsearchException;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ElasticResource {

    ElasticRepository elasticRepository;

    public ElasticResource(ElasticRepository elasticRepository) {
        this.elasticRepository = elasticRepository;
    }

    @RequestMapping("/all")
    List<Elastic> getAllData() {
        return getAll();
    }

    @RequestMapping("saveIndex")
    List<Elastic> save(@Valid @RequestBody Elastic elastic) throws Exception {
        try {
            elasticRepository.save(elastic);
            return getAll();
        } catch(Exception ex) {
            return getAll();
        }
    }

    public List<Elastic> getAll() {
        Page<Elastic> elastic = (Page<Elastic>) elasticRepository.findAll();
        List<Elastic> elasticsVM = elastic.getContent();
        return elasticsVM.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
