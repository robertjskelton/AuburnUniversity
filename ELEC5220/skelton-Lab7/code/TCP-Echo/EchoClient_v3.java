import java.io.*; 
import java.lang.*;
//Please enter the following to run 
//java EchoClient_v3 <Server IP> <Server Port>; use a space to separate them and hit enter
		try {	
			Socket echoSocket = null; 
			String echoServer = null;
			int echoServPort;               /* Echo server port */
        	String echoServIP;                  /* IP address of server */
        	echoServIP = args[0];			/* First arg: server IP Address */
        	echoServPort = Integer.parseInt(args[1]);	/* Second arg: string to echo */
			System.out.println("Server IP address: " + echoServIP + ":" + echoServPort);
			try { 
			catch (UnknownHostException e) { 
				System.exit(1); 
			while ((userInput = stdIn.readLine()) != null) { 
		} 
		catch (IOException e) { 
	}