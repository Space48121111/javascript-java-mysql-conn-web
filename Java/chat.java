import java.net.*;
import java.io.*;
import java.util.*;

public class GroupChat {	
	private static final String TERMINATE = "Exit";
	static String name;
	static volatile boolean finished = false;
	public static void main(String[] args) {
	if (args.length != 2)
		System.out.println("Two arguments are required.")
	else {
		try {
		InetAddress group = InetAddress.getByName(args[0]);
		int port = Integer.parseInt(args[1]);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ur name: ");
		name = sc.nextLine();
		MulticastSocket socket = new MulticastSocket(port);
		socket.setTimeToLive(0);
		socket.joinGroup(group);
		Thread t = new Thread(new ReadThread(socket, group, port));
		t.start();
		System.out.println("Start typing messages. \n");
		while(true) {
			String message;
			message = sr.nextLine();
			if (message.equalsIgnoreCase(GroupChat.TERMINATE)) {
				finished = true;
				socket.leaveGroup(group);
				socket.close();
				break; }	
			message = name + ": " + message;
			byte[] buffer = message.getBytes();
			DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, group, port);
			socket.send(datagram);}
		catch(SocketException se) {
			System.out.println("Error creating sockets.")
			se.printStackTrace();}
		catch(IOException ie) {
			System.out.println("Error reading/writing from/to socket.");
			ie.printStackTrace();}
		}
	
	}	
     }

class ReadThread implements Runnable {
	private MulticastSocket socket;
	private InetAddress group;
	private int port;
	private static final int MAX_LEN = 1000;
	ReadThread(MulticastSocket socket, InetAddress group, int port) {
	this.socket = socket;
	this.group = group;
	this.port = port;}
	
}

	@Override
	public void run() {
	while(!GroupChat.finished){
		byte[] buffer = new byte[ReadThread.MAX_LEN];
		DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, 
		group, port);
		String message;
	  try {
	  socket.receive(datagram);
	  message = new String(buffer, 0, datagram.getLength(), "UTF-8");
	  if(!message.startsWith(GroupChat.name))
		System.out.println(message);
	  }
	  catch(IOException e) {
		System.out.println("Socket closed.");}
	  }
	}
   }

Thread sendMessage = new Thread(new Runnable() {
	@Override
	public void run() {
	while (true) {
		String msg = sc.nextLine();
		dos.writeUTF(msg);
	}
Thread readMessage = new Thread(new Runnable() {
	@Override
	public void run() {
		while (true) {
			String msg = dis.readUTF();
			System.out.println(msg);
public class Client {
	final static int ServerPort = 1234;
	public static void main(String args[]) throws UnknownHostException, IOException {

	Scanner scn = new Scanner(System.in);
	InetAddress ip = InetAddress.getByName("localhost");
	Socket s = new Socket(ip, ServerPort);
	DataInputStream dis = new DataInputStream(s.getInputStream());
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	
	Thread sendMessage = new Thread(new Runnable() {
	@Override
	public void run() {
		String msg = scn.nextLine();
		dos.writeUTF(msg);
		
	Thread readMessage = new Thread(new Runnable(){
	while (true)
		String msg = dis.readUTF();
		System.out.println(msg);
	
	}
	sendMessage.start();
	readMessage.start();

public class UnSyncChatServer {
	public static void main(String args[])
		throws IOException, InterruptedException {
	DatagramSocket ss = new DatagramSocket(1234);
	InetAddress ip = InetAddress.getLocalHost();
	
	Thread ssend;
	ssend = new Thread(new Runnable() {
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);

	while (true) {
		synchronized (this) {
			byte[] sd = new byte[1000];
			sd = sc.nextLine().getBytes();
		DatagramPacket sp = new DatagramPacket(sd, sd.length,
		ip, 5334);
	ss.send(sp);
	String msg = new String(sd);

Thread sreceive;
	@Override 
	public void run() {
		synchronized(this) {
		byte[] rd = new byte[1000];
		DatagramPacket sp1 = new DatagramPacket(rd, rd.length);
		ss.receive(sp1);

	String msg = (new String(rd)).trim();
	
	System.out.println("Client (" + sp1.getPort() + "):" + " " + msg):

	if (msg.equals("bye")) {
		System.out.println("Client" + "Conn closed.");
	ssend.start();
	sreceive.start();
	
	ssend.join():
	sreceive.join();

// end of the file eof




// end 