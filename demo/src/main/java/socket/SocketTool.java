package socket;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;

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
            String msg = acceptMsg();
         
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
    	PrintWriter printWriter;
    	if (receiveId == null) { // 如果 id 为空   群发
    		
    		
    		  //每当客户端连接上,就向相应的客户端进行回应
            Iterator<HashMap.Entry<String, Socket>> entries = socketList.entrySet().iterator(); 
            while (entries.hasNext()){
                HashMap.Entry<String, Socket> entry = entries.next(); 
                System.out.println(entry.getKey());
                if (!String.valueOf(entry.getKey()).equals("")) {
                    System.out.println(entry.getValue());
                    System.out.println("-------------");
                    Socket  socket = entry.getValue();
                    if (socket!=null) {
                        try {
                        	printWriter = new PrintWriter(socket.getOutputStream());  //回复client的ID
                        	printWriter.println(msg);
                        	printWriter.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    		return;
		}
   
		if (!socketList.keySet().contains(receiveId)) { // 如果  id 不在列表中
			return;
		}
		Socket client = socketList.get(receiveId);
		DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
		dataOutputStream.writeUTF("用户"+sendId+"发来一条消息");
	
	}
    /**
     * 接收消息
     */
    public String acceptMsg() {
	    try {
	    	System.out.println("等待远程连接，端口号为："+serverSocket.getLocalPort()+"....");
	    	
	    	Socket socket = serverSocket.accept();
	    	
	    	System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
	    	
	    	System.out.println("getLocalSocketAddress 地址："+socket.getLocalSocketAddress()+ "getLocalPort"+socket.getLocalPort());
	    	System.out.println("getRemoteSocketAddress 地址："+socket.getRemoteSocketAddress()+ "getPort"+socket.getPort());
	    	
	    	socketList.put(socket.getRemoteSocketAddress()+":"+socket.getPort(), socket);
	    	
	    	DataInputStream in = new DataInputStream(socket.getInputStream());
	    	System.out.println(in.readUTF());
	       
	    	
	    	return in.readUTF();
		} catch (SocketTimeoutException s) {
			// TODO: handle exception
			System.out.println("Socket time out ");
		} catch (IOException e)
	    {
			e.printStackTrace();
	    }
	    return "";
	}
    
    
    
}
