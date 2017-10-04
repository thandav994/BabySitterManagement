package com.ooad.dao;

import java.text.ParseException;

import com.ooad.beans.Login;
import com.ooad.beans.User;

public interface LoginDAO {
	public void addUser(User user) throws ParseException;
	public boolean isExistingUser(Login login);
}
