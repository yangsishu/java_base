//package packet;
//
//import net.sourceforge.jpcap.capture.*;
//import net.sourceforge.jpcap.net.*;
//import java.util.*;
//import java.io.*;
// 
//
//public class CapturePacketTest implements RawPacketListener,PacketListener{
//   
//    //public Vector<String> CaptureVec = new Vector<String>();
//    public static FileOutputStream  fos = null;
//   
//    public static void main(String[] args)throws Exception{
//              // Print copyright info
//              System.out.println();
//              System.out.println("Capture Ethernet packet Ver 0.01, author yanqlv(maomao).");
//              System.out.println("Copyright (c) 2005 yanqlv of Luoyang Normal College, all Rights Reserved.");
//              System.out.println();
//       
//        // Determin which capture device to use      
//        PacketCapture pcap = new PacketCapture();
//              String defaultDevice = pcap.findDevice();
//        StringTokenizer st1 = new StringTokenizer(defaultDevice,"\n");
//        String defaultDeviceStr = st1.nextToken();
//        int default_num = 1;       
//       
//        String[] capDevices = pcap.lookupDevices();
//        int capdevice_num = capDevices.length;
//        System.out.println("There "+ (capdevice_num>1?"are":"is") + " "+ capdevice_num +" device"+(capdevice_num>1?"s":"")+" found!");
//        System.out.println("*****************************************************************************");
//        for (int i=0; i<capdevice_num; i++){
//            //System.out.println("*****capture device["+ i +"]="+capDevices[i]);
//            StringTokenizer st = new StringTokenizer(capDevices[i],"\n");
//            String capStr = st.nextToken();
//            String capDesc = st.nextToken();
//            if( defaultDeviceStr.equals(capStr) ) default_num = i+1;
//            System.out.println( "[" + (i+1) + "] " + capStr + "\n(" + capDesc + ")");
//        }
//        System.out.println("*****************************************************************************");
//     
//        System.out.println("(default to use "+ default_num +")");       
//      
//        int selectn = 1;
//        if(capdevice_num > 1 ){
//            System.out.print("Please select [");
//            for(int i=0; i<capdevice_num;i++) {
//                System.out.print(i+1);
//                if(i!=capdevice_num-1) System.out.print(" or ");
//            }
//            System.out.print("]:");          
//            String readstr = new DataInputStream(System.in).readLine();
//            selectn = Integer.parseInt( new String( readstr ) );
//        }
//        //System.out.println("selectn="+selectn);
//               
//        // Want to save capture result to file
//        fos = new FileOutputStream("capture.txt");
// 
//
//        // Begin capture
//        pcap.open( (new StringTokenizer(capDevices[selectn-1],"\n")).nextToken(),true );               
//        CapturePacketTest t1= new CapturePacketTest();
//        pcap.addRawPacketListener(t1);
//        pcap.addPacketListener(t1);
//        pcap.capture(-1);
// 
//
//    }
//   
//    public void rawPacketArrived(RawPacket rawPacket){
//        //System.out.println("rawPacket="+rawPacket);
//    }
//   
//    public void packetArrived(Packet packet) {
//        try{
//            if( packet instanceof TCPPacket){
//                TCPPacket tcppacket = ((TCPPacket)packet);
//                //System.out.println("Packet="+packet);
//                //System.out.println("window size="+tcppacket.getWindowSize());
//                //System.out.println("Packet="+((TCPPacket)packet).toColoredVerboseString(true));
//                //if( tcppacket.getDestinationPort()==110 || tcppacket.getSourcePort() ==110) // pop3
//                if( tcppacket.getDestinationPort()==80 || tcppacket.getSourcePort() ==80){ // http
//                    String captureStr = new String( tcppacket.getTCPData() );
//                    System.out.println( ">>"+ captureStr);
//                    fos.write(tcppacket.getTCPData());
//                    fos.write(new String("**********************************************************\n").getBytes());
//                    //fos.close();
//                    //CaptureVec.addElement(captureStr);
//                }
//            }
//        }catch(Exception ioe){
//            System.out.println("Exception ocurred:"+ioe);
//        }
//    }
//   
//} 
