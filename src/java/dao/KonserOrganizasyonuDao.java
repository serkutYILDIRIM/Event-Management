/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.KonserOrganizasyonu;
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
public class KonserOrganizasyonuDao {

    public KonserOrganizasyonu getKonserOrganizasyonu(int id) {
        KonserOrganizasyonu k = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from konserOrganizasyonu where id=" + id);

            while (rs.next()) {
                k = new KonserOrganizasyonu(rs.getInt("id"), rs.getString("konserAdi"), rs.getString("tarih"), rs.getString("saat"), rs.getString("gosterimYeri"), rs.getString("kiminKonseri"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return k;
    }

    public void createKonserOrganizasyonu(KonserOrganizasyonu k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into konserOrganizasyonu (konserAdi,tarih,saat,gosterimYeri,kiminKonseri) values ('" + k.getKonserAdi() + "', '" + k.getTarih() + "', '" + k.getSaat() + "', '" + k.getGosterimYeri() + "','" + k.getKiminKonseri() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateKonserOrganizasyonu(KonserOrganizasyonu k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update konserOrganizasyonu set konserAdi = '" + k.getKonserAdi() + "', tarih = '" + k.getTarih() + "',saat = '" + k.getSaat() + "', gosterimYeri = '" + k.getGosterimYeri() + "',kiminKonseri = '" + k.getKiminKonseri() + "' where id = " + k.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from konserOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<KonserOrganizasyonu> getKonserOrganizasyonuList() {
        ArrayList<KonserOrganizasyonu> kList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from konserOrganizasyonu");
            while (rs.next()) {
                kList.add(new KonserOrganizasyonu(rs.getInt("id"), rs.getString("konserAdi"), rs.getString("tarih"), rs.getString("saat"), rs.getString("gosterimYeri"), rs.getString("kiminKonseri")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return kList;
    }

}
