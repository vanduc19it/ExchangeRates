/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchangerates;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
 
public class Client {
 
    public static final byte[] BUFFER = new byte[4096];
 
    public static void main(String[] args) {
          JFrame jFrame = new JFrame();
        jFrame.setTitle("Exchange Rates Table");
      

//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//
//JComponent panel2 = makeTextPanel("Panel #2");
//tabbedPane.addTab("Tab 2", icon, panel2, "Does twice as much nothing");
//tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//
//JComponent panel3 = makeTextPanel("Panel #3");
//tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");
//tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);



//         JButton btn1 = new JButton("Hong Kong");
//          JButton  btn2 = new JButton("Tokyo");
//           JButton btn3 = new JButton("NewYork");
//         JPanel p = new JPanel();
//          p.add(btn1);
//           p.add(btn2);
//            p.add(btn3);
//       jFrame.add(p);
     
//        Random generator = new Random();
//       double randomSell = 105 + (115 - 105) * generator.nextDouble();
//       double randomBuy = 105 + (115 - 105) * generator.nextDouble();
//       double sell = (double) Math.round(randomSell * 100) / 100;
//       double buy = (double) Math.round(randomBuy * 100) / 100;
//       
//       double selleur = 120 + (135 - 120) * generator.nextDouble();
//       double buyeur = 120 + (135 - 120) * generator.nextDouble();
//       double eursell = (double) Math.round(selleur * 100) / 100;
//       double eurbuy = (double) Math.round(buyeur * 100) / 100;
//       
//       double sellgbp = 135 + (160 - 135) * generator.nextDouble();
//       double buygbp = 135 + (160 - 135) * generator.nextDouble();
//       double gbpsell = (double) Math.round(sellgbp * 100) / 100;
//       double gbpbuy = (double) Math.round(buygbp * 100) / 100;
//       
//       double sellaud = 65 + (85 - 65) * generator.nextDouble();
//       double buyaud = 65 + (85 - 65) * generator.nextDouble();
//       double audsell = (double) Math.round(sellaud * 100) / 100;
//       double audbuy = (double) Math.round(buyaud * 100) / 100;
       
        
//          JFrame jFrame = new JFrame("Exchange Rates Client");
//        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        JLabel jLabel = new JLabel();
////        JButton jButton = new JButton("Submit");
//        JTextArea jt = new JTextArea(30, 30);
//        JPanel p = new JPanel();
//        p.add(jt);
////        p.add(jButton);
//        jFrame.add(p);
//        p.add(jLabel);
//        jFrame.setSize(500,300);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
        
       
        MulticastSocket socket = null;
        DatagramPacket inPacket = null;
        try {
           
           
            InetAddress address = InetAddress.getByName(Server.GROUP_ADDRESS);
 
          
            socket = new MulticastSocket(Server.PORT);
 
          
            socket.joinGroup(address);
            while (true) {
               
                inPacket = new DatagramPacket(BUFFER, BUFFER.length);
                socket.receive(inPacket);
              
                String msg = new String(BUFFER, 0, inPacket.getLength());
                String[] words = msg.split("\n");
                
                ImageIcon icon3 = new ImageIcon("C:\\Users\\acer\\Downloads\\hk.png");
//              jt.setText("From " + inPacket.getAddress() + " Msg : \n" + msg);
                String[] columnNames = {"Currency", "HKD->Foreign Currencies(Sell)","HKD->Foreign Currencies(Buy)","DateTime"};
                String[] columnNames1 = {"Currency", "JPY->Foreign Currencies(Sell)","JPY->Foreign Currencies(Buy)","DateTime"};
                String[] columnNames2 = {"Currency", "USD->Foreign Currencies(Sell)","USD->Foreign Currencies(Buy)","DateTime"};
                 
                
                
                 Object[][] data = {{"U.S Dollar","1 HKD in USD: "+ words[0],words[5],words[21]}, 
                {"Euro", "1 HKD in EUR: "+words[1],words[9],words[21]},
                {"British Pound","1 HKD in GBP: "+ words[2],words[7],words[21]},
                {"Swiss Franc","1 HKD in CHF: "+ words[3],words[6],words[21]},
                 {"Australian Dollar","1 HKD in AUD: "+ words[4],words[9],words[21]},
                 {"JPY","1 HKD in JPY: "+ words[5],words[5],words[21]},
                 {"Canadian Dollar", "1 HKD in CAD: "+words[6],words[3],words[21]},
                {"Singaporean Dollar","1 HKD in SGD: "+ words[7],words[12],words[21]},
                 {"New Zealand Dollar","1 HKD in NZD: "+ words[8],words[17],words[21]},
                 {"Swedish Krona","1 HKD in SEK: "+ words[9],words[5],words[21]},
                {"Norwegian Krone","1 HKD in NOK: "+ words[10],words[20],words[21]},
                 {"Danish Krone", "1 HKD in DKK: "+words[11],words[15],words[21]},
                {"Thai Baht", "1 HKD in THB: "+words[12],words[19],words[21]},
                 {"South Korean Won*","1 HKD in KRW: "+ words[13],words[5],words[21]},
                {"New Taiwan Dollar","1 HKD in TWD: "+ words[14],words[5],words[21]},
                {"Chinese Yuan", "1 HKD in CNY: "+words[15],words[8],words[21]},
                 {"Indonesian Rupiah*", "1 HKD in IDR: "+words[16],words[12],words[21]},
                 {"Pacific Franc","1 HKD in XPF: "+ words[17],words[13],words[21]},
                 {"Malaysian Ringgit","1 HKD in MYR: "+ words[18],words[17],words[21]},
                 {"Vietnamese Dong*","1 HKD in VND: "+ words[19],words[19],words[21]},
                {"Philippine Peso","1 HKD in PHP: "+ words[20],words[18],words[21]}};
                
                Object[][] data1 = {{"U.S Dollar", "1 JPY in USD: "+ words[4],words[7],words[21]}, 
                {"Euro", "1 JPY in EUR: "+ words[7],words[3],words[21]},
                {"British Pound", "1 JPY in GBP: " + words[2],words[9],words[21]},
                {"Swiss Franc", "1 JPY in CHF: "+words[9],words[2],words[21]},
                 {"Australian Dollar", "1 JPY in AUD: "+ words[20],words[8],words[21]},
                 {"Hong Kong Dollar","1 JPY in HKD: "+ words[18],words[10],words[21]},
                 {"Canadian Dollar", "1 JPY in CAD: "+words[0],words[12],words[21]},
                {"Singaporean Dollar","1 JPY in SGD: "+ words[7],words[19],words[21]},
                 {"New Zealand Dollar", "1 JPY in NZD: "+words[19],words[1],words[21]},
                 {"Swedish Krona","1 JPY in SEK: "+ words[3],words[0],words[21]},
                {"Norwegian Krone", "1 JPY in NOK: "+words[1],words[5],words[21]},
                 {"Danish Krone", "1 JPY in DKK: "+words[11],words[3],words[21]},
                {"Thai Baht","1 JPY in THB:"+ words[10],words[5],words[4]},
                 {"South Korean Won*","1 JPY in KRW: "+ words[13],words[5],words[21]},
                {"New Taiwan Dollar","1 JPY in TWD: "+ words[6],words[9],words[21]},
                {"Chinese Yuan","1 JPY in CNY: "+ words[15],words[10],words[21]},
                 {"Indonesian Rupiah*", "1 JPY in IDR: "+words[16],words[10],words[21]},
                 {"Pacific Franc","1 JPY in XPF: "+ words[9],words[11],words[21]},
                 {"Malaysian Ringgit","1 JPY in MYR: "+ words[5],words[17],words[21]},
                 {"Vietnamese Dong*","1 JPY in VND: "+ words[8],words[5],words[21]},
                {"Philippine Peso","1 JPY in PHP: "+ words[4],words[20],words[21]}};
                
                 Object[][] data2 = {{"JPY", "1 USD in JPY: "+ words[15],words[9],words[21]}, 
                {"Euro", "1 USD in EUR: "+ words[17],words[5],words[21]},
                {"British Pound", "1 USD in GBP: " + words[7],words[20],words[21]},
                {"Swiss Franc", "1 USD in CHF: "+words[14],words[15],words[21]},
                 {"Australian Dollar", "1 USD in AUD: "+ words[20],words[5],words[21]},
                 {"Hong Kong Dollar","1 USD in HKD: "+ words[11],words[10],words[21]},
                 {"Canadian Dollar", "1 USD in CAD: "+words[6],words[1],words[21]},
                {"Singaporean Dollar","1 USD in SGD: "+ words[2],words[2],words[21]},
                 {"New Zealand Dollar", "1 USD in NZD: "+words[8],words[7],words[21]},
                 {"Swedish Krona","1 USD in SEK: "+ words[9],words[10],words[21]},
                {"Norwegian Krone", "1 USD in NOK: "+words[19],words[17],words[21]},
                 {"Danish Krone", "1 USD in DKK: "+words[5],words[13],words[21]},
                {"Thai Baht","1 USD in THB:"+ words[12],words[19],words[21]},
                 {"South Korean Won*","1 USD in KRW: "+ words[13],words[10],words[21]},
                {"New Taiwan Dollar","1 USD in TWD: "+ words[3],words[1],words[21]},
                {"Chinese Yuan","1 USD in CNY: "+ words[0],words[2],words[21]},
                 {"Indonesian Rupiah*", "1 USD in IDR: "+words[16],words[3],words[21]},
                 {"Pacific Franc","1 USD in XPF: "+ words[1],words[4],words[21]},
                 {"Malaysian Ringgit","1 USD in MYR: "+ words[18],words[20],words[21]},
                 {"Vietnamese Dong*","1 USD in VND: "+ words[10],words[5],words[21]},
                {"Philippine Peso","1 USD in PHP: "+ words[4],words[6],words[21]}};
                

        JTable table = new JTable(data, columnNames);
        table.setBackground(Color.pink);
        JTable table1 = new JTable(data1, columnNames1);
        table1.setBackground(Color.CYAN);
        JTable table2 = new JTable(data2, columnNames2);
        table2.setBackground(Color.orange);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        jFrame.setSize(900,415);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        JTabbedPane tabbedPane = new JTabbedPane();

ImageIcon icon = new ImageIcon("C:\\Users\\acer\\Downloads\\hk.png");
tabbedPane.addTab("Hong Kong", icon, scrollPane,"Exchange Rates in Hong Kong");
ImageIcon icon1 = new ImageIcon("C:\\Users\\acer\\Downloads\\japan.png");
tabbedPane.addTab("Tokyo", icon1, scrollPane1,"Exchange Rates in Tokyo");
ImageIcon icon2 = new ImageIcon("C:\\Users\\acer\\Downloads\\usa.png");
tabbedPane.addTab("NewYork", icon2, scrollPane2,"Exchange Rates in New York");
jFrame.add(tabbedPane);
        

      
                System.out.println("From " + inPacket.getAddress() + " Msg : \n" + msg);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
          
       
    }
}

