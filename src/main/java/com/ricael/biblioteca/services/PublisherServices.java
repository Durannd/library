package com.ricael.biblioteca.services;

import com.ricael.biblioteca.model.Publisher;
import com.ricael.biblioteca.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServices {

    @Autowired
    private PublisherRepository publisherRepository;

    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }
    public void savePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
    public Publisher getPublisher(Long id){
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No publisher found for id: " + id));
    }
    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    public List<Publisher> getAllPublisherByNameLike(String name){
        return publisherRepository.findByNameLike("%" + name + "%").orElseThrow(() -> new RuntimeException("No publisher found for name like: " + name));
    }

}
