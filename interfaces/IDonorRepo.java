package interfaces;

import java.lang.*;
import entities.*;

public interface IDonorRepo
{
	void insertUser(Donor d);
	void updateUser(Donor d);
	void deleteUser(String userId);
}