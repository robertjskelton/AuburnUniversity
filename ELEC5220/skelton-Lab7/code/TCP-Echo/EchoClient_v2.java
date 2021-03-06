import java.io.*; import java.net.*;
import java.lang.*;public class EchoClient_v2 { 	public static void main(String[] args) throws IOException {
		try {	
			Socket echoSocket = null; 			PrintWriter out = null; 			BufferedReader in = null;
			InetAddress localHost = InetAddress.getLocalHost(); 
			System.out.println("Localhost IP address: " + localHost);			try { 				echoSocket = new Socket(localHost, 2000); 				out = new PrintWriter(echoSocket.getOutputStream(), true); 				in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); 			} catch (UnknownHostException e) { 				System.err.println("Do not know about host." + e); 	
				System.exit(1); 			} 		
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 			String userInput;
			while ((userInput = stdIn.readLine()) != null) { 				out.println(userInput); 				System.out.println("Echo from TCP Server: " + in.readLine());    			if (userInput.equals("Bye."))        			break;        	 		} 			out.close(); 			in.close(); 			stdIn.close(); 			echoSocket.close(); 		}
		catch (IOException e) { 			System.err.println("Could not get I/O for the connection to localhost."+e); 			System.exit(1);	 	} 
	} } 