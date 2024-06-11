package Controller;

import javax.swing.JOptionPane;

import Model.Login_Admin;
import Model.Login_Employee;
import Model.Login_Manager;
import View.Dashboard_JFrm;

public class Login_REG_ctrl {

	public Login_REG_ctrl(String un, String ps, String rol) {
		// Employee
		if (rol.equals("Employee")) {
			Login_Employee.employee_data_chek(un, ps, rol);
			Login_Employee.employee_data_chek(un, ps, rol);
		}

		// MAnager
		if (rol.equals("Manager")) {
			Login_Manager loginManager = new Login_Manager();
			loginManager.prepare_Manager_data(un, ps, rol);
			loginManager.manager_data_insert();

		}

		// Admin
		if (rol.equals("Admin")) {
			Login_Admin Login_m = new Login_Admin();
			Login_m.prepare_admin_data(un, ps, rol);
			Login_m.admin_data_insert();
			//

		}

	}

}
