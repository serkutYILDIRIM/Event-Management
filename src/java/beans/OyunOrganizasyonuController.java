/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.OyunOrganizasyonuDao;
import entities.OyunOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "oyunOrganizasyonu")
@SessionScoped
public class OyunOrganizasyonuController {

    private OyunOrganizasyonu oyunOrganizasyonu = null;
    private OyunOrganizasyonuDao oDao = null;
    private ArrayList<OyunOrganizasyonu> oList;

    public String getDetail(int id) {
        this.oyunOrganizasyonu = this.getoDao().getOyunOrganizasyonu(id);
        return "oyunListele";
    }

    public String newOyunOrganizasyonu() {
        this.oyunOrganizasyonu = null;
        return "newoyunorganizasyonuForm";
    }


    public String update(OyunOrganizasyonu o) {
        this.oyunOrganizasyonu = o;
        return "updateOyunOrganizasyonu";
    }

    public String updateOyunOrganizasyonu() {
        this.getoDao().updateOyunOrganizasyonu(this.oyunOrganizasyonu);
        return "oyun";
    }

    public String delete(int id) {
        this.getoDao().delete(id);
        return "oyun";
    }

    public String saveOyunOrganizasyonu() {
        this.getoDao().createOyunOrganizasyonu(this.oyunOrganizasyonu);
        return "oyun";
    }

    public OyunOrganizasyonu getOyunOrganizasyonu() {
        if (this.oyunOrganizasyonu == null) {
            this.oyunOrganizasyonu = new OyunOrganizasyonu();
        }

        return oyunOrganizasyonu;
    }

    public void setOyunOrganizasyonu(OyunOrganizasyonu oyunOrganizasyonu) {
        this.oyunOrganizasyonu = oyunOrganizasyonu;
    }

    public OyunOrganizasyonuDao getoDao() {
        if (this.oDao == null) {
            this.oDao = new OyunOrganizasyonuDao();
        }
        return oDao;
    }

    public void setoDao(OyunOrganizasyonuDao oDao) {
        this.oDao = oDao;
    }

    public ArrayList<OyunOrganizasyonu> getoList() {
        this.oList = this.getoDao().getOyunOrganizasyonuList();
        return oList;
    }

    public void setoList(ArrayList<OyunOrganizasyonu> oList) {
        this.oList = oList;
    }

}
