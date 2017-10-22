package com.ooad.dao;

import java.util.ArrayList;

import com.ooad.beans.BabySitter;

public interface ParentsFunctionalityDAO {
	public ArrayList<BabySitter> getListofBabySitters();
	public ArrayList<BabySitter> getSitterInformation();
}
