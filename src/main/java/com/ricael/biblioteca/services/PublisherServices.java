package com.ricael.biblioteca.services;

import com.ricael.biblioteca.controller.request.PublisherRequest;
import com.ricael.biblioteca.controller.response.PublisherResponse;
import com.ricael.biblioteca.mappers.PublisherMapper;
import com.ricael.biblioteca.model.Publisher;
import com.ricael.biblioteca.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServices {

    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public void deletePublisher(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new RuntimeException("No publisher found for id: " + id);
        } else {
            publisherRepository.deleteById(id);
        }
    }

    @Transactional
    public PublisherResponse savePublisher(PublisherRequest publisher) {
        return PublisherMapper.toResponse(publisherRepository.save(PublisherMapper.toEntity(publisher)));
    }

    public PublisherResponse getPublisher(Long id) {
        return PublisherMapper.toResponse(publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No publisher found for id: " + id)));
    }

    public List<PublisherResponse> getAllPublisher() {
        return publisherRepository.findAll()
                .stream()
                .map(PublisherMapper::toResponse)
                .toList();
    }

    public List<PublisherResponse> getAllPublisherByNameLike(String name) {
        return publisherRepository
                .findByNameLike("%" + name + "%").orElseThrow(() -> new RuntimeException("No publisher found for name like: " + name))
                .stream()
                .map(PublisherMapper::toResponse)
                .toList();
    }

}
