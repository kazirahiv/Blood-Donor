package interfaces;

import java.lang.*;
import entity.*;

public interface IDonorRepo
{
	User getUser(String userId, String password);
	void insertUser(Donor d);
	void updateUser(Donor d);
	void deleteUser(String userId);
}