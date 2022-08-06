package com.example.Ejerciciossesiones789.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Double price;
    private Integer memoriaRAMenGB;
    private String procesador;

    //constructores
    public Laptop() {
    }
    public Laptop(Long id, String marca, String modelo, Double price, Integer memoriaRAMenGB, String procesador) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.price = price;
        this.memoriaRAMenGB = memoriaRAMenGB;
        this.procesador = procesador;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMemoriaRAMenGB() {
        return memoriaRAMenGB;
    }

    public void setMemoriaRAMenGB(Integer memoriaRAMenGB) {
        this.memoriaRAMenGB = memoriaRAMenGB;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }


    //tostring
    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", price=" + price +
                ", memoriaRAMenGB=" + memoriaRAMenGB +
                ", procesador='" + procesador + '\'' +
                '}';
    }
}
