package es.stackoverflow.com.questions484544;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class QuestionCellRenderer extends DefaultTreeCellRenderer {
    protected JCheckBox checkBoxRenderer = new JCheckBox();

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            if (userObject instanceof TrueFalseTreeNodeData) {
                TrueFalseTreeNodeData question = (TrueFalseTreeNodeData) userObject;
                prepareQuestionRenderer(question, selected);
                return checkBoxRenderer;
            }
        }
        return super.getTreeCellRendererComponent(tree, value, selected, expanded,
                leaf, row, hasFocus);
    }

    protected void prepareQuestionRenderer(TrueFalseTreeNodeData tfq, boolean selected) {
        checkBoxRenderer.setText(tfq.getValue());
        checkBoxRenderer.setSelected(tfq.isBooleanValue());
        if (selected) {
            checkBoxRenderer.setForeground(getTextSelectionColor());
            checkBoxRenderer.setBackground(getBackgroundSelectionColor());
        } else {
            checkBoxRenderer.setForeground(getTextNonSelectionColor());
            checkBoxRenderer.setBackground(getBackgroundNonSelectionColor());
        }
    }
}
