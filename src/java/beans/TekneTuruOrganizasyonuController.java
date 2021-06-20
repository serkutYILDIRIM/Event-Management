/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.TekneTuruOrganizasyonuDao;
import entities.TekneTuruOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "tekneTuruOrganizasyonu")
@SessionScoped
public class TekneTuruOrganizasyonuController {

    private TekneTuruOrganizasyonu tekneTuruOrganizasyonu = null;
    private TekneTuruOrganizasyonuDao tDao = null;
    private ArrayList<TekneTuruOrganizasyonu> tList;

    public String getDetail(int id) {
        this.tekneTuruOrganizasyonu = this.gettDao().getTekneTuruOrganizasyonu(id);
        return "tekneTuruListele";
    }

    public String newTekneTuruOrganizasyonu() {
        this.tekneTuruOrganizasyonu = null;
        return "newtekneTuruorganizasyonuForm";
    }


    public String update(TekneTuruOrganizasyonu t) {
        this.tekneTuruOrganizasyonu = t;
        return "updateTekneTuruOrganizasyonu";
    }

    public String updateTekneTuruOrganizasyonu() {
        this.gettDao().updateTekneTuruOrganizasyonu(this.tekneTuruOrganizasyonu);
        return "tekneTuru";
    }

    public String delete(int id) {
        this.gettDao().delete(id);
        return "tekneTuru";
    }

    public String saveTekneTuruOrganizasyonu() {
        this.gettDao().createTekneTuruOrganizasyonu(this.tekneTuruOrganizasyonu);
        return "tekneTuru";
    }

    public TekneTuruOrganizasyonu getTekneTuruOrganizasyonu() {
        if (this.tekneTuruOrganizasyonu == null) {
            this.tekneTuruOrganizasyonu = new TekneTuruOrganizasyonu();
        }

        return tekneTuruOrganizasyonu;
    }

    public void setTekneTuruOrganizasyonu(TekneTuruOrganizasyonu tekneTuruOrganizasyonu) {
        this.tekneTuruOrganizasyonu = tekneTuruOrganizasyonu;
    }

    public TekneTuruOrganizasyonuDao gettDao() {
        if (this.tDao == null) {
            this.tDao = new TekneTuruOrganizasyonuDao();
        }
        return tDao;
    }

    public void settDao(TekneTuruOrganizasyonuDao tDao) {
        this.tDao = tDao;
    }

    public ArrayList<TekneTuruOrganizasyonu> gettList() {
        this.tList = this.gettDao().getTekneTuruOrganizasyonuList();
        return tList;
    }

    public void settList(ArrayList<TekneTuruOrganizasyonu> tList) {
        this.tList = tList;
    }

}
