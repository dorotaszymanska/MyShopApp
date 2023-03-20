package com.app1.demo.shop.sklepinternetowy.repository;


import com.app1.demo.shop.sklepinternetowy.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<User, String> {


}
