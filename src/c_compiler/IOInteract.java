/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_compiler;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niteesh Chaudhary
 */
public class IOInteract extends javax.swing.JPanel {

    /**
     * Creates new form IOInteract
     */
        TControlAdv ter;
    final LinkedBlockingQueue<Character> sb = new LinkedBlockingQueue<Character>();
    
    public IOInteract() {
            try {
                initComponents();
                ter = new TControlAdv();
            } catch (IOException ex) {
                Logger.getLogger(IOInteract.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollp = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(58, 0), new java.awt.Dimension(32767, 0));
        sendt = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        go = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        st = new javax.swing.JButton();
        sente = new javax.swing.JTextField();
        state = new javax.swing.JToggleButton();
        temp = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        scrollp.setAutoscrolls(true);
        scrollp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        terminal.setColumns(20);
        terminal.setRows(4);
        terminal.setText(" ");
        terminal.setPreferredSize(new java.awt.Dimension(140, 76));
        scrollp.setViewportView(terminal);

        add(scrollp, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler3);

        sendt.setPreferredSize(new java.awt.Dimension(6, 30));
        sendt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sendtKeyTyped(evt);
            }
        });
        jPanel1.add(sendt);
        jPanel1.add(filler2);

        go.setText("Go");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });
        jPanel1.add(go);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        st.setText(">");
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });

        state.setText("state");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(st)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sente))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void sendtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sendtKeyTyped
        //sb.offer(evt.getKeyChar());
    }//GEN-LAST:event_sendtKeyTyped

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        temp.setText(sendt.getText());
        sente.setText(sendt.getText());
        sendt.setText("");

        /* try{
            InputStream ins=new ByteArrayInputStream(TerminalOI.sendt.getText().getBytes("UTF-8"));
            byte[] buffero = new byte[4000];
            int ni =ins.available();
            if(ni>0){
                int n = ins.read(buffero, 0, Math.min(ni, buffero.length));
                System.out.print(new String(buffero, 0, ni));
            }
        }catch(Exception e){

        }*/
    }//GEN-LAST:event_goActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        if(ter.isAlive()){

        }
        else{
            ter.start();
        }

    }//GEN-LAST:event_stActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    public javax.swing.JButton go;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane scrollp;
    public static javax.swing.JTextField sendt;
    public static javax.swing.JTextField sente;
    public javax.swing.JButton st;
    public static javax.swing.JToggleButton state;
    public static javax.swing.JLabel temp;
    public static javax.swing.JTextArea terminal;
    // End of variables declaration//GEN-END:variables
}
