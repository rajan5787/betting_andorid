package rajan5787.tikuraja.bettingapp;

/**
 * Created by rajanpipaliya on 08/03/19.
 */

public class hourse_model {
    private String hourse_name;
    private String hourse_id;
    private String hourse_fitness_level;
    private String hourse_breed;

    public hourse_model() {
    }

    public hourse_model(String hourse_id, String hourse_name, String hourse_fitness_level,String hourse_breed) {
        this.hourse_id = hourse_id;
        this.hourse_name = hourse_name;
        this.hourse_fitness_level = hourse_fitness_level;
        this.hourse_breed = hourse_breed;

    }

    public String getHourse_name() {
        return hourse_name;
    }

    public void setHourse_name(String hourse_name) {
        this.hourse_name = hourse_name;
    }

    public String getHourse_id() {
        return hourse_id;
    }

    public void setHourse_id(String hourse_id) {
        this.hourse_id = hourse_id;
    }

    public String getHourse_fitness_level() {
        return hourse_fitness_level;
    }

    public void setHourse_fitness_level(String hourse_fitness_level) {
        this.hourse_fitness_level = hourse_fitness_level;
    }

    public String getHourse_breed() {
        return hourse_breed;
    }

    public void setHourse_breed(String hourse_breed) {
        this.hourse_breed = hourse_breed;
    }
}