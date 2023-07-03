/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_compiler;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.InputMap;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: Keep a global StringBuilder to decrease memory footprint

/*class TestTerminal {
	
    public static void main(String[] args) {
        Terminal term = Terminal.getInstance();
        term.open(0, 0, 700, 700);
    }
    
}*/
class Terminal extends JFrame {
    private JTextArea txtArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();
    private CommandProcessor processor = CommandProcessor.getInstance();
    private final String LINE_SEPARATOR = System.lineSeparator();
    private Font font = new Font("SansSerif", Font.BOLD, 15);

    public Terminal() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(scrollPane);
        scrollPane.setViewportView(txtArea);
        txtArea.addKeyListener(new KeyListener());
        txtArea.setFont(font);
        disableArrowKeys(txtArea.getInputMap());
        setBounds(0, 0, 700, 700);
        showPrompt();
    }

    private void disableArrowKeys(InputMap inputMap) {
        String[] keystrokeNames = { "UP", "DOWN", "LEFT", "RIGHT", "HOME" };
        for (int i = 0; i < keystrokeNames.length; ++i)
            inputMap.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

    public static void main(String args[]) {
     /*   SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                       
            }
        });*/
    }

    public void close() {
        this.dispose();
    }

    public void clear() {
        txtArea.setText("");
        showPrompt();
    }

    private void showPrompt() {
        txtArea.setText(txtArea.getText() + "> ");
    }

    private void showNewLine() {
        txtArea.setText(txtArea.getText() + LINE_SEPARATOR);
    }

    public class KeyListener extends KeyAdapter {
        private final int ENTER_KEY = KeyEvent.VK_ENTER;
        private final int BACK_SPACE_KEY = KeyEvent.VK_BACK_SPACE;
        private final String BACK_SPACE_KEY_BINDING = getKeyBinding(
                txtArea.getInputMap(), "BACK_SPACE");
        private final int INITIAL_CURSOR_POSITION = 2;

        private boolean isKeysDisabled;
        private int minCursorPosition = INITIAL_CURSOR_POSITION;

        private String getKeyBinding(InputMap inputMap, String name) {
            return (String) inputMap.get(KeyStroke.getKeyStroke(name));
        }

        public void keyPressed(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == BACK_SPACE_KEY) {
                int cursorPosition = txtArea.getCaretPosition();
                if (cursorPosition == minCursorPosition && !isKeysDisabled) {
                    disableBackspaceKey();
                } else if (cursorPosition > minCursorPosition && isKeysDisabled) {
                    enableBackspaceKey();
                }
            } else if (keyCode == ENTER_KEY) {
                disableTerminal();
                String command = extractCommand();
                executeCommand(command);
                showNewLine();
                showPrompt();
                enableTerminal();
            }
        }

        public void keyReleased(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == ENTER_KEY) {
                txtArea.setCaretPosition(txtArea.getCaretPosition() - 1);
                setMinCursorPosition();
            }
        }

        private void disableBackspaceKey() {
            isKeysDisabled = true;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    "none");
        }

        private void enableBackspaceKey() {
            isKeysDisabled = false;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    BACK_SPACE_KEY_BINDING);
        }

        private void setMinCursorPosition() {
            minCursorPosition = txtArea.getCaretPosition();
        }
    }

    public void enableTerminal() {
        txtArea.setEnabled(true);
    }
    
    public void disableTerminal() {
        txtArea.setEnabled(false);
    }
    
    public void printTerminal(String comm) {
        txtArea.append("\n"+comm);
                disableTerminal();
                //String command = extractCommand();
                //executeCommand(command);
                showNewLine();
                showPrompt();
                enableTerminal();
    }
    
    public void executeCommand(String command) {
       String op= processor.processCmd(command);
       printTerminal(op);
    }

    private String extractCommand() {
        removeLastLineSeparator();
        String newCommand = stripPreviousCommands();
        return newCommand;
    }

    private void removeLastLineSeparator() {
        String terminalText = txtArea.getText();
        terminalText = terminalText.substring(0, terminalText.length() - 1);
        txtArea.setText(terminalText);
    }

    private String stripPreviousCommands() {
        String terminalText = txtArea.getText();
        int lastPromptIndex = terminalText.lastIndexOf('>') + 2;
        if (lastPromptIndex < 0 || lastPromptIndex >= terminalText.length())
            return "";
        else
            return terminalText.substring(lastPromptIndex);
    }

    public static Terminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    private static final class TerminalHolder {
        static final Terminal INSTANCE = new Terminal();
    }
}

class CommandProcessor {
    private CommandProcessor() {
    }

    public String processCmd(String command) {
        //System.out.println("User command: " + command);
       try{
         Runtime runTime = Runtime.getRuntime();
         Process process = runTime.exec(command);
      //ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","g++");
        //builder.redirectErrorStream(true);
        //Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line="",l1="";
        try{
        while (true) {
        	l1 = r.readLine();
        	if(l1==null)
        	{
        		if(line==null){
        			System.out.println("nkc");
        			line="nkc";
        		}
        		System.out.println(line);
        		break;
        	}
        	line+=l1;
            
        }
        }
        catch(Exception ex)
        {
        }
        process = runTime.exec("5");
        try{
        while (true) {
        	l1 = r.readLine();
        	if(l1==null)
        	{
        		if(line==null){
        			System.out.println("nkc");
        			line="nkc";
        		}
        		System.out.println(line);
        		break;
        	}
        	line+=l1;
            
        }
        }
        catch(Exception ex)
        {
        }
        process.destroy();
        
        return line;
    }
    catch(Exception ex)
    {
    	return ex.toString();
    }
    }

    public static CommandProcessor getInstance() {
        return CommandProcessorHolder.INSTANCE;
    }

    private static final class CommandProcessorHolder {
        static final CommandProcessor INSTANCE = new CommandProcessor();
    }
}