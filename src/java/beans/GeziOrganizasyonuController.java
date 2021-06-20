/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.GeziOrganizasyonuDao;
import entities.GeziOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "geziOrganizasyonu")
@SessionScoped
public class GeziOrganizasyonuController {

    private GeziOrganizasyonu geziOrganizasyonu = null;
    private GeziOrganizasyonuDao gDao = null;
    private ArrayList<GeziOrganizasyonu> gList;

    public String getDetail(int id) {
        this.geziOrganizasyonu = this.getgDao().getGeziOrganizasyonu(id);
        return "geziListele";
    }

    public String newGeziOrganizasyonu() {
        this.geziOrganizasyonu = null;
        return "newgeziorganizasyonuForm";
    }

    public String update(GeziOrganizasyonu g) {
        this.geziOrganizasyonu = g;
        return "updateGeziOrganizasyonu";
    }

    public String updateGeziOrganizasyonu() {
        this.getgDao().updateGeziOrganizasyonu(this.geziOrganizasyonu);
        return "gezi";
    }

    public String delete(int id) {
        this.getgDao().delete(id);
        return "gezi";
    }

    public String saveGeziOrganizasyonu() {
        this.getgDao().createGeziOrganizasyonu(this.geziOrganizasyonu);
        return "gezi";
    }

    public GeziOrganizasyonu getGeziOrganizasyonu() {
        if (this.geziOrganizasyonu == null) {
            this.geziOrganizasyonu = new GeziOrganizasyonu();
        }

        return geziOrganizasyonu;
    }

    public void setGeziOrganizasyonu(GeziOrganizasyonu geziOrganizasyonu) {
        this.geziOrganizasyonu = geziOrganizasyonu;
    }

    public GeziOrganizasyonuDao getgDao() {
        if (this.gDao == null) {
            this.gDao = new GeziOrganizasyonuDao();
        }
        return gDao;
    }

    public void setgDao(GeziOrganizasyonuDao gDao) {
        this.gDao = gDao;
    }

    public ArrayList<GeziOrganizasyonu> getgList() {
        this.gList = this.getgDao().getGeziOrganizasyonuList();
        return gList;
    }

    public void setgList(ArrayList<GeziOrganizasyonu> gList) {
        this.gList = gList;
    }

}
