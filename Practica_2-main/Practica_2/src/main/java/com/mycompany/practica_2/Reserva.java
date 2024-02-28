/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_2;

/**
 *
 * @author Ignacio
 */
public class Reserva {
    //Atributos
    private String cedula;
    private String fechaComida;
    private String tipoComida;
    private String guarnicion1;
    private String guarnicion2;
    private String proteina;
    private String ensalada;

    //Constructor
    public Reserva(String cedula, String fechaComida, String tipoComida, String guarnicion1, String guarnicion2, String proteina, String ensalada) {
        this.cedula = cedula;
        this.fechaComida = fechaComida;
        this.tipoComida = tipoComida;
        this.guarnicion1 = guarnicion1;
        this.guarnicion2 = guarnicion2;
        this.proteina = proteina;
        this.ensalada = ensalada;
    }

    //Setters y getters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaComida() {
        return fechaComida;
    }

    public void setFechaComida(String fechaComida) {
        this.fechaComida = fechaComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getGuarnicion1() {
        return guarnicion1;
    }

    public void setGuarnicion1(String guarnicion1) {
        this.guarnicion1 = guarnicion1;
    }

    public String getGuarnicion2() {
        return guarnicion2;
    }

    public void setGuarnicion2(String guarnicion2) {
        this.guarnicion2 = guarnicion2;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public String getEnsalada() {
        return ensalada;
    }

    public void setEnsalada(String ensalada) {
        this.ensalada = ensalada;
    }

    @Override
    public String toString() {
        return "Fecha de comida: " + fechaComida + "\n" +
               "Tipo de comida: " + tipoComida + "\n" +
               "Guarnicion 1: " + guarnicion1 + "\n" +
               "Guarnicion 2: " + guarnicion2 + "\n" +
               "Proteína: " + proteina + "\n" +
               "Ensalada: " + ensalada;
    }
}