/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.mongospike.mongohibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author munif
 */
@Entity
public class Breed {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;

    @Override
    public String toString() {
        return "Breed{" + "id=" + id + ", name=" + name + '}';
    }

}
