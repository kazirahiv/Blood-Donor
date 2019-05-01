package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.*;
import entities.*;
import interfaces.*;
import bindmodels.*;

public class DonorRepo {
	private Donor donorList[];

	public DonorRepo(int SIZE) {
		donorList = new Donor[SIZE];
	}

	public void loadDonors(String sql) {
		try {
			DataAccess da = new DataAccess("root", "abc-1234", "BloodDonor");
			ResultSet rs = da.getData(sql);
			Donor donor = null;
			String name, addressArea, phoneNumber, email, password, bloodGroup;
			int id, isDonor;
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("Name");
				addressArea = rs.getString("AddressArea");
				phoneNumber = rs.getString("PhoneNumber");
				email = rs.getString("Email");
				isDonor = rs.getInt("IsDonor");
				password = rs.getString("Password");
				bloodGroup = rs.getString("BloodGroup");
				donor = new Donor(id, name, addressArea, phoneNumber, email, password, bloodGroup);
				addDonor(donor);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public BindDonor checkDonorAuth(String email, String password) {
		BindDonor donor = new BindDonor();
		donor.authenticated = false;
		donor.donor = null;
		for (Donor d : donorList) {
			if (d != null) {
				if (d.getEmail().equals(email) && d.getPassword().equals(password)) {
					donor.donor = d;
					donor.authenticated = true;
				}
			}
		}
		return donor;
	}


	public Donor[] ReturnDonors()
	{
		return this.donorList;
	}

	public void ClearDonor()
	{
		donorList = null;
		donorList = new Donor[20];	
	}

	public void RefreshDonor()
	{
		donorList = null;
		donorList = new Donor[20];	
		loadDonors("SELECT * FROM BloodDonor.User;");
	}

	public void addDonor(Donor d) {
		for (int i = 0; i < donorList.length; i++) {
			if (donorList[i] == null) {
				donorList[i] = d;
				break;
			}
		}
	}

	public void printDonors() {
		for (Donor d : donorList) {
			if (d != null) {
				d.print();
			}
		}
	}

}
