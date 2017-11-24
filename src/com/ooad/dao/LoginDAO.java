package com.ooad.dao;

import java.text.ParseException;

import com.ooad.beans.BabySitter;
import com.ooad.beans.Login;
import com.ooad.beans.Parent;

public interface LoginDAO {
	public void addParent(Parent parent) throws ParseException;
	public void addBabySitter(BabySitter babySitter) throws ParseException;
	public Login isExistingParent(Parent parent);
	public Login isExistingSitter(BabySitter sitter);
}
