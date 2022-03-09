/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;


/**
 *
 * @author Molka
 */
public class Rating {
    
    int note,idc;

    public Rating() {
    }

    public Rating(int note, int idc) {
        this.note = note;
        this.idc = idc;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

 
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }


    
    
}
