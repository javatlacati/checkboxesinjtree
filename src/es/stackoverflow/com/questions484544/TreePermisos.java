package es.stackoverflow.com.questions484544;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Optional;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class TreePermisos extends javax.swing.JFrame {

    /**
     * Creates new form TreePermisos
     */
    public TreePermisos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionCellRenderer1 = new QuestionCellRenderer();
        questionCellEditor1 = new QuestionCellEditor();
        jScrollPane1 = new JScrollPane();
        jTree1 = new JTree(getRootNode()){
            @Override
            public boolean isPathEditable(TreePath path) {
                Object comp = path.getLastPathComponent();
                if (comp instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) comp;
                    Object userObject = node.getUserObject();
                    if (userObject instanceof TrueFalseTreeNodeData) {
                        return true;
                    }
                }
                return false;
            }
        }
        ;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(850, 500));

        jTree1.setCellEditor(questionCellEditor1);
        jTree1.setCellRenderer(questionCellRenderer1);
        jTree1.setEditable(true);
        jTree1.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        getContentPane().add(jScrollPane1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        Optional<DefaultMutableTreeNode> node = Optional.ofNullable(jTree1.getLastSelectedPathComponent()).filter(DefaultMutableTreeNode.class::isInstance).map(DefaultMutableTreeNode.class::cast);
        Optional<TrueFalseTreeNodeData> userObject = node.map(DefaultMutableTreeNode::getUserObject).filter(TrueFalseTreeNodeData.class::isInstance).map(TrueFalseTreeNodeData.class::cast);
        userObject.ifPresent(uo->{
            if (uo.isBooleanValue()) {
                node.ifPresent(aNode->{
                    for (int i = 0; i < aNode.getChildCount(); i++) {
                        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) aNode.getChildAt(i);
                        TrueFalseTreeNodeData childTreeNodeData = (TrueFalseTreeNodeData) aNode.getUserObject();
                        System.out.println(jTree1.getAnchorSelectionPath());
                    }
                });
            }
        });
    }//GEN-LAST:event_jTree1ValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TreePermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreePermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreePermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreePermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreePermisos().setVisible(true);
            }
        });
    }

    protected MutableTreeNode getRootNode() {
        DefaultMutableTreeNode root, nivel1, nivel2, nivel3, nivel4;
        TrueFalseTreeNodeData rootT;

        rootT = new TrueFalseTreeNodeData("Seleccionar Todo");
        root = new DefaultMutableTreeNode(rootT);

        //1.RRHH
        //2.Operaciones        
        //3.Contabilidad
        nivel1 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Contabilidad"));
        //3.1
        nivel2 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Fichero"));
        nivel1.add(nivel2);
        //3.2
        nivel2 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Transacciones"));
        //3.2.1
        nivel3 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Trabajador Eventual"));
        //3.2.1.1
        nivel4 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Pagos por Realizar"));
        nivel3.add(nivel4);
        //3.2.1.2
        nivel4 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Pagos Realizados"));
        nivel3.add(nivel4);
        //3.2.1.3
        nivel4 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Descuentos del Trabajador"));
        nivel3.add(nivel4);
        nivel2.add(nivel3);
        //3.2.2
        nivel3 = new DefaultMutableTreeNode(new TrueFalseTreeNodeData("Trabajador Fijo"));
        nivel2.add(nivel3);
        nivel1.add(nivel2);
        root.add(nivel1);
        //4.Presupuestos
        return root;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JScrollPane jScrollPane1;
    private JTree jTree1;
    private QuestionCellEditor questionCellEditor1;
    private QuestionCellRenderer questionCellRenderer1;
    // End of variables declaration//GEN-END:variables
}
