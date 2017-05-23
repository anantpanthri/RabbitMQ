package com.example.RabbitMQ;

import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<CustomMessage,Integer>{
	CustomMessage findById(int id);
}
