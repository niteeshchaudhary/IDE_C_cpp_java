/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_compiler;

/**
 *
 * @author Niteesh Chaudhary
 */
import com.jediterm.pty.PtyProcessTtyConnector;
import com.jediterm.terminal.ProcessTtyConnector;
import com.jediterm.terminal.TerminalCustomCommandListener;
import com.jediterm.terminal.TtyConnector;
import com.jediterm.terminal.ui.JediTermWidget;
import com.jediterm.terminal.ui.UIUtil;
import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;
import com.pty4j.PtyProcess;
import com.pty4j.PtyProcessBuilder;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;



import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TerminalApp extends JediTermWidget  {
    PtyProcess process;
    PtyProcessTtyConnector ptc;

    public TerminalApp(String loc){
        super(80, 24, new DefaultSettingsProvider());
        setTtyConnector(createTtyConnector(loc));
        start();

    }


    
    void runInstruction(String ins){
       // this.myTerminal.writeString(ins+"\n");
        //        lst.add("dir");
        //        this.myTerminal.processCustomCommand(lst);
        //    this.myTerminal.addCustomCommandListener(new TerminalCustomCommandListener(){
        //        @Override
        //        public void process(List<String> list){
        //            
        //        }
        //    });
        String[] command = new String[]{"cmd.exe"};
        try{
            ins=ins;
           // process= new PtyProcessBuilder().setCommand(command).setEnvironment( System.getenv()).start();
        //  ptc.write();
          ptc.getProcess().outputWriter().write(ins);
          ptc.getProcess().outputWriter().flush();
          ptc.getProcess().outputWriter().newLine();
          ptc.getProcess().outputWriter().flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }

  private TtyConnector createTtyConnector(String loc) {
    try {
      Map<String, String> envs = System.getenv();
      String[] command;
      if (UIUtil.isWindows) {
        command = new String[]{"cmd","cd "+loc};
      } else {
        command = new String[]{"/bin/bash", "--login"};
        envs = new HashMap<>(System.getenv());
        envs.put("TERM", "xterm-256color");
      }
      process = new PtyProcessBuilder().setCommand(command).setEnvironment(envs).start();
      ptc = new PtyProcessTtyConnector(process, StandardCharsets.UTF_8);
      return ptc;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
