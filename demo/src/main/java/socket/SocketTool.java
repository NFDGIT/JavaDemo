package socket;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class SocketTool {
    private ServerSocket serverSocket;
    private Boolean switchOfServer;
    private static HashMap<String,Socket> socketList =  new HashMap<String, Socket>();
    private static BufferedReader bufferedReader;
    
    
    
    
    public SocketTool(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
    
    
    
    /**
     * 运行 socket
     * @throws IOException
     */
    public void run() throws IOException{
    	switchOfServer = true;
    	while(switchOfServer)
    	{
             acceptMsg();
    	}
    }
    
    /**
     * 停止 socket
     */
    public void stop() {
		switchOfServer = false;
	}
    /**
     * 发送消息
     * @throws IOException 
     */
    public void sendMsg(String sendId,String receiveId ,String msg) throws IOException {
    	
    	if (receiveId == null) { // 如果  id 为空
			return;
		}
		if (!socketList.keySet().contains(receiveId)) { // 如果  id 不在列表中
			return;
		}
		Socket client = socketList.get(receiveId);
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
    	out.writeUTF("用户"+sendId+"发来一条消息");
	
	}
    /**
     * 接收消息
     */
    public void acceptMsg() {
	    try {
	    	System.out.println("等待远程连接，端口号为："+serverSocket.getLocalPort()+"....");
	    	
	    	Socket server = serverSocket.accept();
	    	
	    	System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
	    	
	    	System.out.println("ip 地址："+server.getLocalAddress()+ "端口号"+server.getLocalPort());
	    	
//	    	DataInputStream in = new DataInputStream(server.getInputStream());
//	    	System.out.println(in.readUTF());
//	    	
//	    	DataOutputStream out = new DataOutputStream(server.getOutputStream());
//	    	out.writeUTF("谢谢连接我："+server.getLocalAddress() + "\nGoodbye!");
//	    	server.close();
	    
		} catch (SocketTimeoutException s) {
			// TODO: handle exception
			System.out.println("Socket time out ");
		} catch (IOException e)
	    {
			e.printStackTrace();
	    }
	}
    
    
    
}
