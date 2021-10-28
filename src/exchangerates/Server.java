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
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;


 
public class Server {
    
    public static final String ACCESS_KEY = "2244e5d0a0e40f1dd746201bc2401f26&currencies=EUR,GBP,CAD,PLN&source=USD&format=1";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
  
 
    public static final String GROUP_ADDRESS = "224.0.0.1";
    public static final int PORT = 2345;
    
    
   

 
    public static void main(String[] args) throws InterruptedException {
        

        JFrame jFrame = new JFrame("Exchange Rates Server");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
        JTextArea jt = new JTextArea(30, 60);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jt.setEditable(false);
        jt.setFont(new Font("Verdana", Font.BOLD, 12));
       jt.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JLabel jLabel = new JLabel("    Port: 2345");
        jLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        JPanel p = new JPanel();
        p.setBackground(Color.CYAN);
        p.setLayout(new BorderLayout());
        p.add(jLabel, BorderLayout.NORTH);
      
       
         p.add(jt, BorderLayout.CENTER);
  
        
         jFrame.add(p);
        jFrame.setSize(400,290);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    
//        try {
//			CloseableHttpResponse response =  httpClient.execute(get);
//			HttpEntity entity = response.getEntity();
//			
//			
//			JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
//			
//			System.out.println("Live Currency Exchange Rates");
//			
//			
//			Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000)); 
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
//			String formattedDate = dateFormat.format(timeStampDate);
//                        String GBP = "1 " + exchangeRates.getString("source") + " in GBP : " + exchangeRates.getJSONObject("quotes").getDouble("USDGBP") + " (Date: " + formattedDate + ")"; 
//			String EUR = "1 " + exchangeRates.getString("source") + " in EUR: " + exchangeRates.getJSONObject("quotes").getDouble("USDEUR") + " (Date: " + formattedDate + ")";
//                        String CAD = "1 " + exchangeRates.getString("source") + " in CAD : " + exchangeRates.getJSONObject("quotes").getDouble("USDCAD") + " (Date: " + formattedDate + ")";
//                        String PLN = "1 " + exchangeRates.getString("source") + " in PLN : " + exchangeRates.getJSONObject("quotes").getDouble("USDPLN") + " (Date: " + formattedDate + ")";
                       
                      
                        
                        
                          DatagramSocket socket = null;
        try {
          
           
            InetAddress address = InetAddress.getByName(GROUP_ADDRESS);
 
            
            socket = new DatagramSocket();
 
            DatagramPacket outPacket = null;
            long counter = 0;
            while (true) {
                java.util.Date date=new java.util.Date(); 
                 Random generator = new Random();
                 double randomusd = 0.7 + (0.75 - 0.7) * generator.nextDouble();
                 double usdrandom = (double) Math.round(randomusd * 10000000) / 10000000;
                 
                 double randomeur = 0.8 + (0.9 - 0.8) * generator.nextDouble();
                 double eurrandom = (double) Math.round(randomeur * 10000000) / 10000000;
                 
                  double randomgbp = 1.2 + (1.3 - 1.2) * generator.nextDouble();
                 double gbprandom = (double) Math.round(randomgbp * 10000000) / 10000000;
                 
                  double randomchf = 3.9 + (4.0 - 3.9) * generator.nextDouble();
                 double chfrandom = (double) Math.round(randomchf * 10000000) / 10000000;
                 
                 double randomaud = 1.7 + (3.2 - 1.7) * generator.nextDouble();
                 double audrandom = (double) Math.round(randomaud * 10000000) / 10000000;
                 
                 double randomhkd = 5.0 + (7.0 - 5.0) * generator.nextDouble();
                 double hkdrandom = (double) Math.round(randomhkd * 10000000) / 10000000;
                 
                  double randomcad = 4.6 + (4.7 - 4.6) * generator.nextDouble();
                 double cadrandom = (double) Math.round(randomcad * 10000000) / 10000000;
                 
                  double randomsgd = 3.4 + (4.5 - 3.4) * generator.nextDouble();
                 double sgdrandom = (double) Math.round(randomsgd * 10000000) / 10000000;
                 
                   double randomnzd = 10.6 + (15.3 - 10.6) * generator.nextDouble();
                 double nzdrandom = (double) Math.round(randomnzd * 10000000) / 10000000;
                 
                 double randomsek = 2.5 + (3.7 - 2.5) * generator.nextDouble();
                 double sekrandom = (double) Math.round(randomsek * 10000000) / 10000000;
                 
                  double randomnok = 0.2 + (0.3 - 0.2) * generator.nextDouble();
                 double nokrandom = (double) Math.round(randomnok * 10000000) / 10000000;
                 
                  double randomdkk = 3.2 + (4.0 - 3.2) * generator.nextDouble();
                 double dkkrandom = (double) Math.round(randomdkk * 10000000) / 10000000;
                 
                 double randomthb = 15.0 + (20.0 - 15.0) * generator.nextDouble();
                 double thbrandom = (double) Math.round(randomthb * 10000000) / 10000000;
                 
                 double randomkrw = 40.1 + (50.1 - 40.1) * generator.nextDouble();
                 double krwrandom = (double) Math.round(randomkrw * 10000000) / 10000000;
                 
                  double randomtwd = 1.4 + (1.7 - 1.4) * generator.nextDouble();
                 double twdrandom = (double) Math.round(randomtwd * 10000000) / 10000000;
                 
                  double randomcny = 5.5 + (10.4 - 5.5) * generator.nextDouble();
                 double cnyrandom = (double) Math.round(randomcny * 10000000) / 10000000;
                 
                 double randomidr = 4.9 + (7.3 - 4.9) * generator.nextDouble();
                 double idrrandom = (double) Math.round(randomidr * 10000000) / 10000000;
                 
                 double randomxpf = 3.2 + (6.3 - 3.2) * generator.nextDouble();
                 double xpfrandom = (double) Math.round(randomxpf * 10000000) / 10000000;
                 
                 double randommyr = 9.7 + (18.4 - 9.7) * generator.nextDouble();
                 double myrrandom = (double) Math.round(randommyr * 10000000) / 10000000;
                 
                  double randomvnd = 5.3 + (10.7 - 5.3) * generator.nextDouble();
                 double vndrandom = (double) Math.round(randomvnd * 10000000) / 10000000;
                 
                  double randomphp = 15.7 + (20.4 - 15.7) * generator.nextDouble();
                 double phprandom = (double) Math.round(randomphp * 10000000) / 10000000;
                 
                   String usd = usdrandom + "";
                   String eur = eurrandom + "";
                   String gbp = gbprandom + "";
                   String chf = chfrandom + "";
                   String aud = audrandom + "";
                   String hkd = hkdrandom + "";
                   String cad = cadrandom + "";
                   String sgd = sgdrandom + "";
                   String nzd = nzdrandom + "";
                   String sek = sekrandom + "";
                   String nok = nokrandom + "";
                   String dkk = dkkrandom + "";
                   String thb = thbrandom + "";
                   String krw = krwrandom + "";
                   String twd = twdrandom + "";
                   String cny = cnyrandom + "";
                   String idr = idrrandom + "";
                   String xpf = xpfrandom + "";
                   String myr = myrrandom + "";
                   String vnd = vndrandom + "";
                   String php = phprandom + "";
                   
                   
//                String msg = GBP + "\n" + EUR + "\n" + CAD + "\n" + PLN;
               String msg = usd + "\n" + eur + "\n" + gbp + "\n" + chf + "\n" + aud + "\n" + hkd + "\n" + cad
                             + "\n" + sgd + "\n" + nzd + "\n" + sek + "\n" + nok + "\n" + dkk + "\n" + thb
                             + "\n" + krw + "\n" + twd + "\n" + cny + "\n" + idr + "\n" + xpf + "\n" + myr
                                 + "\n" + vnd + "\n" + php + "\n" + date ;
                counter++;
                outPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, PORT);
                socket.send(outPacket);
                
               jt.setText("Server sent Exchange Rates to Client:\n.............................................................\n" + msg);
                System.out.println("Server sent Exchange Rates to Client:\n" + msg);
                Thread.sleep(1000); 
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
//                        
//			response.close();
//		} catch (ClientProtocolException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		} catch (JSONException e) {
			
//			e.printStackTrace();
		}
        
      
    }

