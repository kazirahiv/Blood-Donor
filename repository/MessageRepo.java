package repository;
import bindmodels.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRepo {
	private Message messageList[];

	public MessageRepo(int SIZE) {
		messageList = new Message[SIZE];
	}

	public void loadMessages(String sql) {
		try {
			DataAccess da = new DataAccess("root", "abc-1234", "BloodDonor");
			ResultSet rs = da.getData(sql);
			Message message = null;
			String messageText, senderName;
			int id, userId;
			while (rs.next()) {
				id = rs.getInt("id");
                userId = rs.getInt("userId");
								messageText = rs.getString("Message");
								senderName = rs.getString("SenderName");
				message = new Message(id, userId, messageText,senderName);
				addMessage(message);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public int GetMessageCount(int id)
	{
		ClearMessage();
		String sql = "SELECT * FROM BloodDonor.Message where userId="+id+";";
		loadMessages(sql);
		return CountMessages();
	}

	public void ClearMessage()
	{
		messageList = null;
		messageList = new Message[20];	
	}
	public Message[] GetMessages()
	{
		return this.messageList;
	}

    public void addMessage(Message m) {
		for (int i = 0; i < messageList.length; i++) {
			if (messageList[i] == null) {
				messageList[i] = m;
				break;
			}
		}
    }
    
	public void printDonors() {
		for (Message m : messageList) {
			if (m != null) {
				m.print();
			}
		}
	}

	public int CountMessages() {
		int count=0;
		for (Message m : messageList) {
			if (m != null) {
				count++;
			}
		}
		return count;
	}

}
