/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fer
 */
@ManagedBean
@ViewScoped
public class Calculadora implements Serializable {

    private double monto;
    private double prima;
    private int mensualidad;
    private double tasa;
    private double recargoServicio;
    private double montoPrestar;
    private double cuotaMensual;

    public double getMontoPrestar() {
        return montoPrestar;
    }

    public void setMontoPrestar(double montoPrestar) {
        this.montoPrestar = montoPrestar;
    }
    
    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }
    
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getRecargoServicio() {
        return recargoServicio;
    }

    public void setRecargoServicio(double recargoServicio) {
        this.recargoServicio = recargoServicio;
    }

    public Calculadora() {
    }

    public void doCalcularMensualidad() {
       calcularMensualidad();
            
    }

    private void calcularMensualidad() {
        double o1, o2, a1, a2, ay;
        
        o1 = 1+tasa;
        a1 = (Math.pow(o1, mensualidad))*tasa;
        
        o2 = 1+tasa;
        a2 = (Math.pow(o2, mensualidad))-1;
       
       montoPrestar = monto - (prima - 10);
        
        ay = recargoServicio + (montoPrestar * (a1 / a2));
        DecimalFormat formato = new DecimalFormat("#####.##");
        cuotaMensual = Double.parseDouble(formato.format(ay));
        
    }
    
    
    public void docalcularMontoPrestar(){
        calcularMontoPrestar();
    }
    
    private void calcularMontoPrestar() {
        montoPrestar = monto - (prima -10);
        
       
        
    }
}
   