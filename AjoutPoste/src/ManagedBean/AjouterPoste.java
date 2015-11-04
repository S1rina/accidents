package ManagedBean;

import java.io.Serializable;

import DAO.*;

import java.sql.*;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

public class AjouterPoste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Poste p = new Poste() ;
	Service c = new Service() ;
	Statement stm ;
	
	public void insert()
	{  System.out.println("hello") ;
	 int x = 0 ;
		try {
			stm = c.connect() ;
			String req="insert into poste (ville,cite,province,nbreEmp,presPoste,date) values ('"+p.getVille()+"','"+p.getCite()+"','"+p.getProvince()+"',"+p.getNbremp()+",'"+p.getPrespos()+"',"+p.getDate()+")" ;
			x=stm.executeUpdate(req) ;
			System.out.println("execution du requete") ;
			if (x != 0)
			{
				FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO,"ajout","Ajout Effectué");
				RequestContext.getCurrentInstance().showMessageInDialog(msg);
				 
				
			}else{
				FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_WARN,"ajout","Ajout Echoué");
				RequestContext.getCurrentInstance().showMessageInDialog(msg); }
			p.setVille("");
			p.setCite("");
		}catch (Exception e)
		{
			e.getStackTrace() ;
		}
	}

	public Poste getP() {
		return p;
	}

	public void setP(Poste p) {
		this.p = p;
	}

	
}
