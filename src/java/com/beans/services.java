/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;


public class services {
    private int id,service_type_id;
    private String service_desc,service_cost,advance_cost,short_service_desc,vendor_id;

    public services() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_desc() {
        return service_desc;
    }

    public void setService_desc(String service_desc) {
        this.service_desc = service_desc;
    }

    public String getService_cost() {
        return service_cost;
    }

    public void setService_cost(String service_cost) {
        this.service_cost = service_cost;
    }

    public String getAdvance_cost() {
        return advance_cost;
    }

    public void setAdvance_cost(String advance_cost) {
        this.advance_cost = advance_cost;
    }

    public String getShort_service_desc() {
        return short_service_desc;
    }

    public void setShort_service_desc(String short_service_desc) {
        this.short_service_desc = short_service_desc;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }
    
}
