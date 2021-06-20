/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.FilmOrganizasyonu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ConnectionManager;

/**
 *
 * @author Serkut
 */
public class FilmOrganizasyonuDao {

    public FilmOrganizasyonu getFilmOrganizasyonu(int id) {
        FilmOrganizasyonu f = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmOrganizasyonu where id=" + id);

            while (rs.next()) {
                f = new FilmOrganizasyonu(rs.getInt("id"), rs.getString("filmAdi"), rs.getString("tarih"), rs.getString("saat"),rs.getString("gosterimYeri"),rs.getString("yonetmen"),rs.getString("basrolOyunculari"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return f;
    }

    public void createFilmOrganizasyonu(FilmOrganizasyonu f) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into filmOrganizasyonu (filmAdi,tarih,saat,gosterimYeri,yonetmen,basrolOyunculari) values ('" + f.getFilmAdi() + "', '" + f.getTarih() + "', '" + f.getSaat() + "', '" + f.getGosterimYeri() + "', '" + f.getYonetmen() + "', '" + f.getBasrolOyunculari() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateFilmOrganizasyonu(FilmOrganizasyonu f) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update filmOrganizasyonu set filmAdi = '" + f.getFilmAdi() + "', tarih = '" + f.getTarih() + "',saat = '" + f.getSaat() + "', gosterimYeri = '" + f.getGosterimYeri() + "', yonetmen = '" + f.getYonetmen() + "', basrolOyunculari = '" + f.getBasrolOyunculari() + "' where id = " + f.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from filmOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<FilmOrganizasyonu> getFilmOrganizasyonuList() {
        ArrayList<FilmOrganizasyonu> fList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmOrganizasyonu");
            while (rs.next()) {
                fList.add(new FilmOrganizasyonu(rs.getInt("id"), rs.getString("filmAdi"), rs.getString("tarih"), rs.getString("saat"), rs.getString("gosterimYeri"), rs.getString("yonetmen"), rs.getString("basrolOyunculari")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return fList;
    }

}
