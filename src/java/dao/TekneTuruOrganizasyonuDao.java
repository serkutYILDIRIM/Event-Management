/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TekneTuruOrganizasyonu;
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
public class TekneTuruOrganizasyonuDao {

    public TekneTuruOrganizasyonu getTekneTuruOrganizasyonu(int id) {
        TekneTuruOrganizasyonu t = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tekneTuruOrganizasyonu where id=" + id);

            while (rs.next()) {
                t = new TekneTuruOrganizasyonu(rs.getInt("id"), rs.getString("hareketYeri"), rs.getString("bitisNoktasi"), rs.getString("turCesidi"), rs.getString("yemek"), rs.getString("fiyat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return t;
    }

    public void createTekneTuruOrganizasyonu(TekneTuruOrganizasyonu t) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into tekneTuruOrganizasyonu (hareketYeri,bitisNoktasi,turCesidi,yemek,fiyat) values ('" + t.getHareketYeri() + "', '" + t.getBitisNoktasi() + "', '" + t.getTurCesidi() + "', '" + t.getYemek() + "','" + t.getFiyat() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateTekneTuruOrganizasyonu(TekneTuruOrganizasyonu t) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update tekneTuruOrganizasyonu set hareketYeri = '" + t.getHareketYeri() + "', bitisNoktasi = '" + t.getBitisNoktasi() + "',turCesidi = '" + t.getTurCesidi() + "', yemek = '" + t.getYemek() + "',fiyat = '" + t.getFiyat() + "' where id = " + t.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from tekneTuruOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<TekneTuruOrganizasyonu> getTekneTuruOrganizasyonuList() {
        ArrayList<TekneTuruOrganizasyonu> tList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tekneTuruOrganizasyonu");
            while (rs.next()) {
                tList.add(new TekneTuruOrganizasyonu(rs.getInt("id"), rs.getString("hareketYeri"), rs.getString("bitisNoktasi"), rs.getString("turCesidi"), rs.getString("yemek"), rs.getString("fiyat")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return tList;
    }

}
