/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.FilmOrganizasyonuDao;
import entities.FilmOrganizasyonu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serkut
 */
@ManagedBean(name = "filmOrganizasyonu")
@SessionScoped
public class FilmOrganizasyonuController {

    private FilmOrganizasyonu filmOrganizasyonu = null;
    private FilmOrganizasyonuDao fDao = null;
    private ArrayList<FilmOrganizasyonu> fList;

    public String getDetail(int id) {
        this.filmOrganizasyonu = this.getfDao().getFilmOrganizasyonu(id);
        return "filmListele";
    }

    public String newFilmOrganizasyonu() {
        this.filmOrganizasyonu = null;
        return "newfilmorganizasyonuForm";
    }

    public String update(FilmOrganizasyonu f) {
        this.filmOrganizasyonu = f;
        return "updateFilmOrganizasyonu";
    }

    public String updateFilmOrganizasyonu() {
        this.getfDao().updateFilmOrganizasyonu(this.filmOrganizasyonu);
        return "film";
    }

    public String delete(int id) {
        this.getfDao().delete(id);
        return "film";
    }

    public String saveFilmOrganizasyonu() {
        this.getfDao().createFilmOrganizasyonu(this.filmOrganizasyonu);
        return "film";
    }

    public FilmOrganizasyonu getFilmOrganizasyonu() {
        if (this.filmOrganizasyonu == null) {
            this.filmOrganizasyonu = new FilmOrganizasyonu();
        }

        return filmOrganizasyonu;
    }

    public void setFilmOrganizasyonu(FilmOrganizasyonu filmOrganizasyonu) {
        this.filmOrganizasyonu = filmOrganizasyonu;
    }

    public FilmOrganizasyonuDao getfDao() {
        if (this.fDao == null) {
            this.fDao = new FilmOrganizasyonuDao();
        }
        return fDao;
    }

    public void setfDao(FilmOrganizasyonuDao fDao) {
        this.fDao = fDao;
    }

    public ArrayList<FilmOrganizasyonu> getfList() {
        this.fList = this.getfDao().getFilmOrganizasyonuList();
        return fList;
    }

    public void setfList(ArrayList<FilmOrganizasyonu> fList) {
        this.fList = fList;
    }

}
