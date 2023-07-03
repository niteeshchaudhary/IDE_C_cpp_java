/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_compiler;

import javax.swing.*;

/**
 *
 * @author Niteesh Chaudhary
 */
import java.awt.BorderLayout;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class CodePane extends JPanel {
    public RSyntaxTextArea source_board;

    public CodePane() {
        setLayout(new BorderLayout());
        source_board = new RSyntaxTextArea(20, 60);
        source_board.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        source_board.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(source_board);
        add(sp);

    }

}