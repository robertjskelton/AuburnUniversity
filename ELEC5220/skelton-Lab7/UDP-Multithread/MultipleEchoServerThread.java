import java.net.*;
import java.io.*; 
public class MultipleEchoServerThread extends Thread {
private DatagramPacket inPacket = null;
private DatagramSocket serverSocket = null;
public MultipleEchoServerThread(DatagramPacket inPacket, DatagramSocket
serverSocket) {
this.inPacket = inPacket;
this.serverSocket = serverSocket;
}
public void run(){
byte[] outData = new byte[1400];
int inPacketLength;
String inputLine;
inPacketLength = inPacket.getLength();
System.out.println("inPacket length: " + inPacketLength);
inputLine = new String(inPacket.getData(), 0, inPacketLength);
System.out.println("inputLine length " + inputLine.length());
InetAddress clientIPAddress = inPacket.getAddress();
int port = inPacket.getPort();
System.out.println("IP Address: " + clientIPAddress + "\nPort number: " + port);
outData = inputLine.getBytes();
DatagramPacket outPacket = new DatagramPacket(outData,
outData.length, clientIPAddress, port);
try {
serverSocket.send(outPacket);
} catch (IOException e) {
System.out.println("send error" + e);
}
System.out.println("Echo to UDP Client: " + inputLine);
}
}