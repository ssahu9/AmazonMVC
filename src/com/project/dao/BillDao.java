package com.project.dao;

import java.sql.SQLException;
import java.util.List;
import com.project.bean.Bill;
import com.project.bean.BillDetails;

public interface BillDao {
	
	//generateBill function linked to BillDaoImpl
	Bill generateBill(int customerId) throws ClassNotFoundException, SQLException;

	//getBillDetails function linked to BillDaoImpl
	List<BillDetails> getBillDetails(int customerId) throws ClassNotFoundException, SQLException;

	//getAllBillDetails function linked to BillDaoImpl
	List<BillDetails> getAllBillDetails() throws ClassNotFoundException, SQLException;

	//getCurrentBill function linked to BillDaoImpl
	List<BillDetails> getCurrentBill(Bill bill) throws ClassNotFoundException, SQLException;
}
