/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DugunOrganizasyonuDao;
import entities.DugunOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "dugunOrganizasyonu")
@SessionScoped
public class DugunOrganizasyonuController {

    private DugunOrganizasyonu dugunOrganizasyonu = null;
    private DugunOrganizasyonuDao dDao = null;
    private ArrayList<DugunOrganizasyonu> dList;

    public String getDetail(int id) {
        this.dugunOrganizasyonu = this.getdDao().getDugunOrganizasyonu(id);
        return "dugunListele";
    }

    public String newDugunOrganizasyonu() {
        this.dugunOrganizasyonu = null;
        return "newdugunorganizasyonuForm";
    }

    public String update(DugunOrganizasyonu d) {
        this.dugunOrganizasyonu = d;
        return "updateDugunOrganizasyonu";
    }

    public String updateDugunOrganizasyonu() {
        this.getdDao().updateDugunOrganizasyonu(this.dugunOrganizasyonu);
        return "dugun";
    }

    public String delete(int id) {
        this.getdDao().delete(id);
        return "dugun";
    }

    public String saveDugunOrganizasyonu() {
        this.getdDao().createDugunOrganizasyonu(this.dugunOrganizasyonu);
        return "dugun";
    }

    public DugunOrganizasyonu getDugunOrganizasyonu() {
        if (this.dugunOrganizasyonu == null) {
            this.dugunOrganizasyonu = new DugunOrganizasyonu();
        }

        return dugunOrganizasyonu;
    }

    public void setDugunOrganizasyonu(DugunOrganizasyonu dugunOrganizasyonu) {
        this.dugunOrganizasyonu = dugunOrganizasyonu;
    }

    public DugunOrganizasyonuDao getdDao() {
        if (this.dDao == null) {
            this.dDao = new DugunOrganizasyonuDao();
        }
        return dDao;
    }

    public void setdDao(DugunOrganizasyonuDao dDao) {
        this.dDao = dDao;
    }

    public ArrayList<DugunOrganizasyonu> getdList() {
        this.dList = this.getdDao().getDugunOrganizasyonuList();
        return dList;
    }

    public void setdList(ArrayList<DugunOrganizasyonu> dList) {
        this.dList = dList;
    }

}
