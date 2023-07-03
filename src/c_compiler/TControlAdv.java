/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_compiler;

import java.io.*;


/**
 *
 * @author NITEESH
 */
public class TControlAdv extends Thread {
     ProcessBuilder builder;
     InputStream out;
     //OutputStream inn;
     BufferedWriter writer;
     Process process;
    public TControlAdv() throws IOException
    {
        builder = new ProcessBuilder("cmd", "-i");
        builder.redirectErrorStream(true); 
        process = builder.start();
        out = process.getInputStream();
        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        //inn= process.getOutputStream();
    }
    public void  run()  
    {
         byte[] buffer = new byte[4000];
         try{
     while (IOInteract.state.isSelected()&& process.isAlive()) {
      int no = out.available();
      if (no > 0) {
        int n = out.read(buffer, 0, Math.min(no, buffer.length));
        IOInteract.terminal.append("\n"+new String(buffer, 0, n));
        System.out.println(new String(buffer, 0, n));
      
      //writer.notify();
      }
      else if(!IOInteract.temp.getText().equals(""))
      {
           writer.write( IOInteract.temp.getText()+"\n");
          // IOInteract.terminal.append("\n"+IOInteract.temp.getText());
           writer.flush();
            //process.waitFor();
         //  writer.flush();
          // writer.close();
           IOInteract.temp.setText("");
           
      }
      else{
          
      }
      IOInteract.scrollp.getVerticalScrollBar().setValue(IOInteract.scrollp.getVerticalScrollBar().getMaximum());
      //int ni = System.in.available();
      //if (ni > 0 ) {
        //int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
        //byte[] buffero="nkc".getBytes();
        //System.out.println(new String(buffero, 0, buffero.length));
        //inn.write(buffero, 0, buffero.length);
        
        //inn.flush();
      //}
    }
    }catch(Exception ex){
            System.out.println(ex.toString());
            }
      try {
        Thread.sleep(10);
      }
      catch (InterruptedException e) {
          System.out.println(e.toString());
      }
    

  //  System.out.println(process.exitValue());
    }
 
  }

/*
StringReader sr = new StringReader(textArea.getText());
BufferedReader br = new BufferedReader(sr);
String nextLine = “”;
while ((nextLine = br.readLine) != null){

}*/

/*
final LinkedBlockingQueue<Character> sb = new LinkedBlockingQueue<Character>();

final JTextField t = new JTextField();
t.addKeyListener(new KeyListener() {
  @Override
  public void keyTyped(KeyEvent e) {
    sb.offer(e.getKeyChar());
  }
  ...
});

System.setIn(new BufferedInputStream(new InputStream() {
  @Override
  public int read() throws IOException {
    int c = -1;
    try {
      c = sb.take();            
    } catch(InterruptedException ie) {
    } 
    return c;           
  }
}));*/

/* byte[] buffer = new byte[4000];
        byte[] buffero = new byte[4000];
        
        while (IOInteract.state.isSelected() && isAlive(process)) 
        {
            if(IOInteract.sendt.getText().equals("exit"))
        {
            process.destroy();
            System.out.println(process.exitValue());
            this.suspend();
        }
          try
          {
            InputStream ins=new ByteArrayInputStream(IOInteract.sendt.getText().getBytes("UTF-8"));
            int no = out.available();
            if (no > 0) {
                int n = out.read(buffero, 0, Math.min(no, buffero.length));
                IOInteract.terminal.append(new String(buffero, 0, n)+"\n");
                System.out.println(new String(buffero, 0, n));
                //IOInteract.sendt.setText("");
            }
            int ni = ins.available();
            int ni1 = System.in.available();
            if (ni1>0) {
                //ni > 0 || !IOInteract.sendt.getText().equals("")||
                //int n = ins.read(buffero, 0, Math.min(ni, buffero.length));
                int nk = System.in.read(buffero, 0, Math.min(ni1, buffero.length));
                //inn.write(buffero,0,n);
                inn.write(buffero,0,nk);
                IOInteract.sente.setText(new String(buffero, 0, nk));
                //System.out.println(new String(buffero, 0, n)+"nk");
                inn.flush();
                //IOInteract.sendt.setText("");
            }
          }catch(Exception e){
              
          }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
            }
        }
    }
    
    public static boolean isAlive(Process p) 
    {
        try {
             p.exitValue();
             return false;
        }
        catch (IllegalThreadStateException e) {
            return true;
        }
    }
*/