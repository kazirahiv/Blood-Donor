package bindmodels;
public class Message
{
	public int id;
    public int userId;
    public String message, senderName;

    public Message(){}
    public Message(int id, int userId, String message, String senderName)
    {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.senderName = senderName;
    }
    public void print(){
		System.out.print("Id "+id);
        System.out.println("UserId "+userId);
        System.out.println("Sender Name "+senderName);
        System.out.println("Message "+message);
    }
    public int getId(){ return this.id;}
    public int getUserId(){ return this.userId;}
    public String getMessage(){ return this.message;}
    public String getName(){ return this.senderName;}
}