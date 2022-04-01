package com.date;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date udate = new java.util.Date();
		System.out.println("Util date: " + udate);
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		System.out.println("Sql date: " + sdate);
		

	}

}
