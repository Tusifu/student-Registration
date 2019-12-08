/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDao;
import dao.chartDataDao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Edison
 */
@ManagedBean (name ="chart")
public class chartsController {
    private PieChartModel pie;
    private PieChartModel pie1;
    private double AllStudents=new StudentDao().approved().size();
    private double male=new chartDataDao().boys().size();
    private double female=new chartDataDao().girls().size();
    private double dayStudents=new chartDataDao().dayStudent().size();
    private double eveningStudents=new chartDataDao().eveningStudent().size();
    private double inService=new chartDataDao().inService().size();
    

    public chartsController() {
        allStudent();
    }

    public PieChartModel getPie1() {
        return pie1;
    }

    public void setPie1(PieChartModel pie1) {
        this.pie1 = pie1;
    }
    
    
 
    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }
    
    
    @PostConstruct
    public void init(){
        Genderpie();
        Programpie();
        
    }
  
    public void Genderpie(){
        pie=new PieChartModel();
        pie.set("Male", Math.round((male / AllStudents)*100));
        pie.set("Female", Math.round((female / AllStudents)*100));
        
        pie.setLegendPosition("w");
    }
      public void Programpie(){
        pie1=new PieChartModel();
        pie1.set("day", Math.round((dayStudents / AllStudents)*100));
        pie1.set("evening", Math.round((eveningStudents / AllStudents)*100));
        pie1.set("inService", Math.round((inService / AllStudents)*100));
        
        pie1.setLegendPosition("w");
    }

    public final int allStudent(){
        return (int) AllStudents;
    }
    
}
