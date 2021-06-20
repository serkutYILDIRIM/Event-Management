package beans;

import java.io.Serializable;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Simple login bean.
 *
 * @author itcuties
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 7765876811740798583L;

    // Simple user database :)

    private String username;
    private String password;
    //Database verilerine ilk değer atanmazsa boş çalıştırıldığında direk giriş yapıyor o yüzden uzun anlamsız String kullandım.
    private String dbuserName="************sdfsdf***fsdfsdfsdfdsfsf*****+^%&/(/%&%++^%+&//&%&*******+%+^%+^%+^%+^&^+%****";
    private String dbnameSurname="*********fsf****werdfsdfs*******+^%&/ÇLSDDÖWEIMWEF(/%&%++^%+&//&%&*******+%+^%+^%+^%+^&^+%***";
    private String dbpassword="***********+sfdsdf^%&sdfsdf(wfwerwer/%&%++^%+&//&%&*******+%+^%+^%+^%+^&^+%****";
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    private boolean loggedIn;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    /**
     * Login operation.
     *
     * @return
     */
        public void dbData(String username) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=organizasyon;user=sa;password=serkut");
            statement = connection.createStatement();
            SQL = "Select * from users where username like ('" + username + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbnameSurname = resultSet.getString("name_surname");
            dbuserName = resultSet.getString("username");
            dbpassword = resultSet.getString("password");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
    public String doLogin() {
        // Get every user from our sample database :)
        dbData(username);
    

            // Successful login
            if (dbuserName.equalsIgnoreCase(username) && dbpassword.equals(password)) {
                setNamesurname(dbnameSurname);
                loggedIn = true;
                return navigationBean.redirectToWelcome();
            }else {
            // Set login ERROR
            FacesMessage msg = new FacesMessage("Başarısız giriş!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            // To to login page
            return navigationBean.toLogin();

        }

    }

    /**
     * Logout operation.
     *
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;

        // Set logout message
        FacesMessage msg = new FacesMessage("Çıkış başarılı!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return navigationBean.toLogin();
    }

    // ------------------------------
    // Getters & Setters 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getDbuserName() {
        return dbuserName;
    }

    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public void setNamesurname(String dbnameSurname) {
        this.dbnameSurname = dbnameSurname;
    }

    public String getdbnameSurname() {
        return dbnameSurname;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

}
