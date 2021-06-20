/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.KonserOrganizasyonuDao;
import entities.KonserOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "konserOrganizasyonu")
@SessionScoped
public class KonserOrganizasyonuController {

    private KonserOrganizasyonu konserOrganizasyonu = null;
    private KonserOrganizasyonuDao kDao = null;
    private ArrayList<KonserOrganizasyonu> kList;

    public String getDetail(int id) {
        this.konserOrganizasyonu = this.getkDao().getKonserOrganizasyonu(id);
        return "konserListele";
    }

    public String newKonserOrganizasyonu() {
        this.konserOrganizasyonu = null;
        return "newkonserorganizasyonuForm";
    }


    public String update(KonserOrganizasyonu k) {
        this.konserOrganizasyonu = k;
        return "updateKonserOrganizasyonu";
    }

    public String updateKonserOrganizasyonu() {
        this.getkDao().updateKonserOrganizasyonu(this.konserOrganizasyonu);
        return "konser";
    }

    public String delete(int id) {
        this.getkDao().delete(id);
        return "konser";
    }

    public String saveKonserOrganizasyonu() {
        this.getkDao().createKonserOrganizasyonu(this.konserOrganizasyonu);
        return "konser";
    }

    public KonserOrganizasyonu getKonserOrganizasyonu() {
        if (this.konserOrganizasyonu == null) {
            this.konserOrganizasyonu = new KonserOrganizasyonu();
        }

        return konserOrganizasyonu;
    }

    public void setKonserOrganizasyonu(KonserOrganizasyonu konserOrganizasyonu) {
        this.konserOrganizasyonu = konserOrganizasyonu;
    }

    public KonserOrganizasyonuDao getkDao() {
        if (this.kDao == null) {
            this.kDao = new KonserOrganizasyonuDao();
        }
        return kDao;
    }

    public void setkDao(KonserOrganizasyonuDao kDao) {
        this.kDao = kDao;
    }

    public ArrayList<KonserOrganizasyonu> getkList() {
        this.kList = this.getkDao().getKonserOrganizasyonuList();
        return kList;
    }

    public void setkList(ArrayList<KonserOrganizasyonu> kList) {
        this.kList = kList;
    }

}
